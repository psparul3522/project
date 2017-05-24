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
input#ho:hover {
	box-shadow: 2px 3px 5px;
}

input:hover {
	background-color: #cccccc;
}
</style>
<script type="text/javascript">
	function validatePassword(form) {
		var pswd = form.password.value;
		var rpswd = form.repassword.value;

		if (pswd == rpswd) {
			return true;
		} else {
			alert("Passwords not matching");
			return false;
		}
	}
</script>
</head>
<body>
	<h1>${message}</h1>
	<form action="nowChangePassword.do" method="post"
		onsubmit="return validatePassword(this);">
		<table align="center">
			<h2 style="color: maroon; background-color: rgba(255, 0, 0, 0.1)">CHANGE
				ACCOUNT PASSWORD</h2>
			<br>
			<br>
			<tr>
				<td><b>&#9755; &nbsp Old password:</td>
				<td><input type="password" name="oldPassword"
					placeholder="Enter Your Old password"></td>
			</tr>
			<tr>
				<td><b><br>&#9755; &nbsp New password:</td>
				<td><br>
				<input type="password" name="newPassword"
					placeholder="Enter Your New password"></td>
			</tr>
			<tr>
				<td><b><br>&#9755; &nbsp Confirm New password:</td>
				<td><br>
				<input type="password" name="repassword"
					placeholder="Confirm Your password"></td>
			</tr>
			<tr>
				<td></td>
				<td><br>
				<input type="submit" value="Save" id="ho"> &nbsp &nbsp &nbsp
					<input type="reset" value="Cancel" id="ho"></td>
			</tr>
			<br>
		</table>
	</form>
	<br>
	<br>
	<br>
	<br>

	<table frame="box" align="center" width=100%
		style="background-color: rgba(255, 0, 0, 0.15)">
		<tr>
			<td rowspan="8"><img src="HomePageCss/note.jpg"
				alt="Image cannot be displayed" /></td>
			<td><li>Mandatory fields are marked with an asterisk(*)</li></td>
		</tr>
		<tr>

			<td><li>Profile password should not match the login
					password</li></td>
		</tr>
		<tr>

			<td>
				<li>Password length should be greater than 8 and upto 20
					characters</li>
			</td>
		</tr>
		<tr>

			<td>
				<li>Password should contain at least one digit [0-9],one
					alphabet[A-Z][a-z]and one special character such as [!@$&]</li>
			</td>
		</tr>
		<tr>

			<td><li>Please avoid choosing a password that is generic in
					nature, guessable or inferable</li></td>
		</tr>
		<tr>

			<td><li>Avoid password from your personal data such as
					name,date of birth, address, telephone number and car number</li></td>
		</tr>
		<tr>

			<td><li>It is good practice to commit your password to
					memory rather than write it down somewhere</li></td>
		</tr>
		<tr>

			<td><li>For security reasons change your password regularly</li></td>
		</tr>

	</table>

</body>
</html>