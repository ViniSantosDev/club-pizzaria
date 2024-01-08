package br.com.vinisantos.dev.clubpizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.vinisantos.dev.clubpizzaria.domain.exception.ExceptionObjectUsed;
import br.com.vinisantos.dev.clubpizzaria.domain.exception.ThisEntityNotFoundException;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import br.com.vinisantos.dev.clubpizzaria.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository repository;

	public Cozinha create(Cozinha cozinha) {
		return repository.salvar(cozinha);
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
