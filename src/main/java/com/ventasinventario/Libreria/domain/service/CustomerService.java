package com.ventasinventario.Libreria.domain.service;

import com.ventasinventario.Libreria.domain.dto.CustomerDto;
import com.ventasinventario.Libreria.domain.repository.ICustomerRepository;
import com.ventasinventario.Libreria.domain.useCase.ICustomerUseCase;
import com.ventasinventario.Libreria.exception.CustomerExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;


    @Override
    public List<CustomerDto> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<CustomerDto> findById(Long idCustomer) {
        return iCustomerRepository.findById(idCustomer);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        if(iCustomerRepository.findById(customerDto.getCardId()).isEmpty()){
            return iCustomerRepository.save(customerDto);
        }
        throw new CustomerExistException();
    }

    @Override
    public boolean delete(Long idCustomer) {
        if(iCustomerRepository.findById(idCustomer).isEmpty()){
            return false;
        }
        iCustomerRepository.delete(idCustomer);
        return true;
    }

    @Override
    public Optional<CustomerDto> findByFullName(String name) {
        return iCustomerRepository.findByFullName(name);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto customerDto) {
        if(iCustomerRepository.findById(customerDto.getCardId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(customerDto));
    }

}
