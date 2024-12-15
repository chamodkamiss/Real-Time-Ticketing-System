package com.example.ticketingSystem.controller;

import com.example.ticketingSystem.controller.config.Config;
import com.example.ticketingSystem.controller.dto.TicketDto;
import com.example.ticketingSystem.controller.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@CrossOrigin
public class TicketController {
    private final TicketService ticketService;
    private final Config config;


    @Autowired
    public TicketController(TicketService ticketService, Config config) {
        this.ticketService = ticketService;
        this.config = config;
    }

    @GetMapping("/config")
    public String getConfig() {
        return config.toString();
    }


    @PostMapping
    public ResponseEntity<String > addTicket(@RequestBody TicketDto ticketDto){
        TicketDto savedTicket = ticketService.saveTicket(ticketDto);
        return ResponseEntity.ok("Ticket saved successfully."+ savedTicket.getTicketId());
    }


    @DeleteMapping("/{ticketId}")
    public ResponseEntity<String > deleteTicket(@PathVariable String ticketId){
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.ok("Ticket deleted: "+ ticketId);
    }

    @GetMapping("/allTickets")
    public ResponseEntity<List<TicketDto>> getAllTickets(){
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable String ticketId){
        return ResponseEntity.ok(ticketService.getTicketById(ticketId));
    }


}
