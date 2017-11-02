package demo.service;

import demo.domain.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeliveryService {
    Delivery saveDeliveryInfo(Delivery delivery);
    Page<Delivery> findAll(Pageable pageable);
    void deleteAll();
}
