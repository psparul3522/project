<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Business For Startup</title>
		<style>
h2{
background-color:rgba(255,0,0,0.1);
color:maroon;
}
</style>
<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";/* again because google chrome don't insert first hash into history */
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
	</head>
	<body>
		<h2>Accept OTP for validation</h2><br/>
		<form action="nowAddPayee.do" method="post">
		<table>
			<tr>
				<td>&#9755;&nbsp&nbspPayee  AccountId</td>
				<td>${payeeTable.payeeAccountId}</td>
			</tr>
			<tr>
				<td>&#9755;&nbsp&nbspPayee NickName</td>
				<td>${payeeTable.nickName}</td>
			</tr>
			<tr>
				<td>&#9755;&nbsp&nbsp One Time Password</td>
				<td><input type="text" name="otp" required pattern="[0-9]*"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"></td>
			</tr>
		</table>
		</form>
		
	
	</body>
</html>