package com.example.ticketingSystem.controller;

import com.example.ticketingSystem.controller.config.ConfigLoader;
import com.example.ticketingSystem.controller.dto.TicketDto;
import com.example.ticketingSystem.controller.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private final TicketService ticketService;
    private final ConfigLoader configLoader;

    @Autowired
    public TicketController(TicketService ticketService, ConfigLoader configLoader) {
        this.ticketService = ticketService;
        this.configLoader = configLoader;
    }

    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        return ConfigLoader.getCliconfig().toMap();
    }

    //save a new ticket
    @PostMapping("/startVendor")
    public ResponseEntity<String > addTicket(@RequestParam String ticketId){
        ticketService.addTicket(ticketId);
        return ResponseEntity.ok("Ticket saved successfully."+ ticketId);
    }

    @PostMapping("/customer")
    public ResponseEntity<String > purchaseTicket(){
        String ticketId = ticketService.removeTicket();
        return ResponseEntity.ok("Ticket purchased: "+ ticketId);
    }

    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTickets(){
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable String ticketId){
        return ResponseEntity.ok(ticketService.getTicketById(ticketId));
    }

//    @PostMapping("/addTickets")
//    public String addTicket(@RequestBody TicketDto ticketDto)
//    {
//        ticketService.saveTicket(ticketDto);
//        return "Ticket added: "+ ticketDto.getTicketId();
//    }

//    @GetMapping("/getTickets")
//    public List<TicketDto> getAllTickets()
//    {
//        return ticketService.getAllTickets();
//    }

    //delete ticket
//    @DeleteMapping("/{ticketId}")
//    public String removeTicket(@PathVariable String ticketId)
//    {
//        boolean removed = ticketService.deleteTicket(ticketId);
//        if (removed){
//            return "Ticket removed: "+ ticketId;
//        }
//        else {
//            return "Ticket not found: "+ ticketId;
//        }
//    }


}
