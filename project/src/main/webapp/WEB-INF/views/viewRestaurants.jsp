<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewRestaurants</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<h2>List of Restaurants</h2>
	<div class="w3-container">
	<c:forEach items ="${foodSuppliers}" var = "restaurant">
	  <div class="w3-panel w3-card-4">
	  <p>${restaurant.firstName}</p>
	  <p><a href="${pageContext.request.contextPath}/foodSupplier/viewRestaurantMenu.htm?id=${restaurant.personID}">View Menu</a></p>
	  </div>
	 </c:forEach> 
</div>
	
</body>
</html>