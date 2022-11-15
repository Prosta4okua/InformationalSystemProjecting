package com.nalitnyk.Lab4.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExitController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/shutdown-app")
    public void shutdownApp() {
        int exitCode = SpringApplication.exit(context, (ExitCodeGenerator) () -> 0);
        System.exit(exitCode);
    }
}
