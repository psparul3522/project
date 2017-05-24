<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Bank of Pune</title>
<link rel="icon" href="HomePageCss\rbpicon.ico" type="image/x-icon"></link>
<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";/* again because google chrome don't insert first hash into history */
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
<style>
input#add:hover {
	box-shadow: 2px 3px 4px;
}

#tex:hover {
	background-color: #cccccc;
}
</style>
</head>
<body>
	<H1 style="color: maroon; background-color: rgba(255, 0, 0, 0.1)">
		<b>Edit Your Mobile Number:</b>
	</H1>
	<form name="edit number" method="get" action="numberChanged.do">
		<p>Enter the address where you will be using the service.The
			address determines the taxes and subscription availability.</p>
		<table align="center" width="80%" cellpadding="15">

			<tr>
				<td><b>&#9755;&nbsp Old Mobile Number:*</td>
				<td><input type="text" name="oldMobileNo" style="width: 500px"
					id="tex" placeholder="Enter your old number" required></td>
				<td style="color: red">${message}
			</tr>

			<tr>
				<td><b>&#9755; &nbsp New Mobile Number:*</td>
				<td><input type="text" name="newMobileNo" style="width: 500px"
					id="tex" placeholder="Enter your new number" required></td>
			</tr>


			<tr>
				<td></td>
				<td><input type="submit" value="Submit Information" id="add">&nbsp&nbsp<input
					type="reset" value="Reset" id="add"></td>
			</tr>
			<br>
			</td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<table frame="box"
		style="color: maroon; background-color: rgba(255, 0, 0, 0.1)">
		<tr>
			<td rowspan="5"><img src="HomePageCss\note.jpg"
				alt="Image cannot be displayed" /></td>
			<td><li>Your mobile number will be updated within 7 working
					days after receipt of the request and complete documentation</li></td>
		</tr>
		<tr>

			<td><li>Joint account holders need to fill separate request
					for mobile number change</li></td>
		</tr>
		<tr>

			<td>
				<li>For any other queries or to know the status of an existing
					application, please call up PhoneBanking or write to us with the
					details mentioned.</li>
			</td>
		</tr>
		<tr>

			<td>
				<li>Your complete new mobile number should be active</li>
			</td>
		</tr>
	</table>

</body>
</html>
