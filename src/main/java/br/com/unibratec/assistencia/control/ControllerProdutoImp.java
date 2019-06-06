package br.com.unibratec.assistencia.control;

import br.com.unibratec.assistencia.exceptions.DaoException;
import br.com.unibratec.assistencia.exceptions.GeneralException;
import br.com.unibratec.assistencia.model.dao.ProdutoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Produto;

public class ControllerProdutoImp {

	ProdutoDAO produtoDAO = new ProdutoDAO();

	public void validaNome(String nome) throws GeneralException {
		if (nome.equals(null) || nome.equals("") || nome.isEmpty()) {
			throw new GeneralException("O nome do produto não pode ser deixado em branco");
		}
	}

	public void validaPreco(Double valor) throws GeneralException {
		if (valor == null || valor <= 0.0) {
			throw new GeneralException("O valor informado é invalido");
		}
	}

	public void validaQuantidade(int quantidade) throws GeneralException {
		if (quantidade <= 0) {
			throw new GeneralException("A quantidade informada é invalida");
		}
	}

	public void validaDescricao(String descricao) throws GeneralException {
		if (descricao.equals("") || descricao.equals(null) || descricao.isEmpty()) {
			throw new GeneralException("A descrição deve ser informada!");
		}
	}

	public Produto inserirProduto(Produto produto) throws GeneralException, DaoException {
		try {
			return produtoDAO.inserir(produto);
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public Produto produtoExistente(String nome) throws DaoException, GeneralException {
		
		Produto p = new Produto();	
		try {
			p = produtoDAO.consultarPorNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar buscar o nome do produto!");
		}
		
		return p;
	}
	public Produto alterarProduto(Produto produto) throws DaoException, GeneralException{
		try {
			return produtoDAO.inserirMerge(produto);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar alterar o produto");
		}
	}
	
	public void deletarProduto(Produto produto) throws DaoException{
		try {
			produtoDAO.excluirPorObjeto(produto);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar deletar o produto!");
		}
	}
	
	public Produto procurarPorChavePrimaria(int chavePrimaria) throws DaoException {
		Produto produto = null;
		try {
			produto = produtoDAO.consultarPorChavePrimaria(Produto.class, chavePrimaria);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao tentar consultar por chave!");
		}
		
		return produto;
	}

}
