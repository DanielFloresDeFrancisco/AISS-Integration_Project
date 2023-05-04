package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Comment;
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
        List<Comment> comments = service.findCommentsOfIssue("22623311", "953");
        assertTrue(!comments.isEmpty(), "There is an error while retrieving the comments");
        System.out.println(comments.toString());
    }

}