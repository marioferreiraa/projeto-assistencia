package br.com.unibratec.assistencia.modelo.dao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
import br.com.unibratec.assistencia.model.entity.OrdemServico;
import br.com.unibratec.assistencia.model.entity.Servico;

public class ServicoDAOtest {
	
	private static ControllerOrdemServicoImp servicoController;
	private static FacadeServico servicoFachada;
	private static ServicoDAO servicoDAO;
	private static List<Servico> resultSet;
	OrdemServico ordemServico;
	Servico servico;
	Servico servicoFind;
	SessionFactory sessao;
	
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
		 * Inserindo os dados padrões de um cliente sem erros, no before.
		 * O objetivo é criar apenas métodos alterando um dado ou outro, a fim de testar uma validacão ou outra, para cobrir todo o código
		 * do módulo de clientes. Fachada, Controller, Classe básica e Métodos de persistencia
		 */
		servico = new Servico();
		servico.setNome("Instala��o do Windows");
		servico.setPreco(150.00);
	}
	
	@Rule
	public ExpectedException thrown =  ExpectedException.none();
	
	
	@Test
	public void testServicoInsert() throws GeneralException, DaoException {
		//Arranjar
		servico.setNome("TesteInsertServico");
		servico.setPreco(100.0);
		//Agir
		servicoFachada.inserirServico(servico);
		
		servicoFind = servicoDAO.consultarPorObjeto(servico);
		
		assertEquals(servico.getId(), servicoFind.getId());
		
		servicoDAO.excluirPorObjeto(servico);
	}
	
	@Test
	public void testServicoInsertError() throws GeneralException, DaoException {
		thrown.expect(DaoException.class);
		thrown.expectMessage("Erro ao tentar cadastrar o servico");
		//Arranjar
		servico.setNome("asdfhksjadhfkhasdjkfhksjadhfkjhasdkjfhlkasdhfkjashdkjfhkasjldhfkjash");
		servico.setPreco(10.0);
		//Agir
		servicoFachada.inserirServico(servico);
	}
	
	@Test
	public void testServicoUpdate() throws GeneralException, DaoException {
		//Arranjar
		servico.setId(1);
		servico.setNome("TesteServicoUpdate");
		servico.setPreco(15.0);
		//Agir
		servicoFachada.mergearServico(servico);
		
		servicoFind = servicoDAO.consultarPorObjeto(servico);
		
		assertEquals(servico.getNome(), servicoFind.getNome());
	}
	@Test
	public void testServicoUpdateError() throws GeneralException, DaoException {
		thrown.expect(DaoException.class);
		//Arranjar
		servico.setId(1);
		servico.setNome("TesteServicoUpdateasfas dfasdfsadf ae ERRRROOOOOOOOOOOOOOOOOOOOO");
		servico.setPreco(15.0);
		//Agir
		servicoFachada.mergearServico(servico);
	}
	@Test
	public void testServicoSelect() throws GeneralException, DaoException {
		//Arranjar
		//Agir
		resultSet = servicoDAO.consultarTodosOsServicos();
	}
	
	
	@Test
	public void testServicoDelete() throws Exception {
		//Arranjar
		thrown.expect(Exception.class);
		servico.setNome("Excluir");
		servico.setPreco(15.0);
		servicoFachada.inserirServico(servico);
		//Agir
		servicoDAO.excluirPorObjetoDireto(servico);
		
		servicoFind = servicoDAO.consultarPorObjeto(servicoFind);
	}
	
	@Ignore
	public void testServicoSelectError() throws GeneralException, DaoException {
		thrown.expect(DaoException.class);
		//Arranjar
		sessao.isClosed();
		//Agir	
		resultSet = servicoDAO.consultarTodosOsServicos();
	}
	
	@After
	public void after() {
		servico.setNome(null);
		servico.setPreco(null);
	}
	
	
	
}

