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
h2{
background-color:rgba(255,0,0,0.1);
color:maroon;
}
#yo:hover{
box-shadow:2px 3px 4px;
}
#yi:hover{
background-color:#cccccc;
}
</style>
	</head>
	<body>
<form name="fundTransfer" method="get" action="fundTransferActivation.do">
<h2>Fund Transfer:</h2>
<table align="center" width="100%" cellspacing="15">
<tr><td><b>Enter Amount:*</td><td><input type="text" name="enterAmount" style="width:500px" id="yi" placeholder="Enter amount" required></td></tr>
<tr><td><b>Enter Transaction Password:*</td><td><input type="password" name="transPass" style="width:500px" id="yi" placeholder="Type Password" required></td></tr>
<tr><td></td><td><input type="submit" value="Confirm" id="yo">&nbsp&nbsp&nbsp<input type="reset" value="Cancel"  id="yo"></td></tr><br>
</td></tr>
</form>
	</body>
</html>