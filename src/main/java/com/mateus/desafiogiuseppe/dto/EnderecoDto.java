package com.mateus.desafiogiuseppe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
