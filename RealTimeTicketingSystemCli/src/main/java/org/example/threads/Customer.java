package org.example.threads;

import org.example.models.TicketPool;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketsToPurchase;
    private final String customerId;
    private final int retrievalRate;

    public Customer(TicketPool ticketPool, int ticketsToPurchase, String customerId, int retrievalRate) {
        this.ticketPool = ticketPool;
        this.ticketsToPurchase = ticketsToPurchase;
        this.customerId = customerId;
        this.retrievalRate = retrievalRate;
    }

    @Override
    public void run() {
        System.out.println("Customer " + customerId + " started purchasing tickets.");
        for (int i = 1; i <= ticketsToPurchase; i++) {
            String ticket = ticketPool.retrieveTicket();
            if (ticket == null) {
                System.out.println("Customer " + customerId + " could not purchase ticket " + i + " because no tickets are available.");
                break;
            }
            System.out.println("Customer " + customerId + " purchased ticket: " + ticket);
            try {
                Thread.sleep(retrievalRate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Customer " + customerId + " finished purchasing tickets.");
    }
}

//
//import org.example.models.TicketingSystem;
//
//public class Customer implements Runnable{
//    private final TicketingSystem ticketingSystem;
//    private final String customerId;
//    private final int ticketsToPurchase;
//
//
//    public Customer(TicketingSystem ticketingSystem, String customerId, int ticketsToPurchase) {
//        this.ticketingSystem = ticketingSystem;
//        this.customerId = customerId;
//        this.ticketsToPurchase = ticketsToPurchase;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (true) {
//                Thread.sleep(3000); // Release tickets every second
//                ticketingSystem.removeTickets(customerId, ticketsToPurchase);
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Customer "+ customerId+ " stopped.");;
//        }
//    }
//}

//package org.example.services;
//
//
//import org.example.models.TicketPool;
//public class Customer implements Runnable{
//
//    private final TicketPool ticketPool;
//    public boolean running = true;
//
//    public Customer(TicketPool ticketPool) {
//        this.ticketPool = ticketPool;
//    }
//    public void stop() {
//        running = false;
//    }
//
//    @Override
//    public void run() {
//
//        while (running) {
//            try {
//                String ticket = ticketPool.removeTicket();
//                System.out.println("Purchased ticket: " + ticket);
//                Thread.sleep(500);
//            }catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                break;
//            }
//        }
//
//
//    }
//
//}
