package ru.orangemaks.restaurant.models;

import ru.orangemaks.restaurant.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDtoModel {
    Long id;
    String date;
    String address;
    List<OrderProductsDtoModel> orderProductsDtoModels;

    public OrderDtoModel(Long id, String date, String address, List<OrderProductsDtoModel> orderProductsDtoModels) {
        this.id = id;
        this.date = date;
        this.address = address;
        this.orderProductsDtoModels = orderProductsDtoModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderProductsDtoModel> getOrderProductsDtoModels() {
        return orderProductsDtoModels;
    }

    public void setOrderProductsDtoModels(List<OrderProductsDtoModel> orderProductsDtoModels) {
        this.orderProductsDtoModels = orderProductsDtoModels;
    }

    public static List<OrderDtoModel> listOrderMapper(List<Order> orders){
        List<OrderDtoModel> orderDtoModels = new ArrayList<>();
        for (Order o :
                orders) {
            orderDtoModels.add(OrderDtoModel.orderMapper(o));
        }
        return orderDtoModels;
    }

    public static OrderDtoModel orderMapper(Order order){
        return new OrderDtoModel(order.getId(), order.getDate(), order.getAddress(), OrderProductsDtoModel.listOrderProductsMapper(order.getProducts()));
    }
}
