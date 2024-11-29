package com.example.ticketingSystem.controller.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component
public class ConfigLoader {
    private final Config cliconfig;


    public ConfigLoader()throws IOException{
        String filepath = "C:\\Users\\HP\\OneDrive\\Documents\\GitHub\\Real-Time-Ticketing-System\\RealTimeTicketingSystemCli\\src\\main\\resources\\config.json";

        ObjectMapper objectMapper = new ObjectMapper();
        this.cliconfig= objectMapper.readValue(new File(filepath), Config.class);

    }
    public Config getCliconfig() {
        return cliconfig;
    }
}
