package demo.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "delivery")
public interface DeliveryRepository extends PagingAndSortingRepository<Delivery, String>{
}
