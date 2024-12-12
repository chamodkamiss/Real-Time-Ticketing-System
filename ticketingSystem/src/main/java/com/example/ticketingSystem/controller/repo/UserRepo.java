package com.example.ticketingSystem.controller.repo;

import com.example.ticketingSystem.controller.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
