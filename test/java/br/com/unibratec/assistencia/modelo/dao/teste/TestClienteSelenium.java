package br.com.unibratec.assistencia.modelo.dao.teste;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestClienteSelenium {
	
	@Test
	public void testarInserirCliente() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
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
	}
	
	@Test
	public void testApiCep() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/assistencia/cadastrar-cliente.xhtml");
		driver.findElement(By.id("formCliente:cep")).sendKeys("51320470");
		Thread.sleep(3000);
		String rua = driver.findElement(By.id("formCliente:rua")).getAttribute("value");
		assertEquals("Rua Raposo Tavares", rua);
	}
	

}
