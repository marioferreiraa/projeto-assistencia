import org.junit.Before;
import org.junit.BeforeClass;

import br.com.unibratec.assistencia.control.ControllerCliente;
import br.com.unibratec.assistencia.model.entity.Cliente;

public class ClienteTest {

	private ControllerCliente controllerCliente;
	
	@BeforeClass
	public void initController() {
		controllerCliente = new ControllerCliente();
	}
	
	
}
