package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Commit;
import AISS.GitHubMiner.models.InputModels.CommentGM;
import AISS.GitHubMiner.models.InputModels.CommitGM;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Prueba "spring-projects", "spring-framework"
@SpringBootTest
class CommitServiceTest {

    @Autowired
    CommitService service;

    @Test
    void findOneCommit() {
        String commitId = "7fd1a60b01f91b314f59955a4e4d4e80d8edf11d";
        Commit commit = service.getOneCommit("octocat", "Hello-World", commitId);
        System.out.println(commit);
    }

    @Test
    @DisplayName("Get commits")
    void findAllCommits() {
        Integer maxCommitsPerPage = 30;
        List<Commit> commits = service.getAllCommits("spring-projects", "spring-framework");
        assertTrue(commits.size() == maxCommitsPerPage, "wrong number of commits");
        assertTrue(!commits.isEmpty(), "wrong number of commits");
        System.out.println(commits.size());
    }

    @Test
    @DisplayName("Get all commits with pagination")
    void findCommitsPagination() {
        Integer maxPages = 2; Integer maxCommitsPerPage = 30;
        List<Commit> commits = service.getCommitsPagination("spring-projects", "spring-framework", maxPages, 2);
        assertTrue(commits.size() <= maxCommitsPerPage * maxPages, "wrong number of commits");
        assertTrue(!commits.isEmpty(), "wrong number of commits");
        System.out.println(commits.size());
    }

    @Test //Test for GM Entity
    void CommitGMTest() {
        Commit commit = service.getOneCommit("octocat", "Hello-World", "7fd1a60b01f91b314f59955a4e4d4e80d8edf11d");
        CommitGM sol = new CommitGM(commit);
        System.out.println(sol.toString());
    }


}