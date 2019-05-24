package br.com.unibratec.assistencia.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import java.io.Console;
import java.io.Serializable;
import java.util.List;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.facade.FacadeClienteEndereco;
import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.dao.EnderecoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;

@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	Cliente cliente = new Cliente();
	Endereco endereco = new Endereco();

	ClienteDAO clienteDAO = new ClienteDAO();
	EnderecoDAO enderecoDAO = new EnderecoDAO();

	List<Cliente> listaClientes;
	List<Endereco> listaEnderecos;

	FacadeClienteEndereco facadeClienteEndereco = new FacadeClienteEndereco();

	public ClienteMB() {
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void novo() {
		cliente = new Cliente();
		endereco = new Endereco();
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getListaEndereco() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<Endereco> listaEndercos) {
		this.listaEnderecos = listaEndercos;
	}

	@PostConstruct
	public void atualizaListaClientes() {
		try {
			this.listaClientes = clienteDAO.consultarTodosOsClientes();
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalInfo("Erro ao tentar listar os clientes!");
		}
	}

	public void inserir() {

		if (this.cliente != null && this.endereco != null) {
			try {
				facadeClienteEndereco.inserirClienteEndereco(cliente, endereco);
				novo();
			} catch (Exception e) {
				Messages.addGlobalInfo("Erro ao tentar inserir o cliente");
				e.printStackTrace();
			}
		} else {
		}
	}

	public void excluirCliente(Cliente cliente) {
		try {
			clienteDAO.excluirPorObjeto(cliente);
			atualizaListaClientes();
			Messages.addGlobalInfo("Cliente Deletado com sucesso");
		} catch (Exception e) {
			Messages.addGlobalError("N�o foi possivel deletar o cliente!");
		}
	}

	public void alterarDados(Cliente cliente) {
		if (cliente != null) {
			this.cliente = cliente;
		}
	}

	public void merge() {
		try {
			clienteDAO.inserirMerge(cliente);
			Messages.addGlobalInfo("Alteração realizada com sucesso!");
		} catch (Exception e) {
			Messages.addGlobalError("Não foi possível realizar a alteração");
		}
	}

}
