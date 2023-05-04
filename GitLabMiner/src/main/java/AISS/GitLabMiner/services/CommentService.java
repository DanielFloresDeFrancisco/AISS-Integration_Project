package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Comment;
import AISS.GitLabMiner.models.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://gitlab.com/api/v4/projects/";

    public List<Comment> findCommentsOfIssue(String projectId, String issueIid) {
        String uri = baseUri + projectId + "/issues/" + issueIid + "/notes";
        HttpHeaders headers = new HttpHeaders();
        String token = "glpat-qcx9bNqo6zTYxEzzJdvT";

        if (token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Comment[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Comment[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, Comment[].class);
        List<Comment> comments = Arrays.stream(response.getBody()).toList();
        return comments;
    }
}
