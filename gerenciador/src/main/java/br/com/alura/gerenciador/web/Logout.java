package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		req.getSession().removeAttribute("usuarioLogado"); // REMOVE SÓ O ATRIBUTO 
//		req.getSession().invalidate();  REMOVE TUDO
//		req.getSession().setMaxInactiveInterval(1);;
		
//		resp.sendRedirect("WEB-INF/paginas/logout.html");
		
		return "WEB-INF/paginas/logout.html";
	}
}
