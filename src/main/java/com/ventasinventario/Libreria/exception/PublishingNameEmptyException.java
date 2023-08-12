package com.ventasinventario.Libreria.exception;

public class PublishingNameEmptyException extends RuntimeException{
        public PublishingNameEmptyException(){
            super("Ingresa el nombre de la editorial");
        }
}
