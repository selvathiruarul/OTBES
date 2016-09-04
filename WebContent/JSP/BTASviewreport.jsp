<%@ page errorPage="/JSP/Error1.jsp"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.otbes.vo.HelpDeskReport"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<HelpDeskReport> datelist = (ArrayList<HelpDeskReport>) request
			.getAttribute("date");
%>
<table>
<tr>
<th>Date of raised</th>
<th>No of tickets</th>
</tr>
<% 
for(HelpDeskReport date:datelist){ %>
<tr>
<td><%=date.getDate() %></td>
<td><%=date.getCount() %></td>
</tr>

<%} %>
</table>
</body>
</html>