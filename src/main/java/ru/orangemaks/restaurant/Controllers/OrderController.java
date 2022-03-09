package ru.orangemaks.restaurant.Controllers;

import org.springframework.web.bind.annotation.*;
import ru.orangemaks.restaurant.Domain.Order.*;
import ru.orangemaks.restaurant.Models.ProductCategories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    private final OrderInputBoundary orderInputBoundary;

    public OrderController(OrderInputBoundary orderInputBoundary) {
        this.orderInputBoundary = orderInputBoundary;
    }

    @GetMapping("/getProductsCategories")
    public String[] getAllProductCategories(){
        String[] categories = new String[ProductCategories.values().length];
        for (int i = 0; i < ProductCategories.values().length; i++) {
            categories[i] = ProductCategories.values()[i].getCategory();
        }
        return categories;
    }

    @GetMapping("/get_menu")
    public MenuResponseModel getAllProducts(){
        return orderInputBoundary.getAll();
    }

    @PostMapping("/getProductsById")
    public BasketResponseModel getProducts(@RequestBody BasketRequestModel basketRequestModel){
        return orderInputBoundary.getProductsById(basketRequestModel);
    }

    @PostMapping("/formOrder")
    public boolean formOrder(@RequestParam Map<String,String> mapInput, @RequestParam String address){
        mapInput.remove("address");
        Map<Long,Integer> map = new HashMap<>();
        for (String key : mapInput.keySet()) {
            map.put(Long.parseLong(key),Integer.parseInt(mapInput.get(key)));
        }
        return orderInputBoundary.formOrder(new OrderRequestModel(map,address));
    }
}
