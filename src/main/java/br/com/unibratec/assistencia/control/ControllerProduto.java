package br.com.unibratec.assistencia.control;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.dao.ProdutoDAO;
import br.com.unibratec.assistencia.model.entity.Produto;

public class ControllerProduto {
	
ProdutoDAO produtoDAO = new ProdutoDAO();
	
	public void validaNome(String nome) throws GeneralException{
		if(nome.equals(null) || nome.equals("") || nome.isEmpty()){
			throw new GeneralException("O nome do produto não pode ser deixado em branco");
		}
	}
	
	public void validaPreco(Double preco) throws GeneralException{
		if(preco <= 0.0) {
			throw new GeneralException("O preço informado é inválido");
		}
	}
	
	public void validaQuantidade(int qtd) throws GeneralException{
		if(qtd <= 0){
			throw new GeneralException("A quantidade informada é inválida");
		}
	}
	
	public void validaDescricao(String descricao) throws GeneralException{
		if(descricao.equals("") || descricao.equals(null) || descricao.isEmpty()){
			throw new GeneralException("A descrição deve ser informada!");
		}
	}
	
	public void inserirProduto(Produto produto) throws GeneralException, DaoException{
		try{
			produtoDAO.inserirMerge(produto);
		}catch(Exception e){
			throw new DaoException(e.getMessage());
		}
	}

}
