package com.tiagopereira.workshopmongo.controller.exception;

import com.tiagopereira.workshopmongo.service.exception.ObjectNotFoundExcepion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExcepion.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExcepion e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        //isso pega o instante atual do sistema "System.currentTimeMillis()"
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado",e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
