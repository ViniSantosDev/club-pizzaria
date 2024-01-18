package br.com.vinisantos.dev.clubpizzaria.domain.dto;

import java.io.Serializable;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CozinhaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;

	public CozinhaDTO(Cozinha entity) {
		this.setId(entity.getId());
		this.setNome(entity.getNome());
	}
 
}
