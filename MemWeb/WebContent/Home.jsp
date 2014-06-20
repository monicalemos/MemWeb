<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Styles/Home.css">
<title>MEM+</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<header>
		<img id="logo" src="images/mem+.png"
			onclick="window.location.href='Home.jsp'" />

		<div id="container">
			<form action="./ServletInicial?accao=validar" method="post">
				<label for="email">Email:</label> <input type="email" id="var_email"
					name="email" required="required"> <br>
					<label for="password">Password:</label>
				<input type="password" id="var_password" name="password"
					required="required">

				<%
					if (session.getAttribute("msgErroAutenticacao") == null) {
						session.setAttribute("msgErroAutenticacao", "");
					}
				%>
				<%=session.getAttribute("msgErroAutenticacao") %>
				<div id="lower">
					<p>
						<a style="font-size: 18px; color: red;"
							href="./RegistrarUtilizador.jsp">Registe-se!</a>
					</p>
					<input type="submit" value="login">
				</div>
				<!--/ lower-->
			</form>
		</div>
	</header>

	<section id="page">
		<div id="menu">
			<div class="line"></div>
			<ul>
				<li><a class="selected" href="Home.jsp">Home</a></li>
				<li><a href="SobreNos.jsp">Sobre Nós</a></li>
				<li><a href="./ServletInicial?accao=contactos">Contactos</a></li>
				<%=session.getAttribute("informações")%>
			</ul>
		</div>
	</section>
	<footer>
		<p>Copyright 2014 - MEM +</p>
	</footer>
</body>
</html>