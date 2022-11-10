package com.nalitnyk;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan("com.nalitnyk.lab3.controller")
//@EnableJpaRepositories("com.nalitnyk.lab3.repository")
public class Lw3Application extends SpringBootServletInitializer implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Lw3Application.class, args);

    }

    @Override
    public void run(String... args) {

    }
}
