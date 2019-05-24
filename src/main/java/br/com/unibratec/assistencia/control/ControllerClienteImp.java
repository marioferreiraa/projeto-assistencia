package br.com.unibratec.assistencia.control;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;

public class ControllerClienteImp {
	ClienteDAO clienteDAO = new ClienteDAO();

	/*
	 * Metodo para validar o nome do cliente.
	 * 
	 * @param String nome
	 */
	public void validaNome(String nome) throws GeneralException {
		if ((nome == null) || nome.isEmpty()) {
			throw new GeneralException("O nome do Cliente não pode ser deixado em branco!");
		}

		if (nome.length() < 5) {
			throw new GeneralException("Favor inserir nome e sobrenome. O nome digitado está muito curto!");
		}
	}

	public void validaCpf(String cpf) throws GeneralException {

		if (cpf == null || cpf.isEmpty()) {
			throw new GeneralException("O CPF precisa ser preenchido");
		}

		if (cpf.length() != 11) {
			throw new GeneralException("O CPF não foi preenchido corretamente");
		}

	}

	public void validaTelefone(String telefone) throws GeneralException {

		if (telefone.length() != 11) {
			throw new GeneralException("O telefone inserido está no formato inválido. O correto é ddd + 9 digitos");
		}

	}

	public void validaEmail(String email) throws GeneralException {

		if (email == null || email.isEmpty()) {
			throw new GeneralException("O email precisa ser preenchido.");
		}

	}

	public void validaSexo(String sexo) throws GeneralException {
		if (sexo == null || sexo.isEmpty()) {
			throw new GeneralException("O sexo deve ser selecionado");
		}
	}

	public String converterCpf(String cpf) {
		return cpf.replaceAll("[.-]", "");
	}

	public String converterTelefone(String telefone) {
		return telefone.replaceAll("[ ()-]", "");
	}

	public void verificaDuplicidade(Cliente cliente) throws DaoException, GeneralException {
		if (cliente != null) {
			try {
				Cliente cliente2 = clienteDAO.consultarPorObjeto(cliente);
				if (cliente2 != null) {
					throw new GeneralException("Esse cliente já está inserido na base de dados.");
				}
			} catch (Exception e) {
				throw new DaoException("Erro ao tentar buscar o cliente no registro!");
			}
		}
	}

	public void inserirCliente(Cliente cliente) throws DaoException, GeneralException {
		try {
			clienteDAO.inserirMerge(cliente);
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}

	}
}
