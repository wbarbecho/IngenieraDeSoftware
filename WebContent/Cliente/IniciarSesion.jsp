
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TuLibro</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/VentaLibros/css/templatemo_style.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="/Telefonica/Styles/styles2.css">
	<link rel="stylesheet" href="/Telefonica/Styles/InicioSesion.css">
</head>
<body>
	<!--  Free CSS Templates from www.templatemo.com -->

	<div id="templatemo_menu">
		<ul>
			<li><a href="CliController" class="current">Home</a></li>
			<li><a href="/">Search</a></li>
			<li><a href="subpage.html">Books</a></li>
			<li><a href="subpage.html">New Releases</a></li>
			<li><a href="#">Company</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</div>
	<!-- end of menu -->

	<section class="our_skill">
	<div class="container">
		<div class="login">

			<div class="login-screen">
				<div class="app-title">
					<h1>Log In</h1>
				</div>

				<div class="login-form">
					<form action="/Telefonica/ControladorSesion" method="post">

						<div class="control-group">

							<input type="email"
								pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}"
								name="user" class="login-field" value="${user}"
								placeholder="username" id="login-name"><label
								class="login-field-icon fui-user" for="login-name"></label>
							<div style="color: red;">${requestScope.validaciones}</div>
						</div>

						<div class="control-group">

							<input type="password" name="password" class="login-field"
								value="${password}" placeholder="password" id="login-pass"><label
								class="login-field-icon fui-lock" for="login-pass"></label>
							<div style="color: red;">${requestScope.validaciones2}</div>
						</div>


						<br /> <input class="btn btn-primary btn-large btn-block"
							type="submit" name="Ingresar" value="Iniciar Sesion" />

					</form>


				</div>

			</div>
		</div>
	</div>
	</section>
	<div id="templatemo_footer">

		<a href="subpage.html">Home</a> | <a href="subpage.html">Search</a> |
		<a href="subpage.html">Books</a> | <a href="#">New Releases</a> | <a
			href="#">FAQs</a> | <a href="#">Contact Us</a><br /> Copyright ©
		2024 <a href="#"><strong>Your Company Name</strong></a>
		<!-- Credit: www.templatemo.com -->
	</div>
	<!-- end of footer -->
	<!--  Free CSS Template www.templatemo.com -->
</body>
</html>