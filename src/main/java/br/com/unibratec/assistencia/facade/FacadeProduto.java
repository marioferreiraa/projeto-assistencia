package br.com.unibratec.assistencia.facade;

import org.omnifaces.util.Messages;

import br.com.unibratec.assistencia.control.ControllerProdutoImp;
import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.entity.Produto;

public class FacadeProduto {

	ControllerProdutoImp cp = new ControllerProdutoImp();

	public void validarProduto(Produto produto) throws GeneralException {
		cp.validaDescricao(produto.getDescricao());
		cp.validaNome(produto.getNome());
		cp.validaPreco(produto.getValor());
		cp.validaQuantidade(produto.getQuantidade());
	}

	public Produto inserirProduto(Produto produto) throws GeneralException, DaoException {
		
		Produto retorno = new Produto();
		try {
			validarProduto(produto);
			retorno = cp.inserirProduto(produto);
		}catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException();
		}
		return retorno;
	}

}
