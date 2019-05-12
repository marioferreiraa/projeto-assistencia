package br.com.unibratec.assistencia.facade;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.omnifaces.util.Messages;

import br.com.unibratec.assistencia.control.ControllerOrdemServico;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.entity.OrdemServico;

public class FacadeOrdemServico {
	
	ControllerOrdemServico cOS = new ControllerOrdemServico();
	
	public void validarOs(OrdemServico os) throws GeneralException{
		cOS.validaPreco(os.getPreco());
		cOS.validaData(os.getDataIniString().getTime(), os.getDataFimString().getTime());
		cOS.validaListas(os.getListaServicos(), os.getListaProdutos());
		cOS.validaCliente(os.getCliente());
	}
	
	public void convertData(OrdemServico os) throws GeneralException {
		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(os.getDataIniString());
			System.out.println();
			os.setDataInicio(java.sql.Date.valueOf(format.format(os.getDataIniString().getTime())));
			os.setDataFim(java.sql.Date.valueOf(format.format(os.getDataFimString().getTime())));
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new GeneralException("Erro na conversão de data!");
		}
	}
	
	public void inserirOrdemServico(OrdemServico os) throws DaoException, GeneralException{
		try{
			validarOs(os);
			convertData(os);
			cOS.inserirOrdem(os);
			Messages.addGlobalInfo("Ordem de Serviço Registrada!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
