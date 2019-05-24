package br.com.unibratec.assistencia.control.imp;

import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.entity.OrdemServico;

public interface ControllerOrdemServico {
	
	void validarOs(OrdemServico os) throws GeneralException;

}
