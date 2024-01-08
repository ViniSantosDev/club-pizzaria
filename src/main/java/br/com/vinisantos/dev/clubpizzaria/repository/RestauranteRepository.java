package br.com.vinisantos.dev.clubpizzaria.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Restaurante;

@Component
public interface RestauranteRepository {

	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Long restaurante);
}
