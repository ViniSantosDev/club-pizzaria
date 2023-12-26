package br.com.vinisantos.dev.clubpizzaria.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private BigDecimal subTotal;
	
	private BigDecimal taxaFrete; 
	
	private BigDecimal valorTotal;
	
	private LocalDate dataCriacao;
	
	private LocalDate dataConfirmacao;
	
	private LocalDate dataEntrega;
	
	private LocalDate dataCancelamento;
	
	@OneToMany
	private List<ItemPedido> itemPedido;

}
