package com.example.ticketingSystem.controller.util;

import com.example.ticketingSystem.controller.config.ConfigLoader;

public class VendorRunnable implements Runnable{

//    private final TicketPool ticketPool;
//    private final TicketService ticketService;
//    private final int ticketPerRelease;
//    private boolean running = true;
    private final TicketPool ticketPool;
    private final int ticketsToAdd;
    private final String vendorId;
    private final int releaseRate;
    private int ticketsAdded = 0;


    public VendorRunnable(TicketPool ticketPool, int ticketsToAdd, String vendorId, int configLoader) {
        this.ticketPool = ticketPool;
        this.ticketsToAdd = ticketsToAdd;
        this.vendorId = vendorId;
        this.releaseRate = ConfigLoader.getCliconfig().getReleaseRate();

    }



    @Override
    public void run() {
        System.out.println("Vendor "+ vendorId+" added and started...");
        for (int i = 1; i <= ticketsToAdd; i++) {
            try {
                String ticket = "Ticket-" + vendorId + "-" + i;
                ticketPool.addTicket(ticket);
                System.out.println("Vendor added: " + ticket);
                Thread.sleep(releaseRate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Vendor thread interrupted.");
                break;
            }
        }

        System.out.println("Vendor " + vendorId + " finished adding tickets.");

    }

}
