package com.ventasinventario.Libreria.domain.repository;

import com.ventasinventario.Libreria.domain.dto.BallotDto;

import java.util.List;

public interface IBallotRepository {

    List<BallotDto> findAll();

    BallotDto save(BallotDto ballotDto);
}
