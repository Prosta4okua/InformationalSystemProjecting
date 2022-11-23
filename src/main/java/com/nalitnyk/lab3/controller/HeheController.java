package com.nalitnyk.lab3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeheController {
    @RequestMapping("/hello")
    public String getAllClients() {
        return "Hello, my favorite Docker!!!!!";
    }
//    Docker allows you to run a container in interactive mode.
//    This means you can execute commands inside the container while it is still running.
}
