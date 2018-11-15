package br.com.unibratec.assistencia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unibratec.assistencia.model.dao.ClienteDAO;
import br.com.unibratec.assistencia.model.entity.Cliente;
import br.com.unibratec.assistencia.model.entity.Endereco;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/url_acesso_servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Consultou o post");
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String telefone = req.getParameter("telefone");
		String email = req.getParameter("email");
		String sexo = req.getParameter("sexo");
		String rua = req.getParameter("rua");
		String cep = req.getParameter("cep");
		String bairro = req.getParameter("bairro");
		String cidade = req.getParameter("cidade");
		String complemento = req.getParameter("complemento");
		String numero = req.getParameter("numero");
				
		//doGet(request, response);
	}

}
