package ru.orangemaks.restaurant.domain.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class BasketRequestModel implements Serializable {
    @JsonProperty("productsId")
    public List<Long> productsId;

    public BasketRequestModel() {
    }

    public BasketRequestModel(List<Long> productsId) {
        this.productsId = productsId;
    }

    public List<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
    }
}
