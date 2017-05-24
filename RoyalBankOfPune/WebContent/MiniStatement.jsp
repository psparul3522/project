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
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<H1 style="color: maroon; background-color: rgba(255, 0, 0, 0.1)">
		<b>Mini Statement</b>
	</H1>
	<table border='1'>
		<tr>
			<th>Transaction Id</th>
			<th>Transaction Description</th>
			<th>Transaction Date</th>
			<th>Transaction Type</th>
			<th>Transaction Amount</th>

		</tr>
		<!-- start for loop -->
		<c:forEach var="transaction" items="${newList}">
			<tr>
				<td>${transaction.transactionId}</td>
				<td>${transaction.tranDescription}</td>
				<td>${transaction.dateOfTransaction}</td>
				<td>${transaction.transactionType}</td>
				<td>${transaction.tranAmount}</td>


			</tr>
		</c:forEach>
		<!-- end for loop -->
	</table>

	<h3>Your Account Balance is Rs ${accountBalance}</h3>
</body>
</html>