package br.com.unibratec.assistencia.modelo.dao.teste;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestClienteSelenium {
	
	@Test
	public void testarInserirCliente() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/assistencia/cadastrar-cliente.xhtml");
		driver.findElement(By.id("formCliente:nomeCliente")).sendKeys("Mario Ferreira");	
		driver.findElement(By.id("formCliente:cpfCliente")).sendKeys("33526796068");
		driver.findElement(By.id("formCliente:telCliente")).sendKeys("81999998999");
		driver.findElement(By.id("formCliente:emailCliente")).sendKeys("mario@aa.aa");
		new Select(driver.findElement(By.id("formCliente:selectSexo"))).selectByIndex(1);
	}
	

}
