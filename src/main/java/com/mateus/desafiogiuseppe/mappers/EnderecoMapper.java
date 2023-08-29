package com.mateus.desafiogiuseppe.mappers;

import com.mateus.desafiogiuseppe.dto.EnderecoDto;
import com.mateus.desafiogiuseppe.dto.PessoaDto;
import com.mateus.desafiogiuseppe.models.Endereco;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public interface EnderecoMapper {

    static EnderecoDto toDto(Endereco endereco) {

        EnderecoDto enderecoDto = new EnderecoDto();
        BeanUtils.copyProperties(endereco,enderecoDto);
        return enderecoDto;
    }

    static Endereco toEntity(EnderecoDto dto) {
        Endereco endereco = new Endereco();
        endereco.setId(dto.getId());
        endereco.setIdPessoa(dto.getIdPessoa());
        endereco.setPais(dto.getPais());
        endereco.setEstado(dto.getEstado());
        endereco.setBairro(dto.getBairro());
        endereco.setEndereco(dto.getEndereco());
        endereco.setNumero(dto.getNumero());
        endereco.setComplemento(dto.getComplemento());
        endereco.setCep(dto.getCep());
        return endereco;
    }
}
