import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.unibratec.assistencia.control.ControllerProduto;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeProduto;
import br.com.unibratec.assistencia.model.dao.ProdutoDAO;
import br.com.unibratec.assistencia.model.entity.Produto;

public class ProdutoTest {

		
		private static ControllerProduto produtoController;
		private static FacadeProduto produtoFachada;
		Produto produto;
		private static List<Produto> lista;
		private static ProdutoDAO produtoDAO;
		
		@BeforeClass
		public static void beforeClass() {
			produtoController = new ControllerProduto();
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
			thrown.expectMessage("Favor inserir o nome do produto!");
			//Arranjar
			produto.setNome("windows y");
			//Agir
			produtoFachada.validarProduto(produto);		
		}
		
		@Test
		public void testProdutoWithInvalidDescricao() throws GeneralException, DaoException{
			thrown.expect(GeneralException.class);
			thrown.expectMessage("Favor inserir a descrição do produto!");
			//Arranjar
			produto.setDescricao("produto x");
			//Agir
			produtoFachada.validarProduto(produto);
			
		}
		
		@Test
		public void testProdutoWithInvalidQuantidade() throws GeneralException, DaoException{
			thrown.expect(GeneralException.class);
			thrown.expectMessage("Favor inserir uma Quantidade!");
			produto.setQuantidade(6);
			produtoFachada.validarProduto(produto);
		}
		@Test
		public void testProdutoWithInvalidValor() throws GeneralException, DaoException{
			thrown.expect(GeneralException.class);
			thrown.expectMessage("Favor inserir um Valor!");
			produto.setValor(10.0);
			produtoFachada.validarProduto(produto);
		}
		@Test 
		public void testSelectProdutos ()throws GeneralException, DaoException {
			 lista = produtoDAO.consultarTodosOsProdutos();
		}
		
}