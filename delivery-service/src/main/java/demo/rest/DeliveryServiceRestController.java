package demo.rest;

import demo.domain.Delivery;
import demo.domain.DeliveryRepository;
import demo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeliveryServiceRestController {

    private DeliveryRepository repository;

    private DeliveryService service;

    @Autowired
    public DeliveryServiceRestController(DeliveryRepository repository, DeliveryService service){
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "/delivery_info", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(Delivery delivery){
        this.service.saveDeliveryInfo(delivery);
    }

    @RequestMapping(value = "/delivery_info", method = RequestMethod.GET)
    public Page<Delivery> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "1") int size){
        return this.service.findAll(new PageRequest(page, size));
    }

    @RequestMapping(value = "/delivery_info", method = RequestMethod.DELETE)
    public void purge(){
        this.service.deleteAll();
    }

}
