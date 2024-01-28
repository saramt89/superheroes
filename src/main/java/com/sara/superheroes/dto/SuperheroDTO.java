package com.sara.superheroes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuperheroDTO implements Serializable {

    private String name;
    private String power;
    private String gender;
    private int age;
    private String birthPlace;
    private String operationBase;

}
