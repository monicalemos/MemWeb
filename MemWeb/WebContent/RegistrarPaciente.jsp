<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="RegistrarPaciente">
		<h1>Dados do Paciente</h1><br> 
		Nome Completo: <input type="text" id="nome" name="nome"	size="40px"> <br>
		Data de Nascimento: (dd/mm/aaaa) <input type="text" id="data_nascimento" name="data_nascimento" size="40px"><br>
		
		Local de Nascimento:
		País <input type="text" id="pais_nascimento" name="pais_nascimento" size="40px"><br>
		Região: <input type="text" id="regiao_nascimento" name="regiao_nascimento" size="40px"><br>
		Cidade <input type="text" id="cidade_nascimento" name="cidade_nascimento" size="40px"><br>
		
		Morada Atual:
		País <input type="text" id="pais_morada" name="pais_morada" size="40px"><br>
		Região: <input type="text" id="regiao_morada" name="regiao_morada" size="40px"><br>
		Cidade <input type="text" id="cidade_morada" name="cidade_morada" size="40px"><br>
		
		Género: <select name="genero">
			<option value="Masculino">Masculino</option>
			<option value="Feminino">Feminino</option>
		</select><br>
		
		Profissão: <input type="text" id="profissao" name="profissao" size="40px"><br>
		
		Escolaridade: <select name="escolaridade">
			<option value="Ensino_Basico">Ensino Básico</option>
			<option value="Secundario">Secundário</option>
			<option value="Licenciatura">Licenciatura</option>
			<option value="Pos_Graduacao">Pós-Graduação</option>
			<option value="Mestrado">Mestrado</option>
			<option value="Douturamento">Douturamento</option>
		</select> <br>
		
		Estado Civil: <select name="estado_civil">
			<option value="Solteiro">Solteiro</option>
			<option value="Casado">Casado</option>
			<option value="Divorciado">Divorciado</option>
			<option value="Viuvo">Viúvo</option>
		</select> <br>
		
		Nível de Doença: <select name="nivel_doenca">
			<option value="1">1</option> <option value="2">2</option>
			<option value="3">3</option> <option value="4">4</option>
			<option value="5">5</option> <option value="6">6</option>
			<option value="7">7</option> <option value="8">8</option>
			<option value="9">9</option> <option value="10">10</option>
		</select><br>
		
		Nome do Médico: <input type="text" id="nomeMedico" name="nomeMedico" size="40px"><br>
		Especialidade do Médico: <select name="especialidade_medico">
			<option value="Neurologista">Neurologista</option>
			<option value="Psiquiatra">Psiquiatra</option>
		</select> <br>
		
		Nome de Utilizador: <input type="text" id="nome_utilizador" name ="nome_utilizador" size="40px"><br>
		Password: <input type="password" id="password" name ="password" size="40px"><br>		
		<input type="submit" value="submit">
	</form>
	<!-- <form action="${pageContext.request.contextPath}/Home.jsp"> -->
	 <form action="Inicial">
		<input type="submit" name="voltarInicio" value="voltar ao Inicio">
	</form>
</body>
</html>