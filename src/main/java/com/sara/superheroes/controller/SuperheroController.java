package com.sara.superheroes.controller;

import com.sara.superheroes.dto.SuperheroDTO;
import com.sara.superheroes.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    @GetMapping("/superheroes")
    public ResponseEntity<List<SuperheroDTO>> getAllSuperheroes(){
        List<SuperheroDTO> superheroList = superheroService.getAllSuperheroes();
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }
}
