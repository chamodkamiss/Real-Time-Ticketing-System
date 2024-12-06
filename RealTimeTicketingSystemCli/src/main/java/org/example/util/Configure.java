package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class Configure {

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
