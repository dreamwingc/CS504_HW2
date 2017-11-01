package demo.service;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import demo.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> saveRestaurantsInfo(List<Restaurant> restaurants);
    Page<Restaurant> findByRestaurantName(String restaurantName, Pageable pageable);
    Page<Restaurant> findAll(Pageable pageable);
    void deleteAll();
}