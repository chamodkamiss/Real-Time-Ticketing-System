package com.example.ticketingSystem.controller.repo;

import com.example.ticketingSystem.controller.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByIsSoldFalse();                                   //unsold tickets
}
