package com.service.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductExistsException extends Exception{

    private static long serialVersionUID = 2l;

    public ProductExistsException(String message){
        super(message);
    }
}
