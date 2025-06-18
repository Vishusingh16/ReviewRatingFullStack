

package com.ratingreview.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    /**
     * Handles GET requests to /api/reviews to fetch all reviews.
     * This is the new endpoint that solves the 404 Not Found error.
     *
     * @return A list of all reviews in the database.
     */
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    /**
     * Handles POST requests to /api/reviews/add to create a new review.
     *
     * @param request The review data sent from the frontend.
     * @return The newly created review or an error message.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addReview(@RequestBody ReviewRequest request) {
        try {
            Review review = reviewService.addReview(
                    request.getProductId(),
                    request.getUsername(),
                    request.getRating(),
                    request.getReviewText(),
                    request.getImageUrl()
            );
            return ResponseEntity.ok(review);
        } catch (Exception e) {
            // It's good practice to log the server error for debugging
            // log.error("Error adding review: ", e);
            return ResponseEntity.badRequest().body("Error creating review: " + e.getMessage());
        }
    }

    @GetMapping("/product/{productId}")
    public List<Review> getReviewsForProduct(@PathVariable Long productId) {
        return reviewService.getReviewsForProduct(productId);
    }
}