package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Comment;
import AISS.GitHubMiner.models.InputModels.CommentGM;
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
        List<Comment> comments = service.getAllCommentsOfAnIssue("octocat", "Hello-World", "3");
        assertTrue(!comments.isEmpty(), "There is an error while retrieving the comments");
        System.out.println(comments.toString());
    }

    @Test
    void findOneComment() {
        String commentId = "1325876";
        Comment comment = service.getOneCommentById("octocat", "Hello-World", commentId);
        assertTrue(comment != null, "There is an error while retrieving the comment");
        assertTrue(comment.getId().equals(Integer.valueOf(commentId)), "There is an error while retrieving the comment");
        System.out.println(comment.toString());
    }

    @Test //Test for GM Entity
    void CommentGMTest() {
        Comment comment = service.getOneCommentById("octocat", "Hello-World", "1325876");
        CommentGM sol = new CommentGM(comment);
        System.out.println(sol.toString());
    }
}