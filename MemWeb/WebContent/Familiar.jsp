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
<body>
<div class="content">
	<header>
		<img id="logo" src="images/mem+.png"
			onclick="window.location.href='LoggedPage.jsp'" />

		<div id="containerLogout">
			<h2>
				Olá :
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
				<li><a href="./ServletInicial?accao=evolucaoPacientes">Evolução
						dos Pacientes</a></li>
			</ul>
		</div>
		
		<div id="menu-lateral">
			<div class="line"></div>
			<ul>
				<li><a href="./ServletInicial?accao=verPaciente">Dados do Paciente</a></li>
				<li><a href="./ServletInicial?accao=registrarFamiliar">Inserir
						Familiar</a></li>
				<li><a class="selected" href="./ServletInicial?accao=verFamiliares">Ver
						Familiares</a></li>
				<li><a href="./ServletInicial?accao=novoEvento">Inserir
						Evento</a></li>
				<li><a href="./ServletInicial?accao=verEventos">Ver Eventos</a></li>
			</ul>
		</div>

		<div id="container">
			<h2>Dados do Familiar</h2>
			<%
				Familiar p = (Familiar) session.getAttribute("familiar");
                               // Relacao r = (Relacao) session.getAttribute("relacao");
			%>
			<label for="nome"> Nome: <%=p.getNome_completo()%></label><br> <label
				for="data_nascimento"> Data de Nascimento: <%=p.getData_de_nascimento()%></label><br>
			<label for="local_nascimento"> Local de Nascimento: <%=p.getLocal_nascimento()%></label><br>
			<label for="morada_atual"> Morada Atual: <%=p.getMorada()%></label><br>
			<label for="profissao"> Profissão: <%=p.getProfissao()%></label><br>
			<label for="estado_civil"> Estado civil: <%=p.getEstado_civil()%></label><br>
                       <!-- <label for="parentesco"> Relação com Paciente:</label><br> -->
			<label for="eCuidador"> É cuidador?: <%=p.eCuidador()%></label><br>

		</div>
	</div>

	<footer>
		<p>Copyright 2014 - MEM +</p>
	</footer>
</body>
</html>
