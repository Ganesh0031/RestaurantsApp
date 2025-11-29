package com.example.Restaurants.Service;

import com.example.Restaurants.Dto.RestaurantDto;
import com.example.Restaurants.Entity.Restaurant;
import org.springframework.data.domain.Page;


import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {

    RestaurantDto createRestaurant(Restaurant restaurant);

    RestaurantDto getRestaurantById(Long id);

   Page<RestaurantDto> getAllRestaurants(Pageable pageable);

    double getAverageRating(Long restaurantId);

    List<RestaurantDto> getTop3RestaurantsByCuisine(String cuisine);
}