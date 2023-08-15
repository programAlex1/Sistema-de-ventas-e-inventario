package com.ventasinventario.Libreria.persistance.repository;

import com.ventasinventario.Libreria.domain.dto.CustomerDto;
import com.ventasinventario.Libreria.domain.repository.ICustomerRepository;
import com.ventasinventario.Libreria.persistance.crud.ICustomerCrudRepository;
import com.ventasinventario.Libreria.persistance.entity.CustomerEntity;
import com.ventasinventario.Libreria.persistance.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {
    private final ICustomerCrudRepository iCustomerRepository;

    private final ICustomerMapper iCustomerMapper;
    @Override
    public List<CustomerDto> findAll() {
        return iCustomerMapper.toCustomersDto(iCustomerRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> findById(Long idCustomer) {
        return iCustomerRepository.findById(idCustomer)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        CustomerEntity customerEntity=iCustomerRepository.save(iCustomerMapper.toCustomerEntity(customerDto));
        return iCustomerMapper.toCustomerDto(customerEntity);
    }

    @Override
    public void delete(Long idCustomer) {
        iCustomerRepository.deleteById(idCustomer);

    }

    @Override
    public Optional<CustomerDto> findByFullName(String name) {
        return iCustomerRepository.findByFullName(name)
                .map(iCustomerMapper::toCustomerDto);
    }
}
