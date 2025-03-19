package com.example.ticketingSystem.util;


import com.example.ticketingSystem.config.Config;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class TicketPool {

    private final List<String> tickets ;
    private final int maxCapacity ;

    public TicketPool( Config config) {

        this.maxCapacity = config.getMaxCapacity();
        this.tickets = Collections.synchronizedList(new ArrayList<>());
    }

    // vendors add tickets to the pool
    public synchronized void addTicket(String  ticket) throws InterruptedException{
        while (tickets.size() >= maxCapacity) {
            System.out.println("Ticket pool is full. Vendor cannot add more tickets.");
            wait();
        }
       tickets.add(ticket);
       System.out.println("Added "+ ticket);
       notifyAll();
    }

    // customers removed tickets from the pool
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
