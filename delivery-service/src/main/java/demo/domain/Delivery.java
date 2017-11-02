package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Data
@Document(collection = "delivery")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Delivery {

    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String address;
    private Date timestamp = new Date();
    private List<String> orderList;
    private int totalPrice;
    private int estimateMinutes;

    public Delivery(){}

    public Delivery(int totalPrice, List<String> orderList){
        this.totalPrice = totalPrice;
        this.orderList = orderList;
    }

    public void setEstimateMinutes(){
        Random random = new Random();
        this.estimateMinutes = random.nextInt(56) + 5;
    }
}
