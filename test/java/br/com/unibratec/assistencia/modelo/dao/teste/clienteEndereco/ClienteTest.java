package br.com.unibratec.assistencia.modelo.dao.teste.clienteEndereco;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import br.com.unibratec.assistencia.control.ControllerClienteImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeClienteEndereco;
import br.com.unibratec.assistencia.model.entity.Cliente;

public class ClienteTest {
	
	private static ControllerClienteImp clienteController;
	private static FacadeClienteEndereco clienteFachada;
	Cliente cliente;
	
	@BeforeClass
	public static void beforeClass() {
		clienteController = new ControllerClienteImp();
		clienteFachada = new FacadeClienteEndereco();
	}
	
	@Before
	public void before() {
		/*
		 * Arranjar
		 * Inserindo os dados padrões de um cliente sem erros, no before.
		 * O objetivo é criar apenas métodos alterando um dado ou outro, a fim de testar uma validação ou outra, para cobrir todo o código
		 * do módulo de clientes. Fachada, Controller, Classe básica e Métodos de persistencia
		 */
		cliente = new Cliente("Mario Ferreira","12345678909","81999999999","mario@aa.aa","M");
	}
	
	@Rule
	public ExpectedException thrown =  ExpectedException.none();
	
	@Test
	public void createCliente() throws GeneralException, DaoException {	
		/**
		 * Agir
		 * Verificando se os dados estão todos OK, utilizando a classe de Controle e fachada.
		 * Os dados do cliente já foram inseridos pelo construtor.
		 * Método sem Assert e sem Expected, simulando que o validarCliente não vai estourar nenhuma excessão.
		 */
		clienteFachada.validarCliente(cliente);
		
	}
	
	@Test
	public void testClienteWithInvalidName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("Favor inserir nome e sobrenome. O nome digitado está muito curto!");
		//Arranjar
		cliente.setNome("aaaa");
		//Agir
		clienteFachada.validarCliente(cliente);		
	}
	
	@Test
	public void testClientWithoutName() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O nome do Cliente não pode ser deixado em branco!");
		//Arranjar
		cliente.setNome("");
		//Agir
		clienteFachada.validarCliente(cliente);
	}
	
	@Test
	public void testClientWithoutCpf() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O CPF precisa ser preenchido");
		//Arranjar
		cliente.setCpf("");
		//Agir
		clienteFachada.validarCliente(cliente);
	}
	
	@Test
	public void testClientWithInvalidCpf() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O CPF não foi preenchido corretamente");
		//Arranjar
		cliente.setCpf("12345");
		//Agir
		clienteFachada.validarCliente(cliente);
	}
	
	@Test
	public void testClientWithInvalidTel() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O telefone inserido está no formato inválido. O correto é ddd + 9 digitos");
		//Arranjar
		cliente.setTelefone("1234569999");
		//Agir
		clienteFachada.validarCliente(cliente);
	}
	
	@Test
	public void testClientWithInvalidEmail() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O email precisa ser preenchido.");
		//Arranjar
		cliente.setEmail("");
		//Agir
		clienteFachada.validarCliente(cliente);
	}
	
	@Test
	public void testClientWithoutSexo() throws GeneralException, DaoException {
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O sexo deve ser selecionado");
		//Arranjar
		cliente.setSexo("");
		//Agir
		clienteFachada.validarCliente(cliente);
	}
	
	
	
	public static ControllerClienteImp getClienteController() {
		return clienteController;
	}

	public static void setClienteController(ControllerClienteImp clienteController) {
		ClienteTest.clienteController = clienteController;
	}

	public static FacadeClienteEndereco getClienteFachada() {
		return clienteFachada;
	}

	public static void setClienteFachada(FacadeClienteEndereco clienteFachada) {
		ClienteTest.clienteFachada = clienteFachada;
	}

}
