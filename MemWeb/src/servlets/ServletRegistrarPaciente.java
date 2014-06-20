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
import javax.servlet.http.HttpSession;

import classesDados.Morada;
import classesDados.Paciente;
import classesDados.Pessoa;
import classesDados.Utilizador;
import enumerados.TipoEstadoCivil;
import enumerados.TipoGenero;
import gestor.Utilitario;


@WebServlet("/Servlet")
public class ServletRegistrarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilitario utilitario = new Utilitario();
		session = request.getSession();
		
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
		String nomeMedico= request.getParameter("nomeMedico");
		int telefoneMedico = Integer.parseInt(request.getParameter("telefoneMedico"));
		int nivelDoenca = Integer.parseInt(request.getParameter("nivelDoenca"));		
		String dataDeDiagnostico = request.getParameter("dataDiagnostico");
		String[] dataDiagnostico = dataDeDiagnostico.split("/");
		
		PrintWriter out = response.getWriter();
		out.println ( 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\n" +
						"<html> \n" +
		   "<head> \n" +
		   "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
		   "<title> Dados do Cliente  </title> \n" +
		   "</head> \n" +
		   "<body> \n" + "<h1> Dados do Paciente:</h1><br> \n" + 
		   "Nome: " + nome + "<br>\n" +
		   "Data de Nascimento: " + dataDeNascimento + "<br>\n" +
		   "Estado Civil: " + estadoCivil + "<br>\n" +
		   "Género: " + genero + "<br>\n" +
		   "Telefone: " + telefone + "<br>\n" + 
		   "Email: " + email + "<br>\n" + 
		   "Morada: " + pais + ", " + cidade + ", rua " + rua +"<br>\n" +
		   "Nome do Médico: " + nomeMedico + "<br>\n" +
		   "Telefone do médico: " + telefoneMedico + "<br>\n" + 
		   "Nível de Doença: " + nivelDoenca + "<br>\n" +
		   "Data de Diagnóstico: " + dataDeDiagnostico + "<br\n" + 
		   "<form action = \"Inicial\">" + 
		   "<input type =\"submit\" name=\"voltarInicio\" value =\"Voltar ao Inicio\">"+ 
		   "</form>" + 
		   "</body> \n" +
		"</html>" );
		
		int idMorada=0;
		int idPaciente = 0;
		
		try {
			idMorada = utilitario.novoIdMorada();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			idPaciente = utilitario.novoIdPaciente();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Morada morada = new Morada(idMorada, pais, cidade, rua);
		utilitario.registoMorada(morada);
		
		Pessoa medico = new Pessoa(nomeMedico, telefoneMedico);
		//TODO tem de ser acrescentado o resp medico de login
		Paciente paciente = new Paciente(idPaciente, nome, new Date(Integer.parseInt(dataNascimento[2]), Integer.parseInt(dataNascimento[1]), Integer.parseInt(dataNascimento[0])), estadoCivil, genero, telefone, email, morada, medico.getNomeCompleto(), medico.getTelefone(), new Date(Integer.parseInt(dataDiagnostico[2]), Integer.parseInt(dataDiagnostico[1]), Integer.parseInt(dataDiagnostico[0])), nivelDoenca, (Utilizador) session.getAttribute("respMedico"));	
		utilitario.registoPaciente(paciente);
	}
}
