package br.com.unibratec.assistencia.facade;

import org.omnifaces.util.Messages;

import br.com.unibratec.assistencia.control.ControllerServico;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.entity.Servico;

public class FacadeServico {

	ControllerServico controllerServico = new ControllerServico();
	
	public void validarServico(Servico servico) throws GeneralException {
		/*servico.setPreco(controllerServico.converterPreco(servico.getPreco()));*/
		controllerServico.validaNome(servico.getNome());
		controllerServico.validaPreco(servico.getPreco());
	}
	
	public void inserirServico(Servico servico) throws GeneralException, DaoException {
		try {
			validarServico(servico);
			controllerServico.inserir(servico);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar cadastrar o serviço");
		}
		
	}
	
	public void mergearServico(Servico servico) throws GeneralException, DaoException {
		try {
			validarServico(servico);
			controllerServico.merge(servico);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
}
