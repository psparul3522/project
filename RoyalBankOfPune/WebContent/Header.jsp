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
ul{
margin:0;
padding:0;
overflow:hidden;
text-decoration:none;
list-style-type:none;
}
li{
float:left;
}
li a{
display:block;
color:white;
text-align:center;
padding:10px;
background-color:black;
}
li a:hover{
background-color:#1abc9c;
}
button:hover{
box-shadow:2px 3px 4px;

}
a#col{
color:white;
text-decoration:none;
}
button{
background-color:#2d5986;
text-align:center;
padding:5px;
cursor:pointer;
}
pre{
text-align:center;
background-color:#cccccc;
}
img{
border-radius:2px 3px;
}
</style>
</head>
<body>
	<pre id="pre1"> <a href ="AboutRBP.jsp"target="side-3" >About RBP</a></pre>  
	
	<a href="AfterLogin.jsp"><img src="HomePagecss\rbpLogo1.jpg" alt="Image cannot be displayed"/></a>
	<a href="AfterLogin.jsp"><img src="HomePagecss\name1.jpg" alt="Image cannot be displayed"/></a>
	<img src="HomePageCss\onlinebanking.jpg" alt="Image cannot be displayed" align="right" id="img"/><br>
	<button  style="float:right"><a href="logout.do" id="col"><b>LOGOUT</b></a></button>
	
	
	<p align="right"><strong>Welcome ${customer.customerName} </strong></p> 
	
	<!-- style="text-decoration: none" -->
	
	<ul>
	 <li><a href ="products.jsp" target=_blank  >Products & Services </a></li> 
		<li><a href ="getBalance.do" target="side-3" >Get Balance</a></li>
		<li><a href ="InterestRate.jsp" target=_blank >Interest Rates</a> </li>
		<li><a href ="changePassword.do" target="side-3" > Change Profile Password</a></li>
		<li><a href ="changeMobileNo.do" target="side-3" > Change Mobile Number</a></li>
		<li><a href ="trackService.do"target="side-3">Track service</a></li>
		<li><a href ="changeAddress.do"target="side-3">Change address</a></li>
		<li><a href ="miniStatement.do"target="side-3" >MiniStatement</a></li>
		<li><a href ="chequeLayout.do"target="side-3" >Cheque Book Issue</a></li>
		<li><a href ="fundTransfer.do"target="side-3" >Fund Transfer</a></li>
		
		
	</ul>
	
</body>
</html>