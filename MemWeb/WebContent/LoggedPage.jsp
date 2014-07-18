<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mem+</title>
</head>
<body>

<h1 >Olá : <%= session.getAttribute("nome_completo") %></h1>
 <form action="Inicial">
    <input type="submit" name="RegistrarPaciente" value="Registrar Paciente" /><br>
    <input type="submit" name="RegistrarFamiliar" value="Registrar Familiar" /><br>
    <input type="submit" name="verDados" value="ver dados" />
    <input type="submit" name="logout" value="Logout" />
</form> 

</body>
</html>
