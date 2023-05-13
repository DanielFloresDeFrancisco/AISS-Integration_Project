package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Comment;
import AISS.GitLabMiner.models.InputModels.CommentGM;
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
        List<Comment> comments = service.getCommentsOfIssue("22623311", "953");
        assertTrue(!comments.isEmpty(), "There is an error while retrieving the comments");
        System.out.println(comments.size());
    }

    @Test //Test GM Entity
    void CommentGMTest() {
        List<Comment> comments = service.getCommentsOfIssue("22623311", "953");
        Comment c = comments.get(0);
        CommentGM sol = new CommentGM(c);
        System.out.println(sol.toString());

    }

}