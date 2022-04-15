package ru.orangemaks.restaurant.controllers;

import org.springframework.web.bind.annotation.*;
import ru.orangemaks.restaurant.domain.order.*;
import ru.orangemaks.restaurant.models.ProductCategories;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller for processing menus and orders
 */
@RestController
public class OrderController {

    /**
     * OrderInteractor
     */
    private final OrderInputBoundary orderInputBoundary;

    public OrderController(OrderInputBoundary orderInputBoundary) {
        this.orderInputBoundary = orderInputBoundary;
    }

    /**
     * get all product categories
     * @return list of product categories
     */
    @GetMapping("/getProductsCategories")
    public String[] getAllProductCategories(){
        String[] categories = new String[ProductCategories.values().length];
        for (int i = 0; i < ProductCategories.values().length; i++) {
            categories[i] = ProductCategories.values()[i].getCategory();
        }
        return categories;
    }

    /**
     * get all products
     * @return list of products
     */
    @GetMapping("/get_menu")
    public MenuResponseModel getAllProducts(){
        return orderInputBoundary.getAll();
    }

    /**
     * get all products in basket
     * @param basketRequestModel basket parameters
     * @return list of products in basket
     */
    @PostMapping("/getProductsById")
    public BasketResponseModel getProducts(@RequestBody BasketRequestModel basketRequestModel){
        return orderInputBoundary.getProductsById(basketRequestModel);
    }

    /**
     * make an order
     * @param mapInput list of products
     * @param address user address
     * @return
     */
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
