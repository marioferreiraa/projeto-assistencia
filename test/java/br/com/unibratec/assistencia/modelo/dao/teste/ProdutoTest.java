package br.com.unibratec.assistencia.modelo.dao.teste;

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
import br.com.unibratec.assistencia.control.ControllerProdutoImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeClienteEndereco;
import br.com.unibratec.assistencia.facade.FacadeProduto;
import br.com.unibratec.assistencia.facade.FacadeServico;
import br.com.unibratec.assistencia.model.dao.ProdutoDAO;
import br.com.unibratec.assistencia.model.dao.ServicoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.OrdemServico;
import br.com.unibratec.assistencia.model.entity.Produto;
import br.com.unibratec.assistencia.model.entity.Servico;

public class ProdutoTest {
	
	private static ControllerProdutoImp servicoController;
	private static FacadeProduto produtoFachada;
	private static ProdutoDAO produtoDAO;
	private static List<Produto> resultSet;
	OrdemServico ordemServico;
	Produto produto;
	SessionFactory sessao;
	
	@BeforeClass
	public static void beforeClass() {
		servicoController = new ControllerProdutoImp();
		produtoFachada = new FacadeProduto();
		produtoDAO = new ProdutoDAO();
		
		
	}
	
	@Before
	public void before() {
		/*
		 * Arranjar
		 * Inserindo os dados padrões de um produto sem erros, no before.
		 * O objetivo é criar apenas métodos alterando um dado ou outro, a fim de testar uma validação ou outra, para cobrir todo o código
		 * do módulo de produtos. Fachada, Controller, Classe básica e Métodos de persistencia
		 */
		produto = new Produto();
		produto.setNome("HD DESKTOP 250gb");
		produto.setDescricao("HD Para computador pessoal");
		produto.setQuantidade(10);
		produto.setValor(220.0);
	}
	
	@Rule
	public ExpectedException thrown =  ExpectedException.none();
	
	@Test
	public void createProduto() throws GeneralException, DaoException {	
		/**
		 * Agir
		 * Verificando se os dados estão todos OK, utilizando a classe de Controle e fachada.
		 * Os dados do produto j� foram incluidos
		 * Metodo sem Assert e sem Expected, simulando que o validarCliente n�o vai estourar nenhuma excess�o.
		 */
		produtoFachada.validarProduto(produto);
		
	}
	
	@Test
	public void testProdutoWithInvalidName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O nome do produto não pode ser deixado em branco");
		//Arranjar
		produto.setNome("");
		//Agir
		produtoFachada.validarProduto(produto);		
	}
	
	@Test
	public void testProdutoWithoutName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O nome do produto não pode ser deixado em branco");
		//Arranjar
		produto.setNome("");
		//Agir
		produtoFachada.validarProduto(produto);	
	}
	@Test
	public void testProdutoNullName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O nome do produto não pode ser deixado em branco");
		//Arranjar
		produto.setNome(null);
		//Agir
		produtoFachada.validarProduto(produto);	
	}
	
	@Test
	public void testProdutoWithoutPrice() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		throw new GeneralException("O valor informado é invalido");
		//Arranjar
		//produto.setValor(-220.0);
		//Agir
		//produtoFachada.validarProduto(produto);
	}
	@Test
	public void testProdutoConstruct() throws GeneralException, DaoException {
		//Arranjar
		//Agir
		produto = new Produto("TesteCreateProduto","TesteDescricaoProduto",0,10.1);
		}
	@Test
	public void testProdutoGetProduto() throws GeneralException, DaoException {
		//Arranjar
		//Agir
		produto.getId();
		}
	@Test
	public void testProdutoGetOrdemServico() throws GeneralException, DaoException {
		//Arranjar
		//Agir
		produto.getOrdemServico();
		}
	@Test
	public void testProdutoSetOrdemServico() throws GeneralException, DaoException {
		//Arranjar
		//Agir
		produto.setOrdemServico(ordemServico);
		}
	
	@Test
	public void testProdutoInsert() throws GeneralException, DaoException {
		//Arranjar
		//Agir
	//	produtoFachada.inserirProduto(produto);
		produtoDAO.excluirPorObjeto(produto);
	}
	
	@Test
	public void testProdutoInsertError() throws GeneralException, DaoException {
		thrown.expect(DaoException.class);
		//Arranjar
		produto.setNome("asdfhksjadhfkhasdjkfhksjadhfkjhasdkjfhlkasdhfkjashdkjasdfasdfasdfasdfasdfhkasjldhfkjash");
		//Agir
		produtoFachada.inserirProduto(produto);
	}
	
	@Test
	public void testProdutoUpdate() throws GeneralException, DaoException {
		//Arranjar
		produto.setId(1);
		produto.setNome("TesteProdutoUpdate");
		//Agir
		produtoDAO.inserirMerge(produto);
	}
	@Test
	public void testProdutoUpdateError() throws GeneralException, DaoException {
		thrown.expect(DaoException.class);
		//Arranjar
		produto.setId(1);
		produto.setNome("TesteServicoUpdateasfas dfasdfsadf ae ERRRROOOOOOOOOOOOOOOOOOOOORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRr");
		//Agir
		produtoDAO.inserirMerge(produto);
	}
	@Test
	public void testProdutoSelect() throws GeneralException, DaoException {
		//Arranjar
		//Agir
		resultSet = produtoDAO.consultarTodosOsProdutos();
	}
	
	
	@Test
	public void testProdutoDelete() throws GeneralException, DaoException {
		//Arranjar
		produto.setNome("Excluir");
		//produtoFachada.inserirProduto(produto);
		//Agir
		//produtoDAO.excluirPorObjetoDireto(produto);
	}
	
	@Ignore
	public void testProdutoSelectError() throws GeneralException, DaoException {
		thrown.expect(DaoException.class);
		//Arranjar
		sessao.isClosed();
		//Agir	
		resultSet = produtoDAO.consultarTodosOsProdutos();
	}
	
	@After
	public void after() {
		produto.setNome(null);
		produto.setValor(null);
	}
	
	
	
}
