<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java" %>
    <%@ page import="com.otbes.vo.BTHMTicketVO,java.util.*" %>
    <%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"></script>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>View Assigned Ticket</title>
<%session.setAttribute("page","viewAssignedTicket");


%>
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
<div id="menu"><%@ include file="/JSP/sidepane.jsp" %></div>

<div id="main">
<% @SuppressWarnings("unchecked")
ArrayList<BTHMTicketVO> ticketlist=(ArrayList<BTHMTicketVO>)session.getAttribute("ticketls");
if(!ticketlist.isEmpty()){%>
<form method="get" action="BTHMServlet">
<p><label><%=resourceBundle.getString("assignedTicket")%></label></p>
<select name="Ticketid">
<%for(BTHMTicketVO tl:ticketlist){%><option value="<%=tl.getTicketId()%>"><%=tl.getTicketId()%></option>
<%} %>
</select><input type="submit" value=<%=resourceBundle.getString("viewTicketDetails")%> class="button"></input>
</form>
<%}
else{%>
There is No ticket Assignments<%} %>
</div>
</div>
</div>
</body>
</html>