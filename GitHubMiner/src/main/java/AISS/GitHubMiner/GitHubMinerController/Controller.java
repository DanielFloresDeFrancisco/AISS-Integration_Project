package AISS.GitHubMiner.GitHubMinerController;

import AISS.GitHubMiner.models.Comment;
import AISS.GitHubMiner.models.Commit;
import AISS.GitHubMiner.models.InputModels.ProjectGM;
import AISS.GitHubMiner.models.Issue;
import AISS.GitHubMiner.models.Repositorio;
import AISS.GitHubMiner.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/githubminer/projects")
public class Controller {

    @Autowired
    UserService userService;
    @Autowired
    RepositorioService repositorioService;
    @Autowired
    CommitService commitService;
    @Autowired
    CommentService commentService;
    @Autowired
    IssueService issueService;
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/{owner}/{repo}")
    public ProjectGM getOneProject(@PathVariable String owner,@PathVariable String repo, @RequestParam(required = false) Integer maxPages,
                            @RequestParam(required = false) Integer sinceCommits, @RequestParam(required = false) Integer sinceIssues) {

        Repositorio repositorio = repositorioService.getRepository(repo, owner);
        List<Commit> commitList = commitService.getCommitsPagination(owner, repo, maxPages, sinceCommits);
        List<Issue> issueList = issueService.getIssuesPagination(owner, repo, maxPages, sinceIssues);
        Map<Integer, List<Comment>> listMap = new HashMap<>();

        for (Issue issue: issueList) {
            List<Comment> commentList = commentService.getAllCommentsOfAnIssue(owner, repo, issue.getNumber().toString());
            listMap.put(issue.getId(), commentList);
        }

        ProjectGM res = new ProjectGM(repositorio,commitList,issueList,listMap);
        System.out.println(res);

        return  res;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{owner}/{repo}")
    public ProjectGM createProject(@PathVariable String owner,@PathVariable String repo, @RequestParam(required = false) Integer maxPages,
                                   @RequestParam(required = false) Integer sinceCommits, @RequestParam(required = false) Integer sinceIssues) {

        String url = "http://localhost:8080/gitminer/projects";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ProjectGM project = getOneProject(owner, repo, maxPages, sinceCommits, sinceCommits);
        System.out.println(project);

        HttpEntity<ProjectGM> req = new HttpEntity<>(project, headers);
        try {
            ProjectGM projectPosted = restTemplate.postForObject(url, req, ProjectGM.class);
            return projectPosted;
        } catch (HttpStatusCodeException error) {
            throw new ResponseStatusException(
                    HttpStatus.valueOf(error.getRawStatusCode()),"Error while posting the project", error
            );
        }
    }
}