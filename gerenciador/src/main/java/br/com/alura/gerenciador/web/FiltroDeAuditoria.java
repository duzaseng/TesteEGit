package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String usuario = getUsuario(req);
		System.out.println("Usuario " + usuario + " acessando a URI: " + req.getRequestURI());
		chain.doFilter(request, resp);
	}

	private String getUsuario(HttpServletRequest req) {
		Usuario user = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if( user == null ) return "deslogado";
		return user.getEmail();
//		String usuario = "deslogado";
//		Cookie cok = new Cookies( req.getCookies()).buscaUsuarioLogado();
//		if( cok == null ) return "deslogado";
//		return cok.getValue();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	
	
}
