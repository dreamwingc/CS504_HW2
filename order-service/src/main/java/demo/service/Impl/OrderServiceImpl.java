package demo.service.Impl;

import demo.domain.Order;
import demo.domain.OrderRepository;
import demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Order> saveOrderInfo(List<Order> orders) {
        return (ArrayList<Order>)this.repository.save(orders);
    }

    @Override
    public Page<Order> findByOrderNumber(String orderNumber, Pageable pageable) {
        return this.repository.findByOrderNumber(orderNumber, pageable);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }
}
