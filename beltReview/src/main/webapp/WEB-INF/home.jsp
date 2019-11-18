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
<div id="container">
	<div id="wrapper1">
	 	<h1>Welcome, ${user.firstName}</h1>
	 	<a id="logout" href="/logout">Logout</a>
	 	<p>Here are some of the events in your state:</p>
	 	<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date</th>
      <th scope="col">Location</th>
      <th scope="col">Host</th>
      <th scope="col">Action/Status</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${userLocationEvnets}" var="event">
		<tr>
	        <td>${event.name }</td>
	        <td>${event.date }</td>
	        <td>${event.location }</td>
	        <td>${event.host.firstName}</td>
	        <td></td>
	    </tr>
       </c:forEach>
  </tbody>
</table>
	</div>
		<div id="wrapper2">
	 	<p>Here are some of the events in other state:</p>
	 	<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date</th>
      <th scope="col">Location</th>
      <th scope="col">Host</th>
      <th scope="col">Action/Status</th>
    </tr>
  </thead>
  <tbody>
		<c:forEach items="${notUserLocationEvnets}" var="event">
		<tr>
	        <td>${event.name }</td>
	        <td>${event.date }</td>
	        <td>${event.location }</td>
	        <td>${event.host.firstName}</td>
	        <td></td>
	    </tr>
       </c:forEach>
  </tbody>
</table>

<form method="get" action="/new">
    <button type="submit">Create Event</button>
</form>

</body>
</html>