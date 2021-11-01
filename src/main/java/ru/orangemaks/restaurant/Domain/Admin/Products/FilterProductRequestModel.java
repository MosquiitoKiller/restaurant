package ru.orangemaks.restaurant.Domain.Admin.Products;

public class FilterProductRequestModel {
    Long id;
    String name;
    String categoryFilter;

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

    public String getCategoryFilter() {
        return categoryFilter;
    }

    public void setCategoryFilter(String categoryFilter) {
        this.categoryFilter = categoryFilter;
    }

    @Override
    public String toString() {
        return "FilterProductRequestModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryFilter='" + categoryFilter + '\'' +
                '}';
    }
}
