<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookYourEvent | Booking History</title>
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
		<p class="text-center">
			<button type="button" class="btn btn-info">
				<a href="profile.htm">User Profile</a>
			</button>
			<button type="button" class="btn btn-info">
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
				<th scope="col">Number</th>
				<th scope="col">Book Date</th>
				<th scope="col">Payment Method</th>
				<th scope="col">Number of Tickets</th>
				<th scope="col">Total Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${sessionScope.booking}">
				<tr>
					<td><c:out value="${book.getId()}" /></td>
					<td><c:out value="${book.getBook_date()}" /></td>
					<td><c:out value="${book.getPayment_method()}" /></td>
					<td><c:out value="${book.getNo_of_tickets()}" /></td>
					<td>$<c:out value="${book.getTotal_amount()}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>