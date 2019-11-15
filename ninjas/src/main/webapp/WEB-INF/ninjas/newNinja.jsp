<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
		<title>Dojo Ninjas</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
		<h1>New Ninja</h1>
		<a href="/">Home</a> | <a href="dojos">Create Dojo</a>
		
		
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
			<form:label path="first_name">First Name:
			<form:errors path="first_name"/>
			<form:input path="first_name"/></form:label>
			<form:label path="last_name">Last Name:
			<form:errors path="last_name"/>
			<form:input path="last_name"/></form:label>
			<form:label path="age">Age:
			<form:errors path="age"/>
			<form:input path="age" type="number"/></form:label>
			<form:label path="dojo">Dojo:
			<form:select path="dojo">
				<c:forEach items="${dojos}" var="dojo">
        				<form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
   				</c:forEach>
			</form:select></form:label>
			<input type="submit" value="Create Ninja">
		</form:form>
	</div>
	</body>
</html>