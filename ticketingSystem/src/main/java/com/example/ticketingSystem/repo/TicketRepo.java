package com.example.ticketingSystem.repo;

import com.example.ticketingSystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByTicketId(String ticketId);

    void deleteByTicketId(String ticketId);
}
