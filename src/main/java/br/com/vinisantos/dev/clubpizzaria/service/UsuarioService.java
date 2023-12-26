package br.com.vinisantos.dev.clubpizzaria.service;

import org.springframework.stereotype.Component;

import br.com.vinisantos.dev.clubpizzaria.domain.dto.UsuarioDTO;
import br.com.vinisantos.dev.clubpizzaria.domain.model.Usuario;

@Component
public interface UsuarioService {

	
	Usuario create(UsuarioDTO dto);
}
