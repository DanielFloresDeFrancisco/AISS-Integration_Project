package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Commit;
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

    @Test
    void findIssuesOfProject() {
        List<Issue> issues = service.findIssuesOfProject("10993694");
        assertTrue(issues.size()==20, "Wrong number of commits");
        System.out.println(issues.size());
    }

    @Test
    void findIssuesOfProjectWithPagination() {
        Integer totalIssues = 234;
        List<Issue> issues = service.findIssuesPagination("10993694");
        assertTrue(issues.size() == totalIssues);
        System.out.println(issues.size());
    }

    @Test
    void findOneIssueByInternalId() {
        String issueInternalId = "240";
        Issue issue = service.findOneIssueByInternalId("10993694", issueInternalId);
        assertTrue(issue!=null, "There is an error on the request");
        System.out.println(issue.toString());
    }
}