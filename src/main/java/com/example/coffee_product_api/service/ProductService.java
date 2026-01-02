package com.example.coffee_product_api.service;

import com.example.coffee_product_api.dto.response.ProductListResponse;
import com.example.coffee_product_api.dto.response.ProductResponse;

public interface ProductService {
    
    ProductListResponse getProducts(
        int page,
        int limit
    );

    ProductListResponse searchProducts(
        String keyword,
        int page,
        int limit
    );

    ProductResponse getProduct(String slug);
}
