package com.mateus.desafiogiuseppe.controllers;

import com.mateus.desafiogiuseppe.dto.PessoaDetalhesDto;
import com.mateus.desafiogiuseppe.dto.PessoaDto;
import com.mateus.desafiogiuseppe.services.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {


    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDto> savePessoa(@RequestBody PessoaDto pessoaDto) {
        var pessoaCriada = pessoaService.savePessoa(pessoaDto);
        return new ResponseEntity<>(pessoaCriada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> listarPessoas(){
        List<PessoaDto> pessoas = pessoaService.findAllPessoas();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> findPessoaById(@PathVariable("id") Long id){
        var pessoaDto = pessoaService.findPessoaById(id);
        return ResponseEntity.ok(pessoaDto);
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<PessoaDetalhesDto> detalhesPessoa(@PathVariable Long id){
        PessoaDetalhesDto pessoaDetalhesDto =pessoaService.detalhesPessoa(id);
        if (pessoaDetalhesDto != null){
            return ResponseEntity.ok(pessoaDetalhesDto);
        }else {
            throw new IllegalArgumentException("Este id: " + id + " não esta em nosso banco de dados!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable("id") Long id) {
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }

}
