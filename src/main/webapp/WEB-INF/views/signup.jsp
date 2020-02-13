<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookYourEvent | SignUp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Sign Up Page:</h1>
		<h3>Please fill the below details to create an account</h3>
		<form:form commandName="user" action="user_signup.htm">
			<div class="form-group">
				<label for="firstname"><b>First Name</b></label> <input type="text"
					path="fname" placeholder="Enter First Name" name="fname">
				<form:errors path="fname" class="error" />
			</div>
			<div class="form-group">
				<label for="lastname"><b>Last Name</b></label> <input type="text"
					path="lname" placeholder="Enter Last Name" name="lname">
				<form:errors path="lname" class="error"/>
			</div>
			<div class="form-group">
				<label for="username"><b>Username</b></label> <input type="text"
					path="username" placeholder="Enter username" name="username">
				<form:errors path="username" class="error" />
			</div>
			<div class="form-group">
				<label for="email"><b>Email</b></label> <input type="text"
					path="email" placeholder="Enter Email" name="email">
				<form:errors path="email" class="error"/>
			</div>
			<div class="form-group">
				<label for="password"><b>Password</b></label> <input type="password"
					path="password" placeholder="Enter Password" name="password">
				<form:errors path="password" class="error" />
			</div>
			<div class="form-group">
				<label for="confirmPassword"><b>Confirm Password</b></label> <input
					type="password" placeholder="Enter Confirm Password"
					name="confirmPassword"><form:errors path="confirmPassword" class="error"/>  
			</div>
			<div class="form-group">
				<label for="phonenumber"><b>Phone Number</b></label> <input
					type="text" placeholder="Enter Phone Number" name="phonenumber"
					path="phonenumber">
				<form:errors path="phonenumber" class="error"/>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>