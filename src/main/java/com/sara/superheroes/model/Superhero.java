package com.sara.superheroes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "superheroe")
public class Superhero {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String power;
    private String gender;
    private int age;
    @Column(name = "birth_place")
    private String birthPlace;
    @Column(name = "operation_base")
    private String operationBase;



}
