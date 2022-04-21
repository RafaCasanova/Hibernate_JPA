package br.com.aula.loja.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
	
	public ItemPedido() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;
	
	private Integer quantidade;
	
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Produto produto;
	
	public ItemPedido(Integer quantidade, Pedido pedido,Produto produto) {
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
		this.precoUnitario = produto.getPreco();
	}
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public BigDecimal getPrecoUnitario() {
		return this.precoUnitario;
	}
	
}
