package com.example.ticketingSystem.service.impl;

import com.example.ticketingSystem.dto.TicketDto;
import com.example.ticketingSystem.entity.Ticket;
import com.example.ticketingSystem.repo.TicketRepo;
import com.example.ticketingSystem.service.TicketService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

//    private final TicketPool ticketPool;
    private final TicketRepo ticketRepo;
    private final ModelMapper modelMapper;


    @Autowired
    public TicketServiceImpl( TicketRepo ticketRepo, ModelMapper modelMapper) {

        this.ticketRepo = ticketRepo;
        this.modelMapper = modelMapper;

        modelMapper.typeMap(TicketDto.class, Ticket.class).addMappings(mapper -> {
            mapper.skip(Ticket::setId);
        });
    }

    @Override
    public TicketDto saveTicket(TicketDto ticketDto){
        Ticket ticket = modelMapper.map(ticketDto,Ticket.class);
        Ticket savedTicket = ticketRepo.save(ticket);
        return modelMapper.map(savedTicket,TicketDto.class);
    }



    @Transactional
    @Override
    public void deleteTicket(String ticketId){
        ticketRepo.deleteByTicketId(ticketId);
    }


    @Override
    public List<TicketDto> getAllTickets(){
        return ticketRepo.findAll().stream().
                map(ticket -> modelMapper.map(ticket,TicketDto.class)).
                collect(Collectors.toList());

    }

    @Override
    public TicketDto getTicketById(String ticketId){
        Optional<Ticket>ticket = ticketRepo.findByTicketId(ticketId);

        return ticket.map(ticket1 -> modelMapper.map(ticket1,TicketDto.class))
                .orElseThrow(()-> new RuntimeException("Ticket not found: "+ ticketId));
    }


    public boolean deleteUser(TicketDto ticketDto) {
        ticketRepo.delete(modelMapper.map(ticketDto, Ticket.class));
        return true;
    }

}
