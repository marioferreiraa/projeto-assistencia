package br.com.unibratec.assistencia.modelo.dao.teste.clienteEndereco;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.rules.ExpectedException;

import br.com.unibratec.assistencia.control.ControllerEnderecoImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeClienteEndereco;
import br.com.unibratec.assistencia.model.entity.Endereco;

public class EnderecoTest {
	
	private static ControllerEnderecoImp enderecoController;
	private static FacadeClienteEndereco enderecoFachada;
	Endereco endereco;
	
	@BeforeClass
	public static void beforeClass() {
		enderecoController = new ControllerEnderecoImp();
		enderecoFachada = new FacadeClienteEndereco();
	}
	
	@Before
	public void before() {
		//Arranjar
		endereco = new Endereco("Alameda das garcas", "51320000", "Ibura", "Jaboatao dos Guararapes", "s/c", "s/n");
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testEnderecoWithoutCep() throws GeneralException, DaoException {
		//Afirmar
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O cep não pode ser deixado em branco!");
		//Arranjar
		endereco.setCep(null);
		//Agir
		enderecoFachada.validarEndereco(endereco);
	}
	
	@Test
	public void testEnderecoWithInvalidCep() throws GeneralException, DaoException {
		//Afirmar
		thrown.expect(GeneralException.class);
		thrown.expectMessage("Formato Inválido para o CEP!");
		//Arranjar
		endereco.setCep("1234567");
		//Agir
		enderecoFachada.validarEndereco(endereco);
	}
	
	@Test
	public void testEnderecoWithInvalidCep2() throws GeneralException, DaoException {
		//Afirmar
		thrown.expect(GeneralException.class);
		thrown.expectMessage("Formato Inválido para o CEP!");
		//Arranjar
		endereco.setCep("123456789");
		//Agir
		enderecoFachada.validarEndereco(endereco);
	}
	
	@Test
	public void testEnderecoWithoutRua() throws GeneralException, DaoException {
		//Afirmar
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O campo rua não pode ser deixado em branco!");
		//Arranjar
		endereco.setRua(null);
		//Agir
		enderecoFachada.validarEndereco(endereco);
	}
	
	@Test
	public void testEnderecoWithoutCidade() throws GeneralException, DaoException {
		//Afirmar
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O campo cidade não pode ser deixada em branco!");
		//Arranjar
		endereco.setCidade(null);
		//Agir
		enderecoFachada.validarEndereco(endereco);
	}
	
	@Test
	public void testEnderecoWithoutComplemento() throws GeneralException, DaoException {
		//Arranjar
		endereco.setComplemento(null);
		//Agir
		enderecoFachada.validarEndereco(endereco);
		//Afirmar
		assertEquals("S/C", endereco.getComplemento());
	}
	
	@Test
	public void testEnderecoWithComplemento() throws GeneralException, DaoException {
		//Arranjar
		endereco.setComplemento("Quadra 17, Bloco A36");
		//Agir
		enderecoFachada.validarEndereco(endereco);
		//Afirmar
		assertEquals("Quadra 17, Bloco A36", endereco.getComplemento());
	}
	
	@Test
	public void testEnderecoWithoutNumero() throws GeneralException, DaoException {
		//Afirmar
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O campo numero não pode ser deixado em branco!");
		//Arranjar
		endereco.setNumero(null);
		//Agir
		enderecoFachada.validarEndereco(endereco);
	}
	
	@Test
	public void testEnderecoWithoutBairro() throws GeneralException, DaoException {
		//Afirmar
		thrown.expect(GeneralException.class);
		thrown.expectMessage("O campo bairro não pode ser deixado em branco!");
		//Arranjar
		endereco.setBairro(null);
		//Agir
		enderecoFachada.validarEndereco(endereco);
	}
}
