package org.example.util;

public class SystemParameter {
    private int maxCapacity;
    private int releaseRate;
    private int retrievalRate;
    private int totalTickets;

    public SystemParameter(int maxCapacity, int totalTickets, int ticketReleaseRate, int customerRetrievalRate) {
        this.maxCapacity = maxCapacity;
        this.totalTickets = totalTickets;
        this.releaseRate = ticketReleaseRate;
        this.retrievalRate = customerRetrievalRate;
    }

    public SystemParameter() {

    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
    public int getReleaseRate() {
        return releaseRate;
    }
    public int getRetrievalRate() {
        return retrievalRate;
    }
    public int getTotalTickets() {
        return totalTickets;
    }
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    public void setReleaseRate(int releaseRate) {
        this.releaseRate = releaseRate;
    }
    public void setRetrievalRate(int retrievalRate) {
        this.retrievalRate = retrievalRate;
    }
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }


}




