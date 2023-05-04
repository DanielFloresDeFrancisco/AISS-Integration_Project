package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Commit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommitServiceTest {

    @Autowired
    CommitService service;

    @Test
    @DisplayName("Find commits without pagination; 20 commits per page")
    void findCommitsOfProject() {
        List<Commit> commits = service.findCommitsOfProject("10993694");
        assertTrue(commits.size()==20, "Wrong number of commits");
        System.out.println(commits.size());
    }

    @Test
    @DisplayName("Find commits with pagination; 20 commits per page")
    void findCommitsPagination() {
        Integer numberOfPages = 30; Integer commitPerPage = 20;
        List<Commit> commits = service.findCommitsPagination("10993694");
        assertTrue(commits.size() == numberOfPages * commitPerPage);
        System.out.println(commits.size());
    }

    @Test
    @DisplayName("Find a commit by id")
    void findOneCommitById() {
        String commitId = "802d8bcc8fc33fed263b98590373a3bacaa19a9c";
        Commit commit = service.findOneCommitById("10993694", commitId);
        assertTrue(commit!=null, "There is an error on the request");
        System.out.println(commit.toString());
    }
}