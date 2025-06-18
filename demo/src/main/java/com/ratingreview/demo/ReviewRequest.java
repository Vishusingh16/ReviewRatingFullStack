package com.ratingreview.demo;
public class ReviewRequest {

    private Long productId;
    private String username;
    private Integer rating; // Optional
    private String reviewText; // Optional
    private String imageUrl; // Optional

    // Default constructor
    public ReviewRequest() {
    }

    // All-args constructor
    public ReviewRequest(Long productId, String username, Integer rating, String reviewText, String imageUrl) {
        this.productId = productId;
        this.username = username;
        this.rating = rating;
        this.reviewText = reviewText;
        this.imageUrl = imageUrl;
    }

    // Getters & Setters

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
