//package org.example.cli;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.InputStream;
//
//public class ConfigLoader {
//
//    String json = "/real-time-ticketing-cli/src/main/resources/config.json";
//    public static Configure load(String json) throws RuntimeException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try(InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream(json)) {
//            if (inputStream == null) {
//                throw new RuntimeException("config.json not found" + json);
//            }
//            return objectMapper.readValue(inputStream, Configure.class);
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load config.json",e);
//        }
//    }
//}


