package com.nalitnyk.lab3.controller;

import com.nalitnyk.lab3.repository.TicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketRepository ticketRep;

    public TicketController(TicketRepository tickerRep) {
        this.ticketRep = tickerRep;
    }

    @GetMapping
    public ResponseEntity getAllClients() {
        return ResponseEntity.ok(this.ticketRep.findAll());
    }
}
