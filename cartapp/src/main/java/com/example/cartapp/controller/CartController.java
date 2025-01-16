package com.example.cartapp.controller;

import com.example.cartapp.model.Cart;
import com.example.cartapp.model.CartItem;
import com.example.cartapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

//    public CartController(CartService cartService) {
//        this.cartService = cartService;
//    }

    @GetMapping("/all")
    public ResponseEntity<List<Cart>> getAll(){
        return ResponseEntity.ok(cartService.getAll());
    }
    @PostMapping("/create")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.createCart(cart));
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartService.getCartById(cartId));
    }

    @PostMapping("/addItems")
    public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem) {
        return ResponseEntity.ok(cartService.addCartItem(cartItem));
    }

    @DeleteMapping("/items/{cartItemId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long cartItemId) {
        cartService.deleteItemFromCart(cartItemId);
        return ResponseEntity.noContent().build();
    }
}
