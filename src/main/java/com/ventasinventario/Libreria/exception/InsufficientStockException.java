package com.ventasinventario.Libreria.exception;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(){
        super("El stock es insuficiente");
    }
}
