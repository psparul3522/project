<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Bank of Pune</title>
<link rel="icon" href="HomePageCss\rbpicon.ico" type="image/x-icon"></link>
<style>
h2{
background-color:rgba(255,0,0,0.1);
color:maroon;
}
</style>
</head>
<body>
	<BODY>
	<H2><img src="HomePageCss\rbpLogo1.jpg"/>ROYAL BANK OF PUNE</H2>
	<FORM name="Two Wheeler Loan Application" method="post">
	<TABLE cellspacing="20px">
		<TR><TH colspan = 2>TWO WHEELER LOAN</TH></TR>
		<TR><TD><LABEL>First Name:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "cfname" type= "textbox" pattern= "[a-zA-Z]{2,15}" required title= "First Name should contain a-z, A-Z and max 15 characters long" placeholder= "First Name"  style="width:500px" autofocus ></TD></TR>
		<TR><TD><LABEL>Last Name:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "clname" type= "textbox" pattern= "[a-zA-Z]{2,15}" required title= "Last Name should contain a-z, A-Z and max 15 characters long" placeholder= "Last Name" style="width:500px" ></TD></TR>
		<TR><TD><LABEL>Phone Number:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "cphone" type= "textbox" pattern= "[0-9]{10}"  required title= "Phone No. should contain only numbers and should be of 10 digits" placeholder= "Phone No." style="width:500px"></TD></TR>
		<TR><TD><LABEL>Gender:<SPAN>*</SPAN></LABEL></TD>
			<TD><input type="radio" name="Gender" value="Male" required checked>Male
				<input type="radio" name="Gender" value="Female">Female
			</TD>
		</TR>
		<TR><TD><LABEL>Date Of Birth:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "DOB" type= "date"  max= "1999-01-02" style="width:500px" required></TD></TR>
		<TR><TD><LABEL>Email:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" type= "email" required placeholder= "Email" style="width:500px"></TD></TR>
		<TR><TD><LABEL>Address Line 1:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "caddress1" type= "textbox" required title= "This field is required" placeholder= "Address Line 1" style="width:500px"></TD></TR>
		<TR><TD><LABEL>Address Line 2:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "caddress2" type= "textbox" required title= "This field is required" placeholder= "Address Line 2" style="width:500px"></TD></TR>
		<TR><TD><LABEL>Address Line 3:</LABEL></TD><TD><input class= "field" id= "caddress3" type= "textbox" title= "" placeholder= "Address Line 3" style="width:500px"></TD></TR>
		<TR><TD><LABEL>State:<SPAN>*</SPAN></LABEL></TD>
			<TD><input class="field" id="state" name="state" type="text" list="cstate" required placeholder="Select State" style="width:500px">
				<datalist id = "cstate" title="Select State">
				<option value="Andaman & Nicobar Islands" selected>
				<option value="Andhra Pradesh">
				<option value="Arunachal Pradesh">
				<option value="Assam">
				<option value="Bihar">
				<option value="Chandigarh">
				<option value="Chhatisgarh">
				<option value="Dadra & Nagar Haveli">
				<option value="Daman & Diu">
				<option value="Delhi">
				<option value="Goa">
				<option value="Gujarat">
				<option value="Haryana">
				<option value="Himachal Pradesh">
				<option value="Jammu & Kashmir">
				<option value="Jharkhand">
				<option value="Karnataka">
				<option value="Kerala">
				<option value="Lakshadweep">
				<option value="Madhya Pradesh">
				<option value="Maharashtra">
				<option value="Manipur">
				<option value="Meghalaya">
				<option value="Mizoram">
				<option value="Nagaland">
				<option value="Puducherry">
				<option value="Punjab">
				<option value="Rajasthan">
				<option value="Sikkim">
				<option value="Tamil Nadu">
				<option value="Telangana">
				<option value="Tripura">
				<option value="Uttar Pradesh">
				<option value="Uttarakhand">
				<option value="West Bengal">
				</datalist>	
			</TD>	
		</TR>
		<TR><TD><LABEL>City:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "ccity" type= "textbox" required title= "This field is required" placeholder= "City" style="width:500px"></TD></TR>
		<TR><TD><LABEL>Pincode:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "cpincode" type= "textbox" pattern= "[0-9]{6}"  required title= "Pincode should contain only numbers and should be of 6 digits" placeholder= "Pincode" style="width:500px"></TD></TR>
		<TR><TD><LABEL>Manufacturer:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "cmanufacturer" type= "textbox" pattern= "[a-zA-Z]" required title= "Manufacturer Name should contain a-z, A-Z" placeholder= "Manufacturer" style="width:500px"></TD></TR>
		<TR><TD><LABEL>Model:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "cmodel" type= "textbox" pattern= "[a-zA-Z]" required title= "Model Name should contain a-z, A-Z" placeholder= "Model" style="width:500px"></TD></TR>
		<TR><TD><LABEL>Ex-Showroom Price:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "cexshowroom Price" type= "textbox" pattern= "[0-9]{10}"  required title= "Ex-Showroom Price should contain only numbers" placeholder= "Ex-Showroom Price" style="width:500px"></TD></TR>
		<TR><TD><LABEL>Employeement Type:<SPAN>*</SPAN></LABEL></TD>
			<TD><input class="field" id="employment" name="employment" type="text" list="cemployment" required placeholder="Select Employement" style="width:500px">
				<datalist id = "cemployment" title="Select Employement">
				<option value="Self Employeed" selected>
				<option value="Salaried">
				<option value="Student">
				<option value="Retired">
				</datalist>	
			</TD>	
		</TR>
		<TR><TD><LABEL>Annual Income:<SPAN>*</SPAN></LABEL></TD><TD><input class= "field" id= "cincome" type= "textbox" pattern= "[0-9]{10}"  required title= "It should contain only numbers" placeholder= "Salary" style="width:500px"></TD></TR>
		<TR class="align"><TD colspan =2><PRE><input class="field" type="submit" value="Submit Information">    <input class="field" type = "reset" value="Clear"></TD></PRE></TR>
</BODY>
</body>
</html>