package br.com.unibratec.assistencia.control;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.dao.EnderecoDAO;
import br.com.unibratec.assistencia.model.entity.Endereco;

public class ControllerEndereco{
	
	EnderecoDAO enderecoDAO = new EnderecoDAO();
	
	public String converteCep(String cep) {
		return cep.replaceAll(".-", "");
	}
	
	public void validaCep(String cep) throws GeneralException {
		if(cep == null || cep.isEmpty()) {
			throw new GeneralException("O cep não pode ser deixado em branco!");
		}
		
		if(cep.length() > 8) {
			throw new GeneralException("Formato Inválido para o CEP!");
		}
	}
	
	public void validaRua(String rua) throws GeneralException{
		if(rua == null || rua.isEmpty()) {
			throw new GeneralException("O campo rua não pode ser deixado em branco!");
		}
	}
	
	public void validaCidade(String cidade) throws GeneralException{
		if(cidade == null || cidade.isEmpty()) {
			throw new GeneralException("O campo cidade não pode ser deixada em branco!");
		}
	}
	
	public void validaComplemento(String complemento) throws GeneralException{
		if(complemento == null || complemento.isEmpty()) {
			throw new GeneralException("O campo complemento não pode ser deixado em branco!");
		}
	}
	
	public void validaNumero(String numero) throws GeneralException{
		if(numero == null || numero.isEmpty()) {
			throw new GeneralException("O campo numero não pode ser deixado em branco!");
		}
	}
	
	public void validaBairro(String bairro) throws GeneralException{
		if(bairro == null || bairro.isEmpty()) {
			throw new GeneralException("O campo bairro não pode ser deixado em branco!");
		}
	}
	
	public void inserir(Endereco endereco) throws DaoException {
		try {
			enderecoDAO.inserir(endereco);
		}catch(Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar inserir o endereço");
		}
	}
	
}
