package br.com.unibratec.assistencia.modelo.dao.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.unibratec.assistencia.control.ControllerClienteImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeClienteEndereco;
import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;

public class ClienteEnderecoDAOTest {
	
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
		//Agir
		cliente = clienteEnderecoFachada.inserirClienteEndereco(cliente);
		//Afirmar
		assertNotNull(cliente.getId());
	}
	
	@Test
	public void testInsertRepeatCliente() throws GeneralException, DaoException {
		//Arranjar
		Cliente cliente2 = createTempCliente();
		//Agir
		cliente2 = clienteEnderecoFachada.inserirClienteEndereco(cliente2);	
		//Afirmar
		assertNull(cliente2);
	}
	
	@Test
	public void testChangeCliente() throws DaoException, GeneralException {
		//Arranjar
		Cliente exst = clienteController.clienteDuplicado(cliente.getCpf());
		exst.getEndereco().setNumero("175");
		exst.getEndereco().setComplemento("Quadra 17");
		//Agir
		this.cliente = clienteController.alterarCliente(exst);
		//Afirmar
		assertEquals("175", this.cliente.getEndereco().getNumero());
	}
	
	@Test
	public void deleteCLiente() throws DaoException, GeneralException{
		//Agir
		cliente = clienteController.clienteDuplicado(cliente.getCpf());
		if(cliente.getId() != null) {
			clienteController.deletarCliente(this.cliente);
		}
		this.cliente = clienteController.clienteDuplicado(this.cliente.getCpf());
		//Afirmar
		assertNull(this.cliente);	
	}
	
	public Cliente createTempCliente() {
		
		Cliente retorno = new Cliente("Mario Ferreira", "12345678909", "81999999999", "mario@aa.aa", "M");
		Endereco endereco = new Endereco("Rua Amélia", "54430999", "Graças", "Recife", "s/c", "s/n");
		retorno.setEndereco(endereco);
		
		return retorno;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}