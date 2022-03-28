package ru.orangemaks.restaurant.models;

import ru.orangemaks.restaurant.entities.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDtoModel implements Serializable {
    Long id;
    String name;
    Integer price;
    String category;
    String description;
    String img;

    public ProductDtoModel(Long id, String name, Integer price, String category, String description, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    static public ProductDtoModel productMapper(Product product) {
        return new ProductDtoModel(product.getId(), product.getName(), product.getPrice(),
                product.getCategory(), product.getDescription(), product.getImg());
    }

    static public List<ProductDtoModel> listProductMapper(List<Product> products) {
        List<ProductDtoModel> productDtoModels = new ArrayList<>();
        for (Product product : products)
            productDtoModels.add(productMapper(product));
        return productDtoModels;
    }
}
