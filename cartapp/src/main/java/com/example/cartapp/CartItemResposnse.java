package com.example.cartapp;

import com.example.cartapp.model.Cart;
import com.example.cartapp.model.CartItem;

import java.util.List;

public class CartItemResposnse {
    Cart cart;
    List<CartItem> cartItem;
    Double total;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
