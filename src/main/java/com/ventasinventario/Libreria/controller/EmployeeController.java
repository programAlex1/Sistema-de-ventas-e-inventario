package com.ventasinventario.Libreria.controller;


import com.ventasinventario.Libreria.domain.dto.EmployeeDto;
import com.ventasinventario.Libreria.domain.useCase.IEmployeeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final IEmployeeUseCase iEmployeeUseCase;
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> findAll(){
        return ResponseEntity.ok(iEmployeeUseCase.findAll());
    }

    @GetMapping("/{idEmployee}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long idEmployee){
        return ResponseEntity.of(iEmployeeUseCase.findById(idEmployee));
    }

    @GetMapping("/buscar-por")
    public ResponseEntity<EmployeeDto> findByEmail(@RequestParam(value = "email") String email){
        return ResponseEntity.of(iEmployeeUseCase.findByEmail(email));
    }

    @PostMapping()
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iEmployeeUseCase.save(employeeDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PutMapping()
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.of(iEmployeeUseCase.update(employeeDto));
    }

    @DeleteMapping("/{idEmployee}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idEmployee){
        return new ResponseEntity<>(iEmployeeUseCase.delete(idEmployee)?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

}
