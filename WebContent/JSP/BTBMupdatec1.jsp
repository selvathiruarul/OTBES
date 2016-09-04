<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.otbes.vo.*"%>
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
	src="<%=request.getContextPath()%>/JS/updatec1validation.js">
</script>
<meta name="keywords" content="" />
<meta name="description" content="" />
<style>
label {
	display: inline-block;
	float: center;
	clear: left;
	width: 250px;
	text-align: left;
}

input {
	display: inline-block;
	float: center;
	width: 200px;
}

textarea {
	display: inline-block;
	float: center;
	width: 200px;
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



<div id='main'>
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTBMupdatec.jsp"><b>Back</b></a></p>

<div id="mandatory">* Mandatory</div>
<fieldset><legend>BILL DISPUTE</legend>

<form name="gen" action="BTBMServlet" onsubmit="return validate()"
	method="post">
<%
	BTBMVo vo = (BTBMVo) request.getAttribute("result");
%> <input
	type="hidden" name="option" value="UpdateDispute"></input> <label><%=resourceBundle.getString("billItemId")%></label>
<input type="text" name="bid" size="15" value=<%=vo.getBillItemId()%>
	Readonly="Readonly"></input> <br>
<br>
<label><%=resourceBundle.getString("dateOfRaise")%></label> <input
	type="text" name="d" size="10" value=<%=vo.getDate()%>
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("dateOfUpdate")%></label> <input
	type="text" name="d" size="10" value=<%=vo.getSysDate()%>
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("reason")%> <font color=red>
*</font></label> <textarea name="r"><%=vo.getReason()%></textarea> <br>
<span id="reserror"></span><br>
<br>
<br>

<center><input type="submit"
	value="<%=resourceBundle.getString("update")%>" class="button"></input>
<input type="reset" value="Reset" class="button"></input></center>

</form>
</fieldset>
</div>
</div>
</div>

</body>
</html>


