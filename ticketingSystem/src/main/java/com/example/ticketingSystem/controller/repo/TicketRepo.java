package com.example.ticketingSystem.controller.repo;

import com.example.ticketingSystem.controller.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByTicketId(String ticketId);

    void deleteByTicketId(String ticketId);
}
