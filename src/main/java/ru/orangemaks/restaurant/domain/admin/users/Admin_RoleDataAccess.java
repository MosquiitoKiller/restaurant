package ru.orangemaks.restaurant.domain.admin.users;

import ru.orangemaks.restaurant.entities.Role;

public interface Admin_RoleDataAccess {
    public Role findById(Long id);
}
