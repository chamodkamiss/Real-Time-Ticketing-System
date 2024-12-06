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
