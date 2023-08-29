package com.mateus.desafiogiuseppe.repositories;

import com.mateus.desafiogiuseppe.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByIdPessoa(Long idPessoa);
}
