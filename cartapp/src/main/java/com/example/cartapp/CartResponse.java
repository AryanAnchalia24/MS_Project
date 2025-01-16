package com.example.cartapp;

import com.example.cartapp.model.Cart;
import com.example.cartapp.model.CartItem;

import java.util.List;

public class CartResponse {
    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    private List<Cart> carts;

    private List<CartItem> cartItemList;

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public List<ProductResponse> getProductResponse() {
        return productResponse;
    }

    public void setProductResponse(List<ProductResponse> productResponse) {
        this.productResponse = productResponse;
    }

    private List<ProductResponse> productResponse;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    private Double total;
}
