package com.example.cartapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "productapp", url = "http://localhost:8080",path = "/productapp")
public interface InterCommunication {
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAll();

    @GetMapping("/name/{name}")
    public ResponseEntity<ProductResponse> getProductByName(@PathVariable String name);

    @PutMapping("/updateStock/{name}/{quantity}")
    public ResponseEntity<Boolean> updateStock(@PathVariable String name, @PathVariable Long quantity);

    @GetMapping("/getPrice/{name}")
    public ResponseEntity<Double> getPrice(@PathVariable String name);
}
