package br.com.unibratec.assistencia.modelo.dao.teste;

import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.rmi.CORBA.UtilDelegate;

import org.junit.Test;

import com.mysql.jdbc.Util;

import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.dao.OrdemServicoDAO;
import br.com.unibratec.assistencia.model.dao.ProdutoDAO;
import br.com.unibratec.assistencia.model.dao.ServicoDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.OrdemServico;
import br.com.unibratec.assistencia.model.entity.Produto;
import br.com.unibratec.assistencia.model.entity.Servico;;

public class OrdemServicoDAOTest {
	
	@Test
	public void gerarOrdemServico() throws ParseException {
		List<Servico> listaServicos = new ArrayList<Servico>();
		List<Produto> listaProdutos = new ArrayList<Produto>();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ServicoDAO servicoDAO = new ServicoDAO();
		OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();	
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formBD = new SimpleDateFormat("yyyy-MM-dd");
		
		Produto p = new Produto();
		p.setDescricao("Windows 10");
		p.setNome("windows");
		produtoDAO.inserir(p);		
		listaProdutos.add(p);
		
		Produto p2 = new Produto();
		p2.setDescricao("Avast Antivirus");
		p2.setNome("Antivirus");
		produtoDAO.inserir(p2);	
		listaProdutos.add(p2);
		
		Cliente c = new Cliente("Mario", "11121095445", "81999999999", "mario@gmail.com", "M");
		clienteDAO.inserir(c);
		
		Servico s1 = new Servico("Formatacao",100.0);
		servicoDAO.inserir(s1);
		listaServicos.add(s1);
		
		Servico s2 = new Servico("Limpeza",50.0);
		servicoDAO.inserir(s2);
		listaServicos.add(s2);
		
		
		String dataInicio = "2018-11-21";
		String dataFim = "2018-11-25";
		
		try {
		
			OrdemServico ordemServico = new OrdemServico();
			ordemServico.setCliente(c);
			ordemServico.setListaProdutos(listaProdutos);
			ordemServico.setListaServicos(listaServicos);
			ordemServico.setPreco(200.0);
			ordemServico.setDataInicio(java.sql.Date.valueOf(dataInicio));
			ordemServico.setDataFim(java.sql.Date.valueOf(dataFim));
			
			ordemServicoDAO.inserirMerge(ordemServico);
			
		}catch (Exception e) {
			e.printStackTrace();
		}			
		
	}

}
