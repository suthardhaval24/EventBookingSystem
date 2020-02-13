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
	<div class="container">
		<h1 class="text-center">Events Details:</h1>
		<p>
			<b>Event Name:</b> <i>${requestScope.event_detail.getEvent_name()}</i>
		</p>
		<p>
			<b>Address:</b> <i>${requestScope.event_detail.getAddress()}</i>
		</p>
		<p>
			<b>City:</b> <i>${requestScope.event_detail.getCity()}</i>
		</p>
		<p>
			<b>Date:</b> <i>${requestScope.event_detail.getEvent_date()}</i>
		</p>
		<p>
			<b>Available seats:</b> <i id="total">${requestScope.event_detail.getAvaibility()}</i>
		</p>
		<p>
			<b>Price:</b> $<i>${requestScope.event_detail.getPrice()}</i>
		</p>
	</div>
	<div class="container">
		<form:form commandName="booking" action="report.pdf" target="_blank">
			<div class="form-group col-md-3">
				<label for="total_seats"><b>Number of Tickets:</b></label> <input
					class="form-control" placeholder="enter number of tickets"
					type="number" name="no_of_tickets" id="num" min="0"
					max="requestScope.event_detail.getAvaibility()" required>
				<p id="error"></p>
			</div>
			<div class="form-group col-md-3">
				<label for="payment">Select Payment method:</label> <select name="payment_method"
					class="form-control">
					<option value="Debit Card">Debit Card</option>
					<option value="Credit Card">Credit Card</option>
				</select>
			</div>

			<div class="form-group col-md-3">
				<label for="card_details"><b>Card Details:</b></label> <input
					class="form-control" type="text" id="cc	"
					placeholder="enter card details" name="card_detail" required>
			</div>
			<br />
			<input type="hidden" name="eventID"
				value="${requestScope.event_detail.getId()}">
			<button type="submit" class="btn btn-primary"
				onclick="validCreditCardNumber();">Submit</button>

		</form:form>
	</div>
	<script type="text/javascript">
function myFunction() {
  var x, text,t;

  // Get the value of the input field with id="numb"
  x = document.getElementById("num").value;
  t = document.getElementById("total").value;

  // If x is Not a Number or less than one or greater than 10
  if (isNaN(x) || x < 1 || x > isNan(t)) {	
    text = false
  } 
  
  if(!text){
	  alert("Enter valid number");
  }
  
function validCreditCardNumber(){
	var isValid = false;
	var cc = document.getElementById("cc").value;
	var visaRegEx = /^(?:4[0-9]{12}(?:[0-9]{3})?)$/;
	 if (visaRegEx.test(ccNum)) {
		    isValid = true;
		  }
	 if(!isValid){
		 alert("Enter correct card Details");
	 }
} 
  
}
</script>

</body>
</html>