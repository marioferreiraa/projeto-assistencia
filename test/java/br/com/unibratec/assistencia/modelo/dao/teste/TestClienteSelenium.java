package br.com.unibratec.assistencia.modelo.dao.teste;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.unibratec.assistencia.control.ControllerClienteImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeClienteEndereco;
import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;

public class TestClienteSelenium {
	
	WebDriver driver;
	private ControllerClienteImp clienteController;
	private FacadeClienteEndereco clienteEnderecoFachada;
	private ClienteDAO clienteDAO;
	private Cliente cliente;
	
	@Before
	public void before() {
		driver = new ChromeDriver();
		clienteController = new ControllerClienteImp();
		clienteEnderecoFachada = new FacadeClienteEndereco();
		clienteDAO = new ClienteDAO();
	}
	
	@Test
	public void testarInserirCliente() throws InterruptedException, DaoException, GeneralException {
		
		//Arranjar
		int qtdClientes = 0;
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();
		//Agir
		cliente = clienteController.clienteDuplicado("33526796068");
		if(cliente != null) {
			clienteDAO.excluirPorChavePrimaria(Cliente.class, cliente.getChavePrimaria());
		}
		
		listaClientes = clienteDAO.consultarTodosOsClientes();
		qtdClientes = listaClientes.size();
		
		driver.get("http://localhost:8080/assistencia/cadastrar-cliente.xhtml");
		driver.findElement(By.id("formCliente:nomeCliente")).sendKeys("Mario Ferreira");	
		driver.findElement(By.id("formCliente:cpfCliente")).sendKeys("33526796068");
		driver.findElement(By.id("formCliente:telCliente")).sendKeys("81999998999");
		driver.findElement(By.id("formCliente:emailCliente")).sendKeys("mario@aa.aa");
		new Select(driver.findElement(By.id("formCliente:selectSexo"))).selectByIndex(1);
		driver.findElement(By.id("formCliente:cep")).sendKeys("51320470");
		Thread.sleep(2000);
		if(driver.findElement(By.id("formCliente:rua")).getAttribute("value").equals(null)) {
			driver.findElement(By.id("formCliente:rua")).sendKeys("Rua Raposo Tavares");
			driver.findElement(By.id("formCliente:bairro")).sendKeys("COHAB");
			driver.findElement(By.id("formCliente:cidade")).sendKeys("Recife");
		}
		driver.findElement(By.id("formCliente:complemento")).sendKeys("Bloco 20");
		driver.findElement(By.id("formCliente:numero")).sendKeys("175");
		
		driver.findElement(By.id("formCliente:btnSalvar")).click();
		Thread.sleep(2000);
		listaClientes = clienteDAO.consultarTodosOsClientes();
		
		//Afirmar
		assertEquals(qtdClientes + 1, listaClientes.size());
	}
	
	@Test
	public void testApiCep() throws InterruptedException {
		driver.get("http://localhost:8080/assistencia/cadastrar-cliente.xhtml");
		driver.findElement(By.id("formCliente:cep")).sendKeys("51320470");
		Thread.sleep(7000);
		String rua = driver.findElement(By.id("formCliente:rua")).getAttribute("value");
		assertEquals("Rua Raposo Tavares", rua);
	}
	
	@Test
	public void testExcluir() throws DaoException, InterruptedException, GeneralException {
		//Arranjar
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		int qtdCliente;
		//Agir
		listaClientes = clienteDAO.consultarTodosOsClientes();
		if(listaClientes.size() < 1) {
			testarInserirCliente();
			qtdCliente = 1;
		}
		qtdCliente = listaClientes.size();
		driver.get("http://localhost:8080/assistencia/consultar-cliente.xhtml");
		driver.findElement(By.id("formListagem:tabelaClientes:0:j_idt19")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("formListagem:j_idt23")).click();
		Thread.sleep(1000);
		listaClientes = clienteDAO.consultarTodosOsClientes();
		
		//Afirmar
		assertEquals(qtdCliente - 1, listaClientes.size());
	}
	
	@Test
	public void testAlterar() throws DaoException, GeneralException, InterruptedException {
		//Arranjar
		Cliente cliente = new Cliente();
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		//Agir
		listaClientes = clienteDAO.consultarTodosOsClientes();
		if(listaClientes.size() < 1) {
			testarInserirCliente();
		}
		cliente = clienteController.clienteDuplicado("64785352078");
		if(cliente != null) {
			clienteDAO.excluirPorObjeto(cliente);
		}
		
		driver.get("http://localhost:8080/assistencia/consultar-cliente.xhtml");
		driver.findElement(By.id("formListagem:tabelaClientes:0:j_idt21")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("formCliente:j_idt29")).clear();
		driver.findElement(By.id("formCliente:j_idt29")).sendKeys("64785352078");
		driver.findElement(By.id("formCliente:j_idt37")).click();
		
		//Afirmar
		cliente = clienteController.clienteDuplicado("64785352078");
		assertNotNull(cliente);
	}
	
}
