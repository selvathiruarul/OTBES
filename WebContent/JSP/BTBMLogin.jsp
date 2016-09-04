<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page
	import="java.util.Date,com.otbes.language.*,java.util.Locale,java.util.ResourceBundle,java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="com.otbes.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/loginvalidation.js">
</script>
<meta name="keywords" content="" />
<meta name="description" content="" />
<style>
label {
	display: inline-block;
	float: center;
	clear: center;
	width: 250px;
	text-align: left;
}

input {
	display: inline-block;
	float: center;
}
</style>

</head>
<body onKeyDown="return showKeyCode(event)" onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
<%@ include file="/JSP/lingual.jsp"%>
<div id="wrapper">
<div id="wrapper_background">
<div id="header">
<%
	session.setAttribute("page", "LoginPage");
%>
</div>

<div id="tabs">
<ul>
	<li><a href="#" title="Home"><span>HOME</span></a></li>
	<li><a href="#" title="Services"><span>SERVICES</span></a></li>
	<li><a href="#" title="About Us"><span>ABOUT US</span></a></li>
	<li><a href="#" title="Offers"><span>OFFERS</span></a></li>
	<li><a href="#" title="Contact Us"><span>CONTACT US</span></a></li>
</ul>
</div>



<div id='menu'></div>



<div id='main'>
<div id="mandatory">* Mandatory</div>
<fieldset><legend><%=resourceBundle.getString("login")%></legend>
<form name="gen" action="BTBMServlet" method="post"><input
	type="hidden" name="option" value="LoginPage"></input>
<table>





	<tr>
		<td><label><%=resourceBundle.getString("userName")%> * </label></td>
		<td><input type="text" name="uName" size="18" maxlength="6"
			onKeyPress="return isNumberKey(event)"></input><br></br>


		<span id="logerror"> </span></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("password")%>* </label></td>
		<td><input type="password" name="pwd" size="20" maxlength="6"
			onKeyPress="return isAlphanemeric(event)"></input><br></br>


		<span id="log1error"> </span></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("role")%>* </label></td>
		<td><select name="role">
			<option value="Administrator"><%=resourceBundle.getString("administrator")%>
			</option>
			<option value="Customer"><%=resourceBundle.getString("customer")%>
			</option>
		</select></td>
	</tr>
	<tr>
		<td>
		<center><input type="submit"
			value="<%=resourceBundle.getString("submit")%>" class="button"
			onClick="return validate()"></input></center>
		</td>
	</tr>
</table>






</form>

</fieldset>
<form action="changeLanguage.jsp">
<p><label><%=resourceBundle.getString("selectTheLanguage")%></label><select
	name="language">
	<option value="en">English</option>
	<option value="bn">Bengali</option>
	<option value="fr">French</option>
</select> <input type="submit" value="change"></input></p>
</form>




</div>
</div>
</div>
</body>
</html>