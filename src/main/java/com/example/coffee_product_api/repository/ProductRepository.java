package com.example.coffee_product_api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffee_product_api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Optional<Product> findBySlug(String slug);

    Page<Product> findAllByOrderByPublishedAtDesc(Pageable pageable);

    Page<Product> findByNameContainingIgnoreCaseOrSlugContainingIgnoreCaseOrderByPublishedAtDesc(
        String name,
        String slug,
        Pageable pageable
    );
}
