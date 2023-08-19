package com.ventasinventario.Libreria.controller;


import com.ventasinventario.Libreria.domain.dto.BallotDto;
import com.ventasinventario.Libreria.domain.dto.ResponseBallotDto;
import com.ventasinventario.Libreria.domain.useCase.IBallotUseCase;
import com.ventasinventario.Libreria.persistance.entity.BallotEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ballots")
public class BallotController {
    private final IBallotUseCase iBallotUseCase;


    @GetMapping()
    public ResponseEntity<List<BallotDto>> findAll(){
        return ResponseEntity.ok(iBallotUseCase.findAll());
    }

    @PostMapping()
    public ResponseEntity<ResponseBallotDto> save(@RequestBody BallotEntity ballot){
        return ResponseEntity.ok(iBallotUseCase.save(ballot));
    }


}
