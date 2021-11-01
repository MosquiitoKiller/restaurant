package ru.orangemaks.restaurant.Domain.Admin.Products;

import org.springframework.web.multipart.MultipartFile;

public class CreateProductRequestModel {
    String name;
    Integer price;
    String categoryAdd;
    String description;
    String img;

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

    public String getCategoryAdd() {
        return categoryAdd;
    }

    public void setCategoryAdd(String categoryAdd) {
        this.categoryAdd = categoryAdd;
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


}
