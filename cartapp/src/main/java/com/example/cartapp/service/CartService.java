package com.example.cartapp.service;

import com.example.cartapp.model.Cart;
import com.example.cartapp.model.CartItem;
import com.example.cartapp.repository.CartItemRepository;
import com.example.cartapp.repository.CartRepository;
//import com.example.cartapp.repository.CartRepository;
//import com.example.productapp.model.Product;
//import com.example.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
//    private final ProductService productService;

//    public CartService(CartRepository cartRepository, CartRepository cartItemRepository, ProductService productService) {
//        this.cartRepository = cartRepository;
//        this.cartItemRepository = cartRepository;
//        this.productService = productService;
//    }

    public Cart createCart(Cart cart) {
        if (cartRepository.findByName(cart.getName()).isPresent()) {
            throw new RuntimeException("Cart with this name already exists.");
        }
//        Cart cart = new Cart();
//        cart.setName(name);
        return cartRepository.save(cart);
    }

    public void deleteCart(Long cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Cart not found.");
        }
        cartRepository.deleteById(cartId);
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found."));
    }

    public CartItem addCartItem(CartItem cartItem) {
        Cart cart = cartRepository.findByName(cartItem.getCart().getName())
                .orElseThrow(() -> new RuntimeException("Cart not found with name: " + cartItem.getCart().getName()));

//        Product product = productService.getProductById(productId);

//        if (product.getStock() < quantity) {
//            throw new RuntimeException("Insufficient stock for product: " + product.getName());
//        }

//        CartItem cartItem = new CartItem();
//        cartItem.setCart(cart);
//        cartItem.setProductId(productId);
//        cartItem.setQuantity(quantity);

        // Update product stock
//        product.setStock(product.getStock() - quantity);
//        productService.updateProductStockAndPrice(productId, product.getStock(), product.getPrice());

        cartItem.setCart(cart);
        return cartItemRepository.save(cartItem);
    }

    public void deleteItemFromCart(Long cartItemId) {
        if (!cartRepository.existsById(cartItemId)) {
            throw new RuntimeException("Cart item not found.");
        }
        cartRepository.deleteById(cartItemId);
    }

    public List<Cart> getAll(){
        return cartRepository.findAll();
    }
}
