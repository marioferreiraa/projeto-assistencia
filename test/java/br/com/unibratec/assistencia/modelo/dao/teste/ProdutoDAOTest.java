import org.junit.Test;

import br.com.unibratec.assistencia.model.dao.OrdemServicoDAO;
import br.com.unibratec.assistencia.model.dao.ProdutoDAO;
import br.com.unibratec.assistencia.model.entity.OrdemServico;
import br.com.unibratec.assistencia.model.entity.Produto;

public class ProdutoDAOTest {
	
	@Test
	public void testInserirProduto() {
		//lendo a data como int
		OrdemServico ordemServico = new OrdemServico("Unibratec", "assistencia", "windows x", 3000.0, 25\05\2019, 25\\07\\2019);
		OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO(); 
		
		Produto produto = new Produto();
		produto.setNome("Nome teste");
		produto.setDescricao("descriçao teste");
		produto.setQuantidade(5);
		produto.setValor(1000.0);
		produto.setOrdemServico(ordemServico);
		
				
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.inserir(produto);

	}
}