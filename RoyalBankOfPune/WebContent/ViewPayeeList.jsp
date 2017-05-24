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
h2 {
	background-color: rgba(255, 0, 0, 0.1);
	color: maroon;
}
</style>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h2>List of Payee</h2>
	<br />
	<table border="2">
		<tr>
			<th>Payee Account Id</th>
			<th>Payee Nick Name</th>
			<th>Funds Transfer</th>
		</tr>
		<!-- start for loop -->
		<c:forEach var="payee" items="${payeeTableList}">
			<tr>
				<td>${payee.payeeAccountId}</td>
				<td>${payee.nickName}</td>
				<td><a
					href="fundTransferOperation.do?PayeeAccountId=${payee.payeeAccountId}">Transfer
						Funds</a></td>
			</tr>
		</c:forEach>
		<!-- end for loop -->
	</table>
	<a href="addPayee.do" align="center">Add Payee</a>

</body>
</html>