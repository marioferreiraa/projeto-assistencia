package br.com.unibratec.assistencia.modelo.dao.teste;

import org.junit.Test;

import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.dao.EnderecoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;

public class ClienteDAOTest {
	
	@Test
	public void testInserirCliente() {
		Endereco endereco = new Endereco();
		endereco.setBairro("candeias");
		endereco.setCep("54320470");
		endereco.setCidade("Jaboatão dos Guararapes");
		endereco.setNumero("10");
		endereco.setId(1002);
		
		Cliente cliente = new Cliente();
		cliente.setCpf("11111111111");
		cliente.setEmail("asa@as.as");
		cliente.setNome("Cliente de Teste");
		cliente.setTelefone("81988765334");
		cliente.setId(1002);
		
		endereco.setCliente(cliente);
		cliente.setEndereco(endereco);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserir(cliente);
		
	}

}
