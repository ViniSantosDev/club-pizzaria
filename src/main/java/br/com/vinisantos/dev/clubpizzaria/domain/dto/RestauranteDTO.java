package br.com.vinisantos.dev.clubpizzaria.domain.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import lombok.Data;

@Data
public class RestauranteDTO {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "taxa_frete")
	private BigDecimal taxaFrete;

//	private boolean ativo;
//	
//	private boolean aberto;
//	
//	private LocalDate dataCadastro;
//	
//	private LocalDate dataAtualizacao;
//	
	@ManyToOne
	@JoinColumn(name = "cozinha_id")
	private Cozinha cozinha;

}
