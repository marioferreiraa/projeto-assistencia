package br.com.unibratec.assistencia.modelo.dao.teste;

import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SuiteModuloClienteEndereco.class, SuiteModuloServico.class, OrdemServicoTest.class, SuiteProduto.class,
		TestClienteSelenium.class, TestServicoSelenium.class })
public class SuiteAll {
}
