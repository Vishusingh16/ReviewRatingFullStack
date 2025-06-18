
package com.ratingreview.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository; // Needed for the addReview method

    /**
     * Retrieves all reviews from the database.
     * This method is called by the new endpoint in ReviewController.
     *
     * @return A list of all Review entities.
     */
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    /**
     * Creates and saves a new review for a specific product.
     *
     * @param productId The ID of the product being reviewed.
     * @param username The name of the user leaving the review.
     * @param rating The star rating (e.g., 1-5).
     * @param reviewText The text content of the review.
     * @param imageUrl An optional URL for an image with the review.
     * @return The saved Review entity.
     * @throws RuntimeException if the product with the given ID is not found.
     */
    public Review addReview(Long productId, String username, Integer rating, String reviewText, String imageUrl) {
        // Find the product by its ID. Throw an error if it doesn't exist.
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        Review review = new Review();
        review.setProduct(product); // Associate the review with the product
        review.setUsername(username);
        review.setRating(rating);
        review.setReviewText(reviewText);
        review.setImageUrl(imageUrl);
        review.setCreatedAt(LocalDateTime.now()); // Set the creation timestamp

        return reviewRepository.save(review);
    }

    /**
     * Retrieves all reviews for a specific product.
     *
     * @param productId The ID of the product.
     * @return A list of reviews for that product.
     */
    public List<Review> getReviewsForProduct(Long productId) {
        return reviewRepository.findByProductId(productId);
    }
}