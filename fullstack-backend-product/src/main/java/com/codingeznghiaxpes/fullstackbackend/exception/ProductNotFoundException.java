package com.codingeznghiaxpes.fullstackbackend.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long id){
        super("Could not found the Product with id: " + id);
    }
}
