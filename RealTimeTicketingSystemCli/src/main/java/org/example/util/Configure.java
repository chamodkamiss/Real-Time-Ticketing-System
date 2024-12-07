package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Configure {
    static Scanner scanner = new Scanner(System.in);

    private static final String CONFIG_FILE_PATH = "src/main/resources/config.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    //load file
    public static SystemParameter load()  {
        try {
            return objectMapper.readValue(new File(CONFIG_FILE_PATH), SystemParameter.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + CONFIG_FILE_PATH, e);
        }
    }

    //save file
    public static void save(SystemParameter systemParameter) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(CONFIG_FILE_PATH), systemParameter);

        }catch (IOException e) {
            throw new RuntimeException("Failed to save configuration file: " + CONFIG_FILE_PATH, e);
        }
    }

    public static void configureSystem() {
        SystemParameter parameters;
        try {
            parameters = Configure.load();
            System.out.println("=============System Configuration==============\n");
            System.out.println("maxCapacity: " + parameters.getMaxCapacity());
            System.out.println("releaseRate: " + parameters.getReleaseRate());
            System.out.println("retrievalRate: " + parameters.getRetrievalRate());
            System.out.println("totalTickets: " + parameters.getTotalTickets());
        }catch (Exception e) {
            System.out.println("No existing configuration file. Please create a new one.");
            parameters = new SystemParameter();

            int maxCapacity = getValidatedInput(scanner, "Enter max ticket capacity: ", 1, Integer.MAX_VALUE);
            parameters.setMaxCapacity(maxCapacity);
            int totalTickets = getValidatedInput(scanner, "Enter total tickets available in the system: ", 1, maxCapacity);
            parameters.setTotalTickets(totalTickets);
            int ticketReleaseRate = getValidatedInput(scanner, "Enter ticket release rate (ms): ", 100, 10000);
            parameters.setReleaseRate(ticketReleaseRate);
            int customerRetrievalRate = getValidatedInput(scanner, "Enter customer retrieval rate (ms): ", 100, 10000);
            parameters.setRetrievalRate(customerRetrievalRate);


//
//            System.out.println();
//            System.out.println("--- System Configuration ---");
//            System.out.println("\nEnter max capacity: ");
//            parameters.setMaxCapacity(scanner.nextInt());
//            System.out.println("Enter total tickets: ");
//            parameters.setTotalTickets(scanner.nextInt());
//            System.out.println("Enter release rate: ");
//            parameters.setReleaseRate(scanner.nextInt());
//            System.out.println("Enter retrieval rate: ");
//            parameters.setRetrievalRate(scanner.nextInt());



            Configure.save(parameters);

            System.out.println("Your New Configuration saved.");
            System.out.println("\nTotal tickets: " + parameters.getTotalTickets());
            System.out.println("Max capacity: " + parameters.getMaxCapacity());
            System.out.println("Release rate: " + parameters.getReleaseRate());
            System.out.println("Retrieval rate: " + parameters.getRetrievalRate());
        }
    }

    private static int getValidatedInput(Scanner scanner, String message, int min, int max) {
        int value;
        while (true) {
            System.out.print(message);
            value = scanner.nextInt();
            if (value >= min && value <= max) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a value between " + min + " and " + max + ".");
            }
        }
        return value;
    }



//   private int maxCapacity;
//    private int ticketsPerRelease;
//    private int retrievalRate;
//
//
//    public int getMaxCapacity() {
//        return maxCapacity;
//    }
//
//    public int getTicketPerRelease() {
//        return ticketsPerRelease;
//    }
//
//
//    public int getRetrievalRate() {
//        return retrievalRate;
//    }
//
//    public void setMaxCapacity(int maxCapacity) {
//        this.maxCapacity = maxCapacity;
//    }
//
//    public void setTicketPerRelease(int ticketPerRelease) {
//        this.ticketsPerRelease = ticketPerRelease;
//    }

//    public void setTotalTickets(int totalTickets) {
//        this.totalTickets = totalTickets;
//    }

//    public void setRetrievalRate(int retrievalRate) {
//        this.retrievalRate = retrievalRate;
//    }




}
