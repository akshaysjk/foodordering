<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
 
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Signup</title>

</head>
<body>
<% System.out.println( "Line: 1"); %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% System.out.println( "Line: 2"); %>
 <c:choose>
        <c:when test="${type eq 'create'}"><c:set var="contextPath" value="${pageContext.request.contextPath}/address/create" /></c:when>
        <c:otherwise><c:set var="contextPath" value="/update" /></c:otherwise>
    </c:choose>
    <% System.out.println( "Line: 3"); %>
	<c:set var="index" value="${fn:length(user.addresses)}"/>
	<% System.out.println( "Line: 4 Index value "+pageContext.findAttribute("index")); %>
	<form:form action="../customersignup.htm" commandName="user" name="user" method="post">
	
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
				 <% System.out.println( "Line: 4"); %>
			 <c:forEach items="${user.addresses}" var="addresses" varStatus="loop">
		 
                        <div id="addresses${loop.index}.wrapper">
                        <td>Area:</td>
                        <% System.out.println( "Line: 6"); %>
				<td><form:input path="addresses[${loop.index}].area"  name="addresses[${loop.index}].area" size="30"
						type="text" required="required" /> <font color="red"><form:errors
							path="addresses[${loop.index}].area" /></font></td>
			</tr>
			<% System.out.println( "Line: 7"); %>
			<tr>
				<td>City:</td>
				<td><form:input  path="addresses[${loop.index}].city"  name="addresses[${loop.index}].city" size="30"
						type="text" required="required" /> <font color="red"><form:errors
							path="addresses[${loop.index}].city" /></font></td>
			</tr>
			
			<tr>
				<td>State:</td>
				<td><form:input  size="30" path="addresses[${loop.index}].state"  name="addresses[${loop.index}].state"
						type="text" required="required" /> <font color="red"><form:errors
							path="addresses[${loop.index}].state" /></font></td>
			</tr>
			
			<tr>
				<td>Zip Code:</td>
				<td><form:input  path="addresses[${loop.index}].zipcode"  name="addresses[${loop.index}].zipcode" size="6"
						type="number" required="required" /> <font color="red"><form:errors
							path="addresses[${loop.index}].zipcode" /></font></td>
			</tr>
			
			
                        	</div>
			</c:forEach>
			<tr>
			<td><button id="add" type="button" data-selector="${index}">add</button></td>
			<tr>

		</table>
	<input type="submit" value="Register User" />				
</form:form>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src='../resources/js/app.js'></script>
<script>

$("#add").click( function(e) {
	  e.preventDefault();
	  alert("ADD CLICKED");
    $(this).before(function() {
  	  var index =$(this).data('selector');
        var html = '<div id="addresses' + index + '.wrapper" class="hidden">';                    
        html += '<tr><td>Area:</td><td><input type="text" id="addresses' + index + '.area" name="addresses[' + index + '].area" /></br></td></tr>';
        html += '<tr><td>City:</td><td><input type="text" id="addresses' + index + '.city" name="addresses[' + index + '].city" /></br></td></tr>';
        html += '<tr><td>State:</td><td><input type="text" id="addresses' + index + '.state" name="addresses[' + index + '].state" /></br></td></tr>';
        html += '<tr><td>Zipcode:</td><td><input type="text" id="addresses' + index + '.zipcode" name="addresses[' + index + '].zipcode" /></br></td></tr>';
        html += '<input type="hidden" id="addresses' + index + '.remove" name="addresses[' + index + '].remove" value="0" />';
        html += '<button id="remove" type="button" class="addresses.remove" data-index="' + index + '">remove</button>';                    
        html += "</div>";
        return html;
    });
    $("#addresses" + index + "\\.wrapper").show();
    index++;
    return false;
});

</script>					
</body>
</html>