package br.com.unibratec.assistencia.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.unibratec.assistencia.model.dao.OrdemServicoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.OrdemServico;
import br.com.unibratec.assistencia.model.entity.Produto;
import br.com.unibratec.assistencia.model.entity.Servico;

@ManagedBean
@ViewScoped
public class OrdemServicoMB implements Serializable{

	/**
	 *Serial Version UID 
	 */
	private static final long serialVersionUID = 1L;	
	
	OrdemServico os = new OrdemServico();
	OrdemServicoDAO osDAO = new OrdemServicoDAO();
	private Cliente clienteSelecionado;
	private List<Servico> servicosSelecionados;
	private List<Produto> produtosSelecionados;
	
	public Cliente getClienteSelecionado() {
		return this.clienteSelecionado;
	}
	
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
	public List<Servico> getServicosSelecionados(){
		return this.servicosSelecionados; 
	}
	
	public void setServicosSelecionados(List<Servico> servicosSelecionados) {
		this.servicosSelecionados = servicosSelecionados;
	}
	
	public List<Produto> getProdutosSelecionados(){
		return this.produtosSelecionados;
	}
	
	public void setProdutosSelecionados(List<Produto> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}
}
