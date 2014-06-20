package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classesDados.Morada;
import classesDados.Pessoa;
import enumerados.TipoEstadoCivil;
import enumerados.TipoGenero;
import gestor.Utilitario;


@WebServlet("/ServletRegistrarPessoa")
public class ServletRegistrarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletRegistrarPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilitario utilitario = new Utilitario();
		
		// reading the user input
				String nome = request.getParameter("nome");
				String 	dataDeNascimento = request.getParameter("dataNascimento");
				String[] dataNascimento = dataDeNascimento.split("/");
				TipoEstadoCivil estadoCivil = TipoEstadoCivil.valueOf(request.getParameter("estadoCivil").toUpperCase());
				TipoGenero genero = TipoGenero.valueOf(request.getParameter("genero").toUpperCase());
				int telefone = Integer.parseInt(request.getParameter("telefone"));
				String email = request.getParameter("email");
				String pais= request.getParameter("pais");
				String cidade= request.getParameter("cidade");
				String rua= request.getParameter("rua");
				
				PrintWriter out = response.getWriter();
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
				
				int idMorada=0;
				int idPessoa = 0;
				
				try {
					idMorada = utilitario.novoIdMorada();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					idPessoa = utilitario.novoIdPessoa();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				Morada morada = new Morada(idMorada, pais, cidade, rua);
				utilitario.registoMorada(morada);
				Pessoa pessoa = new Pessoa(idPessoa, nome, new Date(Integer.parseInt(dataNascimento[2]), Integer.parseInt(dataNascimento[1]), Integer.parseInt(dataNascimento[0])), estadoCivil, genero, telefone, email, morada);
				utilitario.registoPessoa(pessoa);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
