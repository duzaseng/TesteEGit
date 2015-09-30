package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa implements Tarefa{
	
//	String filtro = "";  NAO DEVE UTILIZAR VARIAVEL MEMBRO POIS A INSTANCIA DA SERVLET É UNICA INSTANCIA NO SERVIDOR
	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String filtro = req.getParameter( "filtro" );
//		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade( filtro );
//		req.setAttribute("empresas", empresas);
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/paginas/buscaEmpresa.jsp");
//		requestDispatcher.forward(req, resp);
//	}

	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		String filtro = req.getParameter( "filtro" );
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade( filtro );
		req.setAttribute("empresas", empresas);
		return "WEB-INF/paginas/buscaEmpresa.jsp";
	}

}
