package com.example.ticketingSystem.controller.util;

import com.example.ticketingSystem.controller.config.Config;

public class CustomerRunnable implements Runnable{
    private final TicketPool ticketPool;
    private final int retrievalRate;
    private boolean running;

    public CustomerRunnable(TicketPool ticketPool, Config config) {
        this.ticketPool = ticketPool;
        this.retrievalRate = config.getRetrievalRate();
    }

    public void stop(){
        running = false;
    }

    @Override
    public void run() {
        try {
            while (running)
            {
                    String ticket = ticketPool.removeTicket();
                    System.out.println("Customer purchased: "+ ticket);
                    Thread.sleep(retrievalRate);
            }
        }catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Customer Thread interrupted.");
    }

    }
}