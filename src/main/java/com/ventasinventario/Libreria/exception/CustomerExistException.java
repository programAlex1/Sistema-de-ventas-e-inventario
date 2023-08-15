package com.ventasinventario.Libreria.exception;

public class CustomerExistException extends RuntimeException{
    public CustomerExistException(){
        super("Ya existe un cliente con ese documento");
    }
}
