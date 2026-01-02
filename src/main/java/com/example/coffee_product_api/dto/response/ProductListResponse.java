package com.example.coffee_product_api.dto.response;

import java.util.List;

public class ProductListResponse {
    
    private List<ProductResponse> data;
    private PaginationResponse pagination;

    public ProductListResponse(
        List<ProductResponse> data,
        PaginationResponse pagination
    ) {
        this.data = data;
        this.pagination = pagination;
    }

    public List<ProductResponse> getData() {
        return data;
    }

    public PaginationResponse getPagination() {
        return pagination;
    }
}
