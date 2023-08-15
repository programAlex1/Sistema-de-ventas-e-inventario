package com.ventasinventario.Libreria.domain.repository;

import com.ventasinventario.Libreria.domain.dto.BookDto;
import com.ventasinventario.Libreria.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {

    List<CustomerDto> findAll();

    Optional<CustomerDto> findById(Long idCustomer);

    CustomerDto save(CustomerDto customerDto);

    void delete(Long idCustomer);

    Optional<CustomerDto> findByFullName(String name);
}
