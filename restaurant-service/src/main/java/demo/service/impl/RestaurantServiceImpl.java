package demo.service.impl;

import demo.domain.Restaurant;
import demo.domain.RestaurantRepository;
import demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Restaurant> saveRestaurantsInfo(List<Restaurant> restaurants){
        return (ArrayList<Restaurant>)this.repository.save(restaurants);
    }

    @Override
    public Page<Restaurant> findByRestaurantName(String restaurantName, Pageable pageable){
        return this.repository.findByRestaurantName(restaurantName, pageable);
    }

    @Override
    public Page<Restaurant> findAll(Pageable pageable){
        return this.repository.findAll(pageable);
    }

    @Override
    public void deleteAll(){
        this.repository.deleteAll();
    }

}