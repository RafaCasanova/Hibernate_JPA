package br.com.aula.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.aula.loja.dao.CategoriaDao;
import br.com.aula.loja.dao.ProdutoDao;
import br.com.aula.loja.model.Categoria;
import br.com.aula.loja.model.Produto;
import br.com.aula.loja.util.JPAUtil;

public class cadastrandoProdutos {

	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1);
		
		//System.out.println(p.getPreco());
		List<Produto> todos = produtoDao.buscaTodos();
		todos.forEach(p2 -> System.out.println(p.getNome()));
		
		BigDecimal precoDoProduto = produtoDao.buscaPrecoPorNome("MotoG 200");
		
		System.out.println(precoDoProduto);
		
	}
	private static void cadastrarProduto(){
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("MotoG 200","O olho da cara, mas, valeu.",new BigDecimal(2800), celulares );
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
		}

}
