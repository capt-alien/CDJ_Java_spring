<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Page</title>
</head>
<body>
	<div class="container">
    	<p><form:errors path="show.*"/></p>
    
    <form:form method="POST" action="/edit/${show.id}" modelAttribute="show">
        <p>
            <form:label path="title">Title:</form:label>
            <form:input type="text" path="title"/>
        </p>
        <p>
            <form:label path="network">Network</form:label>
            <form:input type="text" path="network"/>
        </p>
        
        <input type="submit" value="Edit"/>
    </form:form>
    	<a href="/home">Go Back</a>
    </div>
</body>
</html>