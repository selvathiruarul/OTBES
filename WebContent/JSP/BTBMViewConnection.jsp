<%@ page
	import="java.util.Date,com.otbes.language.*,java.util.Locale,java.util.ResourceBundle,java.text.SimpleDateFormat"%>
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
	src="<%=request.getContextPath()%>/JS/viewconnvalidation.js">
</script>
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




<div id='main'>


<fieldset><legend><%=resourceBundle.getString("billGeneration")%></legend>
<form name="gen" action="BTBMServlet" onsubmit="return validate()"
	method="post">
<center>
<h2><b><%=resourceBundle.getString("viewBill")%> </b></h2>
</center>
<center>
<h4><b><%=resourceBundle.getString("enterTheConnectionNumber")%></b></h4>
<table>
	<tr>
		<td><%=resourceBundle.getString("connectionNumber")%></td>
		<td><input type="text" name="connection" maxlength="8"
			onKeyPress="return isNumberKey(event)"></input><br></br>
		<span id="conerror"> </span></td>
	</tr>
</table>
<br>

<input type="submit" name="submit"
	value=<%=resourceBundle.getString("submit")%> class="button"> <input
	type="reset" name="reset" value=<%=resourceBundle.getString("reset")%>
	class="button"> <input type="hidden" name="option"
	value="view1"></input></center>
</form>
</fieldset>
</div>
</div>
</div>

</body>
</html>