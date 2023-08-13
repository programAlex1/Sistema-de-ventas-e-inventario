package com.ventasinventario.Libreria.exception;

public class PublishindNotExistException extends RuntimeException{
    public PublishindNotExistException(){
        super("La editorial que introduzco no existe");
    }
}
