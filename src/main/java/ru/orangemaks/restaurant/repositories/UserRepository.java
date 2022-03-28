package ru.orangemaks.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangemaks.restaurant.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    Optional<User> findById(Long id);
}
