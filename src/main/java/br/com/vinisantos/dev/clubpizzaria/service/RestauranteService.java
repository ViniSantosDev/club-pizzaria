package br.com.vinisantos.dev.clubpizzaria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.vinisantos.dev.clubpizzaria.domain.exception.ThisEntityNotFoundException;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Restaurante;
import br.com.vinisantos.dev.clubpizzaria.repository.CozinhaRepository;
import br.com.vinisantos.dev.clubpizzaria.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

		if (cozinha == null) {
			throw new ThisEntityNotFoundException(
					String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
		}

		restaurante.setCozinha(cozinha);

		return restauranteRepository.salvar(restaurante);
	}

	public Restaurante buscar(Long id) {
		Restaurante obj;	
		try {
		 obj = restauranteRepository.buscar(id);
		} catch (ThisEntityNotFoundException e) {
			e.printStackTrace();
			throw new ThisEntityNotFoundException("Restaurante não existe");
		}
		return obj;
	}

}
