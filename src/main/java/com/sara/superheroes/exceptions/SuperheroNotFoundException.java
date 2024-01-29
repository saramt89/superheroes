package com.sara.superheroes.exceptions;

public class SuperheroNotFoundException extends RuntimeException{
    public SuperheroNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
