package br.com.unibratec.assistencia.facade;

import java.io.Serializable;

import br.com.unibratec.assistencia.control.ControllerServicoImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.entity.Servico;

public class FacadeServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControllerServicoImp controllerServico = new ControllerServicoImp();

	public void validarServico(Servico servico) throws GeneralException {
		/* servico.setPreco(controllerServico.converterPreco(servico.getPreco())); */
		controllerServico.validaNome(servico.getNome());
		controllerServico.validaPreco(servico.getPreco());
	}

	public void inserirServico(Servico servico) throws GeneralException, DaoException {
		try {
			validarServico(servico);
			controllerServico.inserir(servico);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar cadastrar o servico");
		}

	}

	public void mergearServico(Servico servico) throws GeneralException, DaoException {
		try {
			validarServico(servico);
			controllerServico.merge(servico);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

}
