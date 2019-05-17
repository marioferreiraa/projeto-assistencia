package br.com.unibratec.assistencia.exceptions;

import org.omnifaces.util.Messages;

public class GeneralException extends Exception{
	
	/*
	 * Serialização genérica.
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrão vazio.
	 */
	public GeneralException(){
	}
	
	/*
	 * Construtor recebendo um Exception e retornando para a classe pai tratar.
	 * @param Exception e
	 */
	public GeneralException(Exception e) {
		super(e);
	}
	
	/*
	 * Construtor recebendo uma String e enviando para o front JSF.
	 * @param String msg
	 */
	public GeneralException(String msg) {
		super(msg);
		//Messages.addGlobalError(msg);
	}
	
}
