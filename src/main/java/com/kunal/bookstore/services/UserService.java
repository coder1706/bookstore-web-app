package com.kunal.bookstore.services;

import com.kunal.bookstore.entities.User;
import com.kunal.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

 /*   public User registerUser(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already taken");
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password)); // Hash password
        newUser.setRole("USER"); // Default role

        return userRepository.save(newUser);
    } */
    public void registerUser(User user) {
        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set default role if not specified
        if (user.getRole() == null) {
            user.setRole("USER"); // Default role for new users
        }

        // Save the user
        userRepository.save(user);
    }


    // This method is used during login to find a user by their username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }


    // Method to return the currently authenticated user
    public User getAuthenticatedUser() {
        // Retrieve the authentication object from the security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // If no authentication or if it's anonymous (e.g., not logged in), return null or throw an exception
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return null;  // Or throw a custom exception if preferred
        }

        // Extract the username (principal) from the Authentication object
        String username = authentication.getName();

        // Return the User entity from the database by username
        return userRepository.findByUsername(username);
    }
}

