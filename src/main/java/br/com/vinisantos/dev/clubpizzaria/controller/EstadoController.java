package br.com.vinisantos.dev.clubpizzaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinisantos.dev.clubpizzaria.domain.exception.ExceptionObjectUsed;
import br.com.vinisantos.dev.clubpizzaria.domain.exception.ThisEntityNotFoundException;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Estado;
import br.com.vinisantos.dev.clubpizzaria.repository.EstadoRepository;
import br.com.vinisantos.dev.clubpizzaria.service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	private EstadoRepository repository;

	@Autowired
	private EstadoService service;

	@GetMapping
	public List<Estado> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estado> byId(@PathVariable Long id) {
		try {
			Estado estado = service.buscarId(id);
			return ResponseEntity.ok(estado);
		} catch (ThisEntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado create(@RequestBody Estado body) {
		return service.create(body);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Estado> update(@PathVariable Long id, @RequestBody Estado body) {

		if (!this.repository.existsById(body.getId())) {
			throw new ThisEntityNotFoundException("Estado não existe");
		}
		return ResponseEntity.ok().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Estado> delete(@PathVariable Long id) {

		try {
			service.excluir(id);
			return ResponseEntity.noContent().build();

		} catch (ThisEntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (ExceptionObjectUsed e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

}
