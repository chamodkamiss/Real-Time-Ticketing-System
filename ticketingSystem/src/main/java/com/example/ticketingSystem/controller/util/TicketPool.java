package com.example.ticketingSystem.controller.util;


import com.example.ticketingSystem.controller.config.Config;
import com.example.ticketingSystem.controller.config.ConfigLoader;
import com.example.ticketingSystem.controller.dto.TicketDto;
import com.example.ticketingSystem.controller.service.TicketService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class TicketPool {

    private final List<String> tickets ;
    private final int maxCapacity ;
//    private  int totalTicketsAdded;


    public TicketPool( Config config) {
        this.maxCapacity = config.getMaxCapacity();
        this.tickets = Collections.synchronizedList(new ArrayList<>());
    }

    // vendors
    public synchronized void addTicket(String  ticketId) throws InterruptedException{
        while (tickets.size() >= maxCapacity){
           System.out.println("Pool is full. Waiting... (Current size: " + tickets.size() + ")");
           wait();
       }

       //add tickets to the pool
       tickets.add(ticketId);
//       totalTicketsAdded++;

       // save ticket
        TicketDto ticketDto = new TicketDto();
//        ticketDto.setTicketId(ticketId);
//        ticketDto.setTimestamp(System.currentTimeMillis());
//        ticketService.saveTicket(ticketDto);
       System.out.println("Added "+ ticketId);
       notifyAll();
    }

    // customers
    public synchronized String removeTicket() throws InterruptedException{
        while (tickets.isEmpty())
        {
            System.out.println("Pool is Empty. Waiting...");
            wait();
        }
        String ticket = tickets.remove(0);
        System.out.println("Removed: "+ ticket);
        notifyAll();
        return ticket;
    }

    public synchronized int getTicketCount(){
        return tickets.size();
    }

    public synchronized List<String> getTickets() {
        return new ArrayList<>(tickets);
    }
//    public synchronized int getTotalTicketsAdded(){
//        return totalTicketsAdded;
//    }
}
