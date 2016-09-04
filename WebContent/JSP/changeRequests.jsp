<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"> </script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
</head>
<body onKeyDown="return
	showKeyCode(event);"
onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
<%
	session.setAttribute("page", "changepwdpage");
%>
<%
	response.setHeader("Pragma", "no-control");
	response.setDateHeader("Cache-Control", 0);
	response.setDateHeader("Expires", 0);
	String user = (String) session.getAttribute("User");
	if (user == null) {
		response.sendRedirect("redirect.jsp");
	}
%>
<div id="wrapper">
<div id="wrapper_background">

<div id="header"></div>

<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%></div>
<div id='main'>
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/profile.jsp"><b>Back</b></a></p>

<fieldset><legend>CHANGE THEME</legend>
<form method="get" action="BTHMServlet"><input type="hidden"
	name="formname" value="formtheme"> <input type="hidden"
	name="userid" size="40" class="input"
	value="<%=session.getAttribute("userId")%>"
	onkeypress="return isNumberKey(event);"><span class="error"
	id="uiderror"></span>
<p><label>Change your theme:</label> <select name="theme"
	onchange="setTheme(this.value)">
	<option value="blue"
		<%if (((String) session.getAttribute("themeColor")).matches("blue")) {%>
		selected="selected" <%}%>>Blue</option>
	<option value="green"
		<%if (((String) session.getAttribute("themeColor")).matches("green")) {%>
		selected="selected" <%}%>>Green</option>
	<option value="orange"
		<%if (((String) session.getAttribute("themeColor")).matches("orange")) {%>
		selected="selected" <%}%>>Orange</option>
	<option value="pink"
		<%if (((String) session.getAttribute("themeColor")).matches("pink")) {%>
		selected="selected" <%}%>>Pink</option>
</select><br></br>
<input type="submit" class="button" value="CHANGE"></input></p>
</form>
</fieldset>

<fieldset><legend>CHANGE PASSWORD</legend>
<form name="changepwd" onsubmit="return changePasswordValidate()"
	action="BTHMServlet"><input type="hidden" name="formname"
	value="formpassword">
<table border="0" cellspacing="10" cellpadding="10">
	<tr>
		<td ALIGN="left"><input type="hidden" name="userid" size="40"
			class="input" value="<%=session.getAttribute("userId")%>"
			onkeypress=returnisNumberKey(event);;
><span class="error"
			id="uiderror"></span>
	</tr>
	<tr>
		<td ALIGN="left"><label class="label">New Password: * </label></td>
		<td ALIGN="left"><input type="password" name="newpass" size="40"
			class="input"><br>
		<span class="error" id="nperror"></span>
	</tr>
	<tr>
		<td ALIGN="left"><label class="label">Re-type New
		Password: * </label></td>
		<td ALIGN="left"><input type="password" name="repass" size="40"
			class="input"><br>
		<span class="error" id="rperror"></span>
	</tr>
	<tr>
		<td ALIGN="center"><input type="submit" value="CHANGE PASSWORD"
			class="button" /></td>
		<td ALIGN="center"><input type="reset" value="RESET"
			class="button" /></td>


	</tr>
</table>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>