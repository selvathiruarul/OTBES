<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java" %>
     <%@ page import="com.otbes.vo.BTHMEmployeeVO,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Assign Employee</title>
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

<form name="employeeList" action="BTHMServlet" method="post" onsubmit="return validateEmployeeDropDown()">
<fieldset>
<legend><%=resourceBundle.getString("assignTicketToEmployee")%></legend>
<%session.setAttribute("page","AssignEmployee");%>
<p align="right"><a href="<%=request.getContextPath()%>/JSP/BTHMOpenTicketList.jsp"><b>BACK</b></a></p>

<input type="hidden" name="ticketid" value="<%=request.getAttribute("ticketid")%>"/>
<% @SuppressWarnings("unchecked")
ArrayList<BTHMEmployeeVO> employeelist=(ArrayList<BTHMEmployeeVO>)request.getAttribute("employeels");%><%=resourceBundle.getString("employeeId")%>
<select name="employeeId">
	<option value="0">Select</option>
<%for(BTHMEmployeeVO el:employeelist){%><option value="<%=el.getEmployeeId()%>"><%=el.getEmployeeId()%></option>
<%} %></select>
<input type="submit" name="selectEmployee" value="<%=resourceBundle.getString("assignTicket")%>" class="button"></input>
</fieldset>
<p><span id="error"></span></p>

</form>
</div>

</div>
</div>
</body>
</html>