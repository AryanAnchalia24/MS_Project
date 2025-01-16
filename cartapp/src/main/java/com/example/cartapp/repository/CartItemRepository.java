package com.example.cartapp.repository;

import com.example.cartapp.model.Cart;
import com.example.cartapp.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
//    Optional<Cart> findByName(String name);
}