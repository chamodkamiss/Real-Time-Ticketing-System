package com.example.ticketingSystem.controller.config;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Config implements Serializable {
    private int totalTickets;
    private int ReleaseRate;
    private int customerRetrievalRate;
    private int maxCapacity;
    private boolean running;

    public Config() {
        this.running = true; // Default to running
    }

    // Method to get input and validate
    public static void getConfigInputs(Config config) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n=== Ticket System Configuration ===");

        // Total number of tickets
        while (true) {
            try {
                System.out.print("Enter Total Tickets: ");
                int newTotalTickets = input.nextInt();
                if (newTotalTickets > 0) {
                    config.setTotalTickets(newTotalTickets);
                    break;
                } else {
                    System.out.println("Error: Please enter an integer value greater than 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter an integer value");
                input.next(); // Clear invalid input
            }
        }

        // Ticket release rate
        while (true) {
            try {
                System.out.print("Enter Ticket Release Rate (1-5): ");
                int ReleaseRate = input.nextInt();
                if (ReleaseRate >= 1 && newReleaseRate <= 5) {
                    config.setTicketReleaseRate(newReleaseRate);
                    break;
                } else {
                    System.out.println("Error: Please enter an integer value between 1 and 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter an integer value");
                input.next(); // Clear invalid input
            }
        }

        // Customer retrieval rate
        while (true) {
            try {
                System.out.print("Enter Customer Retrieval Rate (1-5): ");
                int newCustomerRetrievalRate = input.nextInt();
                if (newCustomerRetrievalRate >= 1 && newCustomerRetrievalRate <= 5) {
                    config.setCustomerRetrievalRate(newCustomerRetrievalRate);
                    break;
                } else {
                    System.out.println("Error: Please enter an integer value between 1 and 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter an integer value");
                input.next(); // Clear invalid input
            }
        }

        // Max Ticket Capacity
        while (true) {
            try {
                System.out.print("Enter Max Ticket Capacity: ");
                int newMaxCapacity = input.nextInt();
                if (newMaxCapacity > 0 && newMaxCapacity <= config.getTotalTickets()) {
                    config.setMaxCapacity(newMaxCapacity);
                    break;
                } else {
                    System.out.println("Error: Max Ticket Capacity must be greater than 0 and less than or equal to Total Tickets");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter an integer value");
                input.next(); // Clear invalid input
            }
        }
    }

    // Save object
    public static void saveConfiguration(Config config, String filePath) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(config);

        // Write JSON string to file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
            System.out.println("Configuration saved successfully to: " + filePath);
        }
    }

    // Update configuration
    public Config updateConfiguration(Config newConfig) {
        this.totalTickets = newConfig.getTotalTickets();
        this.ReleaseRate = newConfig.getTicketReleaseRate();
        this.customerRetrievalRate = newConfig.getCustomerRetrievalRate();
        this.maxCapacity = newConfig.getMaxCapacity();
        return this;
    }

    // Getters and setters
    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getReleaseRate() {
        return ReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ReleaseRate = ReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public String toString() {
        return "Config{" +
                "totalTickets=" + totalTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxCapacity=" + maxCapacity +
                ", running=" + running +
                '}';
    }
}

//
//import com.example.ticketingSystem.controller.util.TicketPool;
//import org.hibernate.boot.cfgxml.internal.ConfigLoader;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.Map;
//import java.util.Scanner;
//
//import static com.example.ticketingSystem.controller.config.ConfigLoader.saveConfigToFile;
//
//@Configuration
//public class Config implements Serializable {
//    private int totalTickets;
//    private int maxCapacity;
//    private int releaseRate;
//    private int retrievalRate;
//
//
//    public Config(int totalTickets, int maxCapacity, int releaseRate, int retrievalRate) {
//        this.totalTickets = totalTickets;
//        this.maxCapacity = maxCapacity;
//        this.releaseRate = releaseRate;
//        this.retrievalRate = retrievalRate;
//    }
//
//    public int getTotalTickets() {
//        return totalTickets;
//    }
//
//    public void setTotalTickets(int totalTickets) {
//        this.totalTickets = totalTickets;
//    }
//
//    public int getMaxCapacity() {
//        return maxCapacity;
//    }
//
//    public void setMaxCapacity(int maxCapacity) {
//        this.maxCapacity = maxCapacity;
//    }
//
//    public int getReleaseRate() {
//        return releaseRate;
//    }
//
//    public void setReleaseRate(int releaseRate) {
//        this.releaseRate = releaseRate;
//    }
//
//    public int getRetrievalRate() {
//        return retrievalRate;
//    }
//
//    public void setRetrievalRate(int retrievalRate) {
//        this.retrievalRate = retrievalRate;
//    }
//
//    public static void promptForConfig(String filepath) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//
//        // Prompt for required parameters
//        System.out.print("Enter total number of tickets: ");
//        int totalTickets = scanner.nextInt();
//        setTotalTickets(totalTickets);
//
//        System.out.print("Enter ticket release rate (in milliseconds): ");
//        int ticketReleaseRate = scanner.nextInt();
//        setReleaseRate(ticketReleaseRate);
//
//        System.out.print("Enter customer retrieval rate (in milliseconds): ");
//        int customerRetrievalRate = scanner.nextInt();
//        setRetrievalRate(customerRetrievalRate);
//
//        System.out.print("Enter max ticket capacity: ");
//        int maxTicketCapacity = scanner.nextInt();
//        setMaxCapacity(maxTicketCapacity);
//
//        // Create a Config object with the entered values
//        ConfigLoader cliConfig = new ConfigLoader(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
//
//        // Save the configuration to the file
//        saveConfigToFile(filepath);
//    }
//
//    public Map<String, Object> toMap() {
//        return Map.of("totalTickets", totalTickets, "maxCapacity", maxCapacity, "releaseRate", releaseRate, "retrievalRate", retrievalRate);
//    }
//
//
//}
