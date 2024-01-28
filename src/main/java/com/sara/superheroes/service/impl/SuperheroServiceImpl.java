package com.sara.superheroes.service.impl;

import com.sara.superheroes.dto.SuperheroDTO;
import com.sara.superheroes.mapper.SuperheroMapper;
import com.sara.superheroes.model.Superhero;
import com.sara.superheroes.respository.SuperheroRepository;
import com.sara.superheroes.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperheroServiceImpl implements SuperheroService {

    @Autowired
    private SuperheroMapper superheroMapper;

    @Autowired
    private SuperheroRepository superheroRepository;

    @Override
    public List<SuperheroDTO> getAllSuperheroes() {
        return superheroMapper.superheroToSuperheroeDTO(superheroRepository.findAll());
    }

    @Override
    public SuperheroDTO getSuperhero(int id) {
        SuperheroDTO superheroDTO = null;
        Optional<Superhero> superhero = superheroRepository.findById(id);
        if(superhero.isPresent()){
            superheroDTO = superheroMapper.superheroToSuperheroeDTO(superhero.get());
        }
        return superheroDTO;
    }
}
