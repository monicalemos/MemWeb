package servlets;

import gestor.Utilitario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classesDados.Utilizador;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	private Utilizador utilizador;

	public ServletLogin() {
		super();
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ENTREI...");
		session = request.getSession();
		session.setAttribute("msgErroAutenticacao", "");

		System.out.println(request.getParameter("accao"));

		if(request.getParameter("accao").equals("validar")){
			String email = request.getParameter("email").trim();
			String pass = request.getParameter("password").trim();

			Utilitario utilitario = new Utilitario();
			utilizador = utilitario.devolveUtilizador(email, pass);


			if (utilizador != null) {
				session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("nomeUtilizador", utilizador.getNomeCompleto());
				session.setAttribute("validado", "sim");

				String ret = "LoggedPage.jsp";
				response.sendRedirect(ret);
			}
			else{
				session.setAttribute("msgErroAutenticacao", "Email e/ou password incorrectos");
				String ret = "Home.jsp";
				response.sendRedirect(ret);
			}
		}
		else if (request.getParameter("accao").equals("logout")){
			session = request.getSession();
			session.setAttribute("validado", "nao");
			session.setAttribute("msgErroAutenticacao", "");
			String ret = "Home.jsp";
			response.sendRedirect(ret);
		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
