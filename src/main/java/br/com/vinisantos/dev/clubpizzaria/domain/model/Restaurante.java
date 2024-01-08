package br.com.vinisantos.dev.clubpizzaria.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table
@Entity
public class Restaurante implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
