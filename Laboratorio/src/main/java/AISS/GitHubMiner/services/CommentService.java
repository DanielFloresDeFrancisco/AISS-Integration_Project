package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://api.github.com/repos/";


    public List<Comment> findAllCommentsOfAnIssue(String owner, String repo, String Inumber) {
        String uri = baseUri + owner + "/" + repo + "/issues/" + Inumber + "/comments";
        Comment[] comments = restTemplate.getForObject(uri, Comment[].class);
        return Arrays.stream(comments).toList();
    }

    public Comment findOneComment(String owner, String repo, String commentId) {
        Comment c = null;
        String uri = baseUri + owner + "/" + repo + "/issues/comments/" + commentId;
        c = restTemplate.getForObject(uri, Comment.class);
        return c;
    }
}
