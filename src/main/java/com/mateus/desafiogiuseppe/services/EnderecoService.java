package com.mateus.desafiogiuseppe.services;

import com.mateus.desafiogiuseppe.dto.EnderecoDto;
import com.mateus.desafiogiuseppe.mappers.EnderecoMapper;
import com.mateus.desafiogiuseppe.models.Endereco;
import com.mateus.desafiogiuseppe.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoDto criarEndereco(EnderecoDto enderecoDto){
        Endereco endereco = EnderecoMapper.toEntity(enderecoDto);
        var enderecoSalvo = enderecoRepository.save(endereco);
        return EnderecoMapper.toDto(enderecoSalvo);
    }


    public List<EnderecoDto> getAllEnderecos(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream()
                        .map(EnderecoMapper::toDto)
                        .collect(Collectors.toList());
    }

    public List<EnderecoDto> listarEnderecosPessoa(Long idPessoa){
        List<Endereco> enderecos = enderecoRepository.findByIdPessoa(idPessoa);
        return enderecos.stream()
                        .map(EnderecoMapper::toDto)
                        .collect(Collectors.toList());
    }



    public EnderecoDto findEnderecoById(Long id){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()){
            return EnderecoMapper.toDto(enderecoOptional.get());
        }
        throw new IllegalArgumentException("Este id: " + id + " não esta em nosso banco de dados!");
    }


}
