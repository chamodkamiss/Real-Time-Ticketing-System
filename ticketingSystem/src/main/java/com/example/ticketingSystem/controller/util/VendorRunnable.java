package com.example.ticketingSystem.controller.util;

import com.example.ticketingSystem.controller.config.Config;
import com.example.ticketingSystem.controller.dto.TicketDto;
import com.example.ticketingSystem.controller.service.TicketService;

public class VendorRunnable implements Runnable{

    private final TicketPool ticketPool;
//    private final TicketService ticketService;
    private final int ticketPerRelease;
    private boolean running = true;

    public VendorRunnable(TicketPool ticketPool, int ticketPerRelease) {
        this.ticketPool = ticketPool;
        this.ticketPerRelease = ticketPerRelease;
//        this.ticketService = ticketService;
//        this.releaseRate = config.getReleaseRate();
    }

    public void stop(){
        running = false;
    }

    @Override
    public void run() {
        try {
            while (running)
            {
                for (int i = 0; i < ticketPerRelease;)
                {
                    String ticket = "Ticket - " + System.currentTimeMillis();
                    ticketPool.addTicket(ticket);
                }
                Thread.sleep(1000);
            }

        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Vendor Thread Interrupted.");
        }

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
