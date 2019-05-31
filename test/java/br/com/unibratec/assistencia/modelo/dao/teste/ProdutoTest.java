package br.com.unibratec.assistencia.modelo.dao.teste;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.unibratec.assistencia.control.ControllerClienteImp;
import br.com.unibratec.assistencia.control.ControllerProdutoImp;
import br.com.unibratec.assistencia.control.ControllerProdutoImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeClienteEndereco;
import br.com.unibratec.assistencia.facade.FacadeProduto;
import br.com.unibratec.assistencia.model.dao.ProdutoDAO;
import br.com.unibratec.assistencia.model.entity.Produto;

public class ProdutoTest {

		
		private static ControllerProdutoImp produtoController;
		private static FacadeProduto produtoFachada;
		Produto produto;
		private static List<Produto> lista;
		private static ProdutoDAO produtoDAO;
		
		@BeforeClass
		public static void beforeClass() {
			produtoController = new ControllerProdutoImp();
			produtoFachada = new FacadeProduto();
		}
		
		@Before
		public void before() {
			/*
			 * Arranjar
			 */
			produto = new Produto("windowns x","programa x",10,1000.0);
		}
		
		@Rule
		public ExpectedException thrown =  ExpectedException.none();
		

		@Test
		public void createProduto() throws GeneralException, DaoException {	
			
			produtoFachada.validarProduto(produto);
			
		}
		
		@Test
		public void testProdutoWithInvalidName() throws GeneralException, DaoException {
			thrown.expect(GeneralException.class);
			thrown.expectMessage("O nome do produto não pode ser deixado em branco");
			//Arranjar
			produto.setNome("windows y");
			//Agir
			produtoFachada.validarProduto(produto);		
		}
		
		@Test
		public void testProdutoWithInvalidDescricao() throws GeneralException, DaoException{
			thrown.expect(GeneralException.class);
			thrown.expectMessage("A descrição deve ser informada!");
			//Arranjar
			produto.setDescricao("produto x");
			//Agir
			produtoFachada.validarProduto(produto);
			
		}
		
		@Test
		public void testProdutoWithInvalidQuantidade() throws GeneralException, DaoException{
			thrown.expect(GeneralException.class);
			thrown.expectMessage("A quantidade informada é invalida");
			produto.setQuantidade(6);
			produtoFachada.validarProduto(produto);
		}
		@Test
		public void testProdutoWithInvalidValor() throws GeneralException, DaoException{
			thrown.expect(GeneralException.class);
			thrown.expectMessage("O valor informado é invalido");
			produto.setValor(10.0);
			produtoFachada.validarProduto(produto);
		}
		
		
		
		public static ControllerProdutoImp getProdutoController() {
			return produtoController;
		}

		public static void setPrdoutoController(ControllerProdutoImp produtoController) {
			ProdutoTest.produtoController = produtoController;
		}

		public static FacadeProduto getProdutoFachada() {
			return produtoFachada;
		}

		public static void setProdutoFachada(FacadeProduto produtoFachada) {
			ProdutoTest.produtoFachada = produtoFachada;
		}

		
}
