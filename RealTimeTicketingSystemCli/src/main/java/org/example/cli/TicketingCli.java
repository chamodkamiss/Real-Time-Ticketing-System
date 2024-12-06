package org.example.cli;

import org.example.util.Configure;
import org.example.util.SystemParameter;

import java.util.*;

public class TicketingCli {

    static SystemParameter parameters;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
      Configure.load();
      boolean running = true;

      System.out.println("Welcome to the Real Time Ticketing System CLI!");
      System.out.println();

      while (running){
          try {
                System.out.println("\nReal Time Ticketing System");
                System.out.println();
                System.out.println("1. Configure System");
                System.out.println("2. Start Vendor");
                System.out.println("3. Start Customer");
                System.out.println("4. View tickets");
                System.out.println("6. Exit");
                System.out.println();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        configureSystem();
                        break;
                    case 2:
                        ApiClient.saveTicket();



    //                 case 2:
    //                     apiClient.startVendor();
    //                    break;
    //                 case 3:
    //                     apiClient.startCustomer();
    //                     break;
    //                 case 4:
    //                     apiClient.viewTicket();
    //                     break;
    //                 case 6:
    //                     running = false;
    //                     break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
          }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }



//
    }

    public static void configureSystem() {
        try {
            parameters = Configure.load();
            System.out.println("System Parameters:\n");
            System.out.println("maxCapacity: " + parameters.getMaxCapacity());
            System.out.println("releaseRate: " + parameters.getReleaseRate());
            System.out.println("retrievalRate: " + parameters.getRetrievalRate());
            System.out.println("totalTickets: " + parameters.getTotalTickets());
        }catch (Exception e) {
            System.out.println("No existing configuration file. Please create a new one.");
            parameters = new SystemParameter();

            System.out.println();
            System.out.println("--- System Configuration ---");
            System.out.println("\nEnter max capacity: ");
            parameters.setMaxCapacity(scanner.nextInt());
            System.out.println("Enter total tickets: ");
            parameters.setTotalTickets(scanner.nextInt());
            System.out.println("Enter release rate: ");
            parameters.setReleaseRate(scanner.nextInt());
            System.out.println("Enter retrieval rate: ");
            parameters.setRetrievalRate(scanner.nextInt());
            Configure.save(parameters);

            System.out.println("Your New Configuration saved.");
            System.out.println("\nTotal tickets: " + parameters.getTotalTickets());
            System.out.println("Max capacity: " + parameters.getMaxCapacity());
            System.out.println("Release rate: " + parameters.getReleaseRate());
            System.out.println("Retrieval rate: " + parameters.getRetrievalRate());
        }
    }



}
