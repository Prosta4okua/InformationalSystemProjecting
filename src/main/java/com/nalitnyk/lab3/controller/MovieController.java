package com.nalitnyk.lab3.controller;

import com.nalitnyk.lab3.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
//        movieRepository.getReferenceById(1).
    }


    @GetMapping
    public ResponseEntity getAllClients() {
        return ResponseEntity.ok(this.movieRepository.findAll());
    }
}
