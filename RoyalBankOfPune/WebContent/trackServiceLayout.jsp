<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Bank of Pune</title>
<link rel="icon" href="HomePageCss\rbpicon.ico" type="image/x-icon"></link>
<script>
	window.location.hash = "no-back-button";
	window.location.hash = "Again-No-back-button";/* again because google chrome don't insert first hash into history */
	window.onhashchange = function() {
		window.location.hash = "no-back-button";
	}
</script>
<style>
table {
	border-style: double;
	border-width: 10px;
	border-color: rgba(255, 0, 0, 0.1);
}
</style>
</head>
<body>

	<h1 style="color: maroon; background-color: rgba(255, 0, 0, 0.1)">Track
		service request</h1>
	<br>
	<br>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<b>Present Service Request Numbers are:</b>
	<br>
	<br>

	<table align="center" style="width: 20%">
		<tr>
			<th colspan=2>Service ID</th>
			<th>Track Service</th>
		</tr>
		<!-- For Loop -->
		<c:forEach items="${serviceList}" var="service">
			<tr>
				<td></td>
				<td>${service.serviceId}</td>
				<td><a
					href="getServiceDetails.do?serviceId=${service.serviceId}">View
						Details</a></td>
			</tr>
		</c:forEach>
		<!-- End For Loop -->
	</table>
</body>
</html>