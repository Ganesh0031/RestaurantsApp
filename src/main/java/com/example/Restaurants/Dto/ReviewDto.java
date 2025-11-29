package com.example.Restaurants.Dto;

import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Enum.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

public class ReviewDto {
    private Long id;
    private int rating;
    private String comment;
    private LocalDate visitDate;
    private Status status;
    private Restaurant restaurant;

    public ReviewDto() {
    }

    public ReviewDto(Long id, int rating, String comment, LocalDate visitDate, Status status, Restaurant restaurant) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.visitDate = visitDate;
        this.status = status;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
