package br.com.vinisantos.dev.clubpizzaria.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
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

	@Autowired
	private ModelMapper modelMapper;

	public Cozinha create(Cozinha cozinha) {
		return repository.save(cozinha);
	}

	public void excluir(Long id) {
		try {
			repository.deleteById(id);

		} catch (ThisEntityNotFoundException e) {
			throw new ThisEntityNotFoundException(String.format("Não existe cozinha cadastrada com código %d", id));

		} catch (DataIntegrityViolationException e) {
			throw new ExceptionObjectUsed(String.format("Cozinha de código %d não pode ser removida", id));
		}
	}

	public Cozinha findById(Long id) {
		try {
			Optional<Cozinha> cozinha = repository.findById(id);
			if (cozinha.isPresent()) {
				return modelMapper.map(cozinha.get(), Cozinha.class);
			} else {
				throw new ThisEntityNotFoundException(String.format("Não existe cozinha cadastrada com código %d", id));
			}
		} catch (ThisEntityNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
