<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<title>Royal Bank of Pune</title>
<link rel="icon" href="HomePageCss\rbpicon.ico" type="image/x-icon"></link>
<style>
body {
	background: linear-gradient(to right, white, lightblue);
}

#bu {
	background-color: #2d5986;
	padding: 15px 32px;
	text-align: center;
	margin: 4px 2px;
	cursor: pointer;
	display: inline-block;
	align: center;
}

#re:hover {
	background-color: #cccccc;
}

#bu:hover {
	box-shadow: 2px 3px 4px;
}

a {
	color: white;
	text-decoration: none;
}

td {
	font-size: 20px;
}

h2 {
	background-color: #cc0000;
	color: white;
}
</style>
<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";/* again because google chrome don't insert first hash into history */
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
</HEAD>
<BODY>
	<H1>
		<img src="HomePageCss/rbpLogo1.jpg" /><img src="HomePageCss/name1.jpg" /><img
			src="HomePageCss\onlinebanking.jpg" alt="Image cannot be displayed"
			align="right" id="img" />
	</H1>
	<h2>Admin Login</h2>
	<br>
	<form action="authenticateAdmin.do" method="post">
		<TABLE cellspacing="20px" width="400" align="center">
			<TR>
				<Td colspan=2>Username:</Td>
				<Td><input type="text" name="userName" id="re"
					style="width: 400px" placeholder="Enter UserName"></Td>
			</TR>
			<TR>
				<Td colspan=2>Password:</Td>
				<Td><input type="password" name="password" id="re"
					style="width: 400px" placeholder="Enter Password"></Td>
			</TR>
			<tr>
				<td></td>
				<td></td>
				<td><BUTTON id="bu" align="center">
						<A HREF="create.html">Login</A>
					</BUTTON></td>
			</tr>
		</TABLE>

	</form>

</BODY>
</HTML>