package com.mateus.desafiogiuseppe.controllers;

import com.mateus.desafiogiuseppe.dto.EnderecoDto;
import com.mateus.desafiogiuseppe.services.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> getAllEnderecos(){
        List<EnderecoDto> enderecoDtos = enderecoService.getAllEnderecos();
        return ResponseEntity.ok().body(enderecoDtos);
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<EnderecoDto>> listarEnderecosPessoa(@PathVariable Long idPessoa){
        List<EnderecoDto> enderecos = enderecoService.listarEnderecosPessoa(idPessoa);
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> findEnderecosById(@PathVariable("id") Long id){
        EnderecoDto enderecoDto = enderecoService.findEnderecoById(id);
        return ResponseEntity.ok(enderecoDto);
    }

    @PostMapping
    public ResponseEntity<EnderecoDto> criarEndereco(@RequestBody EnderecoDto enderecoDto){
        EnderecoDto enderecoCriado = enderecoService.criarEndereco(enderecoDto);
        return new ResponseEntity<>(enderecoCriado, HttpStatus.CREATED);
    }
}
