package aiss.gitminer.controller;

import aiss.gitminer.exception.CommitNotFoundException;
import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Project;
import aiss.gitminer.repository.CommitRepository;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gitminer/commits")
public class CommitController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    CommitRepository commitRepository;

    // GET http://localhost:8080/api/commits
    @Operation(
            summary = "Retrieve a list of commits",
            description = "Get a list of commits",
            tags = { "commits", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Commit.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Commit not found", content = {@Content(schema= @Schema())})
    })
    @GetMapping
    public List<Commit> findAll(@RequestParam(value = "email", required = false) String email,
                                    @RequestParam(required = false) String title,
                                    @RequestParam(required = false) String order,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) throws CommitNotFoundException {

        Pageable paging;

        if(order != null){
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        }
        else
            paging = PageRequest.of(page, size);

        Page<Commit> pageCommits;

        if(title == null && email == null)
            pageCommits = commitRepository.findAll(paging);
        else if(title != null && email == null)
            pageCommits = commitRepository.findByTitle(title, paging);
        else {
            pageCommits = commitRepository.findByAuthorEmail(email, paging);
        }
        return pageCommits.getContent();
    }

    // GET http://localhost:8080/api/commits/{id}
    @Operation(
            summary = "Retrieve a commit by id",
            description = "Get a commit object by specifying its id",
            tags = { "commits", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Commit.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema= @Schema())})
    })
    @GetMapping("/{id}")
    public Commit findOne(@PathVariable(value="id") String id) throws CommitNotFoundException {
        Optional<Commit> commit = commitRepository.findById(id);
        if(!commit.isPresent()) {
            throw new CommitNotFoundException();
        }
        return commit.get();
    }

    // POST http://localhost:8080/gitminer/commits
    @Operation(
            summary = "Insert a commit",
            description = "Add a new commit whose data is passed in the body of the request in JSON format",
            tags = { "commits", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Commit.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema= @Schema())})
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Commit createCommit(@RequestBody @Valid Commit commit) {
        Commit _commit = commitRepository
                .save(new Commit(
                        commit.getId(),
                        commit.getTitle(),
                        commit.getMessage(),
                        commit.getAuthorName(),
                        commit.getAuthorEmail(),
                        commit.getAuthoredDate(),
                        commit.getCommitterName(),
                        commit.getCommitterEmail(),
                        commit.getCommittedDate(),
                        commit.getWebUrl()));
        return _commit;
    }

    // PUT http://localhost:8080/api/commits/{id}
    @Operation(
            summary = "Update a commit",
            description = "Update a commit object by specifying its id and whose data is passed in the body of the request in JSON format",
            tags = { "commits", "put" })
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = {@Content(schema= @Schema()) }),
            @ApiResponse(responseCode = "404", content = {@Content(schema= @Schema()) })
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCommit(@RequestBody @Valid Commit updatedCommit, @PathVariable String id) throws CommitNotFoundException {
        Optional<Commit> commitData = commitRepository.findById(id);
        if(!commitData.isPresent()) {
            throw new CommitNotFoundException();
        }
        Commit _commit = commitData.get();
        _commit.setId(updatedCommit.getId());
        _commit.setTitle(updatedCommit.getTitle());
        _commit.setMessage(updatedCommit.getMessage());
        _commit.setAuthorName(updatedCommit.getAuthorName());
        _commit.setAuthorEmail(updatedCommit.getAuthorEmail());
        _commit.setAuthoredDate(updatedCommit.getAuthoredDate());
        _commit.setCommitterName(updatedCommit.getCommitterName());
        _commit.setCommitterEmail(updatedCommit.getCommitterEmail());
        _commit.setCommittedDate(updatedCommit.getCommittedDate());
        _commit.setWebUrl(updatedCommit.getWebUrl());
        commitRepository.save(_commit);
    }

    // DELETE http://localhost:8080/api/commits/{id}
    @Operation(
            summary = "Delete a commit",
            description = "Delete a commit object by specifying its id",
            tags = { "commits", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = {@Content(schema= @Schema()) }),
            @ApiResponse(responseCode = "404", content = {@Content(schema= @Schema()) })
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommit(@PathVariable String id) {
        if (commitRepository.existsById(id)){
            commitRepository.deleteById(id);
        }
    }
}
