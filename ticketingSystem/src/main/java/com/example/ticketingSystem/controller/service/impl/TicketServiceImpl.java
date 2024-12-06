package com.example.ticketingSystem.controller.service.impl;

import com.example.ticketingSystem.controller.dto.TicketDto;
import com.example.ticketingSystem.controller.entity.Ticket;
import com.example.ticketingSystem.controller.repo.TicketRepo;
import com.example.ticketingSystem.controller.service.TicketService;
import com.example.ticketingSystem.controller.util.TicketPool;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketPool ticketPool;
    private final TicketRepo ticketRepo;
    private final ModelMapper modelMapper;


    @Autowired
    public TicketServiceImpl(TicketPool ticketPool, TicketRepo ticketRepo, ModelMapper modelMapper) {
        this.ticketPool = ticketPool;
        this.ticketRepo = ticketRepo;
        this.modelMapper = modelMapper;

//        modelMapper.typeMap(TicketDto.class, Ticket.class).addMappings(mapper -> {
//            mapper.skip(Ticket::setId);
//        });
    }

    @Override
    public void addTicket(String ticketId){
        try {
            ticketPool.addTicket(ticketId);

            Ticket ticket = new Ticket();
            ticket.setTicketId(ticketId);
            ticket.setTimestamp(System.currentTimeMillis());
            ticketRepo.save(ticket);
            System.out.println("Ticket added to the pool and the database: "+ ticketId);
        }catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            System.out.println("Failed to add ticket: "+ e.getMessage());
        }
    }

    @Override
    public String removeTicket(){
        try {
            String ticketId = ticketPool.removeTicket();

            Optional<Ticket> ticketOpt = ticketRepo.findByTicketId(ticketId);
            if (ticketOpt.isPresent())
            {
                Ticket ticket = ticketOpt.get();
                ticket.setIs_sold(true);
                ticketRepo.save(ticket);
                System.out.println("Ticket removed from the pool and marked as sold: "+ ticketId);
            }
            else {
                System.out.println("Ticket not found in the database: "+ ticketId);
            }
            return ticketId;
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Failed to remove ticket: ");
            return null;
        }
    }


//    @Override
//    public void saveTicket(TicketDto ticketDto){
//        Ticket ticket = modelMapper.map(ticketDto,Ticket.class);
//        ticketRepo.save(ticket);
//        System.out.println("Ticket saved." + ticket.getTicketId());
//    }

    @Override
    public List<TicketDto> getAllTickets(){
        return ticketRepo.findAll().stream().
                map(ticket -> modelMapper.map(ticket,TicketDto.class)).
                collect(Collectors.toList());
//        List<Ticket> tickets = ticketRepo.findAll();
//        return tickets.stream().map(ticket -> modelMapper.map(ticket,TicketDto.class))
//                .toList();
    }

    @Override
    public TicketDto getTicketById(String ticketId){
        Optional<Ticket>ticket = ticketRepo.findByTicketId(ticketId);

        return ticket.map(ticket1 -> modelMapper.map(ticket1,TicketDto.class))
                .orElseThrow(()-> new RuntimeException("Ticket not found: "+ ticketId));
    }

    @Override
    public List<String> getTicketsInPool() {
        return ticketPool.getTickets();
    }
//
//    @Override
//    public boolean deleteTicket(String ticketId) {
//        return false;
//    }

//    @Override
//    public boolean deleteTicket(String ticketId){
//        Ticket ticket = ticketRepo.findByTicketId(ticketId);
//        if (ticket != null)
//        {
//            ticketRepo.delete(ticket);
//            return true;
//        }
//        return false;
//    }

}
