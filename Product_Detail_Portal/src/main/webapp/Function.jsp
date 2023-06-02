<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Details!!!</title>
</head>
<body>
<%
		
		out.println("<h1>Hi, The Details You Entered : </h1>");
		out.println("<h4>Product ID :  "+ request.getParameter("pid") + "</h4>");
		out.println("<h4>Product Name :  "+ request.getParameter("pname") + "</h4>" );
		out.println("<h4>Product Category :  "+ request.getParameter("Vehicles") + "</h4>" );
		out.println("<h4>Product Price :  "+ request.getParameter("pprice") + "</h4>" );


%>

</body>
</html>