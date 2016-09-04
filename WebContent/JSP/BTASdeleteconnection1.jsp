<%@ page errorPage="/JSP/Error1.jsp"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.otbes.vo.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/customerid.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
</head>
<body onKeyDown="return showKeyCode(event)"  onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires",0);
String role=(String)session.getAttribute("User");

if(role==null)
	response.sendRedirect("index.jsp");
%>

<%ArrayList<ConnectionVO> connlist=(ArrayList<ConnectionVO>)request.getAttribute("deleteconnection1");%>
<div id="wrapper">
<div id="wrapper_background">
<div id="header"></div>
<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>

</div>

<div id="main">
<fieldset><legend><%=resourceBundle.getString("deleteConnection")%></legend>
<form name="f1" action="BTASServlet" onsubmit="return reasonforcancellation()"
	method="post"><input type="hidden" name="option"
	value="deleteconnection1" />
<table align="left" cellpadding="10" cellspacing="10">
	<tr>
		<td align="left"><label><%=resourceBundle.getString("connectionNumber")%></label></td>
		<td align="left"><select name="number">
			<% for(ConnectionVO connection:connlist)
{%>
			<option value="<%=connection.getConnectionNo()%>"><%=connection.getConnectionNo()%>
			</option>
			<%} %>
		</select></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("reasonForCancellation")%></label></td>
		<td align="left"><textarea name="reason"></textarea><span id="rerror"></span></td>
	</tr>
	<tr>
		<td align="left"><input class="button" type="submit" value="<%=resourceBundle.getString("delete")%>"></td>
		<td align="left"><input class="button" type="reset" value="<%=resourceBundle.getString("reset")%>"></td>
	</tr>
</table>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>