<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>
	<div class="container-fluid">
		<div>
			<h1>Apagar Registo</h1>
			<a class="brand"
				href="<%=request.getContextPath()%>/Technician"> <img
				src="<%=request.getContextPath()%>/resources/static/img/24x24/go-back-icon.png"
				alt="Go Back" title="Go Back" />
			</a>
		</div>
		<div class="row-fluid">

			<form:form action="Delete" modelAttribute="technicianModel">
				<%@include file="partial/readable.jsp"%>
			</form:form>
		</div>
	</div>
</div>