package br.com.unibratec.assistencia.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.unibratec.assistencia.facade.FacadeServico;
import br.com.unibratec.assistencia.model.dao.ServicoDAO;
import br.com.unibratec.assistencia.model.entity.Servico;

@ManagedBean
@ViewScoped
public class ServicoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Servico servico = new Servico();
	ServicoDAO servicoDAO = new ServicoDAO();
	FacadeServico fachadaServico = new FacadeServico();
	List<Servico> listaServicos;
	
	public ServicoMB() {}
	
	@PostConstruct
	public void atualizaListaServicos() {
		try {
			this.listaServicos = servicoDAO.consultarTodosOsServicos();
		}catch(Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao tentar listar os serviços");
		}
	}
	
	public void novo() {
		servico = new Servico();
	}
	
	public void inserir() {
		if(this.servico != null) {
			String msg = "";
			try {
				if(servico.getChavePrimaria() == null) {
					fachadaServico.inserirServico(servico);
					msg = "Serviço inserido com sucesso!";
				}else {
					fachadaServico.mergearServico(servico);
					msg = "Serviço alterados com sucesso!";
				}
				novo();
				Messages.addGlobalInfo(msg);
				atualizaListaServicos();
			}catch (Exception e) {
				e.printStackTrace();
				Messages.addGlobalError("Erro ao tentar inserir o serviço no banco!");
			}
		}
	}
	
	public void excluirServico(Servico servico) {
		try {
			servicoDAO.excluirPorObjeto(servico);
			atualizaListaServicos();
			Messages.addGlobalInfo("Servico Deletado com sucesso");
		}catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao tentar deletar o serviço!");
		}
	}
	
	public void alterarServicos(Servico servico) {
		if(servico != null) {
			this.servico = servico;
		}
	}
	
	public void merge() {
		try {
			servicoDAO.inserirMerge(servico);
			Messages.addGlobalInfo("Alteração realizada com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao tentar alterar o serviço!");
		}
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public ServicoDAO getServicoDAO() {
		return servicoDAO;
	}

	public void setServicoDAO(ServicoDAO servicoDAO) {
		this.servicoDAO = servicoDAO;
	}

	public List<Servico> getListaServicos() {
		return listaServicos;
	}

	public void setListaServicos(List<Servico> listaServicos) {
		this.listaServicos = listaServicos;
	}

}
