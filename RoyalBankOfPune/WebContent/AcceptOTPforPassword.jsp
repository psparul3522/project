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
table {
	border-style: double;
	border-width: 10px;
	border-color: maroon;
}

h2 {
	background-color: rgba(255, 0, 0, 0.1);
	color: maroon;
}

td {
	font-size: 20px;
}

#go:hover {
	box-shadow: 2px 3px 4px;
}

#te:hover {
	background-color: #cccccc;
}
</style>
</head>
<body>
	<H1>
		<img src="HomePageCss/rbpLogo1.jpg" /><img src="HomePageCss/name1.jpg" /><img
			src="HomePageCss\onlinebanking.jpg" alt="Image cannot be displayed"
			align="right" id="img" />
	</H1>
	<br>
	<br>
	<h2>Security Question</h2>
	<br>
	<br>
	<form action="generateNewPassword.do" method="post">
		<table align="center" cellspacing="15">
			<tr>
				<td colspan="2">Your OTP is:</td>
				<td>${requestScope.otp}</td>
			</tr>
			<tr>
				<td>Enter your OTP:</td>
				<td><input type="text" name="otp"
					placeholder="Enter your OTP" id="te" required></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="submit answer" id="go"></td>
			</tr>
		</table>

	</form>

	</table>
</body>
</html>