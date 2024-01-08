package br.com.vinisantos.dev.clubpizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Estado;
import br.com.vinisantos.dev.clubpizzaria.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	
	public Estado create(Estado body) {
		return repository.save(body);
	}

}
