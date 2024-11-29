package com.example.ticketingSystem.controller;


import com.example.ticketingSystem.controller.dto.TicketDto;
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



    @GetMapping("/getTicket")
    public String getTicket() {
        return "Ticket";
    }

    @PostMapping("/saveTicket")
    public TicketDto addTicketsToPool(@RequestBody TicketDto ticketDto) {
        return ticketService.addTicketsToPool(ticketDto);
    }


    @PutMapping("/updateTicket")
    public String updateTicket() {
        return "pTicket";
    }
    @DeleteMapping("/deleteTicket")
    public String deleteTicket() {
        return "dTicket";
    }




}
