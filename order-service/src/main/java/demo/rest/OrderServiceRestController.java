package demo.rest;

import demo.domain.Order;
import demo.domain.OrderRepository;
import demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderServiceRestController {

    private OrderRepository repository;

    private OrderService service;

    @Autowired
    public OrderServiceRestController(OrderRepository repository, OrderService service){
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "/all_orders", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Order> upload(@RequestBody List<Order> orders){
        return this.service.saveOrderInfo(orders);
    }

    @RequestMapping(value = "/all_orders/{orderNumber}", method = RequestMethod.GET)
    public Page<Order> findByOrderNumber(@PathVariable String orderNumber,
                                         @RequestParam(name = "page") int page,
                                         @RequestParam(name = "size") int size){
        return this.repository.findByOrderNumber(orderNumber, new PageRequest(page, size));
    }

    @RequestMapping(value = "/all_orders", method = RequestMethod.GET)
    public Page<Order> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "3") int size){
        return this.repository.findAll(new PageRequest(page, size));
    }

    @RequestMapping(value = "/all_orders", method = RequestMethod.DELETE)
    public void purge(){
        this.service.deleteAll();
    }

}
