package br.com.vinisantos.dev.clubpizzaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinisantos.dev.clubpizzaria.domain.dto.UsuarioDTO;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Usuario;
import br.com.vinisantos.dev.clubpizzaria.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public List<Usuario> listar() {
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		convertEntityForDTO(usuario, dto);
		repository.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}

	private void convertEntityForDTO(Usuario usuario, UsuarioDTO dto) {
		usuario.setId(dto.getId());
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());
		usuario.setDataCadastro(dto.getDataCadastro());
		
	}
}
