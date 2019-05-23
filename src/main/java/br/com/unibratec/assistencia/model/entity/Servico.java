package br.com.unibratec.assistencia.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Servico implements IEntidade, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_codigo_servico")
	@SequenceGenerator(name = "s_codigo_servico", sequenceName = "sequence_servico", initialValue = 100, allocationSize = 1)
	@Column(name = "codigo_servico")
	private Integer id;

	@Column(name = "nome_servico", length = 50)
	private String nome;

	@Column(name = "preco_servico")
	private Double preco;

	/**
	 * Construtores
	 */

	/*
	 * Construtor Padrão
	 */
	public Servico() {
	}

	/*
	 * Construtor com todos os parametros
	 */
	public Servico(String nome, Double preco) {
		this.setNome(nome);
		this.setPreco(preco);
	}

	/**
	 * Getters and setters
	 */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Object getChavePrimaria() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
