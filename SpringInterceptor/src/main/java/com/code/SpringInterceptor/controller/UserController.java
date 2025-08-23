package com.code.SpringInterceptor.controller;

import com.code.SpringInterceptor.entity.User;
import com.code.SpringInterceptor.service.UserService;
import com.code.SpringInterceptor.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    // getting service bean
    private UserServiceImpl userService;

    UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.userList());
    }


}
