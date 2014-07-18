package servlets;

import enumerados.TipoUtilizador;
import gestor.Utilitario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classesDados.Familiar;
import classesDados.Paciente;
import classesDados.Tecnico;

@WebServlet("/ServletInicial")
public class ServletInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	
	private Tecnico tecnico;
	private Paciente paciente;
	private Familiar familiar;
	
//	private Utilizador utilizador;

	public ServletInit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("entrei no inicial");
		System.out.println(request.getParameter("accao"));
		
		if (request.getParameter("RegistrarPaciente")!=null) {

			System.out.println("Cliquei no registrar Paciente");
			request.setAttribute("RegistrarPaciente", request.getServletPath());
			RequestDispatcher rd = request.getRequestDispatcher("/RegistrarPaciente.jsp");
			if (rd != null)
				rd.forward(request, response);

		} else if (request.getParameter("RegistrarPessoa")!=null) {

			System.out.println("Cliquei no registrar Pessoa");
			request.setAttribute("RegistrarPessoa", request.getServletPath());
			RequestDispatcher rd = request.getRequestDispatcher("/RegistrarPessoa.jsp");
			if (rd != null)
				rd.forward(request, response);

		} else if (request.getParameter("verDados")!=null) {
			System.out.println("Cliquei no ver Dados");
			request.setAttribute("verDados", request.getServletPath());
			RequestDispatcher rd = request.getRequestDispatcher("/VerDados");
			if (rd != null)
				rd.forward(request, response);
		}
		else if(request.getParameter("voltarInicio")!=null){
			System.out.println("cliquei no voltar ao inicio");
			ServletContext sc = this.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/PaginaOperacao.jsp");
			//			//request.setAttribute("voltarInicio", request.get);
			//			RequestDispatcher rd = request.getRequestDispatcher("${pageContext.request.contextPath}/Home.jsp");
			if (rd != null)
				rd.forward(request, response);
		}

//		else if(request.getParameter("accao").equals("registrarUtilizador")){
//			System.out.println("Cliquei no registrar Utilizador");
//			request.setAttribute("registrarUtilizador", request.getServletPath());
//			RequestDispatcher rd = request.getRequestDispatcher("/RegistrarUtilizador.jsp");
//			if (rd != null)
//				rd.forward(request, response);
//		}

		else if(request.getParameter("accao").equals("validar")){
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("ENTREI...");
			System.out.println("Cliquei no efectuar login");
			
			session = request.getSession();
			session.setAttribute("msgErroAutenticacao", "");

			System.out.println(request.getParameter("accao"));

			String user = request.getParameter("user").trim();
			String pass = request.getParameter("password").trim();

			Utilitario utilitario = new Utilitario();
			
			paciente = utilitario.devolve_Paciente(user, pass);
			familiar = utilitario.devolve_Familiar(user, pass);
			tecnico = utilitario.devolve_Tecnico(user, pass);

			if (paciente != null) {
				System.out.println("encontrei o paciente");

				session = request.getSession();
				session.setAttribute("tipo_utilizador", TipoUtilizador.PACIENTE);
				session.setAttribute("username", paciente.getNome_utilizador());
				session.setAttribute("nome_utilizador", paciente.getNome_completo());
				session.setAttribute("idUtilizador", paciente.getId());
				session.setAttribute("validado", "sim");
				System.out.println(session.getAttribute("nome_utilizador"));
				String ret = "LoggedPage.jsp";
				response.sendRedirect(ret);
			}
			
			else if(familiar != null) {
				System.out.println("encontrei o familiar");

				session = request.getSession();
				session.setAttribute("tipo_utilizador", TipoUtilizador.CUIDADOR);
				session.setAttribute("username", familiar.getNome_utilizador());
				session.setAttribute("nome_utilizador", familiar.getNome_completo());
				session.setAttribute("idUtilizador", familiar.getId());
				session.setAttribute("validado", "sim");
				System.out.println(session.getAttribute("nome_utilizador"));
				String ret = "LoggedPage.jsp";
				response.sendRedirect(ret);
			}
			
			else if(tecnico != null) {
				System.out.println("encontrei o tecnico");

				session = request.getSession();
				session.setAttribute("tecnico", tecnico);
				session.setAttribute("tipo_utilizador", TipoUtilizador.TECNICO);
				session.setAttribute("username", tecnico.getNome_utilizador());
				session.setAttribute("nome_utilizador", tecnico.getNome_completo());
				session.setAttribute("idUtilizador", tecnico.getId());
				session.setAttribute("validado", "sim");
				System.out.println(session.getAttribute("nome_utilizador"));
				String ret = "LoggedPage.jsp";
				response.sendRedirect(ret);
			}
			
			else{
				System.out.println("erro a autenticar");
				session.setAttribute("msgErroAutenticacao", "Email e/ou password incorrectos");
				String ret = "Home.jsp";
				response.sendRedirect(ret);
			}

			//			if (respMedico != null) {
			//			
			//				request.setAttribute("login", request.getServletPath());
			//				RequestDispatcher rd = request.getRequestDispatcher("/PaginaOperacao.jsp");
			//				if (rd != null){
			//					session = request.getSession();
			//					session.setAttribute("email", email);
			//					session.setAttribute("nome_completo", respMedico.getNomeCompleto());
			//					session.setAttribute("idRespMedico", respMedico.getId());
			//					session.setAttribute("validado", "sim");
			//					System.out.println(session.getAttribute("nome_completo"));
			//					rd.forward(request, response);
			//				}
			//			}
		}

	}
	//		else if(request.getParameter("logout")!=null){
	//			System.out.println("Cliquei no Logout");
	//			request.setAttribute("logout", request.getServletPath());
	//			RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
	//			if (rd != null){
	//				session = request.getSession();
	//				session.setAttribute("validado", "nao");
	//				session.setAttribute("msgErroAutenticacao", "");
	//				rd.forward(request, response);
	//			}
	//		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
