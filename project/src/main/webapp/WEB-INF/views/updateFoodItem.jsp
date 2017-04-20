<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<form action="${contextPath}/foodSupplier/UpdateFoodItemPage.htm" method="post">
	<input type="hidden" value="${foodItem.fooditemID}" name= "foodItem">
		<table id="fieldList">

			
			<tr>
				<td>FoodItem Name</td>
				<td><input name="fooditemname" type="text"
					placeholder="FoodItemName"  value="${foodItem.name}"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input name="description" type="text"
					placeholder="description" value="${foodItem.description}"/></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input name="price" type="text" placeholder="price" value="${foodItem.price}">
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		<br> <input type="submit" value="Update" />
	</form>
</body>
</html>