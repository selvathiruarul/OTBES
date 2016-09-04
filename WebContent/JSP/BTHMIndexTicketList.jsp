<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java"%>
<%@ page import="com.otbes.vo.BTHMTicketVO,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Ticket List</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
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
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>
</div>
<div id="main">
<fieldset>
<legend><%=resourceBundle.getString("assignTicketToEmployee")%></legend>
<form action="BTHMServlet" name="ticketList" method="post" onsubmit="return validateDropDown()">
<p align="right"><a href="<%=request.getContextPath()%>/JSP/BTHMOpenTicketList.jsp"><b>BACK</b></a></p>
<%
	session.setAttribute("page", "ViewTicketList");
%>

 <%
 @SuppressWarnings("unchecked")
ArrayList<BTHMTicketVO> ticketlist = (ArrayList<BTHMTicketVO>) request.getAttribute("TicketVo");

 %> <%=resourceBundle.getString("ticketId")%><select name="ticketId" id="dd1" >
	<option value="0">Select</option>
	<%
		for (BTHMTicketVO tl : ticketlist) {
	%>
	
	  <option value="<%=tl.getTicketId()%>"><%=tl.getTicketId()%></option>
	<%
		}
	%>
</select> <input type="submit" name="ticketList" value="<%=resourceBundle.getString("showEmployeeList") %>"
	class="button"></input></form>
	
	
	<p><span id="error"></span></p>
<p><span id="inputerror"></span></p>
</fieldset>
</div>
</div>
</div>
</body>
</html>