package com.mateus.desafiogiuseppe.dto;

import lombok.Data;

@Data
public class EnderecoDto {

    Long id;
    Long idPessoa;
    String pais;
    String estado;
    String bairro;
    String endereco;
    String numero;
    String complemento;
    String cep;
}
