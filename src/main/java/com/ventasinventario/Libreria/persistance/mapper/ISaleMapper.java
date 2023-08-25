package com.ventasinventario.Libreria.persistance.mapper;

import com.ventasinventario.Libreria.domain.dto.BookSaleRequestDto;
import com.ventasinventario.Libreria.domain.dto.BookSaleResponseDto;
import com.ventasinventario.Libreria.domain.dto.SaleDtoRequest;
import com.ventasinventario.Libreria.domain.dto.SaleDtoResponse;
import com.ventasinventario.Libreria.persistance.entity.BookSaleEntity;
import com.ventasinventario.Libreria.persistance.entity.SaleEntity;
import com.ventasinventario.Libreria.persistance.entity.CustomerEntity;
import com.ventasinventario.Libreria.persistance.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISaleMapper {

    @Mapping(source = "book.id", target = "idBook")
    @Mapping(source = "book.title", target = "nameBook")
    @Mapping(source = "ballot.id", target = "idBallot")
    BookSaleResponseDto toBookSaleResponseDto(BookSaleEntity bookSaleEntity);
    @Mapping(source = "idBook",target = "book.id")
    @Mapping(source = "idBallot",target = "ballot.id")
    BookSaleEntity toBookSaleEntity(BookSaleRequestDto bookSaleRequestDto);

    List<BookSaleEntity> toBookSaleEntityList(List<BookSaleRequestDto> bookSaleRequestDtos);

    List<BookSaleResponseDto> toBookSaleResponseDtoList(List<BookSaleEntity> bookSaleEntityList);

    @Mapping(source = "idEmployee",target = "idEmployee")
    @Mapping(source = "idCustomer",target = "idCustomer")
    @Mapping(source = "bookList",target = "bookList")
    SaleDtoResponse toSaleDtoResponse(SaleEntity saleEntity);

    List<SaleDtoResponse> toSaleDtoResponseList(List<SaleEntity> saleEntityList);

    @Mapping(source = "idEmployee",target = "idEmployee.id")
    @Mapping(source = "idCustomer",target = "idCustomer.cardId")
    @Mapping(source = "bookList",target = "bookList")
    SaleEntity toSaleEntity(SaleDtoRequest saleDtoRequest);

    default Long map(EmployeeEntity employeeEntity) {
        return employeeEntity.getId();
    }
    default Long map(CustomerEntity customerEntity) {
        return customerEntity.getCardId();
    }

}
