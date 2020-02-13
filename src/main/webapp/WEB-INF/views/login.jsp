<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BookYourEvent | Login</title>
<link rel='icon' href='favicon.ico' type='image/x-icon'/ >
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.login-form {
	width: 340px;
	margin: 50px auto;
}

.login-form form {
	margin-bottom: 15px;
	background: #f7f7f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.login-form h2 {
	margin: 0 0 15px;
}

.form-control, .btn {
	min-height: 38px;
	border-radius: 2px;
}

.btn {
	font-size: 15px;
	font-weight: bold;
}

.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="login-form">
		<h1 class="text-center">BookYourEvents!</h1>
		<form:form action="eventpage.htm" commandName="user" method="POST">
			<h2 class="text-center">Log in</h2>
			<br />
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Enter username"
					name="username" path="username"><form:errors path="username" class="error" />
			</div>
			<div class="form-group">
				<input type="password" class="form-control"
					placeholder="Enter Password" name="password" path="password"><form:errors path="password" class="error" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">Login</button>
			</div>
		</form:form>
		<p class="text-center">
			<a href="signup.htm">Create an Account</a>
		</p>
	</div>
</body>
</html>