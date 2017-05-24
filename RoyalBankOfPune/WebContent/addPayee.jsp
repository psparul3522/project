<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
				<style>
h2{
background-color:rgba(255,0,0,0.1);
color:maroon;
}
table{
font-size:20px;
}
#tu:hover{
box-shadow:2px 4px 3px;
}
#re:hover{
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
	<h2>Add New Payee</h2>
	<form action="showOTP.do" method="post">
	<table align="center">
	<tr>
	<td>
	&#9755;&nbspEnter Payee Account Id:
	</td>
		<td>
			<input type="text" name="payeeAccountId"  style="width:400px" id="re">
		</td>
			</tr>
			<tr>
			<td>
	&#9755;&nbspEnter NickName:
	</td>
		<td>
			<input type="text" name="nickName" style="width:400px" id="re">
		</td>
		</tr>
	</table><br>
	<br>
	<div align="center"><input type="submit" value="Add Payee"  style="width:200px" id="tu"></div>
	</form>
	</body>
</html>