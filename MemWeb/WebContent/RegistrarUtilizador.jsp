<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Styles/Registo.css">
<title>MEM+</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<header>
		<hgroup>
			<h1>
				<img id="logo" src="images/mem+.png"
					onclick="window.location.href='Home.jsp'" />
			</h1>
		</hgroup>
	</header>
	<div id="page">
		<div id="menu">
			<div class="line"></div>
			<ul>
				<li><a class="selected" href="Home.jsp">Home</a></li>
				<li><a href="./ServletInicial?accao=sobreNos">Sobre Nós</a></li>
				<li><a href="./ServletInicial?accao=contactos">Contactos</a></li>
			</ul>
		</div>
		<div id="container">
			<form id="RegistrarUtilizador" action="RegistrarUtilizador">
				<header id="header" class="info">
					<h2>Novo Registo</h1>
				</header>

				<label for="nome">Nome Completo:</label> 
				<input type="text" id="nome" name="nome"> 
				<br> 
				
				<label for="dataNascimento">Data de Nascimento (dd/mm/aaaa):</label> 	
				<input type="text" id="dataNascimento" name="dataNascimento"><br>
				
				<label for="genero">Género:</label> 
				<select name="genero">
					<option value="Masculino">Masculino</option>
					<option value="Feminino">Feminino</option>
				</select><br> 
				
				<label for="telefone">Telefone:</label> 
				<input type="int" id="telefone" name="telefone"><br> 
				
				<label for="email">Email:</label> 
				<input type="text" id="email" name="email"><br> 
				
				<label for="morada">Morada:</label> <br>
				<label for="pais">Pais:</label> 
				<input type="text" id="pais" name="pais"><br>
				
				<label for="cidade">Cidade:</label> 
				<input type="text" id="cidade" name="cidade"><br>
				
				<label for="rua">Rua:</label> 
				<input type="text" id="rua" name="rua" size="40px"><br>
				
				<label for="password">Password:</label> 
				<input type="password" id="password" name="password"><br> 
				
				<label for="tipoUtilizador">Tipo de Utilizador:</label> 
				<select name="tipo_utilizador">
					<option value="Psicologo">Psicologo</option>
					<option value="Medico">Medico</option>
					<option value="Enfermeiro">Enfermeiro</option>
				</select><br>
				<div id="lower">
					<input type="submit" value="Registar">
				</div>
			</form>
			<!-- <form action="${pageContext.request.contextPath}/Home.jsp"> -->
	</div>
	</section>
	<footer>
		<p>Copyright 2014 - MEM +</p>
	</footer>
</body>
</html>