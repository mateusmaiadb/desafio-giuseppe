package com.mateus.desafiogiuseppe.repositories;

import com.mateus.desafiogiuseppe.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
