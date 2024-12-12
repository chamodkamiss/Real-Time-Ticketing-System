package com.example.ticketingSystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class TicketDto {

    private long id;
    private String ticketId;
//    private long timestamp;
//
//    private boolean is_sold= false;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
//
//    public long getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(long timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public boolean isIs_sold() {
//        return is_sold;
//    }
//
//    public void setIs_sold(boolean is_sold) {
//        this.is_sold = is_sold;
//    }

}
