package br.com.unibratec.assistencia.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.UtilJPA;

public class ClienteDAO extends AbstractDAO<Cliente> implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public List<Cliente> consultarTodosOsClientes() throws DaoException {
		try {
			String querySelect = "Select c From Cliente c";
			TypedQuery<Cliente> typedQuery = UtilJPA.getEntityManager().createQuery(querySelect, Cliente.class);
			List<Cliente> resultSet = typedQuery.getResultList();
			return resultSet;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar listar os clientes!");
		}
	}
	
	public Cliente consultarPorCpf(String cpf) throws DaoException{
		Cliente cliente = new Cliente();
		TypedQuery<Cliente> typedQuery;
		try {
			String query = "SELECT c FROM Cliente c where cpf = '"+cpf+"'";
			typedQuery = UtilJPA.getEntityManager().createQuery(query, Cliente.class);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar buscar o cliente pelo CPF");
		}
		try {
			cliente = typedQuery.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
		return cliente;
	}

}
