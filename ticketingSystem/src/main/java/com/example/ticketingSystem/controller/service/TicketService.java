package com.example.ticketingSystem.controller.service;

import com.example.ticketingSystem.controller.dto.TicketDto;

import java.util.List;

public interface TicketService {

    TicketDto saveTicket(TicketDto ticketDto);

    void deleteTicket(String ticketId);

    List<TicketDto> getAllTickets();

    TicketDto getTicketById(String ticketId);


}

