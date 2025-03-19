package com.example.ticketingSystem.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
//import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

@Configuration
public class Config implements Serializable {
    private int totalTickets;
    private int maxCapacity;
    private int releaseRate;
    private int retrievalRate;


//    public Config(int totalTickets, int maxCapacity, int releaseRate, int retrievalRate) {
//        this.totalTickets = totalTickets;
//        this.maxCapacity = maxCapacity;
//        this.releaseRate = releaseRate;
//        this.retrievalRate = retrievalRate;
//    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getReleaseRate() {
        return releaseRate;
    }

    public void setReleaseRate(int releaseRate) {
        this.releaseRate = releaseRate;
    }

    public int getRetrievalRate() {
        return retrievalRate;
    }

    public void setRetrievalRate(int retrievalRate) {
        this.retrievalRate = retrievalRate;
    }

    public Map<String, Object> toMap() {
        return Map.of("totalTickets", totalTickets, "maxCapacity", maxCapacity, "releaseRate", releaseRate, "retrievalRate", retrievalRate);
    }


    public void saveToJsonFile(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), this);
    }

    // New method to load configuration from JSON file
    public static Config loadFromJsonFile(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        // If file doesn't exist, return a default configuration
        if (!file.exists()) {
            Config defaultConfig = new Config();
            defaultConfig.setTotalTickets(100);  // Example default values
            defaultConfig.setMaxCapacity(50);
            defaultConfig.setReleaseRate(10);
            defaultConfig.setRetrievalRate(10);

            // Save the default configuration
            defaultConfig.saveToJsonFile(filePath);
            return defaultConfig;
        }

        // If file exists, load from it
        return mapper.readValue(file, Config.class);
    }

    // Optional: Add a toString method for easier debugging
    @Override
    public String toString() {
        return "Config{" +
                "totalTickets=" + totalTickets +
                ", maxCapacity=" + maxCapacity +
                ", releaseRate=" + releaseRate +
                ", retrievalRate=" + retrievalRate +
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
