package br.com.vinisantos.dev.clubpizzaria.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import br.com.vinisantos.dev.clubpizzaria.repository.impl.CozinhaRepositoryImpl;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	private CozinhaRepositoryImpl repository;
	
	@GetMapping()
	public List<Cozinha> listar() {
		return repository.listar();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhaXmlWrapper listarWithXml() {
		return new CozinhaXmlWrapper(repository.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> byId(@PathVariable Long id){
		Cozinha cozinha =  repository.buscar(id);
		 	 	
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.notFound().build();		
	}
	
	 
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha create(@RequestBody CozinhaDTO dto) {
		Cozinha cozinha = new Cozinha();
		return cozinha;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody CozinhaDTO dto) {
		
		Cozinha cozinhaExist = repository.buscar(id);
		
		if(cozinhaExist != null) {
			BeanUtils.copyProperties(dto, cozinhaExist, "id");
			repository.salvar(cozinhaExist);
			return ResponseEntity.ok(cozinhaExist);
		}
		return ResponseEntity.notFound().build();
		
		
		
		
	}

}
