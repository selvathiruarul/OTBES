<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java" %>
<%@ page
	import="com.otbes.vo.BTHMTicketVO,java.util.*,com.otbes.vo.BTHMEmployeeVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Update Ticket Assignments - Bharath Tele Services</title>
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
<form action="BTHMServlet" name="update" method="post"
	onSubmit="return updateValidate()">
<%
	session.setAttribute("page", "updatedetails");
%>
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTHMUpdateTicketDetails.jsp"><b>BACK</b></a></p>
<fieldset><legend><%=resourceBundle.getString("updateAssignedTicketDetails")%></legend>
 <%
	BTHMTicketVO s = (BTHMTicketVO) request
			.getAttribute("BTHMTicketVo");
	%>

<table border="0">

	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("ticketId")%></label></td>
		<td ALIGN="left"><input type="text" name="ticket" value="<%=s.getTicketId()%>" readonly="readonly"/></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("description")%></label></td>
		<td ALIGN="left"><textarea name="description"
			id="description1"><%out.println(s.getTicketDescription());%></textarea></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("employeeId")%></label></td>
		<td ALIGN="left">
		<%
		@SuppressWarnings("unchecked")
			ArrayList<BTHMEmployeeVO> employeelist = (ArrayList<BTHMEmployeeVO>)request.getAttribute("employeels");
		%> <select name="employee" id="employeeid">
			<option selected="selected"
				value="<%=s.getEmployeevo().getEmployeeId()%>">
			<%
				out.println(s.getEmployeevo().getEmployeeId());
			%>
			</option>
			<%
				for (BTHMEmployeeVO el : employeelist) {
					if (el.getEmployeeId() != s.getEmployeevo().getEmployeeId()) {
			%><option value="<%=el.getEmployeeId()%>"><%=el.getEmployeeId()%></option>
			<%
				}
				}
			%>
		</select></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" name="update" value="<%=resourceBundle.getString("update")%>"
			class="button"></input></td>
	</tr>

</table>
<p>
<%
	if (request.getAttribute("message") != null) {
%> <span id="error"><%=request.getAttribute("message")%></span></p>
<%
	}
%>
</fieldset>
<p><span id="inputerror"></span></p>
</form>
</div>

</div>
</div>
</body>
</html>