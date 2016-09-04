<%@page import="javax.servlet.RequestDispatcher"%>
<%
	if (request.getAttribute("Error") == null) {
		System.out.println(request.getAttribute("Error"));
		session.invalidate();
		response.sendRedirect("index.jsp");
	} else {
		session.invalidate();
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/JSP/index.jsp");
		dispatcher.forward(request, response);
	
	}
%>