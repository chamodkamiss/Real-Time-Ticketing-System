package org.example;

import org.example.models.TicketPool;
import org.example.threads.Customer;
import org.example.threads.Vendor;
import org.example.util.Configure;
import org.example.util.SystemParameter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CliApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SystemParameter parameters = Configure.load();

        TicketPool ticketPool = new TicketPool(parameters.getMaxCapacity(), parameters.getTotalTickets());

        while (true) {
            try {
                System.out.println("\n============= Command Menu ==============\n");
                System.out.println("1. Configure System");
                System.out.println("2. Start Operations");
                System.out.println("3. Stop Operations");
                System.out.println("4. Monitor System");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");


                int choice = scanner.nextInt();

                if (choice == 1) {
                    // Configure system
                    Configure.configureSystem();
                }
                else if (choice == 2) {
                    // Start operations
                    startOperations(scanner, ticketPool, parameters.getReleaseRate(), parameters.getRetrievalRate(), parameters.getTotalTickets());
                } else if (choice == 3) {
                    System.out.println("Stopping operations...");
                    ticketPool.stopOperations();
                } else if (choice == 4) {
                    ticketPool.monitorStatus();
                } else if (choice == 5) {
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }

            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }

        scanner.close();
    }

    private static void startOperations(Scanner scanner, TicketPool ticketPool, int ticketReleaseRate, int customerRetrievalRate, int totalTickets) {

        System.out.print("\nEnter number of vendors: ");
        int numVendors = scanner.nextInt();
        System.out.print("Enter number of customers: ");
        int numCustomers = scanner.nextInt();

        // Create and start vendor threads
        for (int i = 0; i < numVendors; i++) {
            System.out.print("\nEnter vendor ID for vendor " + (i + 1) + ": ");
            String vendorId = scanner.next();
            System.out.print("Enter tickets to add for vendor " + (i + 1) + ": ");
            int ticketsToAdd = scanner.nextInt();
            System.out.println();
            Vendor vendor = new Vendor(ticketPool, ticketsToAdd, vendorId, ticketReleaseRate);
            Thread vendorThread = new Thread(vendor);
            vendorThread.start();
            try {
                vendorThread.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting for vendor.");
            }
        }

        // Create and start customer threads
        for (int i = 0; i < numCustomers; i++) {
            System.out.print("\nEnter customer ID for customer " + (i + 1) + ": ");
            String customerId = scanner.next();
            System.out.print("Enter tickets to purchase for customer " + (i + 1) + ": ");
            int ticketsToPurchase = scanner.nextInt();
            Customer customer = new Customer(ticketPool, ticketsToPurchase, customerId, customerRetrievalRate);
            Thread customerThread = new Thread(customer);
            customerThread.start();
            try {
                customerThread.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting for customer.");
            }

        }
    }


}



