<%@ page errorPage="/JSP/Error1.jsp"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.otbes.vo.*"%>
<%@ page import="com.otbes.language.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OTBES</title>
<link href="<%=request.getContextPath() %>/CSS/layout.css"
	rel="stylesheet" type="text/css" />
<meta name="keywords" content="" />
<meta name="description" content="" />

</head>
<body onKeyDown="return showKeyCode(event)" onLoad="disableBackButton()">
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires",0);
String role=(String)session.getAttribute("User");

if(role==null)
	response.sendRedirect("index.jsp");
%>

<div id="wrapper">
<div id="wrapper_background">

<div id="header"></div>
<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>

</div>
<div id='main'>

<fieldset>
<form>


<h1><%=resourceBundle.getString("customerDetailsAreSuccessfullyAdded")%></h1>
<br>
<label><%=resourceBundle.getString("theCustomerIdIs")%></label><br>
<h1><%=request.getAttribute("error")%></h1>
<%=request.getAttribute("link") %>



</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>