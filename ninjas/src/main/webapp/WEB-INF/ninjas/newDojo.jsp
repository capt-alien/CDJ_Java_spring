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
		<h1>New Dojo</h1>
		<a href="/">Home</a> | <a href="/ninjas/new">Create Ninja</a>
		<form:form action="/dojos/new" method="post" modelAttribute="dojo">
			<form:label path="name">Name:
			<form:errors path="name"/>
			<form:input path="name"/></form:label>
			<input type="submit" value="Create Dojo">
		</form:form>
	</div>
	</body>
</html>