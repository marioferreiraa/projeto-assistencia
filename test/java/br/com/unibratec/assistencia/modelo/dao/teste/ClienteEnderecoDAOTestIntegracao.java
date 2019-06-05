package br.com.unibratec.assistencia.modelo.dao.teste;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.unibratec.assistencia.control.ControllerClienteImp;
import br.com.unibratec.assistencia.control.ControllerEnderecoImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeClienteEndereco;
import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;

public class ClienteEnderecoDAOTestIntegracao {
	
	private static ControllerClienteImp clienteController;
	private static FacadeClienteEndereco clienteEnderecoFachada;
	private Cliente cliente;
	
	@BeforeClass
	public static void beforeClass() {
		clienteController = new ControllerClienteImp();
		clienteEnderecoFachada = new FacadeClienteEndereco();
	}
	
	@Before
	public void before() throws DaoException {
		//Arranjando os objetos de Cliente e Endereco, inicialmente com dados válidos
		cliente = createTempCliente();
	}
	
	@Test
	public void testInsertClienteEndereco() throws DaoException, GeneralException {
		//Arranjar
		Cliente cliente = createTempCliente();
		//Agir
		if(clienteController.clienteDuplicado(cliente.getCpf()) != null) {
			clienteController.deletarCliente(cliente);
		}
		cliente = clienteEnderecoFachada.inserirClienteEndereco(cliente);
		//Afirmar
		assertNotNull(cliente.getId());
	}
	
	@Test
	public void testInsertRepeatCliente() throws GeneralException, DaoException {
		//Arranjar
		Cliente cliente1 = createTempCliente();
		Cliente cliente2 = createTempCliente();
		//Agir
		cliente1 = clienteEnderecoFachada.inserirClienteEndereco(cliente1);
		cliente2 = clienteEnderecoFachada.inserirClienteEndereco(cliente2);	
		//Afirmar
		assertNull(cliente2);
	}
	
	@Test
	public void testChangeCliente() throws DaoException, GeneralException {
		//Arranjar
		Cliente cliente = createTempCliente();
		//Agir
		cliente = clienteController.clienteDuplicado(cliente.getCpf());
		if(cliente == null) {
			cliente = clienteEnderecoFachada.inserirClienteEndereco(cliente);
		}
		cliente.getEndereco().setNumero("175");
		cliente.getEndereco().setComplemento("Quadra 17");
		
		this.cliente = clienteController.alterarCliente(cliente);
		//Afirmar
		assertEquals("175", cliente.getEndereco().getNumero());
	}
	
	@Test
	public void deleteCLiente() throws DaoException, GeneralException{
		//Agir
		cliente = clienteController.clienteDuplicado(cliente.getCpf());
		if(cliente.getId() == null) {
			clienteController.inserirCliente(cliente);
		}
		
		clienteController.deletarCliente(this.cliente);
		
		this.cliente = clienteController.clienteDuplicado(this.cliente.getCpf());
		//Afirmar
		assertNull(this.cliente);	
	}
	
	@Test(expected = DaoException.class)
	public void inserirClienteNull() throws DaoException, GeneralException {
		//Forçar erro ao tentar buscar se cliente ja existe
		//Arranjar
		Cliente cNull = null;
		//Agir
		clienteController.inserirCliente(cNull);
	}
	
	@Test(expected = DaoException.class)
	public void alterarClienteNull() throws DaoException, GeneralException{
		//Arranjar
		Cliente cNull = null;
		//Agir
		clienteController.alterarCliente(cNull);
	}
	
	@Test(expected = DaoException.class)
	public void deletarClienteNull() throws DaoException, GeneralException{
		//Arranjar
		Cliente cNull = null;
		//Agir
		clienteController.deletarCliente(cNull);
	}
	
	@Test
	public void testSelectAllCliente() throws DaoException, GeneralException {
		//Arranjar
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		Cliente cliente = createTempCliente();
		cliente.setCpf("21376584026");
		
		//Agir
		clienteController.inserirCliente(cliente);
		listaClientes = clienteDAO.consultarTodosOsClientes();
		
		//Afirmar
		assertNotNull(listaClientes);
	}
	
	@Test
	public void testSelectForCPF() throws DaoException, GeneralException {
		//Arranjar
		Cliente cliente = createTempCliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		//Agir
		cliente.setCpf("21376584026");
		clienteController.inserirCliente(cliente);
		cliente = clienteDAO.consultarPorCpf(cliente.getCpf());
		//Afirmar
		assertNotNull(cliente.getChavePrimaria());
	}
	
	@Test
	public void testSelectForNullCpf() throws DaoException, GeneralException{
		//Arranjar
		String cpf = null;
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		//Agir
		cliente = clienteDAO.consultarPorCpf(cpf);
		//Afirmar
		assertNull(cliente);
	}
	
	public Cliente createTempCliente() {
		
		Cliente retorno = new Cliente("Mario Ferreira", "12345678909", "81999999999", "mario@aa.aa", "M");
		Endereco endereco = new Endereco("Rua Amélia", "54430999", "Graças", "Recife", "s/c", "s/n");
		retorno.setEndereco(endereco);
		
		return retorno;
	}

	
}