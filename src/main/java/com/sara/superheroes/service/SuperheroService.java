package com.sara.superheroes.service;

import com.sara.superheroes.dto.SuperheroDTO;

import java.util.List;

public interface SuperheroService {
    List<SuperheroDTO> getAllSuperheroes();

    SuperheroDTO getSuperhero(int id);

    List<SuperheroDTO> getSuperheroesByName(String name);

    SuperheroDTO createSuperhero(SuperheroDTO superhero);

    SuperheroDTO updateSuperhero(SuperheroDTO superhero);
}
