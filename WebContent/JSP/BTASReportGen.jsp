<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.otbes.language.*"%>
	<%@ page import = "com.otbes.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/addcustomer.js"></script>
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
<fieldset>
<form action="BTASServlet" method="post">

<input type="hidden"  name="option" value="reportGen"></input>
 
<% ReportVo repVo = (ReportVo) request.getAttribute("result"); %>

<input type="hidden"   name="std" value="<%=repVo.getStdCalls() %>" ></input>
<input type="hidden"  name="isd"  value="<%=repVo.getIsdCalls() %>" ></input>
<input type="hidden"  name="local" value="<%=repVo.getLocalCalls()%>" ></input>

<table>
<tr><td>Customer ID</td><td><%=repVo.getCustomerId() %></td></tr>
<tr><td>Total Calls</td><td><%=repVo.getTotalCalls() %></td></tr>
<tr><td>STD Calls</td><td><%=repVo.getStdCalls() %></td></tr>
<tr><td>ISD Calls</td><td><%=repVo.getIsdCalls() %></td></tr>
<tr><td>LOCAL Calls</td><td><%=repVo.getLocalCalls() %></td></tr>
<tr><td>Total Calls %</td><td><%=repVo.getTotalCalls() %></td></tr>
<tr><td>STD Calls %</td><td><%=(repVo.getStdCalls()*100)/(repVo.getTotalCalls()) %>%</td></tr>
<tr><td>ISD Calls %</td><td><%=(repVo.getIsdCalls()*100)/(repVo.getTotalCalls()) %>%</td></tr>
<tr><td>LOCAL Calls %</td><td><%=(repVo.getLocalCalls()*100)/(repVo.getTotalCalls()) %>%</td></tr>
<%request.setAttribute("new", repVo); %>




<tr><td><input class="button" type="submit" value="submit"></input></td></tr>
</table>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>
