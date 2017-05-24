<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Royal Bank of Pune</title>
<link rel="icon" href="HomePageCss\rbpicon.ico" type="image/x-icon"></link>
<link href="HomePageCss\cd.css" rel="stylesheet">
</head>
<body>
<div class="form-style-10">
<h2 style="color: maroon; background-color: rgba(255, 0, 0, 0.1)">CREDIT CARD APPROVAL</h2>
<form>
    <div class="section"><span>1</span>First Name &amp; Address</div>
    <div class="inner-wrap">
        <label>Your Full Name <input type="text" name="field1" /></label>
		<label>D.O.B<input type="date"/></label>
        <label>Gender
  <input type="radio" name="fb" value="small" />
  <img src="HomePageCss\fb1.png">
  <input type="radio" name="fb" value="small" />
  <img src="HomePageCss\fb2.jpg">
</label>
        <label>Address <textarea name="field2"></textarea></label>
		<label>city<input type="text" name="feild7" placeholder="city name"/></label>
		
    </div>

    <div class="section"><span>2</span>Email &amp; Phone</div>
    <div class="inner-wrap">
        <label>Email Address <input type="email" name="field3" /></label>
        <label>Phone Number <input type="text" name="field4" /></label>
    </div>

    <div class="section"><span>3</span>Employment Details</div>
        <div class="inner-wrap">
        <label>Employment Details</label><select>
		                                                 <option>Emplyment Type</option>
		                                                 <option>Salaried</option>
														 <option>Salaried Doctor</option>
														 <option>Self Employed Business</option>
														 <option>Self Employed Professional</option>
														 <option>Student</option>
														 <option>Retired</option>
														 <option>Homemaker</option>
														 </select>
        
    </div>
    <div class="button-section">
     <input type="submit" name="Sign Up" />
     <span class="privacy-policy">
     <input type="checkbox" name="field7">You agree to our Terms and Policy. 
     </span>
    </div>
</form>
</div>
</body>
</html>