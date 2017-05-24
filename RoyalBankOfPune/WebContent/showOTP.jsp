<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Business For Startup</title>
<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";/* again because google chrome don't insert first hash into history */
window.onhashchange=function(){window.location.hash="no-back-button";}
</script>
<style>
h2 {
	background-color: rgba(255, 0, 0, 0.1);
	color: maroon;
}
</style>
</head>
<body>
	<h2>Activate business account</h2>
	<br />
	<table>
		<tr>
			<td>&#9755;&nbsp&nbsp <b>Payee AccountId</b></td>
			<td>${payeeTable.payeeAccountId}</td>
		</tr>
		<tr>
			<td>&#9755;&nbsp&nbsp <b>Payee NickName</b></td>
			<td>${payeeTable.nickName}</td>
		</tr>
		<tr>
			<td>&#9755;&nbsp&nbsp <b>One Time Password</b></td>
			<td>${otp}</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="getotpEntryPage.do">Activate
					account</a></td>
		</tr>
	</table>


</body>
</html>