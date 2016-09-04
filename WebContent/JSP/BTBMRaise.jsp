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
	src="<%=request.getContextPath()%>/JS/raisevalidation.js"> </script>

<meta name="keywords" content="" />
<meta name="description" content="" />
<style>
label {
	display: inline-block;
	float: center;
	clear: left;
	width: 150px;
	text-align: left;
}

input {
	display: inline-block;
	float: center;
	width: 150px;
}

textarea {
	display: inline-block;
	float: center;
	width: 200px;
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
<div id="mandatory">* Mandatory</div>
<fieldset><legend>BILL DISPUTE</legend>
<h1 style="text-align: center"><%=resourceBundle.getString("raiseABillDispute")%></h1>
<form name="gen" action="BTBMServlet" onsubmit="return validate()"
	method="post"><input type="hidden" name="option" value="Raise"></input>

<table>

	<tr>

		<td><label> <%=resourceBundle.getString("customerId")%>
		<font color=red> * </font></label></td>
		<td><input type="text" name="custid"
			value="<%=session.getAttribute("userId")%>" size="15" maxlength="6"
			onKeyPress="return isNumberKey(event)" readonly="readonly"></input><br></br>
		<span id="custerror"> </span></td>
	</tr>

	<tr>
		<td><label><%=resourceBundle.getString("billItemId")%> <font
			color=red> * </font></label></td>
		<td><input type="text" name="id" size="15" maxlength="7"
			onKeyPress="return isNumberKey(event)"></input><br></br>
		<span id="bilit1error"> </span></td>
	</tr>



	<tr>

		<td><label><%=resourceBundle.getString("reason")%> <font
			color=red> * </font></label></td>
		<td><textarea name="r"></textarea><br></br>
		<span id="reaserror"> </span></td>


	</tr>

	<tr>
		<td><input type="submit"
			value="<%=resourceBundle.getString("submit")%>" class="button"></input></td>
		<td><input type="reset" value="Reset" class="button"></input></td>
	</tr>
</table>


</form>
</fieldset>
</div>
</div>
</div>


</body>
</html>
