<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>The CODE</title>
	<style>
	#main{
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	
	#errors{
		color: red;
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<div id="main">
	<h2>Do you know the code?</h2>
		<p id="errors"><c:out value="${errors}"></c:out></p>	
	<form action="guess" method="POST">
		<input type="text" name="aGuess">
		<input type="submit" value="Try code">
	</form>
</div>
</body>
</html>