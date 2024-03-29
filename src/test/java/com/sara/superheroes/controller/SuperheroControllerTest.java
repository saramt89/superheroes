package com.sara.superheroes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sara.superheroes.dto.SuperheroDTO;
import com.sara.superheroes.service.SuperheroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SuperheroController.class)
@ExtendWith(SpringExtension.class)
public class SuperheroControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SuperheroService superheroService;

    @Test
    void getAllSuperheroesTest() throws Exception {
        mockMvc.perform(get("/api/superheroes"))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    void getAllSuperheroByIdTest() throws Exception {
        mockMvc.perform(get("/api/superheroes/{id}", 1))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    void getAllSuperheroByNameTest() throws Exception {
        mockMvc.perform(get("/api/superheroes")
                        .param("name", "superman"))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    void createSuperhero() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/superheroes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(SuperheroDTO.builder().build())))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    void updateSuperhero() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(put("/api/superheroes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(SuperheroDTO.builder().build())))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void deleteSuperhero() throws Exception {
        mockMvc.perform(delete("/api/superheroes/{id}", 1))
                .andExpect(status().is2xxSuccessful());
    }

}
