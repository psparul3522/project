<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create New Account
</title>
<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";/* again because google chrome don't insert first hash into history */
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
<style>
		#wer{
		background-color:#1abc9c;
		border:none;
		color:white;
		font-size:20px;
		padding:15px 32px;
		text-align:center;
		margin:4px 2px;
		cursor:pointer;
		display:inline-block;
		text-decoration:none;
		}
		body{
		background:linear-gradient(to right , white, lightblue);
		}
		input:hover,textarea:hover{
		background-color:#cccccc;
		}
		</style>
<link href="cascade.css" rel="stylesheet">
</head>
<body>
<H1><img src="HomePageCss\rbpLogo1.jpg"/><img src="HomePageCss\name1.jpg"/><a href="logoutAdmin.do" style="float:right" id="wer">Logout</a></H1>
<form action="registerNewaccount.do" method="post">
<table cellspacing=20 align="center" style="text-align:left">
<tr><th>Account Holder Name:<SPAN>*</SPAN></th><th><input type="text" name="name" placeholder="Enter Your Name" style="width:500px" pattern=[A-Za-z]* required></th></tr>
<tr><th>Address:<SPAN>*</SPAN> </th><th><textarea rows=5 columns=10 name="address" placeholder="Enter Your Address" style="width:500px" required></textarea></th></tr>
<tr><th>Mobile Number:<SPAN>*</SPAN> </th><th><input type="number" name="mob" placeholder="Enter Mobile Number" style="width:500px" pattern=[0-9]* required></th></tr>
<tr><th>Email Id:<SPAN>*</SPAN></th><th><input type="email" name="mail" placeholder="Enter Your Email" style="width:500px" required></th></tr>
<tr><th>Pancard:<SPAN>*</SPAN></th><th><input type="text" name="pancard" placeholder="Enter Pancard" style="width:500px"required></th></tr>
<tr><th>Account Type: <SPAN>*</SPAN></th><th><input type="radio" name="accType" value="Savings" >Savings
											 <input type="radio" name="accType" value="Current">Current</th></tr>
<tr><th>Password:<SPAN>*</SPAN></th><th><input type="text" name="password" placeholder="Enter Password" style="width:500px"required></th></tr>
<tr><th>Secret Question:<SPAN>*</SPAN></th><th><input type="text" name="secretQuestion" placeholder="Enter Secret Question" style="width:500px"required></th></tr>
<tr><th>Secret Answer:<SPAN>*</SPAN></th><th><input type="text" name="secretAnswer" placeholder="Enter secret Question Answer" style="width:500px"required></th></tr>
<tr><th>Transaction Password:<SPAN>*</SPAN></th><th><input type="text" name="transactionPassword" placeholder="Enter Transaction Password" style="width:500px"required></th></tr>
<tr><th>Balance:<SPAN>*</SPAN></th><th><input type="number" name="balance" placeholder="Enter Your Opening Balance" style="width:500px"></th></tr>
<tr><th colspan="2" align="center"><input type="submit" value="Submit"/></th></tr>
</table>
<br/>
<a href="AdminPage.jsp">Admin HomePage</a>
</form>
</body>
</html> 