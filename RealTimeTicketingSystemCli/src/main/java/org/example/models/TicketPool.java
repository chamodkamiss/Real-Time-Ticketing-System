//package org.example.models;
//
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class TicketPool {
//    private int totalTicketsAdded;
//    private final int maxCapacity ;
//    private final List<String> tickets = new LinkedList<>();
//
//    public TicketPool(int maxCapacity) {
//        this.maxCapacity = maxCapacity;
//    }
//
//    public synchronized void addTicket(String ticket) throws InterruptedException  {
//        while (tickets.size() >= maxCapacity){
//            wait();
//        }
//        tickets.add(ticket);
//        totalTicketsAdded++; //increment the total tickets added to the counter
//        System.out.println("Added: " + ticket);
//        notifyAll();
//    }
//
//    public synchronized String removeTicket() throws InterruptedException {
//        while (tickets.isEmpty()){
//            wait();
//        }
//
//        String ticket = tickets.remove(0);
//        System.out.println("Removed: " + ticket);
//        notifyAll();
//        return ticket;
//    }
//
//    public synchronized int getTicketCount() {
//        return tickets.size();
//    }
//
//    public synchronized int getTotalTicketsAdded() {
//        return totalTicketsAdded;
//    }
//
//
////    public void printTickets() {
////        for (String ticket : tickets) {
////            System.out.println("Available tickets:"+ ticket);
////        }
////        System.out.println("Ticket count:"+ tickets.size());
////    }
//}
