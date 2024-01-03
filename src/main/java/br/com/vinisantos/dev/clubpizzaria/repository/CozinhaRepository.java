package br.com.vinisantos.dev.clubpizzaria.repository;

import java.util.List;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;

public interface CozinhaRepository {

	//CRUD:
	
	//CREATE = CRIAR
	//READ = LER
	//UPDATE = ATUALIZAR
	//DELETE = DELETAR
	
	List<Cozinha> listar(); //READ TODOS
	Cozinha buscar(Long id); //READ por um filtro id
	Cozinha salvar(Cozinha cozinha); //CREATE
	void remover(Cozinha cozinha); //DELETE
}
