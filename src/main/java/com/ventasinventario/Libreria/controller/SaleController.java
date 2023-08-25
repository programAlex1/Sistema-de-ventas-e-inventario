package com.ventasinventario.Libreria.controller;


import com.ventasinventario.Libreria.domain.dto.SaleDtoRequest;
import com.ventasinventario.Libreria.domain.dto.SaleDtoResponse;
import com.ventasinventario.Libreria.domain.useCase.ISaleUseCase;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sales")
public class SaleController {

    private final ISaleUseCase iSaleUseCase;
    @GetMapping()
    public ResponseEntity<List<SaleDtoResponse>> findAll(){

        return ResponseEntity.ok(iSaleUseCase.findAll());
    }

    @PostMapping()
    public ResponseEntity<SaleDtoResponse> save(@RequestBody SaleDtoRequest saleDtoRequest){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iSaleUseCase.save(saleDtoRequest));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @GetMapping("/{idSale}")
    public ResponseEntity<SaleDtoResponse> findById(@PathVariable Long idSale){
        return ResponseEntity.of(iSaleUseCase.findById(idSale));
    }

    @GetMapping("/export-pdf/{id}")
    public ResponseEntity<byte[]> exportToPdfReceipt(@PathVariable Long id) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("BillBook","Receipt.pdf");
        return ResponseEntity.ok().headers(headers).body(iSaleUseCase.exportToPdf(id));

    }



}
