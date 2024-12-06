package com.example.ticketingSystem.controller.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ConfigLoader {
    private static  Config cliconfig;

    public ConfigLoader()throws IOException{
        String filepath = "C:\\Users\\HP\\OneDrive\\Documents\\GitHub\\Real-Time-Ticketing-System\\RealTimeTicketingSystemCli\\src\\main\\resources\\config.json";

        ObjectMapper objectMapper = new ObjectMapper();
        this.cliconfig= objectMapper.readValue(new File(filepath), Config.class);

    }
    public static Config getCliconfig() {
        return cliconfig;
    }
}
