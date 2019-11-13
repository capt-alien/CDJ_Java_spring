<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE HTML>
<html>
<head>

</head>


<body>  
<h1>${book.title}</h1>


	<p>Description: ${book.description} </p>
	<p>Language: ${book.language} </p>
	<p>Number of pages: ${book.numberOfPages}</p>
	
<form action="/books/${book.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
   	<a href="/books/${book.id}/edit">Edit Book</a>
    
</form>
</body>
</html>