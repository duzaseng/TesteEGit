package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa{


	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario user = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		HttpSession session = req.getSession();
		session.setAttribute("usuarioLogado", user);
//		req.setAttribute("usuario", user);
		return "WEB-INF/paginas/login.jsp"; 
	}

}
