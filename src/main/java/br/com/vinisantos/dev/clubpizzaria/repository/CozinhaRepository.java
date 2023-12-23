package br.com.vinisantos.dev.clubpizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
	
}
