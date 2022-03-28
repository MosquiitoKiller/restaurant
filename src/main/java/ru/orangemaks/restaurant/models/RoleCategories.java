package ru.orangemaks.restaurant.models;

public enum RoleCategories {
    ROLE_USER(1L),
    ROLE_ADMIN(2L);
    Long id;

    RoleCategories(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
