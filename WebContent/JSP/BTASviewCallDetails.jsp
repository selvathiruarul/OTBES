<%@ page errorPage="/JSP/Error1.jsp"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList,com.otbes.vo.CallDetailVO"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.otbes.language.*"%>
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
<%
ArrayList<CallDetailVO> calldetailslist=(ArrayList<CallDetailVO>)request.getAttribute("CallDetailsList");
%>
<div id="main">

<table class="table" cellspacing="10" cellpadding="10">
	<tr>
		<th class="th"><label><%=resourceBundle.getString("connectionNumber")%></label></th>
		<th class="th"><label><%=resourceBundle.getString("callId")%></label></th>
		<th class="th"><label><%=resourceBundle.getString("calledNumber")%></label></th>
		<th class="th"><label><%=resourceBundle.getString("typeOfCall")%></label></th>
		<th class="th"><label><%=resourceBundle.getString("dateOfCall")%></label></th>
		<th class="th"><label><%=resourceBundle.getString("duration")%></label></th>
		<th class="th"><label><%=resourceBundle.getString("edit")%></label></th>
		<th class="th"><label><%=resourceBundle.getString("delete")%></label></th>
		<td align="left"></td>
	</tr>
	<%
 for(CallDetailVO calldetail:calldetailslist)
 {
 %>
	<tr class="tr">
		<td class="td"><%= calldetail.getConnectionNo() %></td>
		<td class="td"><%= calldetail.getCallID() %></td>
		<td class="td"><%= calldetail.getDialedNo() %></td>
		<td class="td"><%= calldetail.getTypeOfCall() %></td>
		<td class="td"><%= calldetail.getDateOfCall() %></td>
		<td class="td"><%= calldetail.getDuration() %></td>
		<td class="td"><a
			href="BTASServlet?id=<%= calldetail.getCallID() %>&option=updateviewcalldetails">Edit</a></td>
		<td class="td"><a
			href="BTASServlet?id=<%= calldetail.getCallID() %>&option=deletecalldetails">Delete</a></td>
	</tr>
	<%
 }
%>
</table>

</div>
</div>
</div>
</body>
</html>