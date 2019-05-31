package br.com.unibratec.assistencia.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente implements IEntidade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_codigo_cliente")
	@SequenceGenerator(name = "s_codigo_cliente", sequenceName = "sequence_cliente", initialValue = 1000, allocationSize = 1)
	@Column(name = "codigo_cliente")
	private Integer id;

	@Column(name = "nome_cliente", length = 50)
	private String nome;

	@Column(name = "cpf_cliente", length = 11)
	private String cpf;

	@Column(name = "telefone_cliente", length = 11)
	private String telefone;

	@Column(name = "email_cliente", length = 50)
	private String email;

	@Column(name = "sexo_cliente", length = 10)
	private String sexo;
	
	@Embedded
	private Endereco endereco;

	/*
	 * Construtor padr�o
	 */
	public Cliente() {
		super();
	}

	/*
	 * Construtor com todos os parametros de cliente
	 */
	public Cliente(String nome, String cpf, String telefone, String email, String sexo) {

		this.setCpf(cpf);
		this.setEmail(email);
		this.setNome(nome);
		this.setSexo(sexo);
		this.setTelefone(telefone);

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getChavePrimaria() {
		return this.id;
	}


}
