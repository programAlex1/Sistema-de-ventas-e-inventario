package com.ventasinventario.Libreria.controller;


import com.ventasinventario.Libreria.domain.dto.TypeBookDto;
import com.ventasinventario.Libreria.domain.useCase.ITypeBookUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/typebooks")
public class TypeBookController {

    private final ITypeBookUseCase iTypeBookUseCase;

    @GetMapping()
    public ResponseEntity<List<TypeBookDto>> findAll(){
        return ResponseEntity.ok(iTypeBookUseCase.findAll());
    }

    @GetMapping("/{idBook}")
    public ResponseEntity<TypeBookDto> findById(@PathVariable Long idBook){
        return ResponseEntity.of(iTypeBookUseCase.findById(idBook));
    }

    @PostMapping()
    public ResponseEntity<TypeBookDto> save(@RequestBody TypeBookDto typeBookDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iTypeBookUseCase.save(typeBookDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }


    @PutMapping()
    public ResponseEntity<TypeBookDto> update(@RequestBody TypeBookDto typeBookDto){
            return ResponseEntity.of(iTypeBookUseCase.update(typeBookDto));
    }

    @DeleteMapping("/{idBook}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idBook){
        return new ResponseEntity<>(iTypeBookUseCase.delete(idBook)? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
