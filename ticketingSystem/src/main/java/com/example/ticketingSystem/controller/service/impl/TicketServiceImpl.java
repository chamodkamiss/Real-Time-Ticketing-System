package com.example.ticketingSystem.controller.service.impl;

import com.example.ticketingSystem.controller.dto.TicketDto;
import com.example.ticketingSystem.controller.entity.Ticket;
import com.example.ticketingSystem.controller.repo.TicketRepo;
import com.example.ticketingSystem.controller.service.TicketService;
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


//    @Override
//    public void addTicket(String ticketId){
//        try {
//            ticketPool.addTicket(ticketId);
//
//            Ticket ticket = new Ticket();
//            ticket.setTicketId(ticketId);
////            ticket.setTimestamp(System.currentTimeMillis());
//            ticketRepo.save(ticket);
//            System.out.println("Ticket added to the pool and the database: "+ ticketId);
//        }catch (InterruptedException e)
//        {
//            Thread.currentThread().interrupt();
//            System.out.println("Failed to add ticket: "+ e.getMessage());
//        }
//    }

    @Transactional
    @Override
    public void deleteTicket(String ticketId){
        ticketRepo.deleteByTicketId(ticketId);
    }
//    @Override
//    public String removeTicket() {
//        try {
//            // Remove ticket from the pool
//            String ticketId = ticketPool.removeTicket(String.valueOf(1));
//
//            // Mark the ticket as sold in the database
//            Optional<Ticket> ticketOpt = ticketRepo.findByTicketId(ticketId);
//            if (ticketOpt.isPresent()) {
//                Ticket ticket = ticketOpt.get();
////                ticket.setSold(true);
//                ticketRepo.save(ticket);
//
//                System.out.println("Ticket removed from pool and marked as sold: " + ticketId);
//            } else {
//                System.out.println("Ticket not found in the database: " + ticketId);
//            }
//
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.out.println("Failed to remove ticket: " + e.getMessage());
//        }
//        return null;
//    }

//    @Override
//    public void removeTicket(String ticketId){
//        try {
//            ticketPool.removeTicket(ticketId);
//
//            Optional<Ticket> ticketOpt = ticketRepo.findByTicketId(ticketId);
//            if (ticketOpt.isPresent())
//            {
//                Ticket ticket = ticketOpt.get();
////                ticket.setIs_sold(true);
//                ticketRepo.save(ticket);
//                System.out.println("Ticket removed from the pool and marked as sold: "+ ticketId);
//            }
//            else {
//                System.out.println("Ticket not found in the database: "+ ticketId);
//            }
//
//        }catch (InterruptedException e){
//            Thread.currentThread().interrupt();
//            System.out.println("Failed to remove ticket: ");
//
//        }
//    }

//    @Override
//    public boolean deleteTicket(String ticketId) {
//        Optional<Ticket> ticket = ticketRepo.findByTicketId(ticketId);
//        if (ticket != null) {
//            ticketRepo.delete(Ticket);
//            return true;
//        }
//        return false;
//    }





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

//    @Override
//    public List<String> getTicketsInPool() {
//        return ticketPool.getTickets();
//    }

//    @Override
//    public boolean deleteTicket(TicketDto ticketDto) {
//        ticketRepo.delete(modelMapper.map(ticketDto, Ticket.class));
//        return true;
//    }
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

    public boolean deleteUser(TicketDto ticketDto) {
        ticketRepo.delete(modelMapper.map(ticketDto, Ticket.class));
        return true;
    }

}
