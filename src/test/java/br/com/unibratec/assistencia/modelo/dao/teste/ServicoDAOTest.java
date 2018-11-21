package br.com.unibratec.assistencia.modelo.dao.teste;

import org.junit.Test;

import br.com.unibratec.assistencia.model.dao.ServicoDAO;
import br.com.unibratec.assistencia.model.entity.Servico;

public class ServicoDAOTest {
	
	@Test
	public void testInserirServico() {
		Servico servico = new Servico("Formatação de micro",100.0);
		ServicoDAO servicoDAO = new ServicoDAO();
		servicoDAO.inserir(servico);
	}

}
