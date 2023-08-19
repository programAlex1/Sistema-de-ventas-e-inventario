package com.ventasinventario.Libreria.domain.service;

import com.ventasinventario.Libreria.domain.dto.BallotDto;
import com.ventasinventario.Libreria.domain.dto.BookBallotDto;
import com.ventasinventario.Libreria.domain.dto.BookDto;
import com.ventasinventario.Libreria.domain.dto.ResponseBallotDto;
import com.ventasinventario.Libreria.domain.repository.IBookRepository;
import com.ventasinventario.Libreria.domain.useCase.IBallotUseCase;
import com.ventasinventario.Libreria.persistance.crud.IBallotCrudRepository;
import com.ventasinventario.Libreria.persistance.crud.IBookBallotCrudRepository;
import com.ventasinventario.Libreria.persistance.entity.BallotEntity;
import com.ventasinventario.Libreria.persistance.entity.BookBallotEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BalloService implements IBallotUseCase {

    private final IBookBallotCrudRepository IBookBallotCrudRepository;
    private final IBallotCrudRepository IBallotCrudRepository;
    private final IBookRepository iBookRepository;
    @Override
    public List<BallotDto> findAll() {
        List<BallotEntity> ballot = IBallotCrudRepository.findAll();
        List<BallotDto> ballotDto= new ArrayList<>();
        for (BallotEntity ballot1: ballot){
            BallotDto ballotDto1= new BallotDto();
            ballotDto1.setId(ballot1.getId());
            ballotDto1.setIdEmployee(ballot1.getIdEmployee().getId());
            ballotDto1.setIdCustomer(ballot1.getIdCustomer().getCardId());
            ballotDto1.setMethod(ballot1.getMethod());
            ballotDto1.setTotal(ballot1.getTotal());
            ballotDto1.setDate(ballot1.getDate());
            List<BookBallotDto> bookBallotDtos = getBookAllotDtos(ballot1);
            ballotDto1.setBookList(bookBallotDtos);
            ballotDto.add(ballotDto1);
        }

        return ballotDto;
    }



    @Override
    public ResponseBallotDto save(BallotEntity ballot) {
        ballot.setDate(new Date());

        ballot.setTotal(ballot.getBookList().stream().mapToDouble(detalle ->{
            Optional<BookDto> book= iBookRepository.findById(detalle.getBook().getId());
            detalle.setPrice(book.get().getPrice());
            detalle.setTotal(book.get().getPrice()*detalle.getQuantity());
            return detalle.getTotal();
        }).sum());
        BallotEntity ballot1= IBallotCrudRepository.save(ballot);

        for (BookBallotEntity item:ballot.getBookList()){
            item.setBallot(ballot1);
        }

        IBookBallotCrudRepository.saveAll(ballot.getBookList());

        ResponseBallotDto ballotDto = new ResponseBallotDto();
        ballotDto.setId(ballot.getId());
        ballotDto.setDate(ballot.getDate());
        ballotDto.setTotal(ballot.getTotal());
        ballotDto.setIdEmployee(ballot.getIdEmployee().getId());
        ballotDto.setIdCustomer(ballot.getIdCustomer().getCardId());
        ballotDto.setMethod(ballot.getMethod());
        List<BookBallotDto> bookBallotDtos = getBookAllotDtos(ballot);
        ballotDto.setBookList(bookBallotDtos);
        return ballotDto;
    }

    private List<BookBallotDto> getBookAllotDtos(BallotEntity ballot1) {
        List<BookBallotDto> bookBallotDtos= new ArrayList<>();
        for(BookBallotEntity bookBallotEntity: ballot1.getBookList()){
            Optional<BookDto> nameBook=iBookRepository.findById(bookBallotEntity.getBook().getId());
            BookBallotDto bookBallotDto= new BookBallotDto();
            bookBallotDto.setId(bookBallotEntity.getId());
            bookBallotDto.setIdBook(bookBallotEntity.getBook().getId());
            bookBallotDto.setIdBallot(bookBallotEntity.getBallot().getId());
            bookBallotDto.setQuantity(bookBallotEntity.getQuantity());
            bookBallotDto.setPrice(bookBallotEntity.getPrice());
            bookBallotDto.setTotal(bookBallotEntity.getTotal());
            bookBallotDto.setNameBook(nameBook.get().getTitle());
            bookBallotDtos.add(bookBallotDto);
        }
        return bookBallotDtos;
    }
}
