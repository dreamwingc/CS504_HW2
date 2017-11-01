package demo.service;

import demo.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    List<Order> saveOrderInfo(List<Order> orders);
    Page<Order> findByOrderNumber(String orderNumber, Pageable pageable);
    Page<Order> findAll(Pageable pageable);
    void deleteAll();
}
