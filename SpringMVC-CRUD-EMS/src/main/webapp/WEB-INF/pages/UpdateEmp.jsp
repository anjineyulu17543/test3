<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<form action="update" method="post">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">ID</label> <input
				type="text" class="form-control" id="id" name="id" readonly
				value="<c:out value="${emp.id}" />">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Name</label>
			<input type="text" class="form-control" id="name" name="name"
				value="<c:out value="${emp.name}" />">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Email</label>
			<input type="text" class="form-control" id="email" name="email"
				value="<c:out value="${emp.email}" />">
		</div>

		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Salary</label>
			<input type="text" class="form-control" id="salary" name="salary"
				value="<c:out value="${emp.salary}" />">
		</div>
		
		<div>
			<button type="submit" class="btn btn-primary">Update</button>
		</div>
	</form>
</body>
<script>
	var stdDepartment = "<c:out value="${std.dept}" />";

	var selectElement = document.getElementById("dept");

	for (var i = 0; i < selectElement.options.length; i++) {
		if (selectElement.options[i].value === stdDepartment) {
			selectElement.options[i].selected = true;
			break;
		}
	}
</script>
</html>