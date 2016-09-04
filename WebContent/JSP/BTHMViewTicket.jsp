<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java" %>
    <%@ page import="com.otbes.vo.BTHMTicketVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>View Ticket Details</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
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

<div id="menu">
<%@ include file="/JSP/sidepane.jsp" %>
</div>

<div id="main">
<form  name="ViewDetails">
<p align="right"><a href="<%=request.getContextPath()%>/JSP/BTHMViewTicketDetailsAdmin.jsp"><b>BACK</b></a></p>
<fieldset>
<legend><%=resourceBundle.getString("viewTicketDetails")%></legend>

<%
	BTHMTicketVO s = (BTHMTicketVO)request.getAttribute("ticketVO");
%> 

<table border="0">
<tr><td  ALIGN="left"><label><%=resourceBundle.getString("ticketId")%></label></td><td  ALIGN="left"><%out.println(s.getTicketId()); %></td></tr>
<tr></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td  ALIGN="left"><label><%=resourceBundle.getString("description")%>:</label></td><td ALIGN="left"><%out.println(s.getTicketDescription());%> </td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td  ALIGN="left"><label><%=resourceBundle.getString("employee")%>:</label></td><td ALIGN="left"><%out.println(s.getEmployeevo().getEmployeeId());%>  </td></tr>

</table>
</fieldset>
</form>
</div>

</div>
</div>
</body>
</html>