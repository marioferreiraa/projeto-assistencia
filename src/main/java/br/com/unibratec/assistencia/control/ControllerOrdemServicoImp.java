package br.com.unibratec.assistencia.control;

import java.util.Date;
import java.util.List;

import br.com.unibratec.assistencia.control.imp.ControllerOrdemServico;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.helper.CollectionUtils;
import br.com.unibratec.assistencia.model.dao.OrdemServicoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.OrdemServico;
import br.com.unibratec.assistencia.model.entity.Produto;
import br.com.unibratec.assistencia.model.entity.Servico;

public class ControllerOrdemServicoImp implements ControllerOrdemServico {

	OrdemServicoDAO osDAO = new OrdemServicoDAO();
	
	public void validarOs(OrdemServico os) throws GeneralException {
		validaPreco(os.getPreco());
		validaData(os.getDataInicio(), os.getDataFim());
		validaListas(os);
		validaCliente(os);
	}
	
	public void validaListas(OrdemServico os) throws GeneralException{
		if(CollectionUtils.isNullOrEmpty(os.getListaProdutos())) {
			throw new GeneralException("Precisa ser informado algum produto");
		}
		if (CollectionUtils.isNullOrEmpty(os.getListaServicos())) {
			throw new GeneralException("Precisa ser informado algum tipo de serviço prestado");
		}
	}

	public void validaPreco(double preco) throws GeneralException {
		if (preco <= 0.0) {
			throw new GeneralException("O preço informado é inválido");
		}
	}

	public void validaData(Date dIni, Date dFim) throws GeneralException {

		Date today = new Date();
		
		if (dIni == null || dFim == null) {
		
			throw new GeneralException("Ambas as datas devem ser informadas");
	
		} else {
			
			if (dIni.before(today) || dFim.before(today)) {
				throw new GeneralException("A data inicial ou final não pode ser menor que a data de Hoje!");
			}
			
			if (dIni.after(dFim)) {
				throw new GeneralException("A data inicial não pode ser maior que a data final!");
			}
			
			if (dIni.after(today) || dFim.after(today)) {
				throw new GeneralException("A data inicial ou final não pode ser futura!");
			}
		}
	}

	public void validaCliente(OrdemServico os) throws GeneralException {
		if (os.getCliente() == null) {
			throw new GeneralException("Um cliente deve ser anexado à Ordem de Serviço");
		}
	}

	public void inserirOrdem(OrdemServico ordemServico) throws DaoException, GeneralException {
		try {
			osDAO.inserirMerge(ordemServico);
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}

}