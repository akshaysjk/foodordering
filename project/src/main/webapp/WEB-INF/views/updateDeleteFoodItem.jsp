<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update And Delete Food Item</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {

						$('.delete')
								.click(
										function(e) {
											//alert("Alert");
											e.preventDefault();
											var id = $(this).parent()
													.data("id");
											var urlPath = "${pageContext.request.contextPath}/foodSupplier/deleteFoodItem.htm?id="
													+ id;
											alert(urlPath);
											$.ajax({
												url : urlPath,
												type : 'GET',
												success : function(response) {
													alert(response);
													alert('#foodItem-'
															+ response);
													$('#foodItem-' + response)
															.fadeOut();
												}
											});
										});
					});
</script>
</head>
<body>

	<h2>Menu</h2>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form action="${contextPath}/foodsupplierUpdateMenu.htm" method="post">
		<div class="w3-container">
			<div class="w3-panel w3-card-4">

				<c:set var="starters" value="true" />
				<c:forEach items="${foodItems}" var="foodItems" varStatus="loop">

					<c:if test="${foodItems.type =='Starters'}">
						<c:if test="${starters}">
							<div class="row">
								<div class="col-sm-12">
									<strong>Starters</strong>
								</div>
							</div>
						</c:if>
						<c:set var="starters" value="false" />
						<div id="foodItem-${foodItems.fooditemID}">
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.name}" />
								</div>
								<div class="col-sm-1">
									<a
										href="${pageContext.request.contextPath}/foodSupplier/updateFoodItem.htm?id=${foodItems.fooditemID}">Update</a>
								</div>
								<div class="col-sm-1" data-id="${foodItems.fooditemID}">
									<a class="delete" href="#">Delete</a>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.description}" />
								</div>
								<div class="col-sm-2">
									<c:out value="${foodItems.price}" />
								</div>
							</div>
						
						<hr>
						</div>
					</c:if>
				</c:forEach>

				<c:set var="breads" value="true" />
				<c:forEach items="${foodItems}" var="foodItems" varStatus="loop">

					<c:if test="${foodItems.type =='Breads'}">
						<c:if test="${breads}">
							<div class="row">
								<div class="col-sm-12">
									<strong>Breads</strong>
								</div>
							</div>
						</c:if>
						<c:set var="breads" value="false" />
						<div id="foodItem-${foodItems.fooditemID}">
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.name}" />
								</div>
								<div class="col-sm-1">
									<a
										href="${pageContext.request.contextPath}/foodSupplier/updateFoodItem.htm?id=${foodItems.fooditemID}">Update</a>
								</div>
								<div class="col-sm-1" data-id="${foodItems.fooditemID}">
									<a class="delete" href="#">Delete</a>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.description}" />
								</div>
								<div class="col-sm-2">
									<c:out value="${foodItems.price}" />
								</div>
							</div>
						
						<hr>
						</div>
					</c:if>
				</c:forEach>

				<c:set var="rice" value="true" />
				<c:forEach items="${foodItems}" var="foodItems" varStatus="loop">

					<c:if test="${foodItems.type =='Rice'}">
						<c:if test="${rice}">
							<div class="row">
								<div class="col-sm-12">
									<strong>Rice</strong>
								</div>
							</div>
						</c:if>
						<c:set var="rice" value="false" />
						<div id="foodItem-${foodItems.fooditemID}">
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.name}" />
								</div>
								<div class="col-sm-1">
									<a
										href="${pageContext.request.contextPath}/foodSupplier/updateFoodItem.htm?id=${foodItems.fooditemID}">Update</a>
								</div>
								<div class="col-sm-1" data-id="${foodItems.fooditemID}">
									<a class="delete" href="#">Delete</a>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.description}" />
								</div>
								<div class="col-sm-2">
									<c:out value="${foodItems.price}" />
								</div>
							</div>
						
						<hr>
						</div>
					</c:if>
				</c:forEach>

				<c:set var="chinese" value="true" />
				<c:forEach items="${foodItems}" var="foodItems" varStatus="loop">

					<c:if test="${foodItems.type =='Chinese'}">
						<c:if test="${chinese}">
							<div class="row">
								<div class="col-sm-12">
									<strong>Chinese</strong>
								</div>
							</div>
						</c:if>
						<c:set var="chinese" value="false" />
						<div id="foodItem-${foodItems.fooditemID}">
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.name}" />
								</div>
								<div class="col-sm-1">
									<a
										href="${pageContext.request.contextPath}/foodSupplier/updateFoodItem.htm?id=${foodItems.fooditemID}">Update</a>
								</div>
								<div class="col-sm-1" data-id="${foodItems.fooditemID}">
									<a class="delete" href="#">Delete</a>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.description}" />
								</div>
								<div class="col-sm-2">
									<c:out value="${foodItems.price}" />
								</div>
							</div>
						
						<hr>
						</div>
					</c:if>
				</c:forEach>

				<c:set var="soups" value="true" />
				<c:forEach items="${foodItems}" var="foodItems" varStatus="loop">

					<c:if test="${foodItems.type =='Soups'}">
						<c:if test="${soups}">
							<div class="row">
								<div class="col-sm-12">
									<strong>Soups</strong>
								</div>
							</div>
						</c:if>
						<c:set var="soups" value="false" />
						<div id="foodItem-${foodItems.fooditemID}">
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.name}" />
								</div>
								<div class="col-sm-1">
									<a
										href="${pageContext.request.contextPath}/foodSupplier/updateFoodItem.htm?id=${foodItems.fooditemID}">Update</a>
								</div>
								<div class="col-sm-1" data-id="${foodItems.fooditemID}">
									<a class="delete" href="#">Delete</a>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.description}" />
								</div>
								<div class="col-sm-2">
									<c:out value="${foodItems.price}" />
								</div>
							</div>
						
						<hr>
						</div>
					</c:if>
				</c:forEach>


				<c:set var="beverages" value="true" />
				<c:forEach items="${foodItems}" var="foodItems" varStatus="loop">

					<c:if test="${foodItems.type =='Beverages'}">
						<c:if test="${beverages}">
							<div class="row">
								<div class="col-sm-12">
									<strong>Beverages</strong>
								</div>
							</div>
						</c:if>
						<c:set var="beverages" value="false" />
						<div id="foodItem-${foodItems.fooditemID}">
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.name}" />
								</div>
								<div class="col-sm-1">
									<a
										href="${pageContext.request.contextPath}/foodSupplier/updateFoodItem.htm?id=${foodItems.fooditemID}">Update</a>
								</div>
								<div class="col-sm-1" data-id="${foodItems.fooditemID}">
									<a class="delete" href="#">Delete</a>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.description}" />
								</div>
								<div class="col-sm-2">
									<c:out value="${foodItems.price}" />
								</div>
							</div>
						
						<hr>
						</div>
					</c:if>
				</c:forEach>

				<c:set var="desserts" value="true" />
				<c:forEach items="${foodItems}" var="foodItems" varStatus="loop">

					<c:if test="${foodItems.type =='Desserts'}">
						<c:if test="${desserts}">
							<div class="row">
								<div class="col-sm-12">
									<strong>Desserts</strong>
								</div>
							</div>
						</c:if>
						<c:set var="desserts" value="false" />
						<div id="foodItem-${foodItems.fooditemID}">
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.name}" />
								</div>
								<div class="col-sm-1">
									<a
										href="${pageContext.request.contextPath}/foodSupplier/updateFoodItem.htm?id=${foodItems.fooditemID}">Update</a>
								</div>
								<div class="col-sm-1" data-id="${foodItems.fooditemID}">
									<a class="delete" href="#">Delete</a>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10">
									<c:out value="${foodItems.description}" />
								</div>
								<div class="col-sm-2">
									<c:out value="${foodItems.price}" />
								</div>
							</div>
						
						<hr>
						</div>
					</c:if>
				</c:forEach>

			</div>
		</div>
		<br> <input type="submit" value="Update" />
	</form>
</body>
</html>