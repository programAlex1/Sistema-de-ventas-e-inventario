package com.ventasinventario.Libreria.persistance.mapper;

import com.ventasinventario.Libreria.domain.dto.BallotDto;
import com.ventasinventario.Libreria.domain.dto.BookBallotRequestDto;
import com.ventasinventario.Libreria.persistance.entity.BallotEntity;
import com.ventasinventario.Libreria.persistance.entity.BookBallotEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBallotMapper {


//    @Mapping(source = "idEmployee",target = "idEmployee")
//    @Mapping(source = "idCustomer",target = "idCustomer")
//    List<BallotDto> toBallotDtoList(List<BallotEntity> ballotEntityList);

    @Mapping(source = "book",target = "idBook")
    @Mapping(source = "ballot",target = "idBallot")
    List<BookBallotRequestDto> toBookBallotDtoList(List<BookBallotEntity> bookBallotEntityList);
}
