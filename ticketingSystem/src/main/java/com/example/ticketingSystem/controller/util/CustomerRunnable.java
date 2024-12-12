package com.example.ticketingSystem.controller.util;

import com.example.ticketingSystem.controller.config.Config;

public class CustomerRunnable implements Runnable{
    private final TicketPool ticketPool;
    private final int ticketsToPurchase;
    private final String customerId;
    private final int retrievalRate;

    public CustomerRunnable(TicketPool ticketPool, int ticketsToPurchase, String customerId, int retrievalRate) {
        this.ticketPool = ticketPool;
        this.ticketsToPurchase = ticketsToPurchase;
        this.customerId = customerId;
        this.retrievalRate = retrievalRate;
    }
//    private final TicketPool ticketPool;
//    private final int retrievalRate;
//    private boolean running;
//
//    public CustomerRunnable(TicketPool ticketPool, Config config) {
//        this.ticketPool = ticketPool;
//        this.retrievalRate = config.getRetrievalRate();
//    }

//    public void stop(){
//        running = false;
//    }

    @Override
    public void run() {
        System.out.println("Customer " + customerId + " started purchasing tickets.");
        for (int i = 1; i <= ticketsToPurchase; i++) {
            try {
                String  ticket = ticketPool.removeTicket(null);
                System.out.println("Customer " + customerId + " purchased ticket: " + ticket);
                Thread.sleep(retrievalRate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Customer " + customerId + " interrupted.");
                break;
            }catch (RuntimeException e){
                System.out.println("Customer " + customerId + " could not purchase ticket " + i + " because no tickets are available.");
                break;
            }
        }
        System.out.println("Customer " + customerId + " finished purchasing tickets.");
    }
//            String ticket = null;
//            try {
//                ticket = ticketPool.removeTicket(String.valueOf(i));
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            if (ticket == null) {
//                System.out.println("Customer " + customerId + " could not purchase ticket " + i + " because no tickets are available.");
//                break;
//            }
//            System.out.println("Customer " + customerId + " purchased ticket: " + ticket);
//            try {
//                Thread.sleep(retrievalRate);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }


//    public void run() {
//        try {
//            while (running)
//            {
//                    String ticket = ticketPool.removeTicket();
//                    System.out.println("Customer purchased: "+ ticket);
//                    Thread.sleep(retrievalRate);
//            }
//        }catch (InterruptedException e) {
//        Thread.currentThread().interrupt();
//        System.out.println("Customer Thread interrupted.");
//    }
//
//    }

}