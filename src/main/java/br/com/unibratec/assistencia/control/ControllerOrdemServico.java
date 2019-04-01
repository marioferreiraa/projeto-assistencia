package br.com.unibratec.assistencia.control;

import java.util.Date;
import java.util.List;

import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.dao.OrdemServicoDAO;
import br.com.unibratec.assistencia.model.entity.Produto;
import br.com.unibratec.assistencia.model.entity.Servico;


public class ControllerOrdemServico {
	
	OrdemServicoDAO osDAO = new OrdemServicoDAO();
	
	public void validaListas(List<Servico> listaServicos, List<Produto> listaProdutos) throws GeneralException{
		if(listaServicos == null && listaProdutos == null) {
			throw new GeneralException("Precisa ser informado algum tipo de serviço prestado");
		}
	}
	
	public void validaPreco(double preco) throws GeneralException{
		if(preco <= 0.0) {
			throw new GeneralException("O preço informado é inválido");
		}
	}
	
	public void validaDataInicio(Date dataInicio, Date dataFim) throws GeneralException {
		Date today = new Date();
		
		if(dataInicio.before(today)) {
			throw new GeneralException("A data inserida como início do serviço não pode ser antes de Hoje!");
		}
		
		if(dataInicio.after(dataFim)) {
			throw new GeneralException("A data inserida como data do início não pode ser maior que a data final do serviço!");
		}
		
		if(dataInicio.equals(null)) {
			throw new GeneralException("A data de inicio deve ser informada");
		}
	}

	public void validaDataFim(Date dataFim, Date dataInicio) throws GeneralException{
		Date today = new Date();
		if(dataFim.before(today) || dataFim.before(dataInicio)) {
			throw new GeneralException("A data inserida como término do serviço é inválida!");
		}
		
		if(dataFim.equals(null)) {
			throw new GeneralException("A data de inicio deve ser informada");
		}
	}

}