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
	src="<%=request.getContextPath()%>/JS/update2validation.js"> </script>
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

textarea {
	width: 140px;
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

<div id='main'>
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTBMupdate1.jsp"><b>Back</b></a></p>

<div id="mandatory">* Mandatory</div>
<fieldset><legend>BILL DISPUTE</legend>
<form name="gen" action="BTBMServlet" onsubmit="return validate()"
	method="post"><input type="hidden" name="option" value="update"></input>
<center>
<h4>RESOLVING BILL DISPUTE</h4>
</center>
<table>
	<tr></tr>
	<tr>

	</tr>

	<tr></tr>
	<tr></tr>
	<%
		BTBMVo vo = (BTBMVo) request.getAttribute("result");
	%>

	<tr>
		<td><%=resourceBundle.getString("disputeId")%></td>
		<td><input type="text" name="disputeid"
			value=<%=vo.getDisputeId()%> readonly="readonly"></input></td>
	</tr>
	<%
		// Discrepancyfound  <tr><td><input type="radio"  name="disc"    value="YES" >  Yes</input>    <input type="radio"  name="disc"    value="NO" >  No</input>
	%>
	<tr>
		<td><%=resourceBundle.getString("resolutionComments")%><font
			color="red">*</font></td>
		<td><textarea name="resolution"></textarea> <br></br>
		<span id="reserror"></span></td>
	</tr>
	<tr>
		<td><%=resourceBundle.getString("adjustedCallCost")%><font
			color="red">*</font></td>
		<td><input type="text" name="cost"
			onKeyPress="return isNumberKey(event)"></input></td>
	</tr>
	<tr>
		<td></td>
		<td><span id="costerror"> </span></td>
	</tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<td></td>
		<td><input type="submit"
			value="<%=resourceBundle.getString("update")%>" class="button"></td>
	</tr>



</table>
</form>
</fieldset>
</div>
</div>
</div>

</body>
</html>


