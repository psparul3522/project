<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<HEAD>
		<TITLE>Get Transaction</TITLE>
		<LINK href="cascade.css" rel="stylesheet"/>
		<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";/* again because google chrome don't insert first hash into history */
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
	</HEAD>
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
		a{
		text-decoration:none;
		font-size:20px;
		}
		</style>
<BODY>
<H1><img src="HomepageCss\rbpLogo1.jpg"/><img src="HomePageCss\name1.jpg"/><a href="logoutAdmin.do" style="float:right" id="wer">Logout</a></H1>
&#9755;<A HREF="getAllTransactionAdmin.do">Get All</A>
<br>
<br>
&#9755;<a href="AdminPage.jsp">Admin HomePage</a>
</BODY>
</HTML>