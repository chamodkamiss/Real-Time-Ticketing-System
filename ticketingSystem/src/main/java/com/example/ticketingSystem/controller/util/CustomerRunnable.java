package com.example.ticketingSystem.controller.util;


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


}