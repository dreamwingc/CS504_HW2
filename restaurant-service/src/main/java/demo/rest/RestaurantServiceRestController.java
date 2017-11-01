package demo.rest;

import demo.domain.Restaurant;
import demo.domain.RestaurantRepository;
import demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantServiceRestController {

    private RestaurantRepository repository;

    private RestaurantService service;

    @Autowired
    public RestaurantServiceRestController(RestaurantRepository repository, RestaurantService service){
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Restaurant> restaurants){
        this.service.saveRestaurantsInfo(restaurants);
    }

    @RequestMapping(value = "/list/{restaurantName}", method = RequestMethod.GET)
    public Page<Restaurant> findByRestaurantName(@PathVariable String restaurantName,
                                                 @RequestParam(name = "page") int page,
                                                 @RequestParam(name = "size") int size){
        return this.repository.findByRestaurantName(restaurantName, new PageRequest(page, size));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<Restaurant> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "3") int size){
        return this.repository.findAll(new PageRequest(page, size));
    }

    @RequestMapping(value = "/list", method = RequestMethod.DELETE)
    public void purge(){
        this.service.deleteAll();
    }
}
