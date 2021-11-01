package ru.orangemaks.restaurant.Domain.Admin.Products;

public enum ProductCategories {
    SIGNATURE_DISH("signature dish"),
    COLD_APPETIZER("cold appetizer"),
    COLD_DISH("cold dish"),
    HOT_APPETIZER("hot appetizer"),
    SOUP("soup"),
    HOT("hot"),
    DESSERT("dessert"),
    HOT_DRINK("hot drink"),
    COLD_DRINK("cold drink");

    private final String category;

    ProductCategories(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
