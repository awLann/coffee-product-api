package com.example.coffee_product_api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.coffee_product_api.dto.response.PaginationResponse;
import com.example.coffee_product_api.dto.response.ProductListResponse;
import com.example.coffee_product_api.dto.response.ProductResponse;
import com.example.coffee_product_api.entity.Product;
import com.example.coffee_product_api.exception.ResourceNotFoundException;
import com.example.coffee_product_api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    private static final int MAX_LIMIT = 50;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResponse getProducts(int page, int limit) {
        
        int pageSize = Math.min(limit, MAX_LIMIT);
        PageRequest pageable = PageRequest.of(page, pageSize);

        Page<Product> productPage = productRepository.findAllByOrderByPublishedAtDesc(pageable);

        return buildResponse(productPage);
    }

    @Override
    public ProductListResponse searchProducts(String keyword, int page, int limit) {
        
        int pageSize = Math.min(limit, MAX_LIMIT);
        PageRequest pageable = PageRequest.of(page, pageSize);

        Page<Product> productPage = productRepository.findByNameContainingIgnoreCaseOrSlugContainingIgnoreCaseOrderByPublishedAtDesc(keyword, keyword, pageable);

        return buildResponse(productPage);
    }

    @Override
    public ProductResponse getProduct(String slug) {
        
        Product product = productRepository.findBySlug(slug)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        return ProductResponse.from(product);
    }

    private ProductListResponse buildResponse(Page<Product> page) {

        List<ProductResponse> data = page.getContent()
            .stream()
            .map(ProductResponse::from)
            .toList();

        PaginationResponse pagination = new PaginationResponse(
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages(),
            page.hasNext()
        );

        return new ProductListResponse(data, pagination);
    }
}
