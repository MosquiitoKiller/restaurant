package ru.orangemaks.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangemaks.restaurant.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
