package ru.orangemaks.restaurant.domain.order;

import java.io.Serializable;
import java.util.Map;

public class OrderRequestModel implements Serializable {
    Map<Long,Integer> basket;
    String address;

    public OrderRequestModel(Map<Long, Integer> basket, String address) {
        this.basket = basket;
        this.address = address;
    }

    public Map<Long, Integer> getBasket() {
        return basket;
    }

    public void setBasket(Map<Long, Integer> basket) {
        this.basket = basket;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
