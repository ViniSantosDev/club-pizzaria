package br.com.vinisantos.dev.clubpizzaria.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import br.com.vinisantos.dev.clubpizzaria.domain.dto.CozinhaDTO;
import br.com.vinisantos.dev.clubpizzaria.domain.dto.CozinhaXmlWrapper;
import br.com.vinisantos.dev.clubpizzaria.domain.exception.ExceptionObjectUsed;
import br.com.vinisantos.dev.clubpizzaria.domain.exception.ThisEntityNotFoundException;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import br.com.vinisantos.dev.clubpizzaria.repository.impl.CozinhaRepositoryImpl;
import br.com.vinisantos.dev.clubpizzaria.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepositoryImpl repository;
	
	@Autowired
	private CozinhaService service;
	

	@GetMapping()
	public List<Cozinha> listar() {
		return repository.listar();
	}

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhaXmlWrapper listarWithXml() {
		return new CozinhaXmlWrapper(repository.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> byId(@PathVariable Long id) {
		Cozinha cozinha = repository.buscar(id);

		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha create(@RequestBody Cozinha body) {
		return service.create(body);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody CozinhaDTO dto) {

		Cozinha cozinhaExist = repository.buscar(id);

		if (cozinhaExist != null) {
			BeanUtils.copyProperties(dto, cozinhaExist, "id");
			service.create(cozinhaExist);
			return ResponseEntity.ok(cozinhaExist);
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Cozinha> deleteCozinhaById(@PathVariable Long id) {
		try {
			service.excluir(id);
			return ResponseEntity.noContent().build();
			
		} catch(ThisEntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		catch(ExceptionObjectUsed e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
