//package com.example.ticketingSystem.controller;
//
//import com.example.ticketingSystem.controller.config.Config;
//import com.example.ticketingSystem.controller.config.ConfigLoader;
////import com.example.ticketingSystem.controller.dto.ConfigDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/config")
//public class ConfigController {
//
//    @Autowired
//    private final ConfigLoader configLoader;
//
//
//    public ConfigController(ConfigLoader configLoader) {
//        this.configLoader = configLoader;
//    }
//    @GetMapping("/config")
//    public Map<String, Object> getConfig() {
//        return configLoader.getCliconfig().toMap();
//    }
//
////    @PostMapping("/update")
////    public ConfigLoader updateConfig(@RequestBody Config config) throws Exception{
////        ConfigLoader configLoader = new ConfigLoader();
////        configLoader.getCliconfig().setTotalTickets(config.getTotalTickets());
////        configLoader.getCliconfig().setMaxCapacity(config.getMaxCapacity());
////        configLoader.getCliconfig().setReleaseRate(config.getReleaseRate());
////        configLoader.getCliconfig().setRetrievalRate(config.getRetrievalRate());
////        return configLoader;
////
////    }
//
//}
