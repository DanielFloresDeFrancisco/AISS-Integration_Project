package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService service;

    @Test
    void findAllComments() {
        List<Comment> comments = service.findAllCommentsOfAnIssue("octocat", "Hello-World", "3");
        assertTrue(!comments.isEmpty(), "There is an error while retrieving the comments");
        System.out.println(comments.toString());
    }

    @Test
    void findOneComment() {
        Comment comment = service.findOneComment("octocat", "Hello-World", "1325876");
        assertTrue(comment != null, "There is an error while retrieving the comment");
        System.out.println(comment.toString());
    }
}