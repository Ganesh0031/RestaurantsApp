package com.example.Restaurants.Dto;

import com.example.Restaurants.Entity.Review;
import com.example.Restaurants.Enum.PriceRange;
import jakarta.persistence.*;

import java.util.List;

public class RestaurantDto {

    private Long id;
    private String name;
    private String cuisineType;
    private String address;
    private PriceRange priceRange;
    private List<Review> reviews;

    public RestaurantDto(Long id, String name, String cuisineType, String address, PriceRange priceRange, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.cuisineType = cuisineType;
        this.address = address;
        this.priceRange = priceRange;
        this.reviews = reviews;
    }

    public RestaurantDto() {
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
