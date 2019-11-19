<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
	<h1>Greetings ${user.firstName} ${user.lastName}</h1>   
   
  <!--  SHOWS TABLE HERE --> 
  
  		<table>
    	<thead>
    	<tr>
    	<th>Title</th>
    	<th>Network</th>
    	<th>Actions</th>
    	</tr>
    	</thead>
    	<tbody>
    	<c:forEach items="${shows}" var = "show">
    	<tr>
    	<td><a href="/show/${show.id }">${show.title }</a></td>
    	<td>${show.network }</td>
    	
	    	<td>
	    	<a href="/edit/${show.id }">Edit</a> | 
	    	<a href="/delete/${show.id }">Delete</a>
	    	</td>
	    	<td>
	    	</td>

    	</tr>
    	</c:forEach>
    	
    	</tbody>
    	</table>  
    	
    	<form method="get" action="/new">
    		<button type="submit">Create Event</button>
		</form>
    	<form method="get" action="/logout">
    		<button type="submit">Logout</button>
		</form>
</body>
</html>