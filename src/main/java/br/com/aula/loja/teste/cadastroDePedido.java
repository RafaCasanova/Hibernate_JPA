package br.com.aula.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.aula.loja.dao.CategoriaDao;
import br.com.aula.loja.dao.ClienteDao;
import br.com.aula.loja.dao.PedidoDao;
import br.com.aula.loja.dao.ProdutoDao;
import br.com.aula.loja.model.Categoria;
import br.com.aula.loja.model.Cliente;
import br.com.aula.loja.model.ItemPedido;
import br.com.aula.loja.model.Pedido;
import br.com.aula.loja.model.Produto;
import br.com.aula.loja.util.JPAUtil;

public class cadastroDePedido {

	public static void main(String[] args) {
		cadastraProdutoteste();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto produto = produtoDao.buscarPorId(1);
		ClienteDao clienteDao = new ClienteDao(em);
		Cliente cliente = clienteDao.buscarPorId(1);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10,pedido,produto));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
	}
	
	public static void cadastraProdutoteste() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("MotoG 200","O olho da cara, mas, valeu.",new BigDecimal(2800), celulares );
		Cliente cliente = new Cliente("Rafael","123123123");
		
		EntityManager em = JPAUtil.getEntityManager();
		ClienteDao clienteDao = new ClienteDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		
		em.getTransaction().begin();
		clienteDao.cadastrar(cliente);
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
		}
	}


