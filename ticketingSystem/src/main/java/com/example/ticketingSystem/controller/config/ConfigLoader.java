package com.example.ticketingSystem.controller.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@Component
public class ConfigLoader {
    private static  Config cliconfig;

    public ConfigLoader()throws IOException{
        String filepath = "C:\\Users\\HP\\OneDrive\\Documents\\GitHub\\Real-Time-Ticketing-System\\RealTimeTicketingSystemCli\\src\\main\\resources\\config.json";

        File configFile = new File(filepath);
//        if (configFile.exists()) {
//            // Try to load configuration from the file
//            try {
//                ObjectMapper objectMapper = new ObjectMapper();
//                cliconfig = objectMapper.readValue(configFile, Config.class);
//                System.out.println("Configuration loaded successfully.");
//            } catch (IOException e) {
//                System.out.println("Error reading configuration file. Invalid data.");
//                promptForConfig(filepath); // Prompt for input if the file is invalid
//            }
//        } else {
//            // If the file doesn't exist, prompt for input
//            System.out.println("Configuration file not found. Please enter configuration data.");
//            promptForConfig(filepath); // Prompt for input if the file doesn't exist
//        }


        ObjectMapper objectMapper = new ObjectMapper();
        cliconfig= objectMapper.readValue(new File(filepath), Config.class);

    }
//    private void promptForConfig(String filepath) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//
//        // Prompt for required parameters
//        System.out.print("Enter total number of tickets: ");
//        int totalTickets = scanner.nextInt();
//
//        System.out.print("Enter ticket release rate (in milliseconds): ");
//        int ticketReleaseRate = scanner.nextInt();
//
//        System.out.print("Enter customer retrieval rate (in milliseconds): ");
//        int customerRetrievalRate = scanner.nextInt();
//
//        System.out.print("Enter max ticket capacity: ");
//        int maxTicketCapacity = scanner.nextInt();
//
//        // Create a Config object with the entered values
//        cliconfig = new Config(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
//
//        // Save the configuration to the file
//        saveConfigToFile(filepath);
//    }
//
//    private void saveConfigToFile(String filepath) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filepath), cliconfig);
//        System.out.println("Configuration saved to file.");
//    }


    public static Config getCliconfig() {
        return cliconfig;
    }
}
