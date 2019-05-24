package br.com.unibratec.assistencia.model.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	private String rua;
	private String cep;
	private String bairro;
	private String cidade;
	private String complemento;
	private String numero;
	
	public Endereco(){
		super();
	}

	public Endereco(String rua, String cep, String bairro, String cidade, String complemento, String numero){
		
		this.setRua(rua);
		this.setBairro(bairro);
		this.setCep(cep);
		this.setCidade(cidade);
		this.setNumero(numero);
		
	}
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
