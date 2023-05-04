package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Commit;
import AISS.GitLabMiner.models.User;
import jakarta.persistence.criteria.CriteriaBuilder;
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
public class CommitService {

    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://gitlab.com/api/v4/projects/";

    public List<Commit> findCommitsOfProject(String projectId) {
        String uri = baseUri + projectId + "/repository/commits";
        HttpHeaders headers = new HttpHeaders();
        String token = "glpat-qcx9bNqo6zTYxEzzJdvT";

        if (token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, Commit[].class);
        List<Commit> commits = Arrays.stream(response.getBody()).toList();
        return commits;
    }

    public List<Commit> findCommitsPagination(String projectId) {
        String token = "glpat-qcx9bNqo6zTYxEzzJdvT";
        List<Commit> commits = new ArrayList<>();
        boolean hasMorePages = true;
        int page = 1;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        while (hasMorePages && page <= 30) {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder
                    .fromUriString(baseUri + projectId + "/repository/commits")
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


    public Commit findOneCommitById(String projectId, String commitId) {
        String uri = baseUri + projectId + "/repository/commits/" + commitId;
        HttpHeaders headers = new HttpHeaders();
        String token = "glpat-qcx9bNqo6zTYxEzzJdvT";

        if (token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Commit> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit> response = restTemplate.exchange(uri, HttpMethod.GET, request, Commit.class);
        Commit commit = response.getBody();
        return commit;
    }
}
