package com.sara.superheroes.service.impl;

import com.sara.superheroes.dto.SuperheroDTO;
import com.sara.superheroes.exceptions.SuperheroExistsException;
import com.sara.superheroes.exceptions.SuperheroNotFoundException;
import com.sara.superheroes.mapper.SuperheroMapper;
import com.sara.superheroes.model.Superhero;
import com.sara.superheroes.respository.SuperheroRepository;
import com.sara.superheroes.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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
        }else{
            throw new SuperheroNotFoundException("The superhero with id:" + id + " doesn't exist");
        }
        return superheroDTO;
    }

    @Override
    public List<SuperheroDTO> getSuperheroesByName(String name) {
        return superheroMapper.superheroToSuperheroeDTO(superheroRepository.findByNameContainingIgnoreCase(name));
    }

    @Override
    public SuperheroDTO createSuperhero(SuperheroDTO superhero) {
        if(getSuperhero(superhero.getId()) != null){
            throw new SuperheroExistsException("The superhero with id:" +superhero.getId()+" already exists");
        }
        Superhero savedSuperhero = superheroRepository.save(superheroMapper.superheroDTOToSuperhero(superhero));
        return superheroMapper.superheroToSuperheroeDTO(savedSuperhero);
    }

    @Override
    public SuperheroDTO updateSuperhero(SuperheroDTO superhero) {
        Superhero savedSuperhero = superheroRepository.save(superheroMapper.superheroDTOToSuperhero(superhero));
        return superheroMapper.superheroToSuperheroeDTO(savedSuperhero);
    }

    @Override
    public SuperheroDTO deleteSuperhero(int id) {
        SuperheroDTO deletedSuperhero = getSuperhero(id);
        if(getSuperhero(id) == null){
            throw new SuperheroNotFoundException("The superhero with id:" + id + " doesn't exist");
        }
        superheroRepository.deleteById(id);
        return deletedSuperhero;
    }
}
