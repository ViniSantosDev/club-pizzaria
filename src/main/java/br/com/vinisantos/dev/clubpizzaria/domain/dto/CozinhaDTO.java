package br.com.vinisantos.dev.clubpizzaria.domain.dto;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import lombok.Data;

@Data
public class CozinhaDTO {

	private Long id;
	private String nome;

	public CozinhaDTO(Cozinha x) {
		this.setId(x.getId());
		this.setNome(x.getNome());
	}

}
