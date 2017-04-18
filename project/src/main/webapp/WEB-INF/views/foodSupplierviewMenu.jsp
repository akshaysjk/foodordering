<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Menu</h2>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
      <form:form action="${contextPath}/foodsupplierUpdateMenu.htm" commandName="foodSupplier" method="post">
  		<table>
  		<tr>
  		<td>
  		Breads
  		</td>
  		</tr>
		<c:forEach items="${foodSupplier.menu.foodItems}" var="foodItems" varStatus="loop">
		
			<c:if test = "${foodItems.type =='Breads'}"> 
			<tr>
				<td><c:out value="${foodItems.name}"  /></td>
			</tr>
			<tr>		
				<td><c:out value="${foodItems.price}"  /></td>			
			</tr>
			<tr>	
				<td><c:out value="${foodItems.description}" /></td>		
			</tr>
			</c:if>			
		</c:forEach>	
		</table>
  
  <br>
  <br>
  <input type="submit" value="Update" />
</form:form>
</body>
</html>