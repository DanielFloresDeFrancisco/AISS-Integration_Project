package AISS.GitLabMiner.GitLabMinerController;

import AISS.GitLabMiner.models.Comment;
import AISS.GitLabMiner.models.Commit;
import AISS.GitLabMiner.models.InputModels.IssueGM;
import AISS.GitLabMiner.models.InputModels.ProjectGM;
import AISS.GitLabMiner.models.Issue;
import AISS.GitLabMiner.models.Project;
import AISS.GitLabMiner.services.*;
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
@RequestMapping("/gitlabminer/projects")
public class Controller {

    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    CommitService commitService;
    @Autowired
    CommentService commentService;
    @Autowired
    IssueService issueService;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{id}")
    public ProjectGM getOne(@PathVariable String id, @RequestParam(required = false) Integer maxPages,
                            @RequestParam(required = false) Integer sinceCommits, @RequestParam(required = false) Integer sinceIssues) {

        Project project = projectService.getOneProject(id);
        List<Commit> commits = commitService.getCommitsPagination(id, maxPages, sinceCommits);
        List<Issue> issues = issueService.getIssuesPagination(id, maxPages, sinceIssues);
        Map<Integer, List<Comment>> commentMap = new HashMap<>();

        for (Issue issue: issues) {
            List<Comment> lCom = commentService.getCommentsOfIssue(
                    project.getId().toString(), issue.getIid().toString());

            commentMap.put(issue.getId(), lCom);
        }

        return new ProjectGM(project, commits, issues, commentMap);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public ProjectGM createProject(@PathVariable String id, @RequestParam(required = false) Integer maxPages,
                            @RequestParam(required = false) Integer sinceCommits, @RequestParam(required = false) Integer sinceIssues) {

        String url = "http://localhost:8080/gitminer/projects";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ProjectGM project = getOne(id, maxPages, sinceCommits,sinceIssues);
        for (IssueGM issueGM: project.getIssues()) {
            System.out.println(issueGM);
        }
        // System.out.println(project.getIssues());

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
