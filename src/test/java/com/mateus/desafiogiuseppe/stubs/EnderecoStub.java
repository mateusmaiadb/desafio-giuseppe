package com.mateus.desafiogiuseppe.stubs;

import com.mateus.desafiogiuseppe.dto.EnderecoDto;
import com.mateus.desafiogiuseppe.models.Endereco;

public interface EnderecoStub {

    static Endereco criandoEndereco() {
        return Endereco.builder()
                .id(1L)
                .idPessoa(1L)
                .pais("Brasil")
                .estado("SP")
                .bairro("Centro")
                .endereco("Rua A")
                .numero("123")
                .complemento("Apto 1")
                .cep("12345-678")
                .build();
    }

    static EnderecoDto criandoEnderecoDto() {
        return EnderecoDto.builder()
                .id(1L)
                .endereco("Rua A")
                .numero("123")
                .cep("12345-678")
                .pais("Brasil")
                .bairro("Bom Jesus")
                .complemento("Casa")
                .estado("RS")
                .idPessoa(1L)
                .build();
    }
}
