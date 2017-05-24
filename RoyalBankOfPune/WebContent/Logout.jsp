<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Bank of Pune</title>
<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";/* again because google chrome don't insert first hash into history */
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
<link rel="icon" href="HomePageCss\rbpicon.ico" type="image/x-icon"></link>

</head>
<body>
	<img src="HomePagecss\rbpLogo1.jpg" alt="Image cannot be displayed"/>
	<img src="HomePagecss\name1.jpg" alt="Image cannot be displayed"/>
	<img src="HomePageCss\onlinebanking.jpg" alt="Image cannot be displayed" align="right" id="img"/><br>
<H1 style="color:maroon;background-color:rgba(255,0,0,0.1)"><b>You Have Logged Out Successfully</b></H1>
<button><a href="mainMenu.do" >Home Page</a></button>
</body>
</html>