<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
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
	src="<%=request.getContextPath()%>/JS/view1dispvalidation.js"> </script>
<meta name="keywords" content="" />
<meta name="description" content="" />
<style>
label {
	display: inline-block;
	float: left;
	clear: left;
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
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>
</div>


<div id='main'><br>

<fieldset><legend>BILL DISPUTE</legend>
<form name="gen" action="BTBMServlet" onsubmit="return validate()"
	method="post"><input type="hidden" name="option"
	value="viewLink"></input>
<table>
	<tr>


		<td><label><%=resourceBundle.getString("customerId")%></label></td>
		<td><input type="text" name="custId"
			value="<%=session.getAttribute("userId")%>" maxlength="6"
			onKeyPress="return isNumberKey(event)" readonly="readonly"></td>
	</tr>




	<tr>
		<td></td>
		<td><span id="cust1error"> </span></td>
	</tr>


	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<td></td>
		<td><input type="submit" name="redirect"
			value="<%=resourceBundle.getString("viewbilldisputes")%>"
			class="button"></td>
	</tr>


</table>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>



