package com.AnnualProject.April.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.AnnualProject.April.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // Find user by email (for OAuth authentication)
}