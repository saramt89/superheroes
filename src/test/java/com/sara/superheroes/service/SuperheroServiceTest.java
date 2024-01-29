package com.sara.superheroes.service;

import com.sara.superheroes.dto.SuperheroDTO;
import com.sara.superheroes.mapper.SuperheroMapper;
import com.sara.superheroes.model.Superhero;
import com.sara.superheroes.respository.SuperheroRepository;
import com.sara.superheroes.service.impl.SuperheroServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class SuperheroServiceTest {

    @Mock
    private SuperheroRepository superheroRepository;

    @Mock
    private SuperheroMapper superheroMapper;

    @InjectMocks
    private SuperheroServiceImpl superheroService;

    @Test
    public void getAllSuperheroes(){

        List<Superhero> superheroList = mock(List.class);
        when(superheroRepository.findAll()).thenReturn(superheroList);

        List<SuperheroDTO> superheroDTOList = superheroService.getAllSuperheroes();

        verify(superheroRepository, times(1)).findAll();
        assertNotNull(superheroDTOList);

    }

    @Test
    public void getSuperheroById(){
        int superheroId = 1;
        Superhero mockSuperhero = mock(Superhero.class);
        SuperheroDTO mockSuperheroDTO = mock(SuperheroDTO.class);
        when(superheroRepository.findById(superheroId)).thenReturn(Optional.of(mockSuperhero));
        when(superheroMapper.superheroToSuperheroeDTO(mockSuperhero)).thenReturn(mockSuperheroDTO);

        SuperheroDTO superhero = superheroService.getSuperhero(superheroId);

        assertNotNull(superhero);
        verify(superheroRepository, times(1)).findById(superheroId);

    }

    @Test
    public void getSuperheroesByNameTest(){
        String name = "super";
        List<Superhero> superheroList = mock(List.class);
        when(superheroRepository.findByNameContainingIgnoreCase(name)).thenReturn(superheroList);

        List<SuperheroDTO> superheroDTOList = superheroService.getSuperheroesByName(name);

        verify(superheroRepository, times(1)).findByNameContainingIgnoreCase(name);
        assertNotNull(superheroDTOList);

    }

    @Test
    public void createSuperheroTest(){
        Superhero superhero = new Superhero();
        SuperheroDTO superheroDTO = SuperheroDTO.builder()
                .id(1)
                .name("Superman")
                .age(35)
                .gender("male")
                .birthPlace("Smallville")
                .power("Fly")
                .operationBase("Metropolis")
                .build();

        BeanUtils.copyProperties(superheroDTO, superhero);

        when(superheroMapper.superheroDTOToSuperhero(Mockito.any(SuperheroDTO.class))).thenReturn(superhero);
        when(superheroRepository.save(Mockito.any(Superhero.class))).thenReturn(superhero);
        when(superheroMapper.superheroToSuperheroeDTO(Mockito.any(Superhero.class))).thenReturn(superheroDTO);

        SuperheroDTO savedSuperhero = superheroService.createSuperhero(superheroDTO);

        assertNotNull(savedSuperhero);

    }

    @Test
    public void updateSuperheroTest(){
        Superhero superhero = new Superhero();
        SuperheroDTO superheroToUpdate = SuperheroDTO.builder()
                .id(1)
                .name("Superman")
                .age(35)
                .gender("male")
                .birthPlace("Smallville")
                .power("Fly")
                .operationBase("Metropolis")
                .build();

        BeanUtils.copyProperties(superheroToUpdate, superhero);

        when(superheroMapper.superheroDTOToSuperhero(Mockito.any(SuperheroDTO.class))).thenReturn(superhero);
        when(superheroRepository.save(superhero)).thenReturn(superhero);
        when(superheroMapper.superheroToSuperheroeDTO(Mockito.any(Superhero.class))).thenReturn(superheroToUpdate);

        SuperheroDTO updatedSuperhero = superheroService.updateSuperhero(superheroToUpdate);

        assertNotNull(updatedSuperhero);

    }



}
