<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Menu</title>
</head>
<body>

<h2>Menu</h2>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

      <form action="${contextPath}/foodsupplierUpdateMenu.htm" method="post">
      <input type="hidden" value="${foodSupplier.personID}" name= "foodSupplier">
      <table id="fieldList">
      
  <tr>
  <td>FoodItem Type</td>
  <td>
      <select name="foodtype">
     <option value="Starters">Starters</option>
     <option value="Breads">Breads</option>
     <option value="Rice">Rice</option>
     <option value="Chinese">Chinese</option>
     <option value="Soups">Soups</option>
     <option value="Beverages">Beverages</option>
     <option value="Desserts">Desserts</option>
	</select> 
	
</td>	
</tr>
<tr>
<td>FoodItem Name</td>
<td>
    
      <input name="fooditemname" type="text" placeholder="FoodItemName" />
    
</td>
</tr>
<tr>
<td>Description</td>    
   <td>
    
      <input name="description" type="text" placeholder="description" />
    
    </td>
 </tr>
 <tr>   
 <td>Price</td>   
  <td> 
      <input name="price" type="text" placeholder="price">    
 </td>
 </tr>  
 <tr>
 <td>&nbsp;</td>
 </tr>
<tr> 
	<td> <button id="addMore">Add more FoodItems</button></td>
</tr>

  </table>
  <br>
  <input type="submit" value="Update" />
</form>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- <script src='resources/js/app.js'></script> -->
<script>
$("#addMore").click(function(e) {
    e.preventDefault();
    alert("BUTTON CLICKED");
    $(this).parent().parent().before($("<tr><td>&nbsp;</td></tr><tr><td>FoodItem Type</td><td><select name='foodtype'><option value='Starters'>Starters</option><option value='Breads'>Breads</option><option value='Rice'>Rice</option><option value='Chinese'>Chinese</option><option value='Soups'>Soups</option><option value='Beverages'>Beverages</option><option value='Desserts'>Desserts</option></select></td></tr><tr><td>FoodItem Name</td><td><input type='text'  placeholder='FoodItemName'  name='fooditemname'/></td></tr><tr><td>FoodItem Description</td><td><input type='text'  placeholder='description'  name='description'/></td></tr><tr><td>FoodItem Price</td><td><input type='text'  placeholder='price' name='price'/></td></tr>"));//{
	//$("<tr><td>I am here</td></tr>");   
   // $("<tr>"+"<td>FoodItem Type</td>"+"<td>"+"<select>"+"<option>Starters</option>"+"<option>Breads</option>"+"<option>Rice</option>"+"<option>Chinese</option>"+"<option>Soups</option>"+"<option>Beverages</option>"+"<option>Deserts</option>"+"</select>"+"</td>"+"</tr>");	
   // $("#fieldList").append("<tr>"+"<td>FoodItem Type</td>"+"<td>"+"<select>"+"<option>Starters</option>"+"<option>Breads</option>"+"<option>Rice</option>"+"<option>Chinese</option>"+"<option>Soups</option>"+"<option>Beverages</option>"+"<option>Deserts</option>"+"</select>"+"</td>"+"</tr>");
   // $("#fieldList").append("<tr>"+"<td>FoodItem Name</td>"+"<td><input type='text'  placeholder='FoodItemName'  name='fooditemname'/></td></tr>");
   // $("#fieldList").append("<tr>"+"<td>FoodItem Description</td>"+"<td><input type='text'  placeholder='description'  name='description'/></td></tr>");
   // $("#fieldList").append("<tr>"+"<td>FoodItem Price</td>"+"<td><input type='text'  placeholder='price' name='price'/></td></tr>");    
 // });
});      
</script>
</body>
</html>