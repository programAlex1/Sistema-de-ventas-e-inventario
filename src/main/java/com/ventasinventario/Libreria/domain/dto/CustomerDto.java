package com.ventasinventario.Libreria.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class CustomerDto {

        private Long cardId;

        private String fullName;

        private String cellphone;

        private String address;

        private Date dateOfBirth;
}
