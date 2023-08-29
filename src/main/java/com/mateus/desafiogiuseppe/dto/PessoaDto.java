package com.mateus.desafiogiuseppe.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaDto {

    Long id;
    String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataCadastro;
}
