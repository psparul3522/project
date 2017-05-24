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
	<table align="center" border='1'>
		<tr>
			<th>Service ID</th>
			<th>Service Description</th>
			<th>Service Raise Date</th>
			<th>Service Status</th>
		</tr>
		<tr>
			<td>${ serviceTracker.serviceId}</td>
			<td>${ serviceTracker.serviceDescription}</td>
			<td>${ serviceTracker.serviceRaisedDate}</td>
			<td>${ serviceTracker.serviceStatus}</td>
		</tr>

	</table>
</body>
</html>