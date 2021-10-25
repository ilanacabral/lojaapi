package br.com.diolabs.lojaapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Representão erro retornado como registro não é localizado
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
  
    public NotFoundException(String message) {
       super(message);
    }    
}
