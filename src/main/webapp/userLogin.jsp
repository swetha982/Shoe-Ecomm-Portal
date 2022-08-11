<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${requestScope.msg}
    <h2> User Login Page</h2>
	<form action="validateUser" method="post">
		<label> Email Id </label>
		<input type="email" name="email"> </br></br>
		<label> Password </label>
		 <input type="password" name="password"> </br> </br> 
		 <input type="submit" value="submit"> 
		 <input type="reset" value="reset">  
		</form>
</body>
</html>