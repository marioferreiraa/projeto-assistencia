package br.com.unibratec.assistencia.facade;

import org.omnifaces.util.Messages;

import br.com.unibratec.assistencia.control.ControllerClienteImp;
import br.com.unibratec.assistencia.control.ControllerEnderecoImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;

public class FacadeClienteEndereco {

	ControllerClienteImp controllerCliente = new ControllerClienteImp();
	ControllerEnderecoImp controllerEndereco = new ControllerEnderecoImp();

	public void validarCliente(Cliente cliente) throws GeneralException, DaoException {

		cliente.setCpf(controllerCliente.converterCpf(cliente.getCpf()));
		cliente.setTelefone(controllerCliente.converterTelefone(cliente.getTelefone()));
		controllerCliente.validaNome(cliente.getNome());
		controllerCliente.validaCpf(cliente.getCpf());
		controllerCliente.validaTelefone(cliente.getTelefone());
		controllerCliente.validaEmail(cliente.getEmail());
		controllerCliente.validaSexo(cliente.getSexo());
	}

	public void validarEndereco(Endereco endereco) throws GeneralException, DaoException {

		endereco.setCep(controllerEndereco.validaCep(endereco.getCep()));
		controllerEndereco.validaRua(endereco.getRua());
		controllerEndereco.validaBairro(endereco.getBairro());
		controllerEndereco.validaCidade(endereco.getCidade());
		endereco.setComplemento(controllerEndereco.validaComplemento(endereco.getComplemento()));
		controllerEndereco.validaNumero(endereco.getNumero());
	}

	public Cliente inserirClienteEndereco(Cliente cliente) throws GeneralException, DaoException {
		
		Cliente retorno = new Cliente();
		
		try {
			validarCliente(cliente);
			validarEndereco(cliente.getEndereco());
			retorno = controllerCliente.inserirCliente(cliente);
			//Messages.addGlobalInfo("Cliente Inserido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retorno;

	}
}
