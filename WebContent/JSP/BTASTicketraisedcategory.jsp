<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.otbes.language.*"%>
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
	src="<%=request.getContextPath()%>/JS/addcustomer.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/CALENDAR_JS/dateJS.js"> </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<script>
            
         </script>
<meta name="keywords" content="" />
<meta name="description" content="" />

</head>
<body onKeyDown="return showKeyCode(event)"
	onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires",0);
String role=(String)session.getAttribute("User");

if(role==null)
	response.sendRedirect("index.jsp");
%>

<div id="wrapper">
<div id="wrapper_background">

<div id="header"></div>


<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>

<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>

</div>
<div id='main'>
<form name="myform" method="post"
	action="BTASServlet?option=generatereporthelpdesktable&currentpage=0&noofrecperpage=10" onsubmit="return validateDate()">

<fieldset><legend>HELPDESKTICKET REPORT CATEGORYWISE</legend>

<table>
	<tr>
		<td ALIGN="left"><label>FROM:</label></td>
		<td ALIGN="left"><input type="text" name="fromdate" id="datefrom"></input>
		<img
			src="<%=request.getContextPath()%>/IMAGES/CALENDAR_IMAGES/cal.gif"
			class="calendar" style="cursor: pointer;"
			onclick="javascript:NewCssCal ('datefrom','ddMMyyyy')" /> <span
			class="error" id="dojerror">*</span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label>TO:</label></td>
		<td ALIGN="left"><input type="text" name="todate" id="dateto"></input>
		<img
			src="<%=request.getContextPath()%>/IMAGES/CALENDAR_IMAGES/cal.gif"
			class="calendar" style="cursor: pointer;"
			onclick="javascript:NewCssCal ('dateto','ddMMyyyy')" /> <span
			class="error" id="dojerror">*</span></td>
	</tr>
	<tr>
		<td><input class="button" type="submit" value="Generate"></input></td>
	</tr>
</table>
</fieldset>



</form>






</div>
</div>
</div>
</body>
</html>