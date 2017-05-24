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
div {
	text-align: center;
}

input#cli:hover {
	box-shadow: 2px 3px 4px;
}

input#ser:hover {
	background-color: #cccccc;
}
</style>
</head>
<body>
	<H1 style="color: maroon; background-color: rgba(255, 0, 0, 0.1)">
		Cheque Book</H1>
	<br>
	<br>
	<br>
	<form action="requestCheck.do" method="post">
		<table width="100%" frame="void" class="table1">
			<!-- <tr>
				<th>&#9755;&nbsp Service Description</th>
				<td><input type="text" name="serviceDesc"
					placeholder="Enter Your Request" id="ser"></td>
			</tr> -->
			<!-- <tr><td colspan="2" align="center"><input type="submit"></td></tr> -->
			<%-- <tr><td><a href="requestCheck.do?accountId=${userTable.accountId}"></a>Request CheckBook</td></tr> --%>
		</table>
		<br> <br> <br> <br>
		<div>
			<input type="Submit" value="Raise Request for New ChequeBook" id="cli">
		</div>
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<table frame="box"
		style="color: maroon; background-color: rgba(255, 0, 0, 0.1)">
		<tr>
			<td rowspan="5"><img src="HomePageCss\note.jpg"
				alt="Image cannot be displayed" /></td>
			<td><li>As per Bank's policy, only Multicity Cheque Book is
					available for this account</li></td>
		</tr>
		<tr>

			<td><li>You can request for a cheque book for any of your
					accounts (Savings, Current, Cash Credit, Over Draft)</li></td>
		</tr>
		<tr>

			<td>
				<li>Bearer Cheque:A person holding the cheque can collect the
					amount if it is a bearer cheque</li>
			</td>
		</tr>
		<tr>

			<td>
				<li>Order Cheque: The payee (i.e. the person in whose favour
					the cheque is issued) only or his authorized person only can
					collect the amount of the cheque if it is an order cheque</li>
			</td>
		</tr>
	</table>

</body>
</html>