package com.example.ticketingSystem.controller.service;

import com.example.ticketingSystem.controller.dto.TicketDto;

import java.util.List;

public interface TicketService {
//    void addTicket(String ticketId);

    TicketDto saveTicket(TicketDto ticketDto);

//    String removeTicket();

//    boolean deleteTicket(String ticketId);

    void deleteTicket(String ticketId);

    List<TicketDto> getAllTickets();

    TicketDto getTicketById(String ticketId);

//    List<String >getTicketsInPool();

//    boolean deleteTicket(TicketDto ticketDto);


//    boolean deleteTicket(String ticketId);
}

