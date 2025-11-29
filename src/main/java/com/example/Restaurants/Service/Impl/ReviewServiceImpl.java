package com.example.Restaurants.Service.Impl;

import com.example.Restaurants.Dto.ReviewDto;
import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Entity.Review;
import com.example.Restaurants.Enum.Status;
import com.example.Restaurants.Repository.RestaurantRepository;
import com.example.Restaurants.Repository.ReviewRepository;
import com.example.Restaurants.Service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final ModelMapper modelMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReviewDto submitReview(Long restaurantId, Review review) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));

        review.setRestaurant(restaurant);
        review.setStatus(Status.PENDING);

        Review saved = reviewRepository.save(review);

        return modelMapper.map(saved, ReviewDto.class);
    }


    @Override
    public List<ReviewDto> getReviewsForRestaurant(Long restaurantId) {

        List<Review> reviews = reviewRepository.findByRestaurantId(restaurantId);

        return reviews.stream()
                .map(r -> modelMapper.map(r, ReviewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto approveReview(Long reviewId) {

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));

        review.setStatus(Status.APPROVED);

        Review updated = reviewRepository.save(review);

        return modelMapper.map(updated, ReviewDto.class);
    }
}
