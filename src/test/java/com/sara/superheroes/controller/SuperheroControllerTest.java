package com.sara.superheroes.controller;

import com.sara.superheroes.service.SuperheroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

}
