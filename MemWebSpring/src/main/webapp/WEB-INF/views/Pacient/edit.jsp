<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>
	<div class="container-fluid">
		<div>
			<h1>Editar</h1>
		</div>
		<div class="row-fluid">

			<form:form action="Edit" modelAttribute="PacienteModel">
				<%@include file="partial/editable.jsp"%>
				<input type="submit" value="Submit" />
			</form:form>
		</div>
	</div>
</div>