<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

    

    <%@ page import="java.util.List" %>

    <%@ page import="com.example.bean.Product" %>

    <%@page import="java.util.Iterator"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Shoe Shopping Portal</title>

</head>

<body>

<ul>

<%

 Object obj=request.getAttribute("products");

System.out.println("inside jsp"+obj);

 if(obj!=null)

 {

	 List<Product> products= (List<Product>)obj;

		 %>

		 <c:forEach var="prod" items="${products}">

		<li>

		<div>

			<img src= "${prod.getFilePath()}"/>

			<span> ${prod.getName()} </span>

			 <span> ${prod.getPrice()} </span>

			<a href="addtocart?Id=${prod.getProductId()}">Add to cart</a>

		</div>

			

		</li>

		</c:forEach>

	<%

	}			  

 

%>

</ul>









</body>

</html>

