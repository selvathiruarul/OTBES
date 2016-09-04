<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.otbes.vo.*"%>
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
	src="<%=request.getContextPath()%>/JS/cancelvalidation.js"> </script>
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

<meta name="keywords" content="" />
<meta name="description" content="" />

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

<div id='main'>
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTBMcancel0.jsp"
	style="text-decoration: none"><b>Back</b></a></p>
<div id="mandatory">* Mandatory</div>
<fieldset><legend><%=resourceBundle.getString("billDispute")%></legend>
<form name="gen" action="BTBMServlet" onsubmit="return validate()"
	method="post"><input type="hidden" name="option"
	value="cancelfirst"></input> <%
 	BTBMVo vo = (BTBMVo) request.getAttribute("result");
 %>

<table>


	<tr>
		<td><%=resourceBundle.getString("billItemId")%></td>
		<td><input type="text" name="billid"
			value="<%=vo.getBillItemId()%>" readonly="readonly"></input></td>
	</tr>
	<tr>
		<td><%=resourceBundle.getString("disputeId")%></td>
		<td><input type="text" name="disputeid"
			value="<%=vo.getDisputeId()%>" readonly="readonly"></td>
	</tr>
	<tr>
		<td><%=resourceBundle.getString("dateOfCancel")%></td>
		<td><input type="text" name="disputeid"
			value="<%=vo.getDateOfCancel()%>" readonly="readonly"></td>
	</tr>

	<tr>
		<td><%=resourceBundle.getString("reasonForCancel")%><font
			color=red>*</font></td>
		<td><textarea name="reasons">  </textarea> <br></br>
		<span id="canerror"> </span></td>
	</tr>

	<tr>
		<td><input type="submit"
			value="<%=resourceBundle.getString("cancel")%>" class="button"></input></td>
	</tr>
</table>

</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>

