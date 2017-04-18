<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Supplier Home</title>
</head>
<body>
<h1>Hi, ${foodSupplier.firstName}</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<input type="hidden" value="${foodSupplier.personID}" name= "foodSupplier">
<c:out value="${contextPath}"></c:out>
  <a href="${pageContext.request.contextPath}/foodSupplier/UpdateMenu.htm">Update Menu</a>
  <a href="${pageContext.request.contextPath}/foodSupplier/viewMenu.htm">View Menu</a>

</body>
</html>