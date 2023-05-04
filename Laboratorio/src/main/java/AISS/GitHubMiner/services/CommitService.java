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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class CommitService {

    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://api.github.com/repos/";

    public Commit findOneCommit(String owner, String repos, String commitId) {
        Commit c = null;
        String uri = "https://api.github.com/repos/" + owner + "/" + repos + "/commits/" + commitId;
        c = restTemplate.getForObject(uri, Commit.class);
        return c;
    }

    public List<Commit> findAllCommits(String owner, String repos) {
        String uri = "https://api.github.com/repos/" + owner + "/" + repos + "/commits";
        Commit[] commits = restTemplate.getForObject(uri, Commit[].class);
        return Arrays.stream(commits).toList();

    }


    private ResponseEntity<Commit[]> findCommitsPagination(String uri) {
        HttpHeaders headers = new HttpHeaders();
        String token = "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";

        if (token != "") {
            headers.set("Authorization", "Bearer" + token);
        }
        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, Commit[].class);
        return response;
    }

    public List<Commit> findCommitsPagination(String owner, String repo) {
        String token = "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";
        List<Commit> commits = new ArrayList<>();
        boolean hasMorePages = true;
        int page = 1;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        while (hasMorePages && page <= 30) {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder
                    .fromUriString(baseUri + owner + "/" + repo + "/commits")
                    .queryParam("page", page);

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
