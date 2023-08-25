package com.ventasinventario.Libreria.controller;


import com.ventasinventario.Libreria.domain.dto.SaleDtoResponse;
import com.ventasinventario.Libreria.domain.dto.CustomerDto;
import com.ventasinventario.Libreria.domain.useCase.ISaleUseCase;
import com.ventasinventario.Libreria.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerUseCase iCustomerUseCase;
    private final ISaleUseCase iSaleUseCase;


    @GetMapping()
    public ResponseEntity<List<CustomerDto>> findAll(){
        return ResponseEntity.ok(iCustomerUseCase.findAll());
    }

    @GetMapping("/{idCustomer}")
    public ResponseEntity<CustomerDto> findById(@PathVariable Long idCustomer){
        return ResponseEntity.of(iCustomerUseCase.findById(idCustomer));
    }

    @GetMapping("/{cardId}/sales")
    public ResponseEntity<List<SaleDtoResponse>> findSalesByCardId(@PathVariable Long cardId){
        return ResponseEntity.ok(iSaleUseCase.findByCardIdCustomer(cardId));
    }


    @GetMapping("/name")
    public ResponseEntity<CustomerDto> findByFullName(@RequestParam(value = "name") String name){
        return ResponseEntity.of(iCustomerUseCase.findByFullName(name));
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCustomerUseCase.save(customerDto));
    }

    @PutMapping()
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto){
        return ResponseEntity.of(iCustomerUseCase.update(customerDto));
    }



    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idCustomer){
        return new ResponseEntity<>(iCustomerUseCase.delete(idCustomer)?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

}
