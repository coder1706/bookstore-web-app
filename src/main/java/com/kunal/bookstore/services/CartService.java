package com.kunal.bookstore.services;

import com.kunal.bookstore.entities.Cart;
import com.kunal.bookstore.entities.User;
import com.kunal.bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByUser(User user) {
        return cartRepository.findByUser(user);
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }
}

