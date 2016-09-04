<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.otbes.vo.*"%>
<%@ page import="java.util.*"%>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OTBES</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/view3validation.js">
</script>
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
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTBMView1disp.jsp"><b>Back</b></a></p>

<fieldset><legend><%=resourceBundle.getString("billDispute")%></legend>
<form action="BTBMServlet" method="post" name="gen"><input
	type="hidden" name="option" value="selectId"></input>
<table>
	<% BTBMVo vo = (BTBMVo) request.getAttribute("result"); %>
	<% int index=vo.getIndex();
   %>
	<tr>
		<td><%=resourceBundle.getString("selectTheDisputeIdToViewDetails")%></td>
		<td><select name="dispId">
			<option SELECTED>SELECT</option>

			<%
for(int i=0;(i<index);i++)
{%>

			<option value="<%= vo.getList().get(i) %>"><%= vo.getList().get(i) %></option>


			<% }%>
		</select><br>
		<span id="iderror"></span></td>
	</tr>

	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<td><input type="submit"
			value="<%=resourceBundle.getString("submit")%>"
			onclick="return validate()" class="button"></input></td>
	</tr>
</table>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>



