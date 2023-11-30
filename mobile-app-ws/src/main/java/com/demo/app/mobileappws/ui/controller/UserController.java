package com.demo.app.mobileappws.ui.controller;

import com.demo.app.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.demo.app.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.demo.app.ui.model.response.UserRest;
import com.demo.app.userservice.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Validated
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50") int limit,
            @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "Get users was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
    }

    @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        /*String firstName = null;
        int length = firstName.length(); // Test for null pointer exception handler

        if (true){
            throw new UserServiceException("This is my UserServiceException being thrown.");    //  Test for my custom user service exception handler.
        }
        */

        if (userService.getUsers().containsKey(userId)) {
            return new ResponseEntity<UserRest>(userService.getUserById(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest user = userService.createUser(userDetails);
        if (userService.getUsers() == null)
            userService.setUsers(new HashMap<>());
        userService.getUsers().put(user.getUserId(), user);
        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = {
                    MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public UserRest updateUser(@PathVariable String userId,
            @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
        UserRest storedUserDetails = userService.getUsers().get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        userService.getUsers().put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.getUsers().remove(userId);
        return ResponseEntity.noContent().build();
    }
}
