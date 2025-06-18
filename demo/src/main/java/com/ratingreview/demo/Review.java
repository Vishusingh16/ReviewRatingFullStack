
package com.ratingreview.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private Integer rating;

    @Column(columnDefinition = "TEXT") // Use a larger text field for the review content
    private String reviewText;

    private String imageUrl;

    private LocalDateTime createdAt;

    // This sets up the relationship: Many Reviews can belong to One Product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false) // This creates the foreign key column "product_id"
    @JsonIgnore // Prevents infinite loops when converting to JSON (Product has Reviews, Review has a Product...)
    private Product product;

}