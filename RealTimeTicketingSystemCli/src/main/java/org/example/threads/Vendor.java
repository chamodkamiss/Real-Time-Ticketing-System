package org.example.threads;

import org.example.models.TicketPool;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketsToAdd;
    private final String vendorId;
    private final int releaseRate;
    private int ticketsAdded = 0;

    public Vendor(TicketPool ticketPool, int ticketsToAdd, String vendorId, int releaseRate) {
        this.ticketPool = ticketPool;
        this.ticketsToAdd = ticketsToAdd;
        this.vendorId = vendorId;
        this.releaseRate = releaseRate;
    }

    @Override
    public void run() {
        System.out.println("Vendor "+ vendorId+" added and started...");
        for (int i = 1; i <= ticketsToAdd; i++) {
            boolean success = ticketPool.addTicket("Ticket-" + vendorId + "-" + i);
            ticketsAdded++;
            if (!success) {
                int remainingTickets = ticketsToAdd - ticketsAdded;
                System.out.println("Vendor " + vendorId + " could not add ticket " + (remainingTickets+1) + " due to max capacity.");
                break;
            }
            try {
                Thread.sleep(releaseRate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Vendor " + vendorId + " finished adding tickets.");
    }


}

