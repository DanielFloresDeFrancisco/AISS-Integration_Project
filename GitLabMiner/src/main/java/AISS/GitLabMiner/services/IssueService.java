package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Commit;
import AISS.GitLabMiner.models.Issue;
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

    String baseUri = "https://gitlab.com/api/v4/projects/";

    public List<Issue> findIssuesOfProject(String projectId) {
        String uri = baseUri + projectId + "/issues";
        HttpHeaders headers = new HttpHeaders();
        String token = "glpat-qcx9bNqo6zTYxEzzJdvT";

        if (token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Issue[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Issue[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, Issue[].class);
        List<Issue> isssues = Arrays.stream(response.getBody()).toList();
        return isssues;
    }

    public List<Issue> findIssuesPagination(String projectId) {
        String token = "glpat-qcx9bNqo6zTYxEzzJdvT";
        List<Issue> issues = new ArrayList<>();
        boolean hasMorePages = true;
        int page = 1;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        while (hasMorePages && page <= 30) {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder
                    .fromUriString(baseUri + projectId + "/issues")
                    .queryParam("page", page);

            HttpEntity<?> entity = new HttpEntity<>(headers);
            ResponseEntity<Issue[]> response = restTemplate.exchange(uriBuilder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    Issue[].class);
            List<Issue> pageIssues = Arrays.asList(response.getBody());
            issues.addAll(pageIssues);

            String linkHeader = response.getHeaders().getFirst("Link");
            if (linkHeader == null || !linkHeader.contains("rel=\"next\"")) {
                hasMorePages = false;
            } else {
                page++;
            }
        }
        return issues;
    }

    public Issue findOneIssueByInternalId(String projectId, String internalId) {
        String uri = baseUri + projectId + "/issues/" + internalId;
        HttpHeaders headers = new HttpHeaders();
        String token = "glpat-qcx9bNqo6zTYxEzzJdvT";

        if (token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Issue> request = new HttpEntity<>(null, headers);
        ResponseEntity<Issue> response = restTemplate.exchange(uri, HttpMethod.GET, request, Issue.class);
        Issue issue = response.getBody();
        return issue;
    }
}
