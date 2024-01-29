package com.sara.superheroes.controller;

import com.sara.superheroes.dto.SuperheroDTO;
import com.sara.superheroes.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    @GetMapping("/superheroes")
    public ResponseEntity<List<SuperheroDTO>> getAllSuperheroes(@RequestParam(value = "name", required = false) String name){
        List<SuperheroDTO> superheroList;
        if(name != null && !name.isEmpty()){
            superheroList = superheroService.getSuperheroesByName(name);
        }else{
            superheroList = superheroService.getAllSuperheroes();
        }

        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    @GetMapping("/superheroes/{id}")
    public ResponseEntity<SuperheroDTO> getSuperheroe(@PathVariable(value = "id") int id){
        SuperheroDTO superhero = superheroService.getSuperhero(id);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @PostMapping("/superheroes")
    public ResponseEntity<SuperheroDTO> createSuperheroe(@RequestBody SuperheroDTO superhero){
        SuperheroDTO createdSuperhero = superheroService.createSuperhero(superhero);
        return new ResponseEntity<>(createdSuperhero, HttpStatus.CREATED);
    }

    @PutMapping("/superheroes")
    public ResponseEntity<SuperheroDTO> updateSuperheroe(@RequestBody SuperheroDTO superhero){
        return null;
    }


}
