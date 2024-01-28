package com.sara.superheroes.respository;

import com.sara.superheroes.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Integer> {
    List<Superhero> findByNameContainingIgnoreCase(String name);


}
