package br.com.unibratec.assistencia.modelo.dao.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({SuiteModuloClienteEndereco.class,SuiteModuloServico.class,ProdutoTest.class,ProdutoDAOTest.class,OrdemServicoTest.class,OrdemServicoDAOTest.class})
public class SuiteAll {
}
