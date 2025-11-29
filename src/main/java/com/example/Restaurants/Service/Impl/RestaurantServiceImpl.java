package com.example.Restaurants.Service.Impl;

import com.example.Restaurants.Dto.RestaurantDto;
import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Entity.Review;
import com.example.Restaurants.Enum.Status;
import com.example.Restaurants.Repository.RestaurantRepository;
import com.example.Restaurants.Repository.ReviewRepository;
import com.example.Restaurants.Service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, ReviewRepository reviewRepository, ModelMapper modelMapper) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public RestaurantDto createRestaurant(Restaurant restaurant) {
        Restaurant saved = restaurantRepository.save(restaurant);
        return modelMapper.map(saved, RestaurantDto.class);
    }
    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
        return modelMapper.map(restaurant, RestaurantDto.class);
    }

    @Override
    public Page<RestaurantDto> getAllRestaurants(Pageable pageable) {

        Page<Restaurant> page = restaurantRepository.findAll(pageable);
        return page.map(r -> modelMapper.map(r, RestaurantDto.class));
    }

    @Override
    public double getAverageRating(Long restaurantId) {
        List<Review> reviews =
                reviewRepository.findByRestaurantIdAndStatus(restaurantId, Status.APPROVED);

        return reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
    }

    @Override
    public List<RestaurantDto> getTop3RestaurantsByCuisine(String cuisine) {

        List<Restaurant> restaurants = restaurantRepository.findTop3ByCuisineType(cuisine);
        return restaurants.stream()
                .map(r -> modelMapper.map(r, RestaurantDto.class))
                .collect(Collectors.toList());
    }
}
