package com.kunal.bookstore.repository;

import com.kunal.bookstore.entities.Cart;
import com.kunal.bookstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
