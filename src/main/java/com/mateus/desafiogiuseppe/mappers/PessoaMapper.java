package com.mateus.desafiogiuseppe.mappers;

import com.mateus.desafiogiuseppe.dto.EnderecoDto;
import com.mateus.desafiogiuseppe.dto.PessoaDetalhesDto;
import com.mateus.desafiogiuseppe.dto.PessoaDto;
import com.mateus.desafiogiuseppe.models.Pessoa;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PessoaMapper {

    static PessoaDto toDto(Pessoa pessoa) {
        PessoaDto pessoaDto = new PessoaDto();
        BeanUtils.copyProperties(pessoa,pessoaDto);
        return pessoaDto;
    }

    static PessoaDetalhesDto toDetalhesDto(Pessoa pessoa, List<EnderecoDto> enderecos) {
        PessoaDetalhesDto dto = new PessoaDetalhesDto();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setDataCadastro(pessoa.getDataCadastro());
        dto.setEnderecos(enderecos);
        return dto;
    }


    static Pessoa toEntity(PessoaDto pessoaDTO) {
        return Pessoa.builder()
                .id(pessoaDTO.getId())
                .nome(pessoaDTO.getNome())
                .dataCadastro(pessoaDTO.getDataCadastro()).build();
    }
}
