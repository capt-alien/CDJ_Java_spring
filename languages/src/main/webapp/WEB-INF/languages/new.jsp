<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css">
<title>Languages</title>
</head>
<body>
		
		<!-- ERRORS HERE -->
		<div id="form">
			<form:form action="/languages" method="POST" modelAttribute="addNew">		  
			    <p>
			        <form:label class="label" path="name">Name</form:label>
			        <form:input class="box" path="name"/>
			        <form:errors class="red" path="name"/>

			    </p>
			    <p>
			        <form:label class="label" path="creator">Creator</form:label>
			        <form:input class="box" path="creator"/>
    				<form:errors class="red" path="creator"/>
			    </p>
			    <p>
			        <form:label class="label" path="currentVersion">Version</form:label>
			        <form:input class="box" path="currentVersion"/>
     		 		<form:errors class="red" path="currentVersion"/>
			    </p>
			    <input id="btn" type="submit" value="Submit"/>	 
			</form:form>
		</div>
		
		
		<!-- END ERROR -->
	</div>
</body>
</html>