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
a:hover {
	background-color: rgba(255, 0, 0, 0.1);
}

a {
	text-decoration: none;
}

#sub:hover {
	box-shadow: 2px 4px 4px;
	cursor: pointer;
}
</style>
</head>
<body>
	<b>Jump to:</b>
	<br>
	<select name="cheque_leaves_no">
		<option value="--Select--">--Select--</option>
		<option value="1">My Accounts</option>
		<option value="15">Payment/Transfer</option>
		<option value="20">Enquries</option>
		<input type="Submit" value="Go" name="Go" id="sub">
		<br>
		<hr>
		<br> &#9755;
		<a href="" target="side-3">Standing Instructions</a>
		<br> &#9755;
		<a href="" target="side-3">SMS Alrets</a>
		<br> &#9755;
		<a href="chequeLayout.html" target="side-3">Cheque Book Issue</a>
		<br> &#9755;
		<a href="" target="side-3">Stop Cheque Payment</a>
		<br> &#9755;
		<a href="" target="side-3">Royal Bank freedom</a>
		<br> &#9755;
		<a href="" target="side-3">Online Nominations</a>
		<br> &#9755;
		<a href="" target="side-3">ATM Card services</a>
		<br> &#9755;
		<a href="" target="side-3">Insta Home Loan Top-up</a>
		<br>
		<hr>
</body>
</html>