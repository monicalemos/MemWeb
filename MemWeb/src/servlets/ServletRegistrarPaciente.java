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
import classesDados.Tecnico;
import enumerados.EspecialidadeMedico;
import enumerados.TipoEscolaridade;
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
		
		String 	dataDeNascimento = request.getParameter("data_nascimento");
		String[] dataNascimento = dataDeNascimento.split("/");
		Date data_nascimento = new Date(Integer.parseInt(dataNascimento[2]), Integer.parseInt(dataNascimento[1]), Integer.parseInt(dataNascimento[0]));
		
		String paisNascimento = request.getParameter("pais_nascimento");
		String regiaoNascimento = request.getParameter("regiao_nascimento");
		String cidadeNascimento = request.getParameter("cidade_nascimento");
		
		String paisMorada = request.getParameter("pais_morada");
		String regiaoMorada = request.getParameter("regiao_morada");
		String cidadeMorada = request.getParameter("cidade_morada");
		
		TipoGenero genero = TipoGenero.valueOf(request.getParameter("genero").toUpperCase());
		String profissao = request.getParameter("profissao");
		TipoEscolaridade escolaridade = TipoEscolaridade.valueOf(request.getParameter("escolaridade").toUpperCase());
		TipoEstadoCivil estadoCivil = TipoEstadoCivil.valueOf(request.getParameter("estado_civil").toUpperCase());
		
		int nivelDoenca = Integer.parseInt(request.getParameter("nivel_doenca"));
		String nomeMedico= request.getParameter("nome_medico");
		EspecialidadeMedico especialidadeMedico = EspecialidadeMedico.valueOf(request.getParameter("especialidade_medico").toUpperCase());
				
		String nomeUtilizador = request.getParameter("nome_utilizador");
		String password = request.getParameter("password");
		
		int nivelSessao = Integer.parseInt(request.getParameter("nivel_sessao"));
		
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
		   "Local de Nascimento: " + paisNascimento + ", " + regiaoNascimento + ", rua " + cidadeNascimento +"<br>\n" +
		   "Morada Atual: " + paisMorada + ", " + regiaoMorada + ", rua " + cidadeMorada +"<br>\n" +
		   "Género: " + genero + "<br>\n" +
		   "Profissão " + profissao + "<br>\n" +
		   "Escolaridade " + escolaridade + "<br>\n" +
		   "Estado Civil: " + estadoCivil + "<br>\n" +
		   "Nível de donça " + nivelDoenca + "<br>\n" +
		   "Nome do Médico " + nomeMedico + "<br>\n" +
		   "Especialidade do Médico " + especialidadeMedico + "<br>\n" +
		   "Nome de Utilizador " + nomeUtilizador + "<br>\n" +
		   "Nivel de Sessao " + nivelSessao + "<br>\n" + 
		   "<form action = \"Inicial\">" + 
		   "<input type =\"submit\" name=\"voltarInicio\" value =\"Voltar ao Inicio\">"+ 
		   "</form>" + 
		   "</body> \n" +
		"</html>" );
		
		int idLocalNascimento = 0;
		int idMorada=0;
		int idPaciente = 0;
		
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
			idPaciente = utilitario.novoId_Paciente();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Morada localNascimento = new Morada(idLocalNascimento, paisNascimento, regiaoNascimento, cidadeNascimento);
		Morada morada = new Morada(idMorada, paisMorada, regiaoMorada, cidadeMorada);
		utilitario.registo_Morada(localNascimento);
		utilitario.registo_Morada(morada);
		
		Tecnico tecnico = (Tecnico) session.getAttribute("tecnico");
		
		//TODO tem de ser acrescentado o resp medico de login
		Paciente paciente = new Paciente(idPaciente, nome, data_nascimento, localNascimento, morada, genero, profissao, escolaridade, nivelDoenca, nomeMedico, especialidadeMedico, nomeUtilizador, password, nivelSessao, tecnico);
			
		utilitario.registo_Paciente(paciente);
	}
}
