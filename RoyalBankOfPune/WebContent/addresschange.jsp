<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Bank of Pune</title>
<link rel="icon" href="HomePageCss\rbpicon.ico" type="image/x-icon"></link>
<style>
input#add:hover{
	box-shadow:2px 3px 4px;
}
#tex:hover{
background-color:#cccccc;
}
</style>
<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";/* again because google chrome don't insert first hash into history */
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
</head>
<body>
<H1 style="color:maroon;background-color:rgba(255,0,0,0.1)"><b>Edit Your Personal address:</b></H1>
<form name="edit address" method="get" action="addressChanged.do">
<h2>Old Address: ${address}</h2>
<p>Enter the address where you will be using the service.The address determines the taxes and subscription availability. </p>
<table align="center" width="100" cellpadding="15">
<tr><td>&#9755;&nbsp<b>Address:</td><td><textarea rows="5" coloumn="10" type="text" name="address1" style="width:500px" id="tex" placeholder="Enter your Address"required></textarea></td></tr>
<tr><td></td><td><input type="submit" value="Submit Information" id="add">&nbsp&nbsp<input type="reset" value="Cancel" id="add"></td></tr><br>
</td></tr>
</table>
</form>

<br>
<br>
<table frame="box" style="color:maroon;background-color:rgba(255,0,0,0.1)">
	<tr> 	<td rowspan="5"> <img src="HomePageCss\note.jpg" alt="Image cannot be displayed"/></td>
			<td><li>Your mailing address will be updated within 7 working days after receipt of the request and complete documentation</li></td>
	</tr>
	<tr>
			
			<td><li>Joint account holders need to fill separate request for address change</li></td>
	</tr>
	<tr>
			
			<td> <li>For any other queries or to know the status of an existing application, please call up PhoneBanking or write to us with the details mentioned.</li></td>
	</tr>
	<tr>
			
			<td> <li>Your complete new address and PIN code</li></td>
	</tr>
	</table>
	
</body>
</html>                                                                                                                                                                                                                      