package ru.orangemaks.restaurant.database;

import ru.orangemaks.restaurant.domain.admin.users.Admin_RoleDataAccess;
import ru.orangemaks.restaurant.entities.Role;
import ru.orangemaks.restaurant.repositories.RoleRepository;

/**
 * Class data access to Role
 */
public class JpaRole implements Admin_RoleDataAccess {
    /**
     * data access
     */
    private final RoleRepository roleRepository;

    public JpaRole(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * get role by id
     * @param id id
     * @return role by id
     */
    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
