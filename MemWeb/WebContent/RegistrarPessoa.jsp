<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="RegistrarPessoa">
		<h1>Dados da Pessoa</h1><br> 
		Nome Completo: <input type="text" id="nome" name="nome"	size="40px"> <br>
		Data de Nascimento: (dd/mm/aaaa) <input type="text" id="dataNascimento" name="dataNascimento" size="40px"><br>
		Estado Civil: <select name="estadoCivil">
			<option value="Solteiro">Solteiro</option>
			<option value="Casado">Casado</option>
			<option value="Divorciado">Divorciado</option>
			<option value="Viuvo">Viúvo</option>
		</select> <br>
		Género: <select name="genero">
			<option value="Masculino">Masculino</option>
			<option value="Feminino">Feminino</option>
		</select><br>
		Telefone: <input type="int" id="telefone" name="telefone" size="40px"><br>
		Email: <input type="text" id="email" name="email" size="40px"><br>
		Morada:
		País <input type="text" id="pais" name="pais" size="40px"><br>
		Cidade <input type="text" id="cidade" name="cidade" size="40px"><br>
		Rua: <input type="text" id="rua" name="rua" size="40px"><br>
		<input type="submit" value="submit">
	</form>
	<!-- <form action="${pageContext.request.contextPath}/Home.jsp"> -->
	 <form action="Inicial">
		<input type="submit" name="voltarInicio" value="voltar ao Inicio">
	</form>
</body>
</html>