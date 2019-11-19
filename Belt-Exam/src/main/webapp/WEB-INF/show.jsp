<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>
	<div class="container">
    	<h1>${show.title }</h1>
    	<p>${show.network }</p>
    	<a href="/home">Go Back</a>
    </div>
    
	 	<a href="/edit/${show.id }">Edit</a> | 
	  	<a href="/delete/${show.id }">Delete</a>
    
</body>
</html>