package com.example.Restaurants.Repository;

import com.example.Restaurants.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query(value = """
            SELECT r.*
            FROM restaurant r
            LEFT JOIN review rv ON r.id = rv.restaurant_id
            WHERE r.cuisine_type = :cuisine
              AND rv.status = 'APPROVED'
            GROUP BY r.id
            ORDER BY AVG(rv.rating) DESC
            LIMIT 3
            """, nativeQuery = true)
    List<Restaurant> findTop3ByCuisineType(String cuisine);
}