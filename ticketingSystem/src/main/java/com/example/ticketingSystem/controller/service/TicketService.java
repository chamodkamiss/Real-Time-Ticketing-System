package com.example.ticketingSystem.controller.service;

import com.example.ticketingSystem.controller.dto.TicketDto;
import com.example.ticketingSystem.controller.entity.Ticket;
import com.example.ticketingSystem.controller.repo.TicketRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private ModelMapper modelMapper;

    public TicketDto addTicketsToPool(TicketDto ticketDto) {
        ticketRepo.save(modelMapper.map(ticketDto, Ticket.class));
        return ticketDto;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }


}
