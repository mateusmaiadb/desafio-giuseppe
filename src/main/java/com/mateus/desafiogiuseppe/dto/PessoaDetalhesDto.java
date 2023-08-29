package com.mateus.desafiogiuseppe.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class PessoaDetalhesDto {

    Long id;
    String nome;
    LocalDate dataCadastro;
    List<EnderecoDto> enderecos;
}
