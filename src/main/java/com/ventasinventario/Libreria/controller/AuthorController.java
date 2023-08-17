package com.ventasinventario.Libreria.controller;

import com.ventasinventario.Libreria.domain.dto.AuthorDto;
import com.ventasinventario.Libreria.domain.useCase.IAuthorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final IAuthorUseCase iAuthorUseCase;

    @GetMapping()
    public ResponseEntity<List<AuthorDto>> findAll(){
        return ResponseEntity.ok(iAuthorUseCase.findAll());
    }

    @GetMapping("/{idAuthor}")
    public ResponseEntity<AuthorDto> findById(@PathVariable Long idAuthor){
        return ResponseEntity.of(iAuthorUseCase.findById(idAuthor));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AuthorDto> findByName(@PathVariable String name){
        return ResponseEntity.of(iAuthorUseCase.findByName(name));
    }

    @PostMapping()
    public ResponseEntity<AuthorDto> save(@RequestBody AuthorDto authorDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iAuthorUseCase.save(authorDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PutMapping()
    public ResponseEntity<AuthorDto> update(@RequestBody AuthorDto authorDto){
        return ResponseEntity.of(iAuthorUseCase.update(authorDto));
    }

    @DeleteMapping("/{idAuthor}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idAuthor){
        return new ResponseEntity<>(iAuthorUseCase.delete(idAuthor)?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
}
