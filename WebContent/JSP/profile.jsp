<%@ page errorPage="/JSP/Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Profile</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"> 

</script>
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
<%
		if (session.getAttribute("User").toString()
				.matches("Employee")) { %>
			<br>
			<br>	
			<div style="float:left ; width: 250px;"><img src="../IMAGES/helpdeskteam.JPG" alt="HELP DESK TEAM"></div>
			<center>
			<div style="float:left ; width: 250px;'"><h4> -- TEAM MOTTO -- </h4>
			<p>1.Fast Response Time</p>
			<p>2.Quick Resolution</p>
			<p>3.Timely Follow-up</p>
			<p>4.Ongoing Communication</p></div>
			</center>
		<% }
	%>
<%
		if (session.getAttribute("User").toString()
				.matches("Administrator")) { %>
			<br>
			<br>	
			
			<center>
			<div style="float:left ; width: 310px;"><img src="<%=request.getContextPath()%>/IMAGES/IMAGES_HOME/administrator.jpg" alt="ADMINISTRATOR" height="300" width="300"></div>
			<div style="float:left ; width: 250px;'"><h4> -- HELLO ADMINISTRATOR -- </h4>
			<p>"No one who achieves success does so without acknowledging the help of others.  The wise and confident acknowledge this help with gratitude."</p></div>
			</center>
		<% }
	%>
	
	<%
		if (session.getAttribute("User").toString()
				.matches("Customer")) { %>
			<br>
			<br>	
			
			<center>
			<div style="float:left ; width: 310px;"><img src="<%=request.getContextPath()%>/IMAGES/IMAGES_HOME/customer1.jpg" alt="CUSTOMER" height="300" width="300"></div>
			<div style="float:left ; width: 250px;'"><h4> -- HELLO CUSTOMER -- </h4>
			<p>"A customer is the most important visitor on our premises. You are not dependent on us. We are dependent on you.You are not an interruption in our works. You are the purpose of it. You are not an outsider in our business. You are the part of it.  We are not doing you a favour by serving you. You are doing us a favour by giving us an opportunity to do so... "</p></div>
			</center>
		<% }
	%>
	
</div>
</div>
</div>
</body>
</html>