package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classesDados.Familiar;
import classesDados.Morada;
import enumerados.TipoGenero;
import gestor.Utilitario;


@WebServlet("/ServletRegistrarPessoa")
public class ServletRegistrarFamiliar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletRegistrarFamiliar() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Utilitario utilitario = new Utilitario();

		// reading the user input
		String nome = request.getParameter("nome");

		String 	dataDeNascimento = request.getParameter("data_nascimento");
		String[] dataNascimento = dataDeNascimento.split("/");
		Date data_nascimento = new Date(Integer.parseInt(dataNascimento[2]), Integer.parseInt(dataNascimento[1]), Integer.parseInt(dataNascimento[0]));

		String paisNascimento = request.getParameter("pais_nascimento");
		String regiaoNascimento = request.getParameter("regiao_nascimento");
		String cidadeNascimento = request.getParameter("cidade_nascimento");

		TipoGenero genero = TipoGenero.valueOf(request.getParameter("genero").toUpperCase());
		String profissao = request.getParameter("profissao");

		String paisMorada = request.getParameter("pais_morada");
		String regiaoMorada = request.getParameter("regiao_morada");
		String cidadeMorada = request.getParameter("cidade_morada");

		boolean eCuidador = false;
		String nomeUtilizador = null;
		String password = null;
		if(request.getParameter("e_cuidador") != null){
			eCuidador = true;
			nomeUtilizador = request.getParameter("nome_utilizador");
			password = request.getParameter("password");
		}

		//		PrintWriter out = response.getWriter();
		//				out.println ( 
		//						"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\n" +
		//								"<html> \n" +
		//				   "<head> \n" +
		//				   "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
		//				   "<title> Dados da Pessoa </title> \n" +
		//				   "</head> \n" +
		//				   "<body> \n" + "<h1> Dados da Pessoa:</h1><br> \n" + 
		//				   "Nome: " + nome + "<br>\n" +
		//				   "Data de Nascimento: " + dataDeNascimento + "<br>\n" +
		//				   "Estado Civil: " + estadoCivil + "<br>\n" +
		//				   "Género: " + genero + "<br>\n" +
		//				   "Telefone: " + telefone + "<br>\n" + 
		//				   "Email: " + email + "<br>\n" + 
		//				   "Morada: " + pais + ", " + cidade + ", rua " + rua +"<br>\n" +
		//				   "<form action = \"Inicial\">" + 
		//				   "<input type =\"submit\" name=\"voltarInicio\" value =\"Voltar ao Inicio\">"+ 
		//				   "</form>" + 
		//				   "</body> \n" +
		//				"</html>" );

		int idLocalNascimento = 0;
		int idMorada=0;
		int idFamiliar = 0;

		try {
			idLocalNascimento = utilitario.novoId_Morada();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			idMorada = utilitario.novoId_Morada();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			idFamiliar = utilitario.novoId_Familiar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Morada localNascimento = new Morada(idLocalNascimento, paisNascimento, regiaoNascimento, cidadeNascimento);
		Morada morada = new Morada(idMorada, paisMorada, regiaoMorada, cidadeMorada);
		utilitario.registo_Morada(localNascimento);
		utilitario.registo_Morada(morada);
		Familiar familiar;
		if(eCuidador == true)
			familiar = new Familiar(idFamiliar, nome, data_nascimento, localNascimento, genero, profissao, morada, eCuidador, nomeUtilizador, password);
		else
			familiar = new Familiar(idFamiliar, nome, data_nascimento, localNascimento, genero, profissao, morada, eCuidador);
		
		utilitario.registo_Familiar(familiar);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
