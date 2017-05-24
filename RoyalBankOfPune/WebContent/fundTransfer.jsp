<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Bank Of Pune</title>
<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";/* again because google chrome don't insert first hash into history */
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
<style>
a{
font-size:20px;
text-decoration:none;
}

</style>
</head>
<body>
<h2 style="color:maroon;background-color:rgba(255,0,0,0.1)">Fund Transfer</h2>
<br>
<br>
<br>
<a href="fundTransferFromOwnAcct.do">Transfer Funds</a>
<br>
<br>
<br>
<br>
<table frame="box" style="color:maroon;background-color:rgba(255,0,0,0.1)">
	<tr> 	<td rowspan="5"> <img src="HomePageCss\note.jpg" alt="Image cannot be displayed"/></td>
			<td><li>Register Payee before transfering from your Account.</li></td>
	</tr>
	<tr>
			
			<td><li>After adding the Payee the Account Number should be Valid.</li></td>
	</tr>
	<tr>
			
			<td> <li>Be very careful while entering the OTP, else the registration of the Payee will be declined.</li></td>
	</tr>
	<tr>
			
			<td> <li>Re-check the amount entered before making any Transactions.</li></td>
	</tr>
	</table>

</body>
</html>