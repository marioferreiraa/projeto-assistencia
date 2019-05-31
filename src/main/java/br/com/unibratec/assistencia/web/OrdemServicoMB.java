package br.com.unibratec.assistencia.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.facade.FacadeOrdemServico;
import br.com.unibratec.assistencia.model.dao.OrdemServicoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.OrdemServico;
import br.com.unibratec.assistencia.model.entity.Produto;
import br.com.unibratec.assistencia.model.entity.Servico;

@ManagedBean
@ViewScoped
public class OrdemServicoMB implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	FacadeOrdemServico facadeOrdemServico = new FacadeOrdemServico();
	OrdemServico ordemServico = new OrdemServico();
	OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
	private Cliente clienteSelecionado;
	private List<Servico> servicosSelecionados;
	private List<Produto> produtosSelecionados;

	public OrdemServicoMB() {
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Cliente getClienteSelecionado() {
		return this.clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<Servico> getServicosSelecionados() {
		return this.servicosSelecionados;
	}

	public void setServicosSelecionados(List<Servico> servicosSelecionados) {
		this.servicosSelecionados = servicosSelecionados;
	}

	public List<Produto> getProdutosSelecionados() {
		return this.produtosSelecionados;
	}

	public void setProdutosSelecionados(List<Produto> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}

	public double calcularValorordemServico() {
		double valor = 0;

		for (Servico s : servicosSelecionados) {
			valor += s.getPreco();
		}

		for (Produto p : produtosSelecionados) {
			valor += p.getValor();
		}

		return valor;

	}

	public void inserir() throws DaoException, GeneralException {
		try {
			ordemServico.setPreco(calcularValorordemServico());
			System.out.println(ordemServico.getPreco());
		} catch (Exception e) {
			throw new GeneralException("Erro ao tentar calcular o valor!");
		}

		ordemServico.setCliente(clienteSelecionado);
		ordemServico.setListaProdutos(produtosSelecionados);
		ordemServico.setListaServicos(servicosSelecionados);

		System.out.println("Cliente - " + ordemServico.getCliente().getNome());
		System.out.println("Produtos - " + ordemServico.getListaProdutos().size());
		System.out.println("Serviços - " + ordemServico.getListaServicos().size());
		System.out.println("Preco - " + ordemServico.getPreco());

		facadeOrdemServico.inserirOrdemServico(ordemServico);
	}
}
