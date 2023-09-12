package com.mateus.desafiogiuseppe.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaDto {

    Long id;
    String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataCadastro;
}
