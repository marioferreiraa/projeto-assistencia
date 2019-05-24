package br.com.unibratec.assistencia.model.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.model.entity.Servico;
import br.com.unibratec.assistencia.model.entity.UtilJPA;

public class ServicoDAO extends AbstractDAO<Servico> {

	public List<Servico> consultarTodosOsServicos() throws DaoException {
		try {
			String querySelect = "Select s From Servico s";
			TypedQuery<Servico> typedQuery = UtilJPA.getEntityManager().createQuery(querySelect, Servico.class);
			List<Servico> resultSet = typedQuery.getResultList();
			return resultSet;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar listar os Servicos!");
		}
	}

}
