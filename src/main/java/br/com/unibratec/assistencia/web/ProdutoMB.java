package br.com.unibratec.assistencia.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeProduto;
import br.com.unibratec.assistencia.model.dao.ProdutoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Produto;

import java.io.Console;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProdutoMB implements Serializable {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	Produto produto = new Produto();
	ProdutoDAO produtoDAO = new ProdutoDAO();
	FacadeProduto fp = new FacadeProduto();

	List<Produto> listaProdutos;

	// Construtores
	public ProdutoMB() {
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	@PostConstruct
	public void atualizaListaProdutos() {
		this.listaProdutos = produtoDAO.consultarTodosOsProdutos();
	}

	public void novo() {
		produto = new Produto();
	}

	public void inserir() {
		try {
			System.out.println(produto.getValor());
			fp.inserirProduto(produto);
			novo();
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao tentar inserir o cliente");
			e.printStackTrace();
		}

	}

	public void excluirProduto(Produto produto) {
		produtoDAO.excluirPorObjeto(produto);
		atualizaListaProdutos();
	}

	public void editar(Produto produto) {
		produtoDAO.excluirPorObjeto(produto);
		atualizaListaProdutos();
	}

	public void alterarDados(Produto produto) {
		if (produto != null) {
			this.produto = produto;
			System.out.println("inseriu");
		}
	}
}
