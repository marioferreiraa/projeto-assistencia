package br.com.unibratec.assistencia.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Endereco implements IEntidade {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_codigo_endereco")
	@SequenceGenerator(name = "s_codigo_endereco", sequenceName = "sequence_endereco", initialValue = 1000, allocationSize = 1)
	@Column(name = "codigo_endereco")
	private Integer id;

	@Column
	private String rua;

	@Column
	private String cep;

	@Column
	private String bairro;

	@Column
	private String cidade;

	@Column
	private String complemento;

	@Column
	private String numero;

	/*
	 * Construtor padrão
	 */
	public Endereco() {
		super();
	}

	public Endereco(String rua, String cep, String bairro, String cidade, String complemento, String numero) {

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Object getChavePrimaria() {
		return this.id;
	}

}
