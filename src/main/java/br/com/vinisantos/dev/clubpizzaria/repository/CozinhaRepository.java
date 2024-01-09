package br.com.vinisantos.dev.clubpizzaria.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;

@Component
public interface CozinhaRepository {

	List<Cozinha> listar(); 
	List<Cozinha> consultarPorNome(String nome);
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha); 
	void remover(Long id);
}
