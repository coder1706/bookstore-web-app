package com.kunal.bookstore.controllers;

import com.kunal.bookstore.entities.Book;
import com.kunal.bookstore.entities.Cart;
import com.kunal.bookstore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        // Logic to get cart by user
        return null;
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Book book, @RequestParam Long userId) {
        // Logic to add book to cart
        return null;
    }
}

