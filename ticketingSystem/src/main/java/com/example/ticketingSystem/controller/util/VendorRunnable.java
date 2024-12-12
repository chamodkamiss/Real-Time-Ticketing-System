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
//        this.ticketPerRelease = ticketPerRelease;
//        this.ticketService = ticketService;
//        this.releaseRate = config.getReleaseRate();
    }

//    public void stop(){
//        running = false;
//    }

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
//            boolean success = false;
//            try {
//                success = ticketPool.addTicket("Ticket-" + vendorId + "-" + i);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            ticketsAdded++;
//            if (!success) {
//                int remainingTickets = ticketsToAdd - ticketsAdded;
//                System.out.println("Vendor " + vendorId + " could not add ticket " + (remainingTickets+1) + " due to max capacity.");
//                break;
//            }
//            try {
//                Thread.sleep(releaseRate);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
        System.out.println("Vendor " + vendorId + " finished adding tickets.");

    }
//        while (running){
//            try {
//                for (int i = 0 ; i < releaseRate; i++)
//                {
//                    // create ticket
//                    String ticketId = "Ticket - "+ System.currentTimeMillis();
//                    TicketDto ticketDto = new TicketDto();
//                    ticketDto.setTicketId(ticketId);
//                    ticketDto.setTimestamp(System.currentTimeMillis());
//
//                    ticketPool.addTicket(ticketId);
//                    ticketService.saveTicket(ticketDto);
//                }
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                Thread.currentThread().interrupt();
//                System.out.println("Vendor thread Interrupted.");
//                break;
//            }
//        }
//        System.out.println("Vendor thread stopped.");
//    }


}
//
//import com.example.ticketingSystem.controller.dto.TicketDto;
//import com.example.ticketingSystem.controller.dto.VendorDto;
//
//import java.util.Random;
//
//public class VendorRunnable implements Runnable  {
//    private final TicketPool ticketPool;
//    private final VendorDto vendorDto;
//    private final Random random = new Random();
//
//
//    public VendorRunnable(TicketPool ticketPool, VendorDto vendorDto){
//        this.ticketPool = ticketPool;
//        this.vendorDto = vendorDto;
//
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 5;i++)
//        {
//            ticketPool.addTicket(10);
//        }
//        try {
//            Thread.sleep(2000); //simulate delay
//        }catch (InterruptedException e){
//            Thread.currentThread().interrupt();
//            System.out.println("vendor interrupted.");
//        }
//
//
//    }
//}
