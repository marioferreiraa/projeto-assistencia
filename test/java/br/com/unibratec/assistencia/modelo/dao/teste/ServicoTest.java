package br.com.unibratec.assistencia.modelo.dao.teste;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.unibratec.assistencia.control.ControllerClienteImp;
import br.com.unibratec.assistencia.control.ControllerOrdemServicoImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeClienteEndereco;
import br.com.unibratec.assistencia.facade.FacadeServico;
import br.com.unibratec.assistencia.model.dao.ServicoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Servico;

public class ServicoTest {
	
	private static ControllerOrdemServicoImp servicoController;
	private static FacadeServico servicoFachada;
	private static ServicoDAO servicoDAO;
	Servico servico;
	
	@BeforeClass
	public static void beforeClass() {
		servicoController = new ControllerOrdemServicoImp();
		servicoFachada = new FacadeServico();
		servicoDAO = new ServicoDAO();
		
	}
	
	@Before
	public void before() {
		/*
		 * Arranjar
		 * Inserindo os dados padr√µes de um cliente sem erros, no before.
		 * O objetivo √© criar apenas m√©todos alterando um dado ou outro, a fim de testar uma valida√ß√£o ou outra, para cobrir todo o c√≥digo
		 * do m√≥dulo de clientes. Fachada, Controller, Classe b√°sica e M√©todos de persistencia
		 */
		servico = new Servico();
		servico.setNome("InstalaÁ„o do Windows");
		servico.setPreco(150.00);
	}
	
	@Rule
	public ExpectedException thrown =  ExpectedException.none();
	
	@Test
	public void createServico() throws GeneralException, DaoException {	
		/**
		 * Agir
		 * Verificando se os dados est√£o todos OK, utilizando a classe de Controle e fachada.
		 * Os dados do servico j· foram incluidos
		 * Metodo sem Assert e sem Expected, simulando que o validarCliente n„o vai estourar nenhuma excess„o.
		 */
		servicoFachada.validarServico(servico);
		
	}
	
	@Test
	public void testServicoWithInvalidName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("Favor inserir nome de serviÁo correto. O nome digitado est· muito curto!");
		//Arranjar
		servico.setNome("aaaa");
		//Agir
		servicoFachada.validarServico(servico);		
	}
	
	@Test
	public void testServicoWithoutName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O nome do serviÁo deve ser preenchido!");
		//Arranjar
		servico.setNome("");
		//Agir
		servicoFachada.validarServico(servico);
	}
	@Test
	public void testServicoNullName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O nome do serviÁo deve ser preenchido!");
		//Arranjar
		servico.setNome(null);
		//Agir
		servicoFachada.validarServico(servico);
	}
	
	@Test
	public void testServicoWithoutPrice() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O preÁo do serviÁo deve ser preenchido!");
		//Arranjar
		servico.setPreco(null);;
		//Agir
		servicoFachada.validarServico(servico);
	}
	
	@Test
	public void testServicoInsert() throws GeneralException, DaoException {
		//Arranjar
		servico.setNome("TesteServico");
		servico.setPreco(10.0);
		//Agir
		servicoFachada.inserirServico(servico);
		servicoDAO.excluirPorObjeto(servico);
	}
	
	
	@After
	public void after() {
		servico.setNome(null);
		servico.setPreco(null);
	}
	
	
	
}
