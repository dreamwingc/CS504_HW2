package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Slf4j
public class OrderList {
    private List<String> itemAndPrice;
    private final static Logger logger = LoggerFactory.getLogger(OrderList.class);

    public OrderList() {
        this.itemAndPrice = null;
    }

    public OrderList(List<String> itemAndPrice){
        this.itemAndPrice = itemAndPrice;
    }

    public List<String> getItemAndPrice(){
        logger.info("item {}", itemAndPrice);
        return this.itemAndPrice;
    }
}
