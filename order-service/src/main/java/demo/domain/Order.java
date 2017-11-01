package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.logging.Logger;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document(collection = "order")
@Slf4j
public class Order {

    @Id
    private String orderNumber;
    //private List<String> menu;
    private int totalPrice;
    private PriceCalculator priceCalculator;
    private OrderList orderList;
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(Order.class);

    public Order(){
        this.priceCalculator = null;
        this.orderList = null;
        this.totalPrice = 0;
    }

    @JsonCreator
    public Order(@JsonProperty("itemAndPrice") List<String> itemAndPrice){
        //logger.info("itemAndPrice {}", itemAndPrice);
        this.orderList = new OrderList(itemAndPrice);
    }


    public int getTotalPrice(){
        this.priceCalculator = new PriceCalculator(this.orderList);
        //logger.info("priceCal {}", this.priceCalculator);
        if (this.priceCalculator != null){
            this.totalPrice = this.priceCalculator.getPayPrice();
        }
        return this.totalPrice;
    }

    public List<String> getItemAndPrice(){
        return this.orderList == null ? null : this.orderList.getItemAndPrice();
    }
}
