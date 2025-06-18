//package com.ratingreview.demo;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ReviewRepository extends JpaRepository<Review, Long> {
//
//    boolean existsByUserAndProduct(User user, Product product);
//
//    List<Review> findByProduct(Product product);
//}
//


package com.ratingreview.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks this as a Spring Data repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    /**
     * Finds all reviews associated with a specific product ID.
     * Spring Data JPA automatically creates the query from this method name.
     * This method declaration solves "Cannot resolve method 'findByProductId'".
     *
     * @param productId The ID of the product to find reviews for.
     * @return A list of reviews for the given product.
     */
    List<Review> findByProductId(Long productId);

}