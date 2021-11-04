package com.yurialves.keycloakapiconsumer.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientesExternalDTO {

    private int id;
    private String nome;
    private BigDecimal salario;
    private String email;

}
