<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Royal Bank of Pune</title>
<link rel="icon" href="HomePageCss\rbpicon.ico" type="image/x-icon"></link>
<link href="cascade.css" rel="stylesheet">
<style>
#wer {
	background-color: #1abc9c;
	border: none;
	color: white;
	padding: 15px 32px;
	font-size: 20px;
	text-align: center;
	margin: 4px 2px;
	cursor: pointer;
	display: inline-block;
	text-decoration: none;
	box-shadow: 2px 3px 4px black;
}

body {
	background: linear-gradient(to right, white, lightblue);
}
</style>
<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";/* again because google chrome don't insert first hash into history */
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
</head>

<body>
	<h1>
		<img src="HomePageCss\rbpLogo1.jpg" /><img src="HomePageCss\name1.jpg" /><a
			href="logoutAdmin.do" style="float: right" id="wer">Logout</a>
	</h1>
	<br>
	<br>

	<a href="adminCreateAccount.do" id="wer">Create New Account</a>
	<a href="adminGetTrans.do" id="wer">Get Transactions</a>
</body>
</html>
