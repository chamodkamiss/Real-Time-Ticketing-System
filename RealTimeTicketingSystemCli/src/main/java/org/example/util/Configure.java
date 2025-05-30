package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Configure {
    Scanner scanner = new Scanner(System.in);

    private static final String CONFIG_FILE_PATH = "src/main/resources/config.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    //save file
    public static void save(SystemParameter systemParameter) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(CONFIG_FILE_PATH), systemParameter);

        }catch (IOException e) {
            throw new RuntimeException("Failed to save configuration file: " + CONFIG_FILE_PATH, e);
        }
    }

    //load file
    public static SystemParameter load()  {
        try {
            return objectMapper.readValue(new File(CONFIG_FILE_PATH), SystemParameter.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + CONFIG_FILE_PATH, e);
        }
    }


    public static void configureSystem(SystemParameter systemParameter,Scanner scanner) {

        // Configuration Parameters
        System.out.println("=== System Configuration ===");

        int maxCapacity = getValidatedInput(scanner, "Enter max ticket capacity: ", 1, Integer.MAX_VALUE);
        int totalTickets = getValidatedInput(scanner, "Enter total tickets available in the system(1-" + maxCapacity + "): ", 1, maxCapacity);
        int ticketReleaseRate = getValidatedInput(scanner, "Enter ticket release rate (ms): ", 100, 10000);
        int customerRetrievalRate = getValidatedInput(scanner, "Enter customer retrieval rate (ms): ", 100, 10000);

        System.out.println("System configured successfully!\n");

        System.out.println("Your New Configuration saved.");
        System.out.println("\nTotal tickets: " + totalTickets);
        System.out.println("Max capacity: " + maxCapacity);
        System.out.println("Release rate: " + ticketReleaseRate);
        System.out.println("Retrieval rate: " + customerRetrievalRate);

        systemParameter.setMaxCapacity(maxCapacity);
        systemParameter.setTotalTickets(totalTickets);
        systemParameter.setReleaseRate(ticketReleaseRate);
        systemParameter.setRetrievalRate(customerRetrievalRate);

        save(systemParameter);

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

}
