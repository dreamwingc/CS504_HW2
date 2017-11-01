package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "orders")
public interface OrderRepository extends PagingAndSortingRepository<Order, String> {
    @RestResource(path = "orders")
    Page<Order> findByOrderNumber(String orderNumber, Pageable pageable);
}
