package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Commit;
import AISS.GitLabMiner.models.InputModels.CommitGM;
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
        Integer commitPerPage = 20;
        List<Commit> commits = service.getCommitsOfProject("10993694");
        assertTrue(commits.size() == commitPerPage, "Wrong number of commits");
        System.out.println(commits.size());
    }

    @Test
    @DisplayName("Find commits with pagination; 20 commits per page")
    void findCommitsPagination() {
        Integer maxPages = 30; Integer commitPerPage = 20;
        List<Commit> commits = service.getCommitsPagination("10993694",maxPages,1000);
        assertTrue(!commits.isEmpty(), "There was an error while retrieving commits");
        assertTrue(commits.size() <= maxPages * commitPerPage, "There was an error while retrieving commits");
        System.out.println(commits.size());
    }

    @Test
    @DisplayName("Find a commit by id")
    void findOneCommitById() {
        String commitId = "802d8bcc8fc33fed263b98590373a3bacaa19a9c";
        Commit commit = service.getOneCommitById("10993694", commitId);
        assertTrue(commit!=null, "There is an error on the request");
        assertTrue(commit.getId().equals(commitId), "There is an error on the request");
        System.out.println(commit.toString());
    }

    @Test //Test for GM Entity
    void CommitGMTest() {
        String commitId = "802d8bcc8fc33fed263b98590373a3bacaa19a9c";
        Commit commit = service.getOneCommitById("10993694", commitId);
        CommitGM sol = new CommitGM(commit);
        System.out.println(sol);
    }
}