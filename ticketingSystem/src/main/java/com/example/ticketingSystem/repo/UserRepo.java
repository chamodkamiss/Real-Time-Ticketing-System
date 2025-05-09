package com.example.ticketingSystem.repo;

import com.example.ticketingSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
