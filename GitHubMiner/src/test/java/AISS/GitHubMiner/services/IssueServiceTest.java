package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Comment;
import AISS.GitHubMiner.models.Commit;
import AISS.GitHubMiner.models.InputModels.IssueGM;
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

    @Autowired
    CommentService commentService;

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
        Integer maxPages = 2; Integer maxIssuePerPage = 30;
        List<Issue> issues = service.getIssuesPagination("spring-projects", "spring-framework", maxPages,2);
        assertTrue(!issues.isEmpty(), "The list of issues is empty");
        assertTrue(issues.size() <= maxIssuePerPage * maxPages, "There is an error while retrieving all the issues");
        System.out.println(issues.size());
    }



    @Test
    @DisplayName("Get one issue")
    void getOneIssue() {
        Integer issueN = 2592;
        Issue issue = service.getOneIssue("octocat", "Hello-World", issueN.toString());
        assertTrue(issue.getNumber().equals(issueN), "Wrong Issue retrieving");
        System.out.println(issue);
    }

    @Test //Test for GM Entity
    void IssueGMTest() {
        Issue issue = service.getOneIssue("octocat", "Hello-World", "2592");
        List<Comment> commentList = commentService.getAllCommentsOfAnIssue("octocat", "Hello-World", "2592");
        IssueGM sol = new IssueGM(issue, commentList);
        System.out.println(sol);
    }

}