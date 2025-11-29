package com.example.Restaurants.Repository;



import com.example.Restaurants.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByRestaurantId(Long restaurantId);
    List<Review> findByRestaurantIdAndStatus(Long restaurantId, Enum status);

}
