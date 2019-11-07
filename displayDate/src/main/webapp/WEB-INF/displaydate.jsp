<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Date:</title>
</head>
<body>
		<h3>The Local time is:</h3>
		
		<span id="time"><fmt:formatDate value="${now}" pattern="EEEE, 'the' d 'of' MMMM, yyyy" /></span>

		<br>
		<a href="/">Back</a>		
</body>
</html>