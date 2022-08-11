<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.example.bean.Category" %>
    <%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${requestScope.msg}
<%
Object obj = request.getAttribute("catList"); 
%>
<h2>Add Products</h2>
      
		<form action="addProduct" method="post" enctype="multipart/form-data">
		  <label> Product Name</label>
          <input type="text" name="pname"> </br></br>
          <label>Quantity</label>
          <input type="number" name="pquan"></br></br>
          <label>Price:</label>
          <input type="number" name="price"></br></br>
          <label for="cat"> Choose a Category from List:</label>
          <select name="cat" id="cat">
          <%
          if(obj != null){
        	  List<Category> cList = (List<Category>)obj;
        	  Iterator<Category> itr = cList.listIterator();
        	  while(itr.hasNext()){
        		  Category c = itr.next();
        		  %> 
        		  <option><%=c.getName() %></option>
        		  <% 
        	  }
        	  }
          %>
          </select></br></br>
          <label for="file">Choose Picture:</label>
          <input type="file" id="file" name="file"><br><br>
          <input type="submit" value="Upload"> 
		 <input type="reset" value="reset">  
        </form>
		
</body>
</html>