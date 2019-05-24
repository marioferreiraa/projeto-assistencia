package br.com.unibratec.assistencia.model.dao;

public interface InterfaceDAO<T> {

	public T inserir(T pEntidade);
	
	public T inserirMerge(T pEntidade);
	
	public void alterar(T entidade);
	
	public void excluirPorChavePrimaria(Class pClasse, Object pPrimarykey);
	
	public void excluirPorObjeto(T entidade);
	
	public void excluirPorObjetoDireto(T entidade);
	
	public T consultarPorChavePrimaria(Class pClasse, Object pPrimaryKey);
	
	public T consultarPorObjeto(T pEntidade);
	
}
