package com.nalitnyk.lab3.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nalitnyk.lab3.model.ClientEmail;
import com.nalitnyk.lab3.repository.EmailRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {
    private EntityManager entityManager;
    private List<ClientEmail> clients;
    private final EmailRepository emailRep;
    private final ClientController client;

    public EmailController(EmailRepository emailRep, ClientController clientController) {
        this.emailRep = emailRep;
        this.client = clientController;
    }


    @GetMapping
    public ResponseEntity getAllEmails() {

//        Query nativeQuery = entityManager.createNativeQuery("SELECT ce.client_id, c.name, c.age, c.phone, ce.email FROM client_email ce INNER JOIN client c on c.client_id = ce.client_id");

        return ResponseEntity.ok(emailRep.findAll());
    }
}
