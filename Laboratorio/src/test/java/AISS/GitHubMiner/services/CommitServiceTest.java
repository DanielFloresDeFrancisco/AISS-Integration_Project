package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Commit;
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
        Commit commit = service.findOneCommit("octocat", "Hello-World", "7fd1a60b01f91b314f59955a4e4d4e80d8edf11d");
        System.out.println(commit);

    }

    @Test
    @DisplayName("Get commits")
    void findAllCommits() {
        List<Commit> commits = service.findAllCommits("spring-projects", "spring-framework");
        assertTrue(commits.size()==30, "wrong number of commits");
        System.out.println(commits.size());
    }

    @Test
    @DisplayName("Get all commits with pagination")
    void findCommitsPagination() {
        List<Commit> commits = service.findCommitsPagination("spring-projects", "spring-framework");
        System.out.println(commits.size());
    }


}