package servlets;

import enumerados.TipoGenero;
import enumerados.TipoUtilizador;
import gestor.Utilitario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classesDados.Morada;
import classesDados.Pessoa;
import classesDados.Utilizador;

@WebServlet("/ServletRegistrarRespMedico")
public class ServletRegistrarUtilizador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	private String nome;
	private String 	dataDeNascimento;
	private  TipoGenero genero;
	private int telefone;
	private String email;
	private String pais;
	private String cidade;
	private String rua;
	private String password;
	private TipoUtilizador tipoUtilizador;


	public ServletRegistrarUtilizador() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilitario utilitario = new Utilitario();
		
		// reading the user input
		nome = request.getParameter("nome");
		dataDeNascimento = request.getParameter("dataNascimento");
		System.out.println(dataDeNascimento);
		String[] dataNascimento = dataDeNascimento.split("/");
		genero = TipoGenero.valueOf(request.getParameter("genero").toUpperCase());
		telefone = Integer.parseInt(request.getParameter("telefone"));
		email = request.getParameter("email");
		pais= request.getParameter("pais");
		cidade= request.getParameter("cidade");
		rua= request.getParameter("rua");
		password = request.getParameter("password");
		tipoUtilizador = TipoUtilizador.valueOf(request.getParameter("tipo_utilizador").toUpperCase());

		int idMorada=0;
		int idUtilizador = 0;
		
		try {
			idMorada = utilitario.novoIdMorada();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			idUtilizador = utilitario.novoIdTecnico();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Morada morada = new Morada(idMorada, pais, cidade, rua);
		utilitario.registoMorada(morada);
		Utilizador utilizador = new Utilizador(idUtilizador, nome, new Date(Integer.parseInt(dataNascimento[2]), Integer.parseInt(dataNascimento[1]), Integer.parseInt(dataNascimento[0])), genero, telefone, email, morada, password, tipoUtilizador);
		utilitario.registoTecnico(utilizador);
			System.out.println("registei utilizador");
		session = request.getSession();
		session.setAttribute("nome", nome);
		session.setAttribute("dataDeNascimento", dataDeNascimento);
		session.setAttribute("genero", genero);
		session.setAttribute("telefone", telefone);
		session.setAttribute("email", email);
		session.setAttribute("pais", pais);
		session.setAttribute("cidade", cidade);
		session.setAttribute("rua", rua);
		session.setAttribute("password", password);
		session.setAttribute("tipoUtilizador", tipoUtilizador);
		
		RequestDispatcher dispatcher =
				getServletContext().getRequestDispatcher("/PaginaOperacao.jsp");
				dispatcher.forward(request,response);
		
//		PrintWriter out = response.getWriter();
//		out.println ( 
//				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\n" +
//						"<html> \n" +
//						"<head> \n" +
//						"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
//						"<title> Dados da Pessoa </title> \n" +
//						"</head> \n" +
//						"<body> \n" + "<h1> Dados da Pessoa:</h1><br> \n" + 
//						"Nome: " + nome + "<br>\n" +
//						"Data de Nascimento: " + dataDeNascimento + "<br>\n" +
//						"Género: " + genero + "<br>\n" +
//						"Telefone: " + telefone + "<br>\n" + 
//						"Email: " + email + "<br>\n" + 
//						"Morada: " + pais + ", " + cidade + ", rua " + rua +"<br>\n" +
//						"Tipo de Responsabilidade Médica: " + tipoUtilizador + "<br>\n" + 
//						"<form action = \"ConfirmarRegisto\">" + 
//						"<p>Confirma os seus dados?</p>" +
//						"<input type =\"submit\" name=\"simConfirma\" value =\"Sim\">"+ 
//						"<input type =\"submit\" name=\"naoConfirma\" value =\"Não\">"+ 
//						"</form>" + 
//						"</body> \n" +
//				"</html>" );
	}
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
