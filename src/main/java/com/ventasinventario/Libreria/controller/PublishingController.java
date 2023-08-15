package com.ventasinventario.Libreria.controller;


import com.ventasinventario.Libreria.domain.dto.PublishingDto;
import com.ventasinventario.Libreria.domain.useCase.IPublishingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/publishings")
public class PublishingController {

    private final IPublishingUseCase iPublishingUseCase;

    @GetMapping()
    public ResponseEntity<List<PublishingDto>> findAll(){
        return ResponseEntity.ok(iPublishingUseCase.findAll());
    }

    @GetMapping("/{idPublishing}")
    public ResponseEntity<PublishingDto> findById(@PathVariable Long idPublishing){
        return ResponseEntity.of(iPublishingUseCase.findById(idPublishing));
    }

    @PostMapping()
    public ResponseEntity<PublishingDto> save(@RequestBody PublishingDto publishingDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iPublishingUseCase.save(publishingDto));

    }

    @PutMapping()
    public ResponseEntity<PublishingDto> update(@RequestBody PublishingDto publishingDto){
        return ResponseEntity.of(iPublishingUseCase.update(publishingDto));
    }

    @DeleteMapping("/{idPublishing}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idPublishing){
            return new ResponseEntity<>(iPublishingUseCase.delete(idPublishing)?HttpStatus.OK : HttpStatus.NOT_FOUND);
   }
}
