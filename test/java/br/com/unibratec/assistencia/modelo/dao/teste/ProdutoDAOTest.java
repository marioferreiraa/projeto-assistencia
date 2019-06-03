package br.com.unibratec.assistencia.modelo.dao.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
	
	@Test
	public void testInserirProduto() {
		/*lendo a data como int
		OrdemServico ordemServico = new OrdemServico("Unibratec", "assistencia", "windows x", 3000.0);
		OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO(); 
		*/
		Produto produto = new Produto();
		produto.setNome("Nome teste");
		produto.setDescricao("descri�ao teste");
		produto.setQuantidade(5);
		produto.setValor(1000.0);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.inserir(produto);
		assertNotNull(produto.getId());

	}
	@Test
	public void testChangeDescricaoProduto() throws DaoException, GeneralException {
		//Arranjar
		Produto p = produtoController.produtoExistente(produto.getNome());
		p.setDescricao("teste a");
		//Agir
		this.produto = produtoController.alterarProduto(p);
		//Afirmar
		assertEquals("teste a", this.produto.getDescricao());
	}
	
	@Test
	public void deleteProduto() throws DaoException, GeneralException{
		//Agir
		produto = produtoController.produtoExistente(produto.getNome());
		if(produto.getId() != null) {
			produtoController.deletarProduto(this.produto);
		}
		this.produto = produtoController.produtoExistente(this.produto.getNome());
		//Afirmar
		assertNull(this.produto);	
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
