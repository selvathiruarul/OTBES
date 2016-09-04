<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session.setAttribute("User", null);
	session.invalidate();
	RequestDispatcher rd = getServletContext().getRequestDispatcher(
			"/JSP/Login.jsp");
	rd.forward(request, response);
%>