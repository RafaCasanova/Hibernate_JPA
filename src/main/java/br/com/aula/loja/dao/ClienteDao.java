package br.com.aula.loja.dao;

import javax.persistence.EntityManager;

import br.com.aula.loja.model.Cliente;
import br.com.aula.loja.model.Produto;

public class ClienteDao {
	
	private EntityManager em;
	
	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public Cliente buscarPorId(Integer id){
		return em.find(Cliente.class, id);
	}

}
