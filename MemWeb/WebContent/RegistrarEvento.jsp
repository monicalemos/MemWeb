<!DOCTYPE html>
<html>
<%@ page import="java.util.*"%>
<%@ page import="classesDados.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<head>

<link rel="stylesheet" href="Styles/Paciente.css">
<title>MEM+</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script type="text/javascript">

function show(group)
{
	 /*var visSetting = (checkbox.checked) ? "visible" : "hidden";*/ 
	 document.getElementById(group).style.visibility = "visible"; 
}

</script>
<body>
	<div class="content">
		<header>
			<img id="logo" src="images/mem+.png"
				onclick="window.location.href='LoggedPage.jsp'" />

			<div id="containerLogout">
				<h2>
					Ol� :
					<%=session.getAttribute("nome_utilizador")%></h2>
				<form action="./Inicial?accao=logout" method="post">
					<div id="lower">
						<input type="submit" name="logout" value="Logout" />
					</div>
				</form>
			</div>

		</header>

		<div id="menu">
			<div class="line"></div>
			<ul>
				<li><a href="./LoggedPage.jsp">Home</a></li>
				<li><a class="selected"
					href="./ServletInicial?accao=verPacientes">Ver Pacientes</a></li>
				<li><a href="./RegistrarPaciente.jsp">Registrar Novo
						Paciente</a></li>
				<li><a href="./ServletInicial?accao=evolucaoPacientes">Evolu��o
						dos Pacientes</a></li>
			</ul>
		</div>

		<div id="menu-lateral">
			<div class="line"></div>
			<ul>
				<li><a href="./ServletInicial?accao=verPaciente">Dados do Paciente</a></li>
				<!--<li><a href="./ServletInicial?accao=registrarFamiliar">Inserir
						Familiar</a></li>-->
				<li><a href="./ServletInicial?accao=verFamiliares">Ver
						Familiares</a></li>
				<!--<li><a class="selected" href="./ServletInicial?accao=novoEvento">Inserir
						Evento</a></li>-->
				<li><a href="./ServletInicial?accao=verEventos">Ver Eventos</a></li>
			</ul>
		</div>

		<div id="container">
			<form id="RegistrarEvento" action="RegistrarEvento">
				<header id="header" class="info">
					<h2>Novo Evento</h2>
				</header>
								
				<%
                                Paciente u = (Paciente) session.getAttribute("paciente");
                                session.setAttribute("paciente", u);
                               // Relacao r = (Relacao) session.getAttribute("relacao");
                                %>
                        
				<label for="data_evento">Data do Evento: (aaaa-mm-dd)</label> 
				<input type="text" id="data_evento" name="data_evento"> 
				<br> 
				
				<label for="tipo_evento">Tipo de Evento</label> 
				<select name="tipo_evento" id="tipo_evento">
						<option value="Nascimento">Nascimento</option>
						<option value="Baptizado">Baptizado</option>
						<option value="Anivers�rio">Anivers�rio</option>
						<option value="Noivado">Noivado</option>
						<option value="Casamento">Casamento</option>
						<option value="Festa">Festa</option>
						<option value="Morte">Morte</option>
						<option value="Funeral">Funeral</option>
					</select> 
				<br> 
				
				<label for="morada_evento">Morada do Evento: </label> 
				<br>
				<label2 for="pais">Pa�s:</label2>
				<input type="text" id="pais_evento" name="pais_nascimento" size="40px"> 
				<br>
				<label2 for="regiao">Regi�o: </label2>
				<input type="text" id="regiao_evento" name="regiao_nascimento" size="40px"> 
				<br>
				<label2 for="cidade">Cidade: </label2>
				<input type="text" id="cidade_evento" name="cidade_nascimento" size="40px"> 
				<br> 
				
				<label for="descricao_evento">Descri��o do Evento:</label> 
				<textarea id="descricao_evento" name="descricao_evento" rows="5" cols="60">
				</textarea>
				<br> 
				
				<label for="fotografia">Insira uma fotografia do evento:</label>
                                <input type="file" name="pic" accept="image/*">
                                <input type="submit">
                                <br>
                                
				<div class="checkbox">
					<input type="checkbox" value="1" id="temFamiliar" onclick="show('myGroup');"/><label for="temFamiliar">Esteve um familiar presente</label>
					<label for="checkboxInput"></label>
				</div><br>
				
				<span id="myGroup" style="visibility:hidden" >
					<label for="nome_familiar">Nome do Familiar</label> 
					
					<select name="nome_familiar" id="nome_familiar">
					 <% ArrayList<Familiar> list = new ArrayList<Familiar>(); 
						Object lista_familiares = session.getAttribute("lista_familiares");  
						Paciente paciente = (Paciente)session.getAttribute("paciente");
						list = (ArrayList<Familiar>)lista_familiares; 
					
						ArrayList familiares = new ArrayList(); 
						for(Familiar f : list){
							Map pac = new HashMap();			
							pac.put("id", f.getId());
							pac.put("nome_proprio", f.getNomeProprio());
							pac.put("apelido", f.getApelido());
							familiares.add(pac);
						}
						pageContext.setAttribute("familiares", familiares);
						%>
				
						<c:forEach items="${familiares}" var="current">
							
								<option value="${current.id}">${current.nome_proprio} ${current.apelido}</option>
								
				
				  		</c:forEach>
					</select> 
				</span>
				
				<div id="lower">
					<input type="submit" value="Registar">
				</div>

			</form>
		</div>
	</div>

	<footer>
		<p>Copyright 2014 - MEM +</p>
	</footer>
</body>
</html>