<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Results</title>
		</head>
	<body>
	<h2>Survey Results</h2>
		Your Name: <c:out value="${name}"/><br>
		Location: <c:out value="${dojo}"/><br>
		language: <c:out value="${lang}"/><br>
		
		Comment: <c:out value="${comment}"/><br>
		
		
		<a href="/">Go Back</a>
		
	</body>
</html>