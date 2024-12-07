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


//
//import org.example.cli.TicketingCli;
//import org.example.models.TicketingSystem;
//
//public class Vendor implements Runnable{
//    private final TicketingCli ticketingCli;
//    private final String vendorId;
//    private final int ticketsToAdd;
//
//    public Vendor(TicketingCli ticketingCli, String vendorId, int ticketsToAdd) {
//        this.ticketingCli = ticketingCli;
//        this.vendorId = vendorId;
//        this.ticketsToAdd = ticketsToAdd;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (true) {
//                Thread.sleep(1000); // Release tickets every second
//                addTickets(vendorId, ticketsToAdd);
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Vendor "+ vendorId+ " stopped.");;
//        }
//    }
//}
//



//package org.example.services;
//
//import java.util.Scanner;
//import org.example.models.TicketPool;
//
//
//public class Vendor implements Runnable{
//    private final TicketPool ticketPool;
//    private final int ticketPerRelease;
//    private boolean running = true;
//
//    public Vendor(TicketPool ticketPool, int ticketPerRelease) {
//        this.ticketPool = ticketPool;
//        this.ticketPerRelease = ticketPerRelease;
//    }
//    public void stop() {
//        running = false;
//    }
//
//    @Override
//    public void run() {
//        Scanner scanner = new Scanner(System.in);
//        while (running) {
//            try {
//                for (int i = 0; i < ticketPerRelease; i++) {
//                    String ticket = " Ticket- " + i;
//                    ticketPool.addTicket(ticket);
//                }
//                Thread.sleep(1000);// Release tickets every second
//                System.out.println("Do you need to add more tickets? (yes/no)");
//                String response = scanner.nextLine();
//                if (!response.equalsIgnoreCase("yes")) {
//                    return;
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                break;
//            }
//        }
//    }
//
//
//
//}
