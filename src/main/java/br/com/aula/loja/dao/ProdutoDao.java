package br.com.aula.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.aula.loja.model.Produto;

public class ProdutoDao {
	
	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}
	public void remover(Produto produto){
		produto = em.merge(produto);
		this.em.remove(produto);;
	}
	public Produto buscarPorId(Integer id){
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscaTodos(){
		String jpql = "SELECT p From Produto p";
		return em.createQuery(jpql,Produto.class).getResultList();
	}
	public List<Produto> buscarPorNome(String nome){
		String jpql = "Slect p from Produto p where p.nome = :nome";
		return em.createQuery(jpql,Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	public List<Produto> buscaPorNomeDaCategoria(String nome){
		String jpql = "SELECT p FROM Produto p where p.categoria.nome = :nome";
		return em.createQuery(jpql,Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	public BigDecimal buscaPrecoPorNome(String nome){
		String jpql = "SELECT p.preco FROM Produto p where p.nome = :nome";
		return em.createQuery(jpql,BigDecimal.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}
	
}
