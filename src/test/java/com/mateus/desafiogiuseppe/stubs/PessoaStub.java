package com.mateus.desafiogiuseppe.stubs;


import com.mateus.desafiogiuseppe.dto.PessoaDto;
import com.mateus.desafiogiuseppe.models.Pessoa;

import java.time.LocalDate;

public interface PessoaStub {

    static Pessoa criandoPessoa(){
        return Pessoa.builder().id(1L).nome("João").dataCadastro(LocalDate.of(2023,9,20)).build();
    }

    static PessoaDto criandoPessoaDto() {
        return PessoaDto.builder().id(1L).nome("Maria").dataCadastro(LocalDate.of(2022, 2, 20)).build();
    }

}
