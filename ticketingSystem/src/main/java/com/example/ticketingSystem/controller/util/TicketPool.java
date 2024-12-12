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
    private boolean running = true;
//    private  int totalTicketsAdded;


    public TicketPool( Config configLoader) {

        this.maxCapacity = ConfigLoader.getCliconfig().getMaxCapacity();
        this.tickets = Collections.synchronizedList(new ArrayList<>());
    }

    // vendors
    public synchronized void addTicket(String  ticket) throws InterruptedException{
        while (tickets.size() >= maxCapacity) {
            System.out.println("Ticket pool is full. Vendor cannot add more tickets.");
            wait();

        }

       tickets.add(ticket);

       System.out.println("Added "+ ticket);
       notifyAll();

    }

    // customers

    public synchronized String removeTicket(String ticketId) throws InterruptedException{

        while (tickets.isEmpty())
        {
            System.out.println("Pool is Empty. Waiting...(Current size:  "+  tickets.size() + ")");
            wait();
        }
        String ticket ;
        if (ticketId==null|| ticketId.isEmpty()){
            ticket = tickets.remove(0);
            System.out.println("Removed first ticket: "+ ticket);
        }
        else {
            boolean removed = tickets.remove(ticketId);
            if (removed) {
                ticket = ticketId;
                System.out.println("Removed specific ticket: " + ticket + " (Current size: " + tickets.size() + ")");
            } else {
                System.out.println("Ticket not found: " + ticketId);
                throw new RuntimeException("Ticket not found: " + ticketId);
            }

        }
        notifyAll();
        return ticket;
    }


    public synchronized int getTicketCount(){
        return tickets.size();
    }

    public synchronized List<String> getTickets() {
        return new ArrayList<>(tickets);
    }

}
