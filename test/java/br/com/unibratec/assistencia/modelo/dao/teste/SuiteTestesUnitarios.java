package br.com.unibratec.assistencia.modelo.dao.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClienteEnderecoDAOTest.class, ClienteTest.class, EnderecoTest.class, OrdemServicoTest.class,
		ServicoTest.class })
public class SuiteTestesUnitarios {

}
