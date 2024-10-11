package com.kunal.bookstore.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/home")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();

        // Get logged-in user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authentication: " + authentication);

        // Check if the user is authenticated (not "anonymousUser")
        boolean isAuthenticated = authentication != null && authentication.isAuthenticated()
                && !"anonymousUser".equals(authentication.getName());

        // Add authentication status and username to response
        response.put("isAuthenticated", isAuthenticated);

        if (isAuthenticated) {
            response.put("username", authentication.getName());
        } else {
            response.put("username", null);
        }

        return response;
    }
}
