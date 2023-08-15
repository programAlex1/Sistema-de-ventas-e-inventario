package com.ventasinventario.Libreria.domain.useCase;

import com.ventasinventario.Libreria.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerUseCase {

    List<CustomerDto> findAll();

    Optional<CustomerDto> findById(Long idCustomer);

    CustomerDto save(CustomerDto customerDto);

    boolean delete(Long idCustomer);

    Optional<CustomerDto> findByFullName(String name);

    Optional<CustomerDto> update(CustomerDto customerDto);

}
