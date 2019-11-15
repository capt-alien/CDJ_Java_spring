<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<html>
	<head>
		<title>Dojo Ninjas</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
		<h1>Dojo Ninjas</h1>
		<a href="/dojos/new">Create Dojo</a> | <a href="/ninjas/new">Create Ninja</a>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>Dojo Name</th>
					<th>Ninja Count</th>
					<th>Date Created</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${dojos}" var="dojo">
				<tr>
					<td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
					<td><c:out value="${dojo.getNinjas().size()}"/> ninjas</td>
					<td><c:out value="${dojo.created_at}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>