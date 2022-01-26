package com.selvigtech.jwtauth.repo;

import com.selvigtech.jwtauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
