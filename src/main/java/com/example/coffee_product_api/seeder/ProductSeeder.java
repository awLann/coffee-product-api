package com.example.coffee_product_api.seeder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.coffee_product_api.entity.Product;
import com.example.coffee_product_api.repository.ProductRepository;

@Component
public class ProductSeeder implements CommandLineRunner {
    
    private final ProductRepository productRepository;

    public ProductSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        if (productRepository.count() > 0) {
            return;
        }

        List<Product> products = List.of(
            createProduct(
                "Arabica Gayo",
                "arabica-gayo",
                "Single origin coffee from Aceh with balanced acidity",
                new BigDecimal("85000"),
                "single_origin",
                "medium",
                LocalDateTime.now().minusDays(10)
            ),
            createProduct(
                "Robusta Lampung",
                "robusta-lampung",
                "Strong body and bold flavor from Lampung",
                new BigDecimal("65000"),
                "single_origin",
                "dark",
                LocalDateTime.now().minusDays(9)
            ),
            createProduct(
                "Toraja Kalossi",
                "toraja-kalossi",
                "Earthy flavor with low acidity from Toraja",
                new BigDecimal("90000"),
                "single_origin",
                "medium",
                LocalDateTime.now().minusDays(8)
            ),
            createProduct(
                "House Blend",
                "house-blend",
                "Blend of selected beans for daily coffee",
                new BigDecimal("70000"),
                "blend",
                "medium",
                LocalDateTime.now().minusDays(7)
            ),
            createProduct(
                "Espresso Roast",
                "espresso-roast",
                "Dark roast coffee suitable for espresso",
                new BigDecimal("75000"),
                "blend",
                "dark",
                LocalDateTime.now().minusDays(6)
            )
        );

        productRepository.saveAll(products);

        System.out.println("Coffee products seeded successfully");
    }

    

    private Product createProduct(
        String name,
        String slug,
        String description,
        BigDecimal price,
        String category,
        String roastLevel,
        LocalDateTime publishedAt
    ) {
        Product product = new Product();
        product.setName(name);
        product.setSlug(slug);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);
        product.setRoastLevel(roastLevel);
        product.setPublishedAt(publishedAt);
        return product;
    }
}
