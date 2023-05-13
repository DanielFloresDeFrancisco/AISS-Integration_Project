package aiss.gitminer.controller;

import aiss.gitminer.exception.CommentNotFoundException;
import aiss.gitminer.model.Comment;
import aiss.gitminer.repository.CommentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.User;
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
@Tag(name = "Comment", description = "Comment management API")
@RestController
@RequestMapping("/gitminer/comments")
public class CommentController {

    @Autowired
    CommentRepository repository;

    // Find all comments:
    @Operation(
            summary = "Retrieve a list of all the comments",
            description = "get a list of comments",
            tags = {"comments", "get"})

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Comment.class),
                    mediaType = "application/json")})})

    @GetMapping
    public List<Comment> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(required = false) User author,
                                 @RequestParam(required = false) String order) {

        Pageable paging;

        if (order != null) {
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());

            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        }
        else {
            paging = PageRequest.of(page, size);
        }

        Page<Comment> pageComments;

        if (author == null){
            pageComments = repository.findAll(paging);
        } else {
            pageComments = repository.findByAuthor((aiss.gitminer.model.User) author, paging);
        }

        return pageComments.getContent();
    }

    // Find one comment by its ID
    @Operation(
            summary = "Find a comment by its id",
            description = "Find a comment by specifying its Id",
            tags = {"comments", "get"})

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Comment.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })})

    @GetMapping("/{id}")
    public Comment findOne(@Parameter(description = "Id of the comment that is going to be searched:")
                           @PathVariable String id) throws CommentNotFoundException {
        Optional<Comment> comment = repository.findById(id);
        if (!comment.isPresent()){
            throw new CommentNotFoundException();
        }
        return comment.get();
    }

    // Create a new comment
    @Operation(
            summary = "Insert a Comment",
            description = "Add a new comment whose data is passed in the body of the request in JSON format",
            tags = {"comments", "post"})

    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Comment.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })})

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Comment createComment(@Valid @RequestBody Comment comment) {
        Comment _comment = repository
                .save(new Comment(
                        comment.getId(),
                        comment.getBody(),
                        comment.getAuthor(),
                        comment.getCreatedAt(),
                        comment.getUpdatedAt()));
        return _comment;
    }

    // Update an existing comment
    @Operation(
            summary = "Update a comment",
            description = "update a comment object by specifying its id and " +
                    "whose data is passed in the body of the request in JSON format",
            tags = {"comments", "put"})

    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })})

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateComment(@Valid @RequestBody Comment updatedComment, @PathVariable String id) {
        Optional<Comment> commentData = repository.findById(id);

        Comment _comment = commentData.get();
        _comment.setId(updatedComment.getId());
        _comment.setBody(updatedComment.getBody());
        _comment.setAuthor(updatedComment.getAuthor());
        _comment.setUpdatedAt(updatedComment.getUpdatedAt());
        _comment.setCreatedAt(updatedComment.getCreatedAt());

        repository.save(_comment);
    }

    // Delete a comment

    @Operation(
            summary = "Delete a comment",
            description = "Delete a comment by specifying its Id",
            tags = {"comments", "delete"})

    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })})

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")


    public void deleteComment(@PathVariable String id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
