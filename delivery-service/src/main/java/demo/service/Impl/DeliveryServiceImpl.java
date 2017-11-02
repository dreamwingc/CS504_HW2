package demo.service.Impl;

import demo.domain.Delivery;
import demo.domain.DeliveryRepository;
import demo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService{

    private DeliveryRepository repository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository repository){
        this.repository = repository;
    }

    @Override
    public Delivery saveDeliveryInfo(Delivery delivery) {
        return this.repository.save(delivery);
    }

    @Override
    public Page<Delivery> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }
}
