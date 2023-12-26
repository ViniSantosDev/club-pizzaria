package br.com.vinisantos.dev.clubpizzaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Restaurante;
import br.com.vinisantos.dev.clubpizzaria.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteRepository repository;

	@GetMapping
	public List<Restaurante> listar() {
		return repository.findAll();
	}
}
