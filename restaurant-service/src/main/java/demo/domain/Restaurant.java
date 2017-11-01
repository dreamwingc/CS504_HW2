package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Document(collection = "restaurant")
public class Restaurant {

    @Id
    private String restaurantId;
    private String restaurantName;
    private String restaurantAddress;

    private MenuInfo menuInfo;

    public Restaurant(){
        this.menuInfo = null;
    }

    @JsonCreator
    public Restaurant(@JsonProperty("menu") List<String> menu){
        this.menuInfo = new MenuInfo(menu);
    }

    public Restaurant(MenuInfo menuInfo){
        this.menuInfo = menuInfo;
    }

    public List<String> getMenu(){
        return this.menuInfo == null ? null : this.menuInfo.getMenu();
    }
}
