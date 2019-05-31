package br.com.unibratec.assistencia.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Produto;
import br.com.unibratec.assistencia.model.entity.UtilJPA;

public class ProdutoDAO extends AbstractDAO<Produto> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private EntityManager em;

	public List<Produto> consultarTodosOsProdutos() {
		String querySelect = "Select p From Produto p";
		TypedQuery<Produto> typedQuery = UtilJPA.getEntityManager().createQuery(querySelect, Produto.class);
		List<Produto> resultSet = typedQuery.getResultList();
		return resultSet;
	}
	public Produto consultarPorNome(String nome) throws DaoException{
		Produto produto = new Produto();
		TypedQuery<Produto> typedQuery;
		try {
			String query = "SELECT c FROM Produto c where nome = '"+nome+"'";
			typedQuery = UtilJPA.getEntityManager().createQuery(query, Produto.class);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar buscar o nome do produto");
		}
		try {
			produto = typedQuery.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
		return produto;
	}
}
