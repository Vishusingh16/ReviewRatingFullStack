package com.ratingreview.demo;

import jakarta.persistence.*;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user") // 'user' is a reserved word in PostgreSQL
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String username) {
        this.username = username;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
