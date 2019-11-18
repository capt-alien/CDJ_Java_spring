<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Events</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">
    	#container{
    		width: 80%;
    		margin: 0 auto;
    	}
    	#logout{
    		margin-left: 900px;
    	}
</style>
</head>
<body>
	<div id="wrapper3">
	 	<h1>Create An Event</h1>
 	 	<form:form method="post"  action="/new" modelAttribute="event">
	 		<p>
	 			<form:errors path="name"></form:errors>
	 			<form:label path="name">Name:</form:label>
	 			<form:input path="name"/>
	 		</p>
	 		<p>
	 			<form:errors path="date"></form:errors>
	 			<form:label path="date">Date:</form:label>
	 			<form:input type="date" path="date"/>
	 		</p>
	 		<p>
	 			<form:errors path="location"></form:errors>
	 			<form:label path="location">Location:</form:label>
	 			<form:input path="location"/>
	 			<form:select path="state">
		 			<form:option value="CA">CA</form:option>
	        		<form:option value="TX">TX</form:option>
	        		<form:option value="MI">MI</form:option>
	        		<form:option value="NY">NY</form:option>
	 			</form:select>
	 		</p>
	 		<input type="submit" value="Submit">
	 	</form:form>
	</div>
</body>
</html>