package com.ventasinventario.Libreria.domain.useCase;

import com.ventasinventario.Libreria.domain.dto.BallotDto;
import com.ventasinventario.Libreria.domain.dto.ResponseBallotDto;
import com.ventasinventario.Libreria.persistance.entity.BallotEntity;

import java.util.List;

public interface IBallotUseCase {

    List<BallotDto> findAll();
    ResponseBallotDto save(BallotEntity ballot);
}
