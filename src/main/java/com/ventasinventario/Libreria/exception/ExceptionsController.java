package com.ventasinventario.Libreria.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsController {

    @ExceptionHandler({PublishingNameEmptyException.class, PublishindNotExistException.class,CustomerExistException.class})
    public ProblemDetail badRequestException(RuntimeException e){
            return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,e.getMessage());
    }
}
