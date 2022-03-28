package ru.orangemaks.restaurant.models;

import ru.orangemaks.restaurant.entities.OrderProducts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderProductsDtoModel implements Serializable {
    Long id;
    ProductDtoModel product;
    Integer count;

    public OrderProductsDtoModel(Long id, ProductDtoModel product, Integer count) {
        this.id = id;
        this.product = product;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDtoModel getProduct() {
        return product;
    }

    public void setProduct(ProductDtoModel product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static List<OrderProductsDtoModel> listOrderProductsMapper(List<OrderProducts> orderProducts){
        List<OrderProductsDtoModel> orderProductsDtoModels = new ArrayList<>();
        for (OrderProducts o :
                orderProducts) {
            orderProductsDtoModels.add(orderProductsMapper(o));
        }
        return orderProductsDtoModels;
    }

    public static OrderProductsDtoModel orderProductsMapper(OrderProducts orderProducts){
        return new OrderProductsDtoModel(orderProducts.getId(), ProductDtoModel.productMapper(orderProducts.getProduct()), orderProducts.getCount());
    }

    @Override
    public String toString() {
        return "OrderProductsDtoModel{" +
                "id=" + id +
                ", product=" + product +
                ", count=" + count +
                '}';
    }
}
