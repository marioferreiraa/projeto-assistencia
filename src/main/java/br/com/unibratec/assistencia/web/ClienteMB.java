package br.com.unibratec.assistencia.web;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.dao.EnderecoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;

@ManagedBean
public class ClienteMB implements Serializable{	
	
	/**
	 *Serial Version UID 
	 */
	private static final long serialVersionUID = 1L;	
	
	Cliente cliente = new Cliente();
	Endereco endereco = new Endereco();
	
	ClienteDAO clienteDAO = new ClienteDAO();
	EnderecoDAO enderecoDAO = new EnderecoDAO();
	
	List<Cliente> listaClientes;
	List<Endereco> listaEnderecos;
	
	
	/*Testes para Dayene*/
	final Double valor = 15.0;
	private Integer spinner = 0;
	private Double atualValor = 0.0;
	
	public void mult() {
		if(spinner != null || spinner >= 1) {
			this.atualValor = valor * spinner;
		}
	}
	
	public Double getValor() {
		return valor;
	}

	public Integer getSpinner() {
		return spinner;
	}

	public void setSpinner(Integer spinner) {
		this.spinner = spinner;
	}
	
	public Double getAtualValor() {
		setAtualValor(valor * spinner);
		return this.atualValor;
	}
	
	public void setAtualValor(Double atualValor) {
		this.atualValor = atualValor;
	}
	
	/*Testes para Dayene*/

	public ClienteMB() {}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getListaClientes(){
		return listaClientes;
	}
	
	public void setListaClientes(List<Cliente> listaClientes){
		this.listaClientes = listaClientes;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<Endereco> getListaEndereco(){
		return listaEnderecos;
	}
	
	public void setListaEnderecos(List<Endereco> listaEndercos) {
		this.listaEnderecos = listaEndercos;
	}
	
	public void atualizaListaClientes() {
		this.listaClientes = clienteDAO.consultarTodosOsClientes();
	}
	
	public void inserir() {
		if(this.cliente != null && this.endereco != null) {
			
			enderecoDAO.inserir(this.endereco);
			cliente.setEndereco(this.endereco);
			clienteDAO.inserir(this.cliente);
			
			atualizaListaClientes();
			
		}
	}
	
	public void deletarCliente(ActionEvent evento) {
		cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
		clienteDAO.excluirPorObjeto(cliente);
		atualizaListaClientes();
	}
	
	public void excluirCliente(Cliente cliente) {
		clienteDAO.excluirPorObjeto(cliente);
		atualizaListaClientes();
	}
	
}
