package com.example.Restaurants.Controller;

import com.example.Restaurants.Dto.ResponseDto;
import com.example.Restaurants.Dto.RestaurantDto;
import com.example.Restaurants.Entity.Restaurant;
import com.example.Restaurants.Service.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/addRestaurant")
    public ResponseDto createRestaurant(@RequestBody Restaurant restaurant) {
        ResponseDto response = new ResponseDto();
        try {
            response.data = restaurantService.createRestaurant(restaurant);
            response.message = "Restaurant created successfully";
            response.success = true;
            response.status = 200L;
        } catch (Exception e) {
            response.message = "Failed: " + e.getMessage();
            response.success = false;
            response.status = 500L;
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseDto getRestaurantById(@PathVariable Long id) {
        ResponseDto response = new ResponseDto();
        try {
            response.data = restaurantService.getRestaurantById(id);
            response.message = "Restaurant fetched successfully";
            response.success = true;
            response.status = 200L;
        } catch (Exception e) {
            response.message = "Failed: " + e.getMessage();
            response.success = false;
            response.status = 500L;
        }
        return response;
    }

    @GetMapping
    public ResponseDto getAllRestaurants(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        ResponseDto response = new ResponseDto();
        try {
            Page<RestaurantDto> result = restaurantService.getAllRestaurants(PageRequest.of(page, size));

            response.data = result;
            response.message = "Restaurants fetched successfully";
            response.success = true;
            response.status = 200L;

        } catch (Exception e) {
            response.message = "Failed: " + e.getMessage();
            response.success = false;
            response.status = 500L;
        }
        return response;
    }

    @GetMapping("/averageRating/{id}")
    public ResponseDto getAverageRating(@PathVariable Long id) {
        ResponseDto response = new ResponseDto();
        try {
            response.data = restaurantService.getAverageRating(id);
            response.message = "Average rating fetched successfully";
            response.success = true;
            response.status = 200L;
        } catch (Exception e) {
            response.message = "Failed: " + e.getMessage();
            response.success = false;
            response.status = 500L;
        }
        return response;
    }

    @GetMapping("/top")
    public ResponseDto getTop3Restaurants(@RequestParam String cuisine) {
        ResponseDto response = new ResponseDto();
        try {
            response.data = restaurantService.getTop3RestaurantsByCuisine(cuisine);
            response.message = "Top restaurants fetched successfully";
            response.success = true;
            response.status = 200L;
        } catch (Exception e) {
            response.message = "Failed: " + e.getMessage();
            response.success = false;
            response.status = 500L;
        }
        return response;
    }
}
