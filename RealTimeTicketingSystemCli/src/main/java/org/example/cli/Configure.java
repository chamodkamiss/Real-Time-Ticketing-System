package org.example.cli;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class Configure {
    private int maxCapacity;
    private int ticketsPerRelease;
    private int retrievalRate;


    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getTicketPerRelease() {
        return ticketsPerRelease;
    }


    public int getRetrievalRate() {
        return retrievalRate;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setTicketPerRelease(int ticketPerRelease) {
        this.ticketsPerRelease = ticketPerRelease;
    }

//    public void setTotalTickets(int totalTickets) {
//        this.totalTickets = totalTickets;
//    }

    public void setRetrievalRate(int retrievalRate) {
        this.retrievalRate = retrievalRate;
    }


    public static Configure loadConfigFile(String resourcePath) {
        Gson gson = new Gson();
        try (InputStream inputStream = Configure.class.getResourceAsStream("/config.json");) {
            if (inputStream == null) {
                throw new RuntimeException("Configuration file not found: " + resourcePath);
            }

            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = inputStream.read()) != -1) {
                sb.append((char) ch);
            }
//            System.out.println("file content: " + sb);
            return gson.fromJson(sb.toString(), Configure.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration file: " + resourcePath, e);
        }
    }

}
