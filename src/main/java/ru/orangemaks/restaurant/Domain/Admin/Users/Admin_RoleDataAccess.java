package ru.orangemaks.restaurant.Domain.Admin.Users;

import ru.orangemaks.restaurant.Entities.Role;

public interface Admin_RoleDataAccess {
    public Role findById(Long id);
}
