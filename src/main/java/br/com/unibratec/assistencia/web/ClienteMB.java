package br.com.unibratec.assistencia.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import java.io.Console;
import java.io.Serializable;
import java.util.List;

import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.dao.EnderecoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;

@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable{	
	
	/**
	 *Serial Version UID 
	 */
	private static final long serialVersionUID = 1L;	
	
	Cliente cliente;
	Endereco endereco;
	
	ClienteDAO clienteDAO = new ClienteDAO();
	EnderecoDAO enderecoDAO = new EnderecoDAO();
	
	List<Cliente> listaClientes;
	List<Endereco> listaEnderecos;

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
	
	@PostConstruct
	public void atualizaListaClientes() {
		this.listaClientes = clienteDAO.consultarTodosOsClientes();
	}
	
	public void novo() {
		cliente = new Cliente();		
		endereco = new Endereco();
	}
	
	public void inserir() {
		
		if(this.cliente != null /*&& this.endereco != null*/) {
			
			/*enderecoDAO.inserir(this.endereco);
			cliente.setEndereco(this.endereco);*/
			clienteDAO.inserirMerge(this.cliente);
			
			atualizaListaClientes();
		}
	}
	
	public void deletarCliente(Cliente cliente) {
		
		Messages.addGlobalInfo("Nome: "+ cliente.getNome());
		/*cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
		Messages.addGlobalInfo("Nome: "+ cliente.getNome());
		clienteDAO.excluirPorObjeto(cliente);
		atualizaListaClientes();*/
	}
	
	public void excluirCliente(Cliente cliente) {
		clienteDAO.excluirPorObjeto(cliente);
		atualizaListaClientes();
	}
	
	public void editar(Cliente cliente) {
		clienteDAO.excluirPorObjeto(cliente);
		atualizaListaClientes();
	}
	
	public void alterarDados(Cliente cliente) {
		if(cliente != null) {
			this.cliente = cliente;
			System.out.println("inseriu");
		}
	}
	
}
