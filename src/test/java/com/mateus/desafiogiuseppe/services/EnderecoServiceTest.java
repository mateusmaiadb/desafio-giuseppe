package com.mateus.desafiogiuseppe.services;

import com.mateus.desafiogiuseppe.dto.EnderecoDto;
import com.mateus.desafiogiuseppe.models.Endereco;
import com.mateus.desafiogiuseppe.repositories.EnderecoRepository;
import com.mateus.desafiogiuseppe.stubs.EnderecoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnderecoServiceTest {

    @InjectMocks
    private EnderecoService enderecoService;

    @Mock
    private EnderecoRepository enderecoRepository;

    @Test
    void criarEndereco(){
        EnderecoDto enderecoDto = EnderecoStub.criandoEnderecoDto();
        Endereco endereco = EnderecoStub.criandoEndereco();

        when(enderecoRepository.save(any())).thenReturn(endereco);

        var salvandoEndereco = enderecoService.criarEndereco(enderecoDto);

        verify(enderecoRepository, times(1)).save(any());
        assertNotNull(salvandoEndereco);

    }

    @Test
    void getAllEnderecos() {
        when(enderecoRepository.findAll()).thenReturn(List.of(EnderecoStub.criandoEndereco()));

        List<EnderecoDto> enderecos = enderecoService.getAllEnderecos();

        verify(enderecoRepository, times(1)).findAll();
        assertFalse(enderecos.isEmpty());
    }

    @Test
    void listarEnderecosPessoa() {
        Long idPessoa = 1L;
        when(enderecoRepository.findByIdPessoa(idPessoa)).thenReturn(List.of(EnderecoStub.criandoEndereco()));

        List<EnderecoDto> enderecos = enderecoService.listarEnderecosPessoa(idPessoa);

        verify(enderecoRepository, times(1)).findByIdPessoa(idPessoa);
        assertFalse(enderecos.isEmpty());
    }

    @Test
    void findEnderecoById() {
        Long id = 1L;
        Endereco endereco = EnderecoStub.criandoEndereco();

        when(enderecoRepository.findById(id)).thenReturn(Optional.of(endereco));

        EnderecoDto foundEndereco = enderecoService.findEnderecoById(id);

        verify(enderecoRepository, times(1)).findById(id);
        assertNotNull(foundEndereco);
    }

    @Test
    void findEnderecoById_EnderecoNaoEncontrado() {
        Long id = 2L;

        when(enderecoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> enderecoService.findEnderecoById(id));

        verify(enderecoRepository, times(1)).findById(id);
    }
}