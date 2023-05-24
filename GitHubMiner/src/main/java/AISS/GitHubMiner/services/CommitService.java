package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class CommitService {

    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://api.github.com/repos/";

    public Commit getOneCommit(String owner, String repos, String commitId) {
        Commit c = null;
        String uri = "https://api.github.com/repos/" + owner + "/" + repos + "/commits/" + commitId;
        c = restTemplate.getForObject(uri, Commit.class);
        return c;
    }

    public List<Commit> getAllCommits(String owner, String repos) {
        String uri = "https://api.github.com/repos/" + owner + "/" + repos + "/commits";
        Commit[] commits = restTemplate.getForObject(uri, Commit[].class);
        return Arrays.stream(commits).toList();

    }

    public List<Commit> getCommitsPagination(String owner, String repos, Integer maxPages, Integer sinceCommits) {
        String token = "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";
        List<Commit> commits = new ArrayList<>();
        boolean hasMorePages = true;
        int page = 1;

        // If any of both entities are setted as null, the value will be set 2 as default value
        if (maxPages == null) {
            maxPages = 2;
        }

        if (sinceCommits == null) {
            sinceCommits = 2;
        }

        LocalDateTime since = LocalDateTime.now().minusDays(sinceCommits);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        while (hasMorePages && page <= maxPages) {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder
                    .fromUriString(baseUri + owner + "/" + repos + "/commits")
                    .queryParam("page", page)
                    .queryParam("since", since);

            HttpEntity<?> entity = new HttpEntity<>(headers);
            ResponseEntity<Commit[]> response = restTemplate.exchange(uriBuilder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    Commit[].class);
            List<Commit> pageCommits = Arrays.asList(response.getBody());
            commits.addAll(pageCommits);

            String linkHeader = response.getHeaders().getFirst("Link");
            if (linkHeader == null || !linkHeader.contains("rel=\"next\"")) {
                hasMorePages = false;
            } else {
                page++;
            }
        }

        return commits;
    }

}
