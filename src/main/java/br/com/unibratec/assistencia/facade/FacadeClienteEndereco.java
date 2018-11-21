package br.com.unibratec.assistencia.facade;

import org.omnifaces.util.Messages;

import br.com.unibratec.assistencia.control.ControllerCliente;
import br.com.unibratec.assistencia.control.ControllerEndereco;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;

public class FacadeClienteEndereco {
	
	ControllerCliente controllerCliente = new ControllerCliente();
	ControllerEndereco controllerEndereco = new ControllerEndereco();
	
	public void validarCliente(Cliente cliente) throws GeneralException, DaoException {
		
		cliente.setCpf(controllerCliente.converterCpf(cliente.getCpf()));
		cliente.setTelefone(controllerCliente.converterTelefone(cliente.getTelefone()));
		controllerCliente.validaNome(cliente.getNome());
		controllerCliente.validaCpf(cliente.getCpf());
		controllerCliente.validaTelefone(cliente.getTelefone());
		controllerCliente.validaEmail(cliente.getEmail());
		controllerCliente.validaSexo(cliente.getSexo());
		//controllerCliente.verificaDuplicidade(cliente);	
	}
	
	public void validarEndereco(Endereco endereco) throws GeneralException, DaoException {
		endereco.setCep(controllerEndereco.converteCep(endereco.getCep()));
		controllerEndereco.validaCep(endereco.getCep());
		controllerEndereco.validaRua(endereco.getRua());
		controllerEndereco.validaBairro(endereco.getBairro());
		controllerEndereco.validaCidade(endereco.getCidade());
		controllerEndereco.validaComplemento(endereco.getNumero());
		controllerEndereco.validaNumero(endereco.getNumero());
	}
	
	public void inserirClienteEndereco(Cliente cliente, Endereco endereco) throws GeneralException, DaoException {
		try {
			validarCliente(cliente);
			validarEndereco(endereco);
			controllerEndereco.inserir(endereco);
			cliente.setEndereco(endereco);
			controllerCliente.inserirCliente(cliente);		
			Messages.addGlobalInfo("Cliente Inserido com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
