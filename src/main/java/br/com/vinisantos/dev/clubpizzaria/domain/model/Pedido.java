package br.com.vinisantos.dev.clubpizzaria.domain.model;

import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class Pedido {
	
	@OneToMany
	private ItemPedido itemPedido;

}
