package com.mateus.desafiogiuseppe.services;

import com.mateus.desafiogiuseppe.dto.EnderecoDto;
import com.mateus.desafiogiuseppe.dto.PessoaDetalhesDto;
import com.mateus.desafiogiuseppe.dto.PessoaDto;
import com.mateus.desafiogiuseppe.mappers.PessoaMapper;
import com.mateus.desafiogiuseppe.models.Pessoa;
import com.mateus.desafiogiuseppe.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {


    private PessoaRepository pessoaRepository;

    private EnderecoService enderecoService;



    public PessoaService(PessoaRepository pessoaRepository, EnderecoService enderecoService){
        this.pessoaRepository = pessoaRepository;
        this.enderecoService = enderecoService;
    }

    public List<PessoaDto> findAllPessoas(){
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream()
                      .map(PessoaMapper::toDto)
                      .collect(Collectors.toList());
    }
    public PessoaDto savePessoa(PessoaDto pessoaDTO) {
        Pessoa pessoa = PessoaMapper.toEntity(pessoaDTO);
        var pessoaSalva = pessoaRepository.save(pessoa);
        return PessoaMapper.toDto(pessoaSalva);
    }

    public PessoaDto findPessoaById(Long id){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isPresent()){
            return PessoaMapper.toDto(pessoaOptional.get());
        }
        throw new IllegalArgumentException("Este id: " + id + " não esta em nosso banco de dados!");
    }

    public PessoaDetalhesDto detalhesPessoa(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
        if (pessoa != null){
            List<EnderecoDto> enderecoDto = enderecoService.listarEnderecosPessoa(id);
            return PessoaMapper.toDetalhesDto(pessoa,enderecoDto);
        }
        throw new IllegalArgumentException("Esse id: " + id + " não esta em nosso banco de dados!");
    }
}
