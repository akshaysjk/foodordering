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
  		
  		<c:set var="starters" value="true"/>
		<c:forEach items="${foodSupplier.menu.foodItems}" var="foodItems" varStatus="loop">
			
			<c:if test = "${foodItems.type =='Starters'}"> 
			<c:if test = "${starters}">
			<tr>
	  		<td>
	  		Starters
	  		</td>
	  		</tr>
			</c:if>
		<c:set var="starters" value="false"/>	
			<tr>
			<td>&nbsp;</td>
				<td><c:out value="${foodItems.name}"  /></td>
				<td>&nbsp;</td>	
				<td><c:out value="${foodItems.price}"  /></td>
			</tr>			
			<tr>
			<td>&nbsp;</td>	
				<td><c:out value="${foodItems.description}" /></td>		
			</tr>
			</c:if>			
		</c:forEach>
		
		
  		<c:set var="breads" value="true"/>
		<c:forEach items="${foodSupplier.menu.foodItems}" var="foodItems" varStatus="loop">
				
			<c:if test = "${foodItems.type =='Breads'}"> 			 
			<c:if test = "${breads}">
			<tr>
	  		<td>
	  		Breads
	  		</td>
	  		</tr>
			</c:if>
			<c:set var="breads" value="false"/>
			<tr>
			<td>&nbsp;</td>
				<td><c:out value="${foodItems.name}"  /></td>
				<td>&nbsp;</td>	
				<td><c:out value="${foodItems.price}"  /></td>
			</tr>			
			<tr>
			<td>&nbsp;</td>	
				<td><c:out value="${foodItems.description}" /></td>		
			</tr>
			</c:if>			
		</c:forEach>
		
		<c:set var="rice" value="true"/>
		<c:forEach items="${foodSupplier.menu.foodItems}" var="foodItems" varStatus="loop">
				
			<c:if test = "${foodItems.type =='Rice'}"> 
			<c:if test = "${rice}">
			<tr>
  		<td>
  		Rice
  		</td>
  		</tr>
  		</c:if>
  		<c:set var="rice" value="false"/>
			<tr>
			
			<td>&nbsp;</td>
				<td><c:out value="${foodItems.name}"  /></td>
				<td>&nbsp;</td>	
				<td><c:out value="${foodItems.price}"  /></td>
			</tr>			
			<tr>
			<td>&nbsp;</td>	
				<td><c:out value="${foodItems.description}" /></td>		
			</tr>
			</c:if>			
		</c:forEach>
	<c:set var="chinese" value="true"/>
		<c:forEach items="${foodSupplier.menu.foodItems}" var="foodItems" varStatus="loop">
				
			<c:if test = "${foodItems.type =='Chinese'}"> 
			<c:if test = "${chinese}">
			<tr>
  		<td>
  		Chinese
  		</td>
  		</tr>
  		</c:if> 
  		<c:set var="chinese" value="false"/>
			<tr>
			<td>&nbsp;</td>
				<td><c:out value="${foodItems.name}"  /></td>
				<td>&nbsp;</td>	
				<td><c:out value="${foodItems.price}"  /></td>
			</tr>			
			<tr>
			<td>&nbsp;</td>	
				<td><c:out value="${foodItems.description}" /></td>		
			</tr>
			</c:if>			
		</c:forEach>
	<c:set var="soups" value="true"/>
		<c:forEach items="${foodSupplier.menu.foodItems}" var="foodItems" varStatus="loop">
				
			<c:if test = "${foodItems.type =='Soups'}"> 
			<c:if test = "${soups}">
			<tr>
  		<td>
  		Soups
  		</td>
  		</tr>
  		</c:if>
  		<c:set var="soups" value="false"/> 
			<tr>
			<td>&nbsp;</td>
				<td><c:out value="${foodItems.name}"  /></td>
				<td>&nbsp;</td>	
				<td><c:out value="${foodItems.price}"  /></td>
			</tr>			
			<tr>
			<td>&nbsp;</td>	
				<td><c:out value="${foodItems.description}" /></td>		
			</tr>
			</c:if>			
		</c:forEach>
		<c:set var="beverages" value="true"/>
		<c:forEach items="${foodSupplier.menu.foodItems}" var="foodItems" varStatus="loop">
				
			<c:if test = "${foodItems.type =='Beverages'}"> 
			<c:if test = "${beverages}">
			<tr>
  		<td>
  		Beverages
  		</td>
  		</tr>
  		</c:if>
  		<c:set var="beverages" value="false"/> 
			<tr>
			<td>&nbsp;</td>
				<td><c:out value="${foodItems.name}"  /></td>
				<td>&nbsp;</td>	
				<td><c:out value="${foodItems.price}"  /></td>
			</tr>			
			<tr>
			<td>&nbsp;</td>	
				<td><c:out value="${foodItems.description}" /></td>		
			</tr>
			</c:if>	
			</c:forEach>
			<c:set var="desserts" value="true"/>
		<c:forEach items="${foodSupplier.menu.foodItems}" var="foodItems" varStatus="loop">
				
			<c:if test = "${foodItems.type =='Desserts'}"> 
			<c:if test = "${desserts}">
			<tr>
  		<td>
  		Desserts
  		</td>
  		</tr>
  		</c:if>
  		<c:set var="desserts" value="false"/>
			<tr>
			<td>&nbsp;</td>
				<td><c:out value="${foodItems.name}"  /></td>
				<td>&nbsp;</td>	
				<td><c:out value="${foodItems.price}"  /></td>
			</tr>			
			<tr>
			<td>&nbsp;</td>	
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