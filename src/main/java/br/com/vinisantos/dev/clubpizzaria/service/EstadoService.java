package br.com.vinisantos.dev.clubpizzaria.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.vinisantos.dev.clubpizzaria.domain.exception.ExceptionObjectUsed;
import br.com.vinisantos.dev.clubpizzaria.domain.exception.ThisEntityNotFoundException;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Estado;
import br.com.vinisantos.dev.clubpizzaria.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	@Autowired
	ModelMapper mapper;

	public Estado create(Estado body) {
		return repository.save(body);
	}

	public void excluir(Long id) {
		try {
			repository.deleteById(id);

		} catch (ThisEntityNotFoundException e) {
			throw new ThisEntityNotFoundException(String.format("Não existe Estado cadastrado com código %d", id));

		} catch (DataIntegrityViolationException e) {
			throw new ExceptionObjectUsed(String.format("Estado de código %d não pode ser removido", id));
		}

	}

	public Estado buscarId(Long id) {
		try {
			Optional<Estado> estado = repository.findById(id);
			if (estado.isPresent()) {
				return estado.get();
			} else {
				throw new ThisEntityNotFoundException(null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
