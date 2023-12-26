package br.com.vinisantos.dev.clubpizzaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinisantos.dev.clubpizzaria.domain.dto.CozinhaDTO;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import br.com.vinisantos.dev.clubpizzaria.repository.impl.CozinhaRepositoryImpl;

@RestController
@RequestMapping(value = "/cozinhas",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class CozinhaController {
	
	@Autowired
	private CozinhaRepositoryImpl repository;
	
	@GetMapping()
	public List<Cozinha> listar() {
		return repository.listar();
	}
	
	@GetMapping("/{id}")
	public Cozinha byId(@PathVariable Long id){
		return repository.buscar(id);
	}
	
	
	@PostMapping
	public Cozinha create(@RequestBody CozinhaDTO dto) {
		Cozinha cozinha = new Cozinha();
		return cozinha;
	}

}
