package ru.orangemaks.restaurant.database;

import ru.orangemaks.restaurant.domain.admin.users.Admin_RoleDataAccess;
import ru.orangemaks.restaurant.entities.Role;
import ru.orangemaks.restaurant.repositories.RoleRepository;

public class JpaRole implements Admin_RoleDataAccess {
    private final RoleRepository roleRepository;

    public JpaRole(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
