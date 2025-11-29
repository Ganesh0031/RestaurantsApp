package com.example.Restaurants.Entity;

import com.example.Restaurants.Enum.PriceRange;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String cuisineType;

    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PriceRange priceRange;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, String cuisineType, String address, PriceRange priceRange, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.cuisineType = cuisineType;
        this.address = address;
        this.priceRange = priceRange;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
