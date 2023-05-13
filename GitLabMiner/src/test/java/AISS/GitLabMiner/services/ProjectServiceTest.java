package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Comment;
import AISS.GitLabMiner.models.Commit;
import AISS.GitLabMiner.models.InputModels.ProjectGM;
import AISS.GitLabMiner.models.Issue;
import AISS.GitLabMiner.models.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProjectServiceTest {

    @Autowired
    ProjectService service;
    @Autowired
    CommentService commentService;
    @Autowired
    CommitService commitService;
    @Autowired
    IssueService issueService;

    @Test
    void getAllProjects() {
        List<Project> projects = service.getAllProjects();
        assertTrue(!projects.isEmpty());
        System.out.println(projects.size());
    }

    @Test
    void getOneProject() {
        Project p = service.getOneProject("10993694");
        assertTrue(p.getId().equals(10993694), "Wrong project");
        System.out.println(p.toString());
    }

    @Test // Test for GM Entity
    void ProjectGMTest() {
        Project p = service.getOneProject("10993694");
        List<Commit> commits = commitService.getCommitsPagination("10993694", 2,500);
        List<Issue> issues = issueService.getIssuesPagination("10993694",2,200);
        Map<Integer, List<Comment>> Cmap = new HashMap<>();
        for (Issue i: issues) {
            List<Comment> lCom = commentService.getCommentsOfIssue("10993694", i.getIid().toString());
            Cmap.put(i.getId(), lCom);
        }
        ProjectGM sol = new ProjectGM(p, commits, issues, Cmap);
        System.out.println(sol.toString());
        //System.out.println(sol.getIssues().);
    }
}