package aiss.gitminer.controller;

import aiss.gitminer.exception.IssueNotFoundException;
import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;
import aiss.gitminer.repository.IssueRepository;
import aiss.gitminer.repository.ProjectRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gitminer/issues")
public class IssueController {


    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    IssueRepository issueRepository;

    // GET http://localhost:8080/api/issues
    @Operation(
            summary = "Retrieve a list of issues",
            description = "Get a list of issues",
            tags = { "issues", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Issue.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Issue not found", content = {@Content(schema= @Schema())})
    })
    @GetMapping
    public List<Issue> findAll(@RequestParam(value = "authorId", required = false) String authorId,
                               @RequestParam(value = "state", required = false) String state,
                               @RequestParam(required = false) String title,
                               @RequestParam(required = false) String order,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size) throws IssueNotFoundException {

        Pageable paging;

        if(order != null){
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        }
        else
            paging = PageRequest.of(page, size);

        Page<Issue> pageIssues;

        if(authorId != null)
            pageIssues = issueRepository.findByAuthorId(authorId, paging);
        else if(state != null)
            pageIssues = issueRepository.findByState(state, paging);
        else if(title != null)
            pageIssues = issueRepository.findByTitle(title, paging);
        else {
            pageIssues = issueRepository.findAll(paging);
        }
        return pageIssues.getContent();
    }



    // GET http://localhost:8080/gitminer/issues/{id}
    @Operation(
            summary = "Retrieve a issue by id",
            description = "Get a issue object by specifying its id",
            tags = { "issues", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Issue.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema= @Schema())})
    })
    @GetMapping("/{id}")
    public Issue findOne(@PathVariable(value="id") String id) throws IssueNotFoundException {
        Optional<Issue> issue = issueRepository.findById(id);
        if(!issue.isPresent()) {
            throw new IssueNotFoundException();
        }
        return issue.get();
    }

    // GET http://localhost:8080/gitminer/issues/{id}/comments
    @Operation(
            summary = "Retrieve the comments of a issue",
            description = "Get the comments of a issue object by specifying its id",
            tags = { "commits", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Issue.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema= @Schema())})
    })
    @GetMapping("/{id}/comments")
    public List<Comment> findComments(@PathVariable(value="id") String id) throws IssueNotFoundException {
        Optional<Issue> issue = issueRepository.findById(id);
        if(!issue.isPresent()) {
            throw new IssueNotFoundException();
        }
        return issue.get().getComments();
    }

    // POST http://localhost:8080/gitminer/issues
    @Operation(
            summary = "Insert an issue",
            description = "Add a new issue whose data is passed in the body of the request in JSON format",
            tags = { "issues", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Issue.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema= @Schema())})
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Issue createIssue(@Valid @RequestBody Issue issue) {
        Issue _issue = issueRepository
                .save(new Issue(
                        issue.getId(),
                        issue.getRefId(),
                        issue.getTitle(),
                        issue.getDescription(),
                        issue.getState(),
                        issue.getCreatedAt(),
                        issue.getUpdatedAt(),
                        issue.getClosedAt(),
                        issue.getLabels(),
                        issue.getAuthor(),
                        issue.getAssignee(),
                        issue.getUpvotes(),
                        issue.getDownvotes(),
                        issue.getWebUrl(),
                        issue.getComments()));
        return _issue;
    }

    // PUT http://localhost:8080/gitminer/issues/{id}
    @Operation(
            summary = "Update an issue",
            description = "Update an issue object by specifying its id and whose data is passed in the body of the request in JSON format",
            tags = { "issues", "put" })
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = {@Content(schema= @Schema()) }),
            @ApiResponse(responseCode = "404", content = {@Content(schema= @Schema()) })
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateIssue(@RequestBody @Valid Issue updatedIssue, @PathVariable String id) throws IssueNotFoundException {
        // TODO: COMPLETE
        Optional<Issue> issueData = issueRepository.findById(id);
        if(!issueData.isPresent()) {
            throw new IssueNotFoundException();
        }
        Issue _issue = issueData.get();
        _issue.setId(updatedIssue.getId());
        _issue.setRefId(updatedIssue.getRefId());
        _issue.setTitle(updatedIssue.getTitle());
        _issue.setDescription(updatedIssue.getDescription());
        _issue.setState(updatedIssue.getState());
        _issue.setCreatedAt(updatedIssue.getCreatedAt());
        _issue.setUpdatedAt(updatedIssue.getUpdatedAt());
        _issue.setClosedAt(updatedIssue.getClosedAt());
        _issue.setLabels(updatedIssue.getLabels());
        _issue.setAuthor(updatedIssue.getAuthor());
        _issue.setAssignee(updatedIssue.getAssignee());
        _issue.setUpvotes(updatedIssue.getUpvotes());
        _issue.setDownvotes(updatedIssue.getDownvotes());
        _issue.setWebUrl(updatedIssue.getWebUrl());
        _issue.setComments(updatedIssue.getComments());
        issueRepository.save(_issue);
    }

    // DELETE http://localhost:8080/api/issues/{id}
    @Operation(
            summary = "Delete an issue",
            description = "Delete an issue object by specifying its id",
            tags = { "issues", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = {@Content(schema= @Schema()) }),
            @ApiResponse(responseCode = "404", content = {@Content(schema= @Schema()) })
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIssue(@PathVariable String id) {
        if (issueRepository.existsById(id)){
            issueRepository.deleteById(id);
        }
    }
}
