<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Error Page - Bharath Tele Services</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
</head>
<body onKeyDown="return showKeyCode(event)" onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">


<div id="wrapper">
<div id="wrapper_background">

<div id="header"></div>
<%
	session.setAttribute("page", "error");
%>


<div id="menu"></div>
<div id="main">
<form name="error">
<fieldset><legend>Error</legend> <%
 	session.invalidate();
 %>
<center>Unable to Process your request please click  <a
	href="<%=request.getContextPath()%>/JSP/index.jsp"><b>Login to continue</b></a></center>


</fieldset>
</form>
</div>
</div>
</div>
</body>
</html>