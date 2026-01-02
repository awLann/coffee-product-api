package com.example.coffee_product_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.coffee_product_api.dto.response.ProductListResponse;
import com.example.coffee_product_api.dto.response.ProductResponse;
import com.example.coffee_product_api.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ProductListResponse> getProducts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int limit
    ) {
        return ResponseEntity.ok(
            productService.getProducts(page, limit)
        );
    }
    
    @GetMapping("/search")
    public ResponseEntity<ProductListResponse> searchProducts(
        @RequestParam String q,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int limit
    ) {
        return ResponseEntity.ok(
            productService.searchProducts(q, page, limit)
        );
    }
    
    @GetMapping("/{slug}")
    public ResponseEntity<ProductResponse> getProductDetail(
        @PathVariable String slug
    ) {
        return ResponseEntity.ok(
            productService.getProduct(slug)
        );
    }
    
}
