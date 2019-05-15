package br.com.unibratec.assistencia.model.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class OrdemServico implements IEntidade, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="s_codigo_os")
	@SequenceGenerator(name="s_codigo_os", 
					   sequenceName="sequence_os", 
					   initialValue=1000,
					   allocationSize = 1)
	@Column(name="codigo_ordem")
	private Integer id;
	
	@OneToOne
	private Cliente cliente;
	
	@OneToMany
	private List<Servico> listaServicos;
	
	@OneToMany
	private List<Produto> listaProdutos;
	
	@Column(name="valor_servico")
	private Double preco;
	
	@Column(name="data_inicio_servico")
	private Date dataInicio;
	
	@Column(name="data_entrega_servico")
	private Date dataFim;
	
	private Calendar dataIniString;
	private Calendar dataFimString;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Servico> getListaServicos() {
		return listaServicos;
	}

	public void setListaServicos(List<Servico> listaServicos) {
		this.listaServicos = listaServicos;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getDataIniString() {
		return dataIniString;
	}

	public void setDataIniString(Calendar dataIniString) {
		this.dataIniString = dataIniString;
	}

	public Calendar getDataFimString() {
		return dataFimString;
	}

	public void setDataFimString(Calendar dataFimString) {
		this.dataFimString = dataFimString;
	}

	public Object getChavePrimaria() {
		return this.id;
	}

}
