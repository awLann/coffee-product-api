package com.example.coffee_product_api.dto.response;

public class PaginationResponse {

    private int page;
    private int limit;
    private long totalElements;
    private int totalPages;
    private boolean hasNext;

    public PaginationResponse(int page, int limit, long totalElements, int totalPages, boolean hasNext) {
        this.page = page;
        this.limit = limit;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.hasNext = hasNext;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean isHasNext() {
        return hasNext;
    }
}
