package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Commit;
import AISS.GitHubMiner.models.Issue;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Prueba "spring-projects", "spring-framework"
@SpringBootTest
class IssueServiceTest {

    @Autowired
    IssueService service;

    @Test
    @DisplayName("Get all issues without pagination")
    void getAllIssues() {
        List<Issue> issues= service.getAllIssues("spring-projects", "spring-framework");
        assertTrue(!issues.isEmpty(), "The list of issues is empty");
        assertTrue(issues.size()==30, "Wrong number of issues");
        System.out.println(issues.size());
    }

    @Test
    @DisplayName("Get all issues with pagination")
    void findIssuesPagination() {
        List<Issue> issues = service.findIssuesPagination("spring-projects", "spring-framework");
        System.out.println(issues.size());
    }



    @Test
    @DisplayName("Get one issue")
    void getOneIssue() {
        Issue issue = service.getOneIssue("octocat", "Hello-World", "2592");
        System.out.println(issue);
    }
}