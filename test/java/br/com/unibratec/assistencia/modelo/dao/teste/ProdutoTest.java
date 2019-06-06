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
	
	private static FacadeProduto produtoFachada;
	Produto produto = new Produto();
	SessionFactory sessao;
	
	@BeforeClass
	public static void beforeClass() {
		produtoFachada = new FacadeProduto();		
	}
	
	@Before
	public void before() {
		
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
		Produto produto = createTempProduto();
		produtoFachada.validarProduto(produto);
		
	}
	
	@Test
	public void testProdutoWithInvalidName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O nome do produto não pode ser deixado em branco");
		//Arranjar
		Produto produto = createTempProduto();
		//Agir
		produto.setNome("");
		produtoFachada.validarProduto(produto);		
	}
	
	@Test
	public void testProdutoWithoutName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O nome do produto não pode ser deixado em branco");
		//Arranjar
		Produto produto = createTempProduto();
		//Agir
		produto.setNome("");
		produtoFachada.validarProduto(produto);	
	}
	
	@Test
	public void testProdutoNullName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O nome do produto não pode ser deixado em branco");
		//Arranjar
		Produto produto = createTempProduto();
		//Agir
		produto.setNome("");
		produtoFachada.validarProduto(produto);	
	}
	
	@Test
	public void testProdutoWithoutPrice() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		//Arranjar
		Produto produto = createTempProduto();
		//Agir
		produto.setValor(null);
		produtoFachada.validarProduto(produto);
	}
	
	@Test
	public void testProdutoConstruct() throws GeneralException, DaoException {
		//Arranjar
		Produto produto = new Produto("TesteCreateProduto","TesteDescricaoProduto",1,10.1);
		//Agir
		produtoFachada.validarProduto(produto);
	}
	
	@Test
	public void testProdutoWithoutQuantidade() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("A quantidade informada é invalida");
		//Arranjar
		Produto produto = new Produto("TesteCreateProduto","TesteDescricaoProduto",0,10.1);
		//Agir
		produtoFachada.validarProduto(produto);
	}
	
	@Test
	public void testProdutoWithoutDescription() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("A descrição deve ser informada!");
		//Arranjar
		Produto produto = new Produto("TesteCreateProduto","",0,10.1);
		//Agir
		produtoFachada.validarProduto(produto);
	}	
	
	public Produto createTempProduto() {
		Produto produto = new Produto("Memoria RAM", "Memoria RAM de 8 GB para Notebook",10,300.0);
		return produto;
	}
	
}
