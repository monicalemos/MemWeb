<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page session="false"%> --%>
<fieldset>
	<div class="control-group">
		<div class="controls">
			<form:hidden path="id" />
		</div>
	</div>
	<div class="control-group">
		<label for="nome" class="control-label">Nome Completo:</label>
		<div class="controls">
			<form:input path="nome_completo" cssClass="input-xlarge focused" id="nome"/>
			<font color="red"><form:errors path="nome_completo" /></font><br/>
		</div>
	</div>
	<div class="control-group">
		<label for="data_nascimento" class="control-label">Data de Nascimento:</label>
		<div class="controls">
			<form:input path="data_de_nascimento" cssClass="input-xlarge focused" id="data_nascimento"/>
			<font color="red"><form:errors path="data_de_nascimento" /></font><br/>
		</div>

	</div>
	<div class="control-group">
		<label for="local_nascimento" class="control-label">Local de Nascimento</label>
		<div class="controls">
			<form:input path="local_nascimento" cssClass="input-xlarge focused" id="local_nascimento"/>
			<font color="red"><form:errors path="local_nascimento" /></font><br/>
		</div>

	</div>

</fieldset>