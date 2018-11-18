package br.com.unibratec.assistencia.modelo.dao.teste;

import org.junit.Test;

import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.dao.EnderecoDAO;
import br.com.unibratec.assistencia.model.dao.ProdutoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;
import br.com.unibratec.assistencia.model.entity.Produto;

public class ClienteDAOTest {
	
	@Test
	public void testInserirCliente() {
		
		Endereco endereco = new Endereco("Rua a", "54470250", "Bairro novo", "recife", "s/c", "12");
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.inserir(endereco);
		
		Cliente cliente = new Cliente();
		cliente.setCpf("22222222222");
		cliente.setEmail("asa@as.as");
		cliente.setNome("Cliente de Teste");
		cliente.setTelefone("81988765334");
		cliente.setSexo("Masculino");
		cliente.setEndereco(endereco);
				
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserir(cliente);

	}
	@Test
	public void testInserirProduto() {
		
		Produto produto = new Produto();
		produto.setNome("FonteTESTE");
		produto.setDescricao("TEsteDescrição");
	
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.inserir(produto);

	}

}
