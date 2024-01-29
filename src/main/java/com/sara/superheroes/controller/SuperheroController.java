package com.sara.superheroes.controller;

import com.sara.superheroes.dto.SuperheroDTO;
import com.sara.superheroes.service.SuperheroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "superhero")
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    @Operation(summary = "Get all superheroes and filter them by name")
    @GetMapping("/superheroes")
    public ResponseEntity<List<SuperheroDTO>> getAllSuperheroes(@Parameter(name = "name", description = "Name of the superhero to be filtered by")
                                                                    @RequestParam(value = "name", required = false) String name){
        List<SuperheroDTO> superheroList;
        if(name != null && !name.isEmpty()){
            superheroList = superheroService.getSuperheroesByName(name);
        }else{
            superheroList = superheroService.getAllSuperheroes();
        }

        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    @Operation(summary = "Get a superhero by it's ID")
    @GetMapping("/superheroes/{id}")
    public ResponseEntity<SuperheroDTO> getSuperheroe(@Parameter(name = "id", description = "Id of the superhero to be searched")
                                                          @PathVariable(value = "id") int id){
        SuperheroDTO superhero = superheroService.getSuperhero(id);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @Operation(summary = "Create a superhero")
    @PostMapping("/superheroes")
    public ResponseEntity<SuperheroDTO> createSuperheroe(@RequestBody SuperheroDTO superhero){
        SuperheroDTO createdSuperhero = superheroService.createSuperhero(superhero);
        return new ResponseEntity<>(createdSuperhero, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a superhero")
    @PutMapping("/superheroes")
    public ResponseEntity<SuperheroDTO> updateSuperheroe(@RequestBody SuperheroDTO superhero){
        SuperheroDTO updatedSuperhero = superheroService.updateSuperhero(superhero);
        return new ResponseEntity<>(updatedSuperhero, HttpStatus.OK);
    }

    @Operation(summary = "Delete a superhero")
    @DeleteMapping("/superheroes/{id}")
    public ResponseEntity<SuperheroDTO> deleteSuperheroe(@Parameter(name = "id", description = "Id of the superhero to be deleted")
                                                             @PathVariable(value = "id") int id){
        SuperheroDTO superhero = superheroService.deleteSuperhero(id);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }



}
