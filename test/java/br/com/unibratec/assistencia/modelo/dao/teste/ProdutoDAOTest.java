package br.com.unibratec.assistencia.modelo.dao.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unibratec.assistencia.control.ControllerClienteImp;
import br.com.unibratec.assistencia.control.ControllerProdutoImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeClienteEndereco;
import br.com.unibratec.assistencia.facade.FacadeProduto;
import br.com.unibratec.assistencia.model.dao.OrdemServicoDAO;
import br.com.unibratec.assistencia.model.dao.ProdutoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;
import br.com.unibratec.assistencia.model.entity.OrdemServico;
import br.com.unibratec.assistencia.model.entity.Produto;

public class ProdutoDAOTest {
	
	private static ControllerProdutoImp produtoController;
	private static FacadeProduto produtoFachada;
	private Produto produto;
	
	@BeforeClass
	public static void beforeClass() {
		produtoController = new ControllerProdutoImp();
		produtoFachada = new FacadeProduto();
	}
	
	@Before
	public void before() {
		produto = createTempProduto();
	}
	
	@Test
	public void testInserirProduto() throws Exception {
		//Agir
		produtoFachada.inserirProduto(produto);	
		//Afirmar
		assertNotNull(produto.getChavePrimaria());
	}
	
	@Test(expected = GeneralException.class)
	public void inserirProdutoNull() throws Exception{
		//Arranjar
		produto = null;
		//Agir
		produtoFachada.inserirProduto(produto);
	}
	
	@Test
	public void testAlterarProduto() throws Exception{
		//Agir
		produtoController.inserirProduto(produto);
		if(produto.getChavePrimaria() != null) {
			assertEquals(produto.getNome(), "Memoria RAM");
			produto.setNome("SSD KINGSTON");
			produtoController.alterarProduto(produto);
			assertEquals(produto.getNome(), "SSD KINGSTON");
		}else {
			throw new RuntimeException("Deu pau!");
		}
		
	}
	
	@Test
	public void testDeleteProduto() throws Exception {
		//Agir
		produtoFachada.inserirProduto(produto);
		if(produto.getId() != null) {
			produtoController.deletarProduto(produto);
			Produto temp = produtoController.procurarPorChavePrimaria(produto.getId());
			assertNull(temp);
		}
	}
	
	public Produto createTempProduto() {
		Produto produto = new Produto("Memoria RAM", "Memoria RAM de 8 GB para Notebook",10,300.0);
		return produto;
	}
	
		
	
}
