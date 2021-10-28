package ru.orangemaks.restaurant.Database;

import ru.orangemaks.restaurant.Domain.Admin.Users.Admin_RoleDataAccess;
import ru.orangemaks.restaurant.Entities.Role;

public class JpaRole implements Admin_RoleDataAccess {
    RoleRepository roleRepository;

    public JpaRole(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
