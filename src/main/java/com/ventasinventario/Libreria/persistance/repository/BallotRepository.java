package com.ventasinventario.Libreria.persistance.repository;

import com.ventasinventario.Libreria.domain.dto.BallotDto;
import com.ventasinventario.Libreria.domain.repository.IBallotRepository;
import com.ventasinventario.Libreria.persistance.crud.IBallotCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class BallotRepository implements IBallotRepository {
    private final IBallotCrudRepository iBallotCrudRepository;
    @Override
    public List<BallotDto> findAll() {
        List<BallotDto> ballotDtos=new ArrayList<>();
        return ballotDtos;
    }

    @Override
    public BallotDto save(BallotDto ballotDto) {
        return null;
    }
}
