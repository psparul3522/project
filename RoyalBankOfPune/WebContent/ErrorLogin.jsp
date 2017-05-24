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
</head>
<body>
	<h2 style="background-color: rgba(255, 0, 0, 0.1)";>Login Error</h2>
	<img src="HomePageCss/d3.jpeg" width="60px" height="60px">
	<h3>Wrong username and password</h3>

	<br />
	<a href="AdminLogin.jsp">Admin HomePage</a>
</body>
</html>