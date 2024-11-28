package com.example.ticketingSystem.controller;


import com.example.ticketingSystem.controller.entity.Ticket;
import com.example.ticketingSystem.controller.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "api/v1/ticket")
@CrossOrigin
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping("/purchase/{id}")
    public Ticket purchaseTicket(@PathVariable long id) {
        boolean success = ticketService.purchaseTicket(id);
        if (!success) {
            return null;
        }
        else {


        }

    }


}
