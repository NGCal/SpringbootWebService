package com.Restful.webService.controller;

import com.Restful.webService.model.User;
import com.Restful.webService.services.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

}
