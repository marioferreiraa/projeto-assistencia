package br.com.unibratec.assistencia.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.UtilJPA;

public class ClienteDAO extends AbstractDAO<Cliente> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public List<Cliente> consultarTodosOsClientes(){
		String querySelect = "Select c From Cliente c";
		TypedQuery<Cliente> typedQuery = UtilJPA.getEntityManager().createQuery(querySelect, Cliente.class);
		List<Cliente> resultSet = typedQuery.getResultList();
		return resultSet;
	} 

}
