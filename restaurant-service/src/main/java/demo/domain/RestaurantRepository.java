package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "restaurants")
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, String>{
    @RestResource(path = "restaurants")
    Page<Restaurant> findByRestaurantName(@Param("restaurantName") String restaurantName, Pageable pageable);
}
