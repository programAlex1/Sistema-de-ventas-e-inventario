package com.ventasinventario.Libreria.controller;


import com.ventasinventario.Libreria.domain.dto.BookDto;
import com.ventasinventario.Libreria.domain.useCase.IBookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final IBookUseCase iBookUseCase;

    @GetMapping()
    public ResponseEntity<List<BookDto>> findAll(){
        return ResponseEntity.ok(iBookUseCase.findAll());
    }

    @GetMapping("/{idBook}")
    public ResponseEntity<BookDto> findById(@PathVariable Long idBook){
        return ResponseEntity.of(iBookUseCase.findById(idBook));
    }

    @GetMapping("/by-price")
    public ResponseEntity<List<BookDto>> findByPrecioBetween(@RequestParam double precioMin,double precioMax){
        return ResponseEntity.ok(iBookUseCase.findByPrecioBetween(precioMin,precioMax));
    }

    @GetMapping("/typebook/{idTypeBook}")
    public ResponseEntity<List<BookDto>> findByTypeBook(@PathVariable Long idTypeBook){
        return ResponseEntity.ok(iBookUseCase.findByIdTypeBook(idTypeBook));
    }

    @PostMapping()
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto) {

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBookUseCase.save(bookDto));


    }

    @PutMapping
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto){
        return ResponseEntity.of(iBookUseCase.update(bookDto));
    }

    @DeleteMapping("/{idBook}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idBook){
        return new ResponseEntity<>(iBookUseCase.delete(idBook)?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
}
