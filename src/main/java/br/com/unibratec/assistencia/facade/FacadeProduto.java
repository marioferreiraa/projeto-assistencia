package br.com.unibratec.assistencia.facade;

import org.omnifaces.util.Messages;

import br.com.unibratec.assistencia.control.ControllerProduto;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.entity.Produto;

public class FacadeProduto {
	
	ControllerProduto cp = new ControllerProduto();
	
	public void validarProduto(Produto produto) throws GeneralException{
		cp.validaDescricao(produto.getDescricao());
		cp.validaNome(produto.getNome());
		cp.validaPreco(produto.getValor());
		cp.validaQuantidade(produto.getQuantidade());
	}
	
	public void inserirProduto(Produto produto) throws GeneralException, DaoException{
		this.validarProduto(produto);
		cp.inserirProduto(produto);		
		Messages.addGlobalInfo("Produto inserido com sucesso!");
	}

}
