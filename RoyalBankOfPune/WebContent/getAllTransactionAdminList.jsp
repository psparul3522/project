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
body{
		background:linear-gradient(to right , white, lightblue);
		}
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
		</style>
</head>
<body>
<h1><img src="HomePageCss\rbpLogo1.jpg"/><img src="HomePageCss\name1.jpg"/><a href="HomePageCss\logoutAdmin.do" style="float:right" id="wer">Logout</a></h1>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border='1'>
		<tr>
				<th>Account Id</th>
				<th>Transaction Id</th>
				<th>Transaction Description</th>
				<th>Transaction Date</th>
				<th>Transaction Type</th>
				<th>Transaction Amount</th>
				
			</tr>
			<!-- start for loop -->
			<c:forEach var="transaction" items="${transactionList}">
			<tr>
			    <td>${transaction.accountId}</td>
				<td>${transaction.transactionId}</td>
				<td>${transaction.tranDescription}</td>
				<td>${transaction.dateOfTransaction}</td>
				<td>${transaction.transactionType}</td>
				<td>${transaction.tranAmount}</td>
				
				
			</tr>
			</c:forEach>
			<!-- end for loop -->
			</table>
</body>
</html>