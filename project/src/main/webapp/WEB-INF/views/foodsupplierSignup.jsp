<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Supplier SignUp</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<form:form action="${contextPath}/foodsupplierSignup.htm" commandName="foodSupplier" method="post">
					<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" size="30" required="required" />
					<font color="red"><form:errors path="firstName" /></font></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" size="30" required="required" />
					<font color="red"><form:errors path="lastName" /></font></td>
			</tr>


			<tr>
				<td>User Name:</td>
				<td><form:input path="username" size="30" required="required" />
					<font color="red"><form:errors path="username" /></font></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="30"
						required="required" /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>

			<tr>
				<td>Email Id:</td>
				<td><form:input path="email.emailAddress" size="30"
						type="email" required="required" /> <font color="red"><form:errors
							path="email.emailAddress" /></font></td>
			</tr>
			<tr>
				<td>Card Details:</td>
				<td><form:input path="cardDetails" size="30"
						type="text" required="required" /> <font color="red"><form:errors
							path="cardDetails" /></font></td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><form:input path="phoneDetails" size="10"
						type="number" required="required" /> <font color="red"><form:errors
							path="phoneDetails" /></font></td>
			</tr>
			<tr>
			<td>Enter the Address Details</td>
			</tr>
			<tr>
				<td>Area:</td>
				 
				<td><form:input path="address.area" size="30"
						type="text" required="required" /> <font color="red"><form:errors
							path="address.area" /></font></td>
			</tr>
			
			<tr>
				<td>City:</td>
				<td><form:input  path="address.city" size="30"
						type="text" required="required" /> <font color="red"><form:errors
							path="address.city" /></font></td>
			</tr>
			
			<tr>
				<td>State:</td>
				<td><form:input  size="30" path="address.state"
						type="text" required="required" /> <font color="red"><form:errors
							path="address.state" /></font></td>
			</tr>
			
			<tr>
				<td>Zip Code:</td>
				<td><form:input  path="address.zipcode" size="6"
						type="number" required="required" /> <font color="red"><form:errors
							path="address.zipcode" /></font></td>
			</tr>
			

			<tr>
				<td colspan="2"><input type="submit" value="Register User" /></td>
			</tr>
		</table>
					
</form:form>					
</body>
</html>