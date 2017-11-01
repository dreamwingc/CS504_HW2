package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude//(JsonInclude.Include.NON_EMPTY)
@Slf4j
public class PriceCalculator {
    private OrderList orderList;
    private int payPrice;
    private static final Logger logger = LoggerFactory.getLogger(PriceCalculator.class);

    public PriceCalculator(){
        this.orderList = null;
    }

    public PriceCalculator(OrderList orderList){
        this.orderList = orderList;
    }

    public int getPayPrice(){

        //logger.info("orderList {}", orderList);

        if (this.orderList != null){
            List<String> itemAndPrice = this.orderList.getItemAndPrice();

            this.payPrice = 0;
            for(String x:itemAndPrice){
                String[] splited = x.split("\\s+");
                //logger.info("sub {}", splited[1]);
                this.payPrice += Integer.valueOf(splited[1]);
            }
        }
        return this.payPrice;
    }
}
