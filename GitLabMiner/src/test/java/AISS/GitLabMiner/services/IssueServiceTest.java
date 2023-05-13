package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Comment;
import AISS.GitLabMiner.models.Commit;
import AISS.GitLabMiner.models.InputModels.IssueGM;
import AISS.GitLabMiner.models.Issue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IssueServiceTest {

    @Autowired
    IssueService service;
    @Autowired
    CommentService commentService;

    @Test
    void findIssuesOfProject() {
        // It retrieves only one page of issues (no pagination)
        Integer issuesPerPage = 20;
        List<Issue> issues = service.getIssuesOfProject("10993694");
        assertTrue(issues.size()== issuesPerPage, "Wrong number of commits");
        System.out.println(issues.size());
    }

    @Test
    void findIssuesOfProjectWithPagination() {
        Integer issuesPerPage = 20;
        Integer maxPages = 3;
        List<Issue> issues = service.getIssuesPagination("10993694", maxPages,100);
        assertTrue(!issues.isEmpty(), "There was an error while retrieving issues");
        assertTrue(issues.size() <= issuesPerPage * maxPages, "There was an error while retrieving issues");
        System.out.println(issues.size());
    }

    @Test
    void findOneIssueByInternalId() {
        String issueInternalId = "240";
        Issue issue = service.findOneIssueByInternalId("10993694", issueInternalId);
        assertTrue(issue!=null, "There is an error on the request");
        assertTrue(issue.getIid().equals(240), "There is an error on the request");
        System.out.println(issue.toString());
    }

    @Test //Test for GM Entity
    void IssueGMTest() {
        String issueInternalId = "240";
        Issue issue = service.findOneIssueByInternalId("10993694", issueInternalId);
        List<Comment> comments = commentService.getCommentsOfIssue("10993694", issueInternalId);
        IssueGM sol = new IssueGM(issue, comments);
        System.out.println(sol.toString());

    }
}