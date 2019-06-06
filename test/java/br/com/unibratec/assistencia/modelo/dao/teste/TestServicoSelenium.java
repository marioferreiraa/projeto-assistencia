package br.com.unibratec.assistencia.modelo.dao.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.JVM.NAME_ASCENDING)
public class TestServicoSelenium {
	
	private WebDriver driver;	
	@Before
	  public void setUp() {
		driver = new ChromeDriver();
	  }
	@Test	
	public void testaInsertServico() throws InterruptedException {
		driver.get("http://localhost:8080/assistencia/servico.xhtml");
		driver.manage().window().setSize(new Dimension(1366, 741));
		driver.findElement(By.cssSelector("#formListagem\\3AtabelaServicos\\3Aj_idt7 > .ui-button-text")).click();
	    driver.findElement(By.id("formServico:j_idt24")).sendKeys("ServicoInsertTest");
	    Thread.sleep(2000);
	    driver.findElement(By.id("formServico:j_idt26")).click();
	    driver.findElement(By.id("formServico:j_idt26")).sendKeys("100");
	    driver.findElement(By.cssSelector("#formServico\\3Aj_idt28 > .ui-button-text")).click();
	    driver.findElement(By.cssSelector("#formServico\\3Aj_idt29 > .ui-button-text")).click();
	}
	
	@Test
	  public void testbUpdateServico() {
		driver.get("http://localhost:8080/assistencia/servico.xhtml");
		driver.manage().window().setSize(new Dimension(1366, 741));
	    driver.findElement(By.cssSelector(".ui-icon-pencil")).click();
	    driver.findElement(By.id("formServico:j_idt24")).click();
	    driver.findElement(By.id("formServico:j_idt26")).click();
	    driver.findElement(By.cssSelector("#formServico\\3Aj_idt28 > .ui-button-text")).click();
	    driver.findElement(By.cssSelector("#formServico\\3Aj_idt29 > .ui-button-text")).click();
	    }
	@Test
	  public void testcDeleteServico() {
	    driver.get("http://localhost:8080/assistencia/servico.xhtml");
	    driver.manage().window().setSize(new Dimension(1366, 741));
	    driver.findElement(By.cssSelector("#formListagem\\3AtabelaServicos\\3A 1\\3Aj_idt15 > .ui-button-icon-left")).click();
	    driver.findElement(By.cssSelector("#formListagem\\3Aj_idt19 > .ui-button-text")).click();
	  }
	@After
	  public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
	    driver.quit();
	  }
	


}
