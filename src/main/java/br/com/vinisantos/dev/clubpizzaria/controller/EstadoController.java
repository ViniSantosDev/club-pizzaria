package br.com.vinisantos.dev.clubpizzaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Estado;
import br.com.vinisantos.dev.clubpizzaria.repository.EstadoRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	private EstadoRepository repository;
	
	@GetMapping
	public List<Estado> listar() {
		return repository.findAll();
	}

}
