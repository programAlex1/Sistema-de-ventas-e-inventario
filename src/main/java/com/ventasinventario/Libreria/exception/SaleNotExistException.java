package com.ventasinventario.Libreria.exception;

public class SaleNotExistException extends RuntimeException{
    public SaleNotExistException(){
        super("La venta no existe");
    }
}
