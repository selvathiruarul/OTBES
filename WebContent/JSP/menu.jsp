<div id="tabs">
<ul>
	<li><a href="<%=request.getContextPath()%>/JSP/home.jsp" title="Home"><span>HOME</span></a></li>
	<li><a href="<%=request.getContextPath()%>/JSP/services.jsp"  title="Services"><span>SERVICES</span></a></li>
	<li><a href="<%=request.getContextPath()%>/JSP/aboutUs.jsp" ><span>ABOUT US</span></a></li>
	<li><a href="<%=request.getContextPath()%>/JSP/offer.jsp" title="Offers"><span>OFFERS</span></a></li>
	<li><a href="<%=request.getContextPath()%>/JSP/contactUs.jsp" ><span>CONTACT US</span></a></li>
	
	<%
		if (session.getAttribute("User")==null) {
	%>
	<li><a href="<%=request.getContextPath()%>/JSP/index.jsp"
		" title="login"><span>Login</span></a></li>
		<%}%>
		
	<%
		if (session.getAttribute("User")!=null) {
	%>
	<li><a href="<%=request.getContextPath()%>/JSP/logout.jsp"
		" title="Logout"><span>Logout</span></a></li>
		<%}%>
</ul>
</div>