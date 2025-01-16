package com.example.productapp.service;

import com.example.productapp.model.Product;
import com.example.productapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Product not found with name: " + name));
    }

    public Product createProduct(Product product) {
        if (productRepository.findByName(product.getName()).isPresent()) {
            throw new RuntimeException("Product with the same name already exists.");
        }
        return productRepository.save(product);
    }

    public Product updateProductStockAndPrice(Long id, int stock, double price) {
        Product product = getProductById(id);
        product.setStock(stock);
        product.setPrice(price);
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
