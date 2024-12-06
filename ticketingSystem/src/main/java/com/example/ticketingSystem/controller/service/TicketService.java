package com.example.ticketingSystem.controller.service;

import com.example.ticketingSystem.controller.dto.TicketDto;

import java.util.List;

public interface TicketService {
    void addTicket(String ticketId);

    String removeTicket();

    List<TicketDto> getAllTickets();

    TicketDto getTicketById(String ticketId);

    List<String >getTicketsInPool();

//    boolean deleteTicket(String ticketId);
}
