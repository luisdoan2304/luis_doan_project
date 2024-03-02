<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="home"><i
								class="fa fa-home"></i> Home</a></li>
						<li><a href="checkout.jsp">Checkout</a></li>
						<li><a href="category?action=categoryList">Category</a></li>
						<li><a href="#">Others</a></li>
						<li><a href="#"><i class="fa fa-envelope"></i> Contact</a></li>
						<li><a href="login"><i class="fa fa-user"></i> Login</a></li>
						<li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
						<li><a href="CartDetail">Cart  <span class="cart-amunt">$100<span>
								<i class="fa fa-shopping-cart"></i> <span class="product-count">${sessionScope.cart.items.size()}</span></a></li>

					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>