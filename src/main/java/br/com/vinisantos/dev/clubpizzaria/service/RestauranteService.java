package br.com.vinisantos.dev.clubpizzaria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.vinisantos.dev.clubpizzaria.domain.exception.ExceptionObjectUsed;
import br.com.vinisantos.dev.clubpizzaria.domain.exception.ThisEntityNotFoundException;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Restaurante;
import br.com.vinisantos.dev.clubpizzaria.repository.CozinhaRepository;
import br.com.vinisantos.dev.clubpizzaria.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository repository;

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

		return repository.salvar(restaurante);
	}

	public Restaurante buscar(Long id) {
		Restaurante obj;	
		try {
		 obj = repository.buscar(id);
		} catch (ThisEntityNotFoundException e) {
			e.printStackTrace();
			throw new ThisEntityNotFoundException("Restaurante não existe");
		}
		return obj;
	}

	public void excluir(Long id) {
		
		try {
			repository.remover(id);
			
		} catch (ThisEntityNotFoundException e) {
			throw new ThisEntityNotFoundException(String.format("Não existe cozinha cadastrada com código %d", id));
			
		} catch (DataIntegrityViolationException e) {
			throw new ExceptionObjectUsed(String.format("Cozinha de código %d não pode ser removida", id));
		}
	}

}
