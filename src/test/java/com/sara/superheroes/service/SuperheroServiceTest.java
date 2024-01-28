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

import java.util.List;

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

        List<Superhero> superheroList = Mockito.mock(List.class);
        when(superheroRepository.findAll()).thenReturn(superheroList);

        List<SuperheroDTO> superheroDTOList = superheroService.getAllSuperheroes();

        verify(superheroRepository, times(1)).findAll();
        Assertions.assertThat(superheroDTOList).isNotNull();

    }


}
