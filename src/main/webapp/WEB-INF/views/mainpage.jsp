<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookYourEvent | Home</title>
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

h1 {
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<p class="text-center">

			<button type="button" class="btn btn-info">
				<a href="profile.htm">User Profile</a>
			</button>
			<button type="button" class="btn btn-success">
				<a href="bookings.htm">Booking History</a>
			</button>
			<button type="button" class="btn btn-danger">
				<a href="signout.htm">Logout</a>
			</button>
		</p>
	</div>
	<h1>Hello ${sessionScope.user.getUsername()} ! Please check out
		below events!</h1>
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">No.</th>
				<th scope="col">Event Name</th>
				<th scope="col">Date</th>
				<th scope="col">City</th>
				<th scope="col">Price</th>
				<th scope="col">Book</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${sessionScope.event}">
				<tr>
					<td><c:out value="${e.getId()}" /></td>
					<td><c:out value="${e.getEvent_name()}" /></td>
					<td><c:out value="${e.getEvent_date()}" /></td>
					<td><c:out value="${e.getCity()}" /></td>
					<td>$<c:out value="${e.getPrice()}" /></td>
					<td>
						<form action="book.htm" method="POST">
							<input type="hidden" name="eventID" value="${e.getId()}">
							<button type="submit" class="btn btn-primary">Book</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>