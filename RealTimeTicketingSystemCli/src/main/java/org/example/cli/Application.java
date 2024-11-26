package org.example.cli;

import org.example.models.TicketPool;
import org.example.services.Vendor;
import org.example.services.Customer;


import java.util.*;
public class Application {

    public static void main(String[] args) throws InterruptedException {
        Configure configure = Configure.loadConfigFile("config.json");
        System.out.println("Configure loaded ");

        System.out.println("Max capacity: "+configure.getMaxCapacity());
        System.out.println("Tickets per release: " +configure.getTicketPerRelease());
        System.out.println("Retrieval rate: "+ configure.getRetrievalRate());

        //Initialize the ticket pool , customer and vendor
        TicketPool ticketPool = new TicketPool(configure.getMaxCapacity());
        Vendor vendor = new Vendor(ticketPool, configure.getTicketPerRelease());
        Customer customer = new Customer(ticketPool);

        //Thread for vendor and customer
        Thread vendorThread = new Thread(vendor);
        Thread customerThread = new Thread(customer);

        //CLI Menu
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        int choice = 0;
        do {

            try {
                showMenu();
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        if (vendorThread.isAlive()) {
                            System.out.println("Vendor is already running.");
                        } else {
                            vendorThread.start();
                            System.out.println("Vendor started.");
                        }
                        break;
                    case 2:
                        if (customerThread.isAlive()) {
                            System.out.println("Customer is already running.");
                        } else {
                            customerThread.start();
                            System.out.println("Customer started.");
                        }
                        break;
                    case 3:
                        System.out.println("Available tickets: " + ticketPool.getTicketCount());
                        break;
                    case 4:
                        System.out.println("Total ticket made:"+ ticketPool.getTotalTicketsAdded());
                        break;
                    case 6:
                        vendor.stop();
                        customer.stop();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                vendorThread.join();
                customerThread.join();
                System.out.println("Shutting down...");

            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 6);

    }

    private static void showMenu() {
        System.out.println();
        System.out.println("----------Real Time Ticketing System----------");
        System.out.println();
        System.out.println("1. Configure System");
        System.out.println("2. Start Vendor");
        System.out.println("3. Start Customer");
        System.out.println("4. View tickets");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

}
