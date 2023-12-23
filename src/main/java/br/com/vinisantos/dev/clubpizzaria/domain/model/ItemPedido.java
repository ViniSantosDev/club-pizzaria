package br.com.vinisantos.dev.clubpizzaria.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemPedido {
	
	private Integer quantidade;
	private BigDecimal precoUnitario;
	private BigDecimal precoTotal;
	private String observacao;
}
