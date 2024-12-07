package org.example.models;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final int maxCapacity;

    private final int totalTicket;
    private final Queue<String> ticketQueue;
    private boolean running = true;

    public TicketPool(int maxCapacity, int totalTicket) {
        this.maxCapacity = maxCapacity;
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


//
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class TicketPool {
//    private int totalTicketsAdded;
//    private final int maxCapacity ;
//    private final List<String> tickets = new LinkedList<>();
//
//    public TicketPool(int maxCapacity) {
//        this.maxCapacity = maxCapacity;
//    }
//
//    public synchronized void addTicket(String ticket) throws InterruptedException  {
//        while (tickets.size() >= maxCapacity){
//            wait();
//        }
//        tickets.add(ticket);
//        totalTicketsAdded++; //increment the total tickets added to the counter
//        System.out.println("Added: " + ticket);
//        notifyAll();
//    }
//
//    public synchronized String removeTicket() throws InterruptedException {
//        while (tickets.isEmpty()){
//            wait();
//        }
//
//        String ticket = tickets.remove(0);
//        System.out.println("Removed: " + ticket);
//        notifyAll();
//        return ticket;
//    }
//
//    public synchronized int getTicketCount() {
//        return tickets.size();
//    }
//
//    public synchronized int getTotalTicketsAdded() {
//        return totalTicketsAdded;
//    }
//
//
////    public void printTickets() {
////        for (String ticket : tickets) {
////            System.out.println("Available tickets:"+ ticket);
////        }
////        System.out.println("Ticket count:"+ tickets.size());
////    }
//}
