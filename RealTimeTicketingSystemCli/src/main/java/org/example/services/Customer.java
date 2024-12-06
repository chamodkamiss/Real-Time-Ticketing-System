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
