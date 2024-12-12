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
