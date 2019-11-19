<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Show</title>
</head>
<body>
<h2>Create a New Show:</h2>
	<div class="container">
    	<p><form:errors path="show.*"/></p>
    
    <form:form method="POST" action="/new" modelAttribute="show">
        <p>
            <form:label path="title">Title:</form:label>
            <form:input type="text" path="title"/>
        </p>
        <p>
            <form:label path="network">Network:</form:label>
            <form:input type="text" path="network"/>
        </p>
        
        <input type="submit" value="Add"/>
    </form:form>
    	<a href="/home">Go Back</a>
    </div>
</body>
</html>