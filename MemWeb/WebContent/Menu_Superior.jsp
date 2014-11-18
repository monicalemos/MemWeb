<%-- 
    Document   : Menus
    Created on : 11/nov/2014, 1:43:57
    Author     : Utilizador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section id="page">
		<div id="menu">
			<div class="line"></div>
			<ul>
				<li><a name="home" href="LoggedPage.jsp">Home</a></li>
				<li><a name="ver_pacientes" href="./ServletInicial?accao=verPacientes">Ver Pacientes</a></li>
				<li><a href="./Inicial?accao=registrarPaciente">Registrar Novo Paciente</a></li>
				<li><a href="./ServletInicial?accao=evolucaoPacientes">Evolução dos Pacientes</a></li>
			</ul>
		</div>
	</section>
    </body>
</html>
