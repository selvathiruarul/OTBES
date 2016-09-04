<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.*" %>
	<%@ page import="com.otbes.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/Viewvalidation.js"> </script>
<meta name="keywords" content="" />
<meta name="description" content="" />
<style>
label {
	display: inline-block;
	float: center;
	clear: left;
	width: 250px;
	text-align: center;
}

input {
	display: inline-block;
	float: center;
}
</style>
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




<div id='main'><p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTBMViewid1.jsp"><b>Back</b></a></p>


<fieldset><legend><%=resourceBundle.getString("billPayment")%></legend>



<form name="gen" action="BTBMServlet" method="post"><input
	type="hidden" name="option" value="viewpage"></input><%ArrayList<PaymentVO1> v1=(ArrayList<PaymentVO1>)request.getAttribute("Viewdetail"); %>
<%! @SuppressWarnings("unchecked") %>
<label><%=resourceBundle.getString("connectionNumber")%></label><select name="connectionNo">
                                                                                 <%for(PaymentVO1 v:v1){ %>
                  <option value="<%=v.getConnectionNo() %>"><%=v.getConnectionNo() %></option>
                  <%} %>
                                                                                  </select><br></br>



<input type="submit" value="<%=resourceBundle.getString("viewBill")%>" onclick="return validate()" class="button"></input>
</form>
</fieldset>
</div>
</div>
</div>

</body>
</html>



