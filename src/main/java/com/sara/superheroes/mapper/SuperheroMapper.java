package com.sara.superheroes.mapper;

import com.sara.superheroes.dto.SuperheroDTO;
import com.sara.superheroes.model.Superhero;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SuperheroMapper {

    SuperheroDTO superheroToSuperheroeDTO(Superhero superhero);

    Superhero superheroDTOToSuperhero(SuperheroDTO superheroDTO);

    List<SuperheroDTO> superheroToSuperheroeDTO(List<Superhero> superhero);

    List<Superhero> superheroDTOToSuperhero(List<SuperheroDTO> superheroDTO);
}
