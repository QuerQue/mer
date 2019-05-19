<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!Doctype html>
<html>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' type="text/css" media="screen" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<title>Products</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true">
    <jsp:param name="title" value="Products Catalog"/>
</jsp:include>
	<section>
	<div class="jumbotron">
		<div class="container"> 
			<a href='<c:url value="/cart" />' class="btn btn-default pull-right"  > <span class="glyphicon-shopping-cart glyphicon"></span> view cart</a>
			<p>All the available products in our rental</p>
		</div>
	</div>
	</section>
	<section class="container" ng-app="cartApp">
	<div class="row">
	<c:forEach items="${products}" var="product" >	
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
						<h3>${product.name}</h3>	
						<img src='<c:url value="/resources/images/${product.imageSource}" />' alt="image" />
						<p>${product.name}</p>					
						<p>${product.price} zl/week</p>
						<p>${product.quantity} units in stock</p>
					<a href="${contextPath}/catalog/ordernow/${product.id}" class="btn btn-warning btn-large"> 
					 Order Now
					</a>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	</section>
</body>
</html>