package br.com.unibratec.assistencia.control;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.dao.ServicoDAO;
import br.com.unibratec.assistencia.model.entity.Servico;

public class ControllerServicoImp {

	ServicoDAO servicoDAO = new ServicoDAO();

	public void validaNome(String nome) throws GeneralException {
		if (nome == null || nome == "") {
			throw new GeneralException("O nome do serviço deve ser preenchido!");
		}

		if (nome.length() < 5) {
			throw new GeneralException("Favor inserir nome de serviço correto. O nome digitado está muito curto!");
		}
	}

	/*
	 * public Double converterPreco(String preco) throws GeneralException{
	 * 
	 * Double novoPreco = 0.0;
	 * 
	 * try { novoPreco = Double.parseDouble(preco); }catch(NumberFormatException e)
	 * { throw new GeneralException("O formato do preÃ§o Ã© invÃ¡lido!"); } return
	 * novoPreco; }
	 */

	public void validaPreco(Double preco) throws GeneralException {
		if (preco == null) {
			throw new GeneralException("O preço do serviço deve ser preenchido!");
		}
	}

	public void inserir(Servico servico) throws DaoException {
		try {
			servicoDAO.inserir(servico);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar inserir o servico");
		}
	}

	public void merge(Servico servico) throws DaoException {
		try {
			servicoDAO.inserirMerge(servico);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar atualizar o servico");
		}
	}

}
