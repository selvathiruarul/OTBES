<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ page import="com.otbes.language.*"%>
<%@ page import="com.otbes.vo.ConnectionVO"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTBES</title>
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

<div id="wrapper">
<div id="wrapper_background">
<div id="header"></div>


<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>

</div>
<div id="main">
<fieldset><legend><%=resourceBundle.getString("issueANewConnection")%></legend> <%
 	ConnectionVO conn = (ConnectionVO) request.getAttribute("connection");
 %>

<%

	ArrayList<ConnectionVO> connectionlist = (ArrayList<ConnectionVO>) request.getAttribute("tariffname");
%>
<div id="mandatory"><%=resourceBundle.getString("allFieldsAreMandatory")%></div>
<form name="f1" action="BTASServlet" method="post"><input
	type="hidden" name="option" value="addconnction1" />
<table border=0 cellspacing=10 cellpadding=10 align="center">
	<tr>
		<td align="left"><label><%=resourceBundle.getString("customerId")%></label></td>
		<td align="left"><input type="text" value="<%=conn.getCustId()%>" name="id"
			readonly="readonly" /><span id="error"></span></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("typeOfBill")%></label></td>
		<td align="left"><input type="radio" name="mode"
			value="eBill" checked="checked" class="input" /><%=resourceBundle.getString("electronicBill")%> <span id="error"></span><input type="radio" name="mode"
			value="paperBill" class="input"><%=resourceBundle.getString("paperBill")%></td>
	</tr>


	<tr>
		<td align="left"><label><%=resourceBundle.getString("tariffType")%></label></td>
		<td align="left"><select name="tarifftype">
			<%
				for (ConnectionVO connection : connectionlist) {
			%>
			<option value="<%=connection.getTariffType()%>"><%=connection.getTariffType()%>
			</option>

			<%
				}
			%>
		</select></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("status")%></label></td>
		<td align="left"><input type="radio" name="Status" value="Active"
			checked="checked" class="input"/><label>ACTIVE</label></td>

	</tr>

	<tr>
		<td align="left"><input class="button" type="submit" value="<%=resourceBundle.getString("add")%>"></td>
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