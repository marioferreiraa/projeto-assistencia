package br.com.unibratec.assistencia.modelo.dao.teste;

import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unibratec.assistencia.control.ControllerOrdemServicoImp;
import br.com.unibratec.assistencia.model.dao.OrdemServicoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;
import br.com.unibratec.assistencia.model.entity.OrdemServico;
import br.com.unibratec.assistencia.model.entity.Produto;
import br.com.unibratec.assistencia.model.entity.Servico;

public class OrdemServicoTest {

	private static ControllerOrdemServicoImp ordemServicoController;
	private static OrdemServicoDAO ordemServicoDao;
	private OrdemServico ordemServico;

	@BeforeClass
	public static void beforeClass() {
		ordemServicoController = new ControllerOrdemServicoImp();
		ordemServicoDao = new OrdemServicoDAO();
	}
	
	@Before
	public void before() {
		ordemServico = createTempOrdemServico();
	}

	@Test
	public void createOrdemServicoTest() {

		OrdemServico os = createTempOrdemServico();
		ordemServicoDao.inserir(os);
		assertNotNull(os.getId());
	}

	@Test
	public void validateOrdemServicoNotNullTest() {

		
	}

	@Test
	public void validateNegativePriceTest() {

	}

	@Test
	public void validateFutureIniDateTest() {

	}

	@Test
	public void validateDateIniAfterFimDateTest() {

	}

	@Test
	public void checkClienteNotNullTest() {

	}

	@Test
	public void checkProdutosOrServicosNullOrEmptyTest() {

	}

	public OrdemServico createTempOrdemServico() {

		OrdemServico retorno = new OrdemServico();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Servico> listaServicos = new ArrayList<Servico>();
		List<Produto> listaProdutos = new ArrayList<Produto>();

		Produto p = new Produto();
		p.setDescricao("Windows 10");
		p.setNome("windows");
		listaProdutos.add(p);

		Produto p2 = new Produto();
		p2.setDescricao("Avast Antivirus");
		p2.setNome("Antivirus");
		listaProdutos.add(p2);

		Cliente c = new Cliente("Mario", "11121095445", "81999999999", "mario@gmail.com", "M");
		Endereco endereco = new Endereco("rua teste", "50650200", "torroes", "recife", "", "64");
		c.setEndereco(endereco);

		Servico s1 = new Servico("Formatacao", 100.0);
		listaServicos.add(s1);

		Servico s2 = new Servico("Limpeza", 50.0);
		listaServicos.add(s2);

		try {

			Date dataInicio = sdf.parse("21/10/2018");
			Date dataFim = sdf.parse("25/10/2018");

			retorno.setCliente(c);
			retorno.setListaProdutos(listaProdutos);
			retorno.setListaServicos(listaServicos);
			retorno.setPreco(200.0);
			retorno.setDataInicio(dataInicio);
			retorno.setDataFim(dataFim);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	public static ControllerOrdemServicoImp getOrdemServicoController() {
		return ordemServicoController;
	}

	public static void setOrdemServicoController(ControllerOrdemServicoImp ordemServicoController) {
		OrdemServicoTest.ordemServicoController = ordemServicoController;
	}

	public static OrdemServicoDAO getOrdemServicoDao() {
		return ordemServicoDao;
	}

	public static void setOrdemServicoDao(OrdemServicoDAO ordemServicoDao) {
		OrdemServicoTest.ordemServicoDao = ordemServicoDao;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}
}
