package com.Restful.webService.controller;

import com.Restful.webService.exception.UserNotFoundException;
import com.Restful.webService.model.User;
import com.Restful.webService.services.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.PostUpdate;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao users;

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return users.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = users.findById(id);
        if (user == null) {
            throw new UserNotFoundException("User id-" + id);
        }
        return users.findById(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User newUser = users.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.ok(location);
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        User newUser = users.update(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();

        return ResponseEntity.ok(location);
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {

        User User = users.remove(id);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();

        return ResponseEntity.ok(location);
    }


}
