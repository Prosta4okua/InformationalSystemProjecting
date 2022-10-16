package com.nalitnyk.lab3.controller;

import com.nalitnyk.lab3.repository.ClientRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    @Query("")
    public ResponseEntity getAllClients() {
        return ResponseEntity.ok(this.clientRepository.findAll());
    }
}
