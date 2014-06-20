package servlets;

import gestor.Utilitario;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.BCrypt;
import classesDados.Morada;
import classesDados.Utilizador;
import enumerados.TipoGenero;
import enumerados.TipoUtilizador;

/**
 * Servlet implementation class ServletConfirmaRegisto
 */
@WebServlet("/ServletConfirmaRegisto")
public class ServletConfirmarRegisto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	public ServletConfirmarRegisto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		

		String[] dataNascimento = ((String) session.getAttribute("dataDeNascimento")).split("/");
		if (request.getParameter("simConfirma") != null){


			System.out.println("Clicou no sim");
			Utilitario utilitario = new Utilitario();

			int idMorada=0;
			int idRespMedico = 0;

			try {
				idMorada = utilitario.novoIdMorada();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				idRespMedico = utilitario.novoIdUtilizador();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			Morada morada = new Morada(idMorada, session.getAttribute("pais").toString(), 
					session.getAttribute("cidade").toString(), 
					session.getAttribute("rua").toString());
			utilitario.registoMorada(morada);
			String hashed = BCrypt.hashpw(session.getAttribute("password").toString(), BCrypt.gensalt());
			@SuppressWarnings("deprecation")
			Utilizador respMedico = new Utilizador(idRespMedico, 
					session.getAttribute("nome").toString(), 
					new Date(Integer.parseInt(dataNascimento[2]), 
							Integer.parseInt(dataNascimento[1]), 
							Integer.parseInt(dataNascimento[0])), 
							TipoGenero.valueOf(session.getAttribute("genero").toString()), 
							Integer.parseInt(session.getAttribute("telefone").toString()), 
							session.getAttribute("email").toString(), morada, hashed, 
							TipoUtilizador.valueOf(session.getAttribute("tipoResponsabilidade").toString()));
			utilitario.registoUtilizador(respMedico);
			
			session = request.getSession();
			session.setAttribute("email", respMedico.getEmail());
			session.setAttribute("nome_completo", respMedico.getNomeCompleto());
			session.setAttribute("idRespMedico", respMedico.getId());
			session.setAttribute("validado", "sim");
			session.setAttribute("respMedico", respMedico);
			ServletContext sc = this.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/PaginaOperacao.jsp");
			if (rd != null)
				rd.forward(request, response);
		}

		else if (request.getParameter("naoConfirma") != null){
			System.out.println("Cliquei no não confirmar");
			request.setAttribute("naoConfirmo", request.getServletPath());
			RequestDispatcher rd = request.getRequestDispatcher("/RegistrarRespMedico.jsp");
			if (rd != null)
				rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
