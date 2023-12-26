package br.com.vinisantos.dev.clubpizzaria.domain.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private LocalDate dataCadastro;
}
