package com.example.ticketingSystem.controller.config;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.Map;

@Configuration
public class Config implements Serializable {
    private int totalTickets;
    private int maxCapacity;
    private int releaseRate;
    private int retrievalRate;

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
}
