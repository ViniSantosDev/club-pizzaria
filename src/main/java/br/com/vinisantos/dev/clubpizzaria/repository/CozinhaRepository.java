package br.com.vinisantos.dev.clubpizzaria.repository;

import java.util.List;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> listar();
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Cozinha cozinha);
}
