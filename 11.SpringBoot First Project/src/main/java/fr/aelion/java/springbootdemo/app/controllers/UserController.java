package fr.aelion.java.springbootdemo.app.controllers;


import fr.aelion.java.springbootdemo.app.entities.User;
import fr.aelion.java.springbootdemo.app.exceptions.ApiError;
import fr.aelion.java.springbootdemo.app.exceptions.ContentNotFoundException;
import fr.aelion.java.springbootdemo.app.exceptions.GlobalException;
import fr.aelion.java.springbootdemo.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public Iterable<User> findAll() {
       return this.userService.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Long id) throws ContentNotFoundException {
        return this.userService.findById(id)
                .orElseThrow(() -> new ContentNotFoundException("User not found"));
    }

    @GetMapping("search/{term}")
    public List<User> findSomeUser(@PathVariable String term) {
        return this.userService.findSomeUser(term);
    }

    @PostMapping("")
    public ResponseEntity<User> create(@RequestBody User u) {
        return new ResponseEntity<>(this.userService.create(u), HttpStatus.CREATED);
    }

    /* @ExceptionHandler(ContentNotFoundException.class)
    public ResponseEntity<ApiError> handleContentNotFoundException(GlobalException e) {
        return new ResponseEntity<>(e.toApiError(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
