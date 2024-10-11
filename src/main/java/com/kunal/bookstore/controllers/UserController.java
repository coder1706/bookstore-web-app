package com.kunal.bookstore.controllers;

import com.kunal.bookstore.entities.User;
import com.kunal.bookstore.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Check if the username already exists
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists.");
        }

        userService.registerUser(user); // Register the new user
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok("Login successful");  // Will be handled by Spring Security
    }

    // Profile endpoint to get user details after login
    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile() {
        // Assuming the authenticated user's details are returned here
        // Spring Security automatically handles this with authentication
        User authenticatedUser = userService.getAuthenticatedUser();  // Implement this in UserService
        return ResponseEntity.ok(authenticatedUser);
    }
}
