<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page session="false"%> --%>
<fieldset>
	<div class="control-group">
		<div class="controls"><form:hidden path="id" /></div>
		<div class="controls"><form:hidden path="patientId" /></div>
	</div>
	<div class="control-group">
		<label for="firstName" class="control-label">Nome:</label>
		<div class="controls">
			<form:input path="firstName" cssClass="input-sm focused" id="firstName"/>
			<font color="red"><form:errors path="firstName" /></font><br/>
		</div>
		<label for="middleName" class="control-label">Nome do Meio:</label>
		<div class="controls">
			<form:input path="middleName" cssClass="input-sm focused" id="middleName"/>
			<font color="red"><form:errors path="middleName" /></font><br/>
		</div>
		<label for="lastName" class="control-label">Apelido:</label>
		<div class="controls">
			<form:input path="lastName" cssClass="input-sm focused" id="lastName"/>
			<font color="red"><form:errors path="lastName" /></font><br/>
		</div>
	</div>		
	
	<div class="control-group">
		<label for="dateOfBirth" class="control-label">Data de Nascimento:</label>
		<div class="controls">
			<form:input  path="dateOfBirth" cssClass="input-sm focused" id="dateOfBirth" />
			<font color="red"><form:errors path="dateOfBirth" /></font><br/>
		</div>
	</div>
	<div class="control-group">
		<label for="dateOfDeath" class="control-label">Data de �bito:</label>
		<div class="controls">
			<form:input  path="dateOfDeath" cssClass="input-sm focused" id="dateOfDeath" />
			<font color="red"><form:errors path="dateOfDeath" /></font><br/>
		</div>
	</div>
	<div class="control-group">
		<label for="isCareGiver" class="control-label">� "Cuidador?":</label>
		<div class="controls">
			<form:checkbox   path="isCareGiver" cssClass="input-sm focused" id="isCareGiver" />
			<font color="red"><form:errors path="isCareGiver" /></font><br/>
		</div>
	</div>
	<div class="control-group">
		<label for="gender" class="control-label">G�nero:</label>
		<div class="controls">
			<form:input path="gender" cssClass="input-sm focused" id="gender"/>
			<font color="red"><form:errors path="gender" /></font><br/>
		</div>
	</div>
	<div class="control-group">
		<label for="maritalStatus" class="control-label">Estado Civil:</label>
		<div class="controls">
			<form:input path="maritalStatus" cssClass="input-sm focused" id="maritalStatus"/>
			<font color="red"><form:errors path="maritalStatus" /></font><br/>
		</div>
	</div>
	<div class="control-group">
		<label for="profession" class="control-label">Profiss�o:</label>
		<div class="controls">
			<form:input path="profession" cssClass="input-sm focused" id="profession"/>
			<font color="red"><form:errors path="profession" /></font><br/>
		</div>
	</div>
</fieldset>

<fieldset>
	<div class="control-group">
		<label for="address.country" class="control-label">Pa�s:</label>
		<div class="controls">
			<form:input path="address.country" cssClass="input-sm focused" id="address.country"/>
			<font color="red"><form:errors path="address.country" /></font><br/>
		</div>
				<label for="address.region" class="control-label">Regi�o:</label>
		<div class="controls">
			<form:input path="address.region" cssClass="input-sm focused" id="address.region"/>
			<font color="red"><form:errors path="address.region" /></font><br/>
		</div>
				<label for="address.city" class="control-label">Cidade:</label>
		<div class="controls">
			<form:input path="address.city" cssClass="input-sm focused" id="address.city"/>
			<font color="red"><form:errors path="address.city" /></font><br/>
		</div>
		
	</div>

</fieldset>