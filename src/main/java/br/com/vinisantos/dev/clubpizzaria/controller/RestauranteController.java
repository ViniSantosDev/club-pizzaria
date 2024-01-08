package br.com.vinisantos.dev.clubpizzaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinisantos.dev.clubpizzaria.domain.dto.RestauranteDTO;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Restaurante;
import br.com.vinisantos.dev.clubpizzaria.repository.impl.RestauranteRepositoryImpl;
import br.com.vinisantos.dev.clubpizzaria.service.RestauranteService;
import br.com.vinisantos.dev.clubpizzaria.util.AuxClassConvertEntityForDTO;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepositoryImpl repository;
	
	@Autowired
	private RestauranteService service;
	
	@Autowired
	private AuxClassConvertEntityForDTO mapper;

	@GetMapping
	public List<Restaurante> listar() {
		return repository.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> byId(@PathVariable Long id) {
		Restaurante restaurante = repository.buscar(id);

		if (restaurante != null) {
			return ResponseEntity.ok(restaurante);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante adicionar(@RequestBody RestauranteDTO body) {
		Restaurante restaurante = mapper.convertEntityForDTO(body);
		return service.salvar(restaurante);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Restaurante> update(@PathVariable Long id, @RequestBody RestauranteDTO body) {
		
	Restaurante restaurantExist = service.buscar(id);
	if(restaurantExist != null) {
		Restaurante restauranteEdit = mapper.convertEntityForDTO(body);
		return ResponseEntity.ok(restauranteEdit);
	}
	return ResponseEntity.badRequest().build();

}
}