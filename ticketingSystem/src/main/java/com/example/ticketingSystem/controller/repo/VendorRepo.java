package com.example.ticketingSystem.controller.repo;

import com.example.ticketingSystem.controller.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Vendor, Long> { }
