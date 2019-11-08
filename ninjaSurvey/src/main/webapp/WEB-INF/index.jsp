<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Dojo Survey</title>
	</head>
	
	<body>
		<h3>Dojo Survey Knuckleheads!!</h3>
		
			<form action ="" method="post">
				Your Name: <input type="text" name="name" placeholder="Knucks McKnucklehead"/> <br>
				Dojo Location: <select name="dojo">
				<option>San Jose</option>
				<option>Washington, DC</option>
				</select><br>
				
				Favorite Language: <select name="lang">
				<option>Python</option>
				<option>Java</option>
				</select><br>
				Comment (optional):<br>
				<textarea name="Comment" placeholder="Knucks rock!!"></textarea> <br>
			
				<input type="submit" value="submit">
			
			</form>
	</body>
</html>