package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuInfo {
    private List<String> menu;

    public MenuInfo() {
        this.menu = null;
    }

    public MenuInfo(List<String> menu){
        this.menu = menu;
    }

    /*public void addItem(String itemName, int itemPrice){
        this.menu.add(itemName + ' ' + String.valueOf(itemPrice));
    }

    public void deleteItem(String itemName, int itemPrice){
        this.menu.remove(itemName + ' ' + String.valueOf(itemPrice));
    }*/
}
