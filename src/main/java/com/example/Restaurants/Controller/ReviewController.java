package com.example.Restaurants.Controller;

import com.example.Restaurants.Dto.ResponseDto;
import com.example.Restaurants.Dto.ReviewDto;
import com.example.Restaurants.Entity.Review;
import com.example.Restaurants.Service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/restaurant/{restaurantId}")
    public ResponseDto submitReview(
            @PathVariable Long restaurantId,
            @RequestBody Review review) {

        ResponseDto response = new ResponseDto();

        try {
            ReviewDto savedReview = reviewService.submitReview(restaurantId, review);

            response.data = savedReview;
            response.message = "Review submitted successfully";
            response.success = true;
            response.status = 200L;

        } catch (Exception e) {
            response.data = null;
            response.message = "Failed: " + e.getMessage();
            response.success = false;
            response.status = 500L;
        }

        return response;
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseDto getReviewsByRestaurant(@PathVariable Long restaurantId) {

        ResponseDto response = new ResponseDto();

        try {
            List<ReviewDto> reviews = reviewService.getReviewsForRestaurant(restaurantId);

            response.data = reviews;
            response.message = "Reviews fetched successfully";
            response.success = true;
            response.status = 200L;

        } catch (Exception e) {
            response.data = null;
            response.message = "Failed: " + e.getMessage();
            response.success = false;
            response.status = 500L;
        }

        return response;
    }
    @PutMapping("/approve/{reviewId}")
    public ResponseDto approveReview(@PathVariable Long reviewId) {

        ResponseDto response = new ResponseDto();

        try {
            ReviewDto approved = reviewService.approveReview(reviewId);

            response.data = approved;
            response.message = "Review approved successfully";
            response.success = true;
            response.status = 200L;

        } catch (Exception e) {
            response.data = null;
            response.message = "Failed: " + e.getMessage();
            response.success = false;
            response.status = 500L;
        }

        return response;
    }
}
