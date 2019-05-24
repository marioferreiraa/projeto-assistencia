package br.com.unibratec.assistencia.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Produto implements IEntidade, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_codigo_produto")
	@SequenceGenerator(name = "s_codigo_produto", sequenceName = "sequence_produto", initialValue = 1000, allocationSize = 1)
	@Column(name = "codigo_produto")
	private Integer id;

	@Column(name = "nome_produto", length = 50)
	private String nome;

	@Column(name = "descricao_produto", length = 150)
	private String descricao;
	
	@Column(name = "quantidade_produto")
	private Integer quantidade;

	@Column(name = "valor_produto")
	private Double valor;

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	public OrdemServico ordemServico;

	public Integer getChavePrimaria() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
