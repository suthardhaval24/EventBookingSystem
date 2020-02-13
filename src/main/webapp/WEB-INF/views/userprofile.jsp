<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookYourEvent | Login</title>
<link rel='icon' href='favicon.ico' type='image/x-icon'/ >
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	margin-top: 50px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Profile Details:</h1>
		<p>${sessionScope.user.getFname()}</p>
		<p>${sessionScope.user.getLname()}</p>
		<p>${sessionScope.user.getEmail()}</p>
		<p>${sessionScope.user.getPhonenumber()}</p>

		<p>To update your details click on Edit</p>
		<form:form commandName="user" action="profileUpdate.htm" method="POST">
			<div class="form-group">
				<label for="firstname"><b>First Name</b></label> <input type="text"
					placeholder="Enter First Name" name="fname" id="fname"
					disabled="true">
			</div>
			<div class="form-group">
				<label for="Lastname"><b>LastName</b></label> <input type="text"
					placeholder="Enter Last Name" name="lname" id="lname"
					disabled="true">
			</div>

			<div class="form-group">
				<label for="Phonenumber"><b>Phone Number</b></label> <input
					type="text" placeholder="Enter Phone Number" id="phonenumber"
					name="phonenumber" disabled="true">
			</div>
			<button type="button" class="btn btn-info" onclick="edit()">Edit</button>
			<button type="submit" class="btn btn-info">Submit</button>
		</form:form>
	</div>

	<script>
		function edit() {
			document.getElementById("fname").disabled = false;
			document.getElementById("lname").disabled = false;
			document.getElementById("phonenumber").disabled = false;
		}
	</script>
</body>
</html>