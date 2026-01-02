package com.example.coffee_product_api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.coffee_product_api.entity.Product;

public class ProductResponse {
    
    private Long id;
    private String name;
    private String slug;
    private String description;
    private BigDecimal price;
    private String category;
    private String roastLevel;
    private LocalDateTime publishedAt;

    public static ProductResponse from(Product product) {
        ProductResponse dto = new ProductResponse();
        dto.id = product.getId();
        dto.name = product.getName();
        dto.slug = product.getSlug();
        dto.description = product.getDescription();
        dto.price = product.getPrice();
        dto.category = product.getCategory();
        dto.roastLevel = product.getRoastLevel();
        dto.publishedAt = product.getPublishedAt();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getRoastLevel() {
        return roastLevel;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }
}
