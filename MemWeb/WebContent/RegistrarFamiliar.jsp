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
		
		Local de Nascimento:
		País <input type="text" id="pais_nascimento" name="pais_nascimento" size="40px"><br>
		Região: <input type="text" id="regiao_nascimento" name="regiao_nascimento" size="40px"><br>
		Cidade <input type="text" id="cidade_nascimento" name="cidade_nascimento" size="40px"><br>
		
		Género: <select name="genero">
			<option value="Masculino">Masculino</option>
			<option value="Feminino">Feminino</option>
		</select><br>
		
		Estado Civil: <select name="estadoCivil">
			<option value="Solteiro">Solteiro</option>
			<option value="Casado">Casado</option>
			<option value="Divorciado">Divorciado</option>
			<option value="Viuvo">Viúvo</option>
		</select> <br>
		
		Profissão: <input type="text" id="profissao" name="profissao" size="40px"><br>
		
		
		<input type="submit" value="submit">
	</form>
	<!-- <form action="${pageContext.request.contextPath}/Home.jsp"> -->
	 <form action="Inicial">
		<input type="submit" name="voltarInicio" value="voltar ao Inicio">
	</form>
</body>
</html>