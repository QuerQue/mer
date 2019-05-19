<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!Doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' type="text/css" media="screen" />
</head>
<body>
	<jsp:include page="header.jsp" flush="true">
	    <jsp:param name="title" value="Cart"/>
	</jsp:include>
	<section>
		<div class="jumbotron">
			<div class="container">
				<p>All the selected products in your cart</p>
			</div>
		</div>
	</section>

	<section class="container">
			<div>
				<a class="btn btn-danger pull-left"> <span
					class="glyphicon glyphicon-remove-sign"></span> Clear Cart
				</a> <a href="#" class="btn btn-success pull-right"> <span
					class="glyphicon-shopping-cart glyphicon"></span> Check out
				</a>
			</div>
			<table class="table table-hover">
				<tr>
					<th>Product</th>
					<th>Quantity</th>
					<th>Unit price</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tr>
					<td>${product.name}</td>
					<td>${cart.quantity}</td>
					<td>${product.price}</td>
					<td>${product.price * cart.quantity}</td>
					<td><a href="#" class="label label-danger"> <span
							class="glyphicon glyphicon-remove" /></span> Remove
					</a></td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Total</th>
					<th></th>
				</tr>

			</table>
			<a href="<spring:url value="/catalog" />" class="btn btn-success">
					<span class="glyphicon-circle-arrow-left glyphicon"></span> continue shopping
			</a>
	</section>
</body>
</html>