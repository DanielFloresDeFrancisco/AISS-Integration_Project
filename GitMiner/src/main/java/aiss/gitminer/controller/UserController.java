package aiss.gitminer.controller;

import aiss.gitminer.exception.UserNotFoundException;
import aiss.gitminer.model.Comment;
import aiss.gitminer.model.User;
import aiss.gitminer.repository.UserRepository;
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
@RequestMapping("/gitminer/users")
public class UserController {

    @Autowired
    UserRepository repository;

    // Find all users
    @Operation(
            summary = "Retrieve a list of all the users",
            description = "get a list of users",
            tags = {"users", "get"})

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Comment.class),
                    mediaType = "application/json")})})

    @GetMapping
    public List<User> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(required = false) String name,
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

       Page<User> pageUsers;

       if(name == null) {
           pageUsers = repository.findAll(paging);
       } else {
           pageUsers = repository.findByName(name, paging);
       }

       return pageUsers.getContent();
    }

    // Find one user by its ID
    @Operation(
            summary = "Find an user by its id",
            description = "Find an user by specifying its Id",
            tags = {"users", "get"})

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Comment.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })})

    @GetMapping("/{id}")
    public User findOne(@PathVariable String id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()){
            throw new UserNotFoundException();
        }
        return user.get();
    }

    // Create a new user
    @Operation(
            summary = "Insert an user",
            description = "Add a new user whose data is passed in the body of the request in JSON format",
            tags = {"users", "post"})

    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Comment.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })})

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        User _user = repository
                .save(new User(
                        user.getId(),
                        user.getUsername(),
                        user.getName(),
                        user.getAvatarUrl(),
                        user.getWebUrl()));
        return _user;
    }

    // Update an existing user
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
    public void updateUser(@Valid @RequestBody User updatedUser, @PathVariable String id) {
        Optional<User> userData = repository.findById(id);

        User _user = userData.get();
        _user.setId(updatedUser.getId());
        _user.setName(updatedUser.getName());
        _user.setUsername(updatedUser.getUsername());
        _user.setAvatarUrl(updatedUser.getAvatarUrl());
        _user.setWebUrl(updatedUser.getWebUrl());

        repository.save(_user);
    }

    // Delete an album
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
    public void deleteUser(@PathVariable String id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
