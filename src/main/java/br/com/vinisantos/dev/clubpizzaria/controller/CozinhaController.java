package br.com.vinisantos.dev.clubpizzaria.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinisantos.dev.clubpizzaria.domain.dto.CozinhaDTO;
import br.com.vinisantos.dev.clubpizzaria.domain.dto.CozinhaXmlWrapper;
import br.com.vinisantos.dev.clubpizzaria.domain.exception.ExceptionObjectUsed;
import br.com.vinisantos.dev.clubpizzaria.domain.exception.ThisEntityNotFoundException;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import br.com.vinisantos.dev.clubpizzaria.repository.CozinhaRepository;
import br.com.vinisantos.dev.clubpizzaria.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository repository;
	
	@Autowired
	private CozinhaService service;
	

	@GetMapping
	public ResponseEntity<Page<CozinhaDTO>> listar(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "4") Integer linesPerPage,  
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<CozinhaDTO> cozinhas = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(cozinhas);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhaXmlWrapper listarWithXml() {
		return new CozinhaXmlWrapper(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> byId(@PathVariable Long id) {
		Cozinha cozinha = service.findById(id);

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

//	@PutMapping("/{id}")
//	public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody CozinhaDTO dto) {
//
//		Optional<Cozinha> cozinhaExist = repository.findById(id);
//
//		if (cozinhaExist.isPresent()) {
//			BeanUtils.copyProperties(dto, cozinhaExist.get(), "id");
//			Cozinha cozinhaSalva = service.create(cozinhaExist.get());
//			return ResponseEntity.ok(cozinhaSalva);
//		}
//		return ResponseEntity.notFound().build();
//	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CozinhaDTO> update(@PathVariable Long id, @RequestBody CozinhaDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
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
