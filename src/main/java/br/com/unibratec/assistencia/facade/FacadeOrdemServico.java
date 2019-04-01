package br.com.unibratec.assistencia.facade;

import br.com.unibratec.assistencia.control.ControllerOrdemServico;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.entity.OrdemServico;

public class FacadeOrdemServico {
	
	ControllerOrdemServico cOS = new ControllerOrdemServico();
	
	public void validarOs(OrdemServico os) throws GeneralException{
		cOS.validaPreco(os.getPreco());
		cOS.validaDataFim(os.getDataFim(), os.getDataInicio());
		cOS.validaDataInicio(os.getDataInicio(), os.getDataFim());
		cOS.validaListas(os.getListaServicos(), os.getListaProdutos());
	}

}
