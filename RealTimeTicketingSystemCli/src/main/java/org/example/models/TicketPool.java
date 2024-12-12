package org.example.models;

import org.example.util.SystemParameter;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    SystemParameter systemParameter = new SystemParameter();
    private final int maxCapacity;

    private final int totalTicket;
    private final Queue<String> ticketQueue;



    private boolean running = true;

    public TicketPool(int systemParameter, int totalTicket) {
        this.maxCapacity = systemParameter;
        this.totalTicket = totalTicket;
        this.ticketQueue = new LinkedList<>();
    }

    public synchronized boolean addTicket(String ticket) {
        if (ticketQueue.size() >= maxCapacity) {
            System.out.println("Ticket pool is full. Vendor cannot add more tickets.");
            return false; // Ticket addition failed
        }

        ticketQueue.add(ticket);
        System.out.println("Ticket added: " + ticket + " | Total tickets: " + ticketQueue.size());
        notifyAll();
        return true; // Ticket addition succeeded
    }

    public synchronized String retrieveTicket() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No tickets available. Customer cannot purchase.");
            return null; // No ticket to retrieve
        }
        String ticket = ticketQueue.poll();
        notifyAll();
        return ticket; // Successfully retrieved a ticket
    }

    public synchronized void stopOperations() {
        running = false;
        notifyAll();
    }

    public synchronized void monitorStatus() {
        System.out.println("Current ticket pool size: " + ticketQueue.size());
        System.out.println("Tickets in the pool: " + ticketQueue);
    }

}

