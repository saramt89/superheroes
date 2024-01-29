package com.sara.superheroes.exceptions;

public class SuperheroExistsException extends RuntimeException{
    public SuperheroExistsException(String errorMessage) {
        super(errorMessage);
    }

}
