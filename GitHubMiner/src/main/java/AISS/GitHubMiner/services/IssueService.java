package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Commit;
import AISS.GitHubMiner.models.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://api.github.com/repos/";

    public List<Issue> getAllIssues(String owner, String repos) {
        String uri = "https://api.github.com/repos/" + owner + "/" + repos + "/issues";
        Issue[] issues = restTemplate.getForObject(uri, Issue[].class);
        return Arrays.stream(issues).toList();
    }

    public Issue getOneIssue(String owner, String repos, String issueNumber) {
        Issue issue = null;
        String uri = "https://api.github.com/repos/" + owner + "/" + repos + "/issues/" + issueNumber;
        issue = restTemplate.getForObject(uri, Issue.class);
        return issue;
    }

    public List<Issue> getIssuesPagination(String owner, String repo, Integer maxPages, Integer sinceIssues) {
        String token = "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";
        List<Issue> issues = new ArrayList<>();
        boolean hasMorePages = true;
        int page = 1;

        // If any of both entities are setted as null, the value will be set 2 as default value
        if (maxPages == null) {
            maxPages = 2;
        }

        if (sinceIssues == null) {
            sinceIssues = 2;
        }

        LocalDateTime since = LocalDateTime.now().minusDays(sinceIssues);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        while (hasMorePages && page <= maxPages) {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder
                    .fromUriString(baseUri + owner + "/" + repo + "/issues")
                    .queryParam("page", page)
                    .queryParam("since", since);

            HttpEntity<?> entity = new HttpEntity<>(headers);
            ResponseEntity<Issue[]> response = restTemplate.exchange(uriBuilder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    Issue[].class);
            List<Issue> pageCommits = Arrays.asList(response.getBody());
            issues.addAll(pageCommits);

            String linkHeader = response.getHeaders().getFirst("Link");
            if (linkHeader == null || !linkHeader.contains("rel=\"next\"")) {
                hasMorePages = false;
            } else {
                page++;
            }
        }
        return issues;
    }


}
