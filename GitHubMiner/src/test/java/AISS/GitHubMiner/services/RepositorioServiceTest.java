package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Comment;
import AISS.GitHubMiner.models.Commit;
import AISS.GitHubMiner.models.InputModels.ProjectGM;
import AISS.GitHubMiner.models.Issue;
import AISS.GitHubMiner.models.Repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

@SpringBootTest
class RepositorioServiceTest {

    @Autowired
    RepositorioService service;

    @Autowired
    CommitService commitService;
    @Autowired
    IssueService issueService;
    @Autowired
    CommentService commentService;

    @Test
    void findRepository() {
        Repositorio repos = service.getRepository("Hello-World", "octocat");
        assertTrue(repos != null, "There is an error while retrieving the repository");
        System.out.println(repos);
    }

    @Test //Test of GM Entity
    void ProjectGMTest() {
        Repositorio repos = service.getRepository("HealthVault-Mobile-iOS-Library", "microsoft");
        List<Commit> commits = commitService.getCommitsPagination("microsoft", "HealthVault-Mobile-iOS-Library", 2,2);
        List<Issue> issues = issueService.getIssuesPagination("microsoft", "HealthVault-Mobile-iOS-Library", 2,2);
        Map<Integer, List<Comment>> commentMap = new HashMap<>();
        for (Issue i: issues) {
            List<Comment> lCom = commentService.getAllCommentsOfAnIssue("microsoft","HealthVault-Mobile-iOS-Library", i.getNumber().toString());
            commentMap.put(i.getId(), lCom);
        }
        ProjectGM sol = new ProjectGM(repos, commits, issues, commentMap);
        System.out.println(sol);
    }
}