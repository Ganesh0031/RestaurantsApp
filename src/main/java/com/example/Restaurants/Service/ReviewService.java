package com.example.Restaurants.Service;

import com.example.Restaurants.Dto.ReviewDto;
import com.example.Restaurants.Entity.Review;

import java.util.List;

public interface ReviewService {

    ReviewDto submitReview(Long restaurantId, Review review);

    List<ReviewDto> getReviewsForRestaurant(Long restaurantId);

    ReviewDto approveReview(Long reviewId);
}
