<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%!@SuppressWarnings("unchecked")%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.otbes.vo.*"%>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OTBES</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
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
	src="<%=request.getContextPath()%>/JS/callcostvalidation.js">
</script>

<%
	BillItemVO items = (BillItemVO) request.getAttribute("billitems");
%>
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
	href="<%=request.getContextPath()%>/JSP/BTBMupdate.jsp"><b>Back</b></a></p>

<div id="mandatory">* Mandatory</div>
<fieldset><legend><%=resourceBundle.getString("billGeneration")%></legend>

<form name="gen" action="BTBMServlet" method="post"
	onsubmit="return validate()"><input type="hidden" name="option"
	value="update2"></input> <%@ page import="java.util.ArrayList"%>
<h3><b><%=resourceBundle.getString("billItemDetails")%></b></h3>

<br>
<br>
<%
	ArrayList<BillItemVO> billitems = new ArrayList<BillItemVO>();
	billitems = (ArrayList<BillItemVO>) session
			.getAttribute("billitems");
	int billitemId = Integer.parseInt((String) request
			.getAttribute("billItemid"));

	BillItemVO selectedBillItem = null;
	if (billitems != null) {
		for (BillItemVO bill : billitems) {
			if (billitemId == bill.getBillItemId()) {
				selectedBillItem = bill;
			}
		}
	} else {
		System.err.println("No Bills found");
	}
%> <label><%=resourceBundle.getString("connectionNumber")%></label> <input
	type="text" name="connNo" readonly="readonly"
	value="<%=selectedBillItem.getConnectionNo()%>"> <br>
<br>
<label> <%=resourceBundle.getString("billId")%></label> <input
	type="text" name="billId" readonly="readonly"
	value="<%=selectedBillItem.getBillID()%>"> <br>
<br>
<label><%=resourceBundle.getString("billItemId")%> </label> <input
	type="text" name="billitemid" readonly="readonly"
	value="<%=selectedBillItem.getBillItemId()%>"> <br>
<br>
<label> <%=resourceBundle.getString("dialledNumber")%></label> <input
	type="text" name="dialledno" readonly="readonly"
	value="<%=selectedBillItem.getDialledNo()%>"> <br>
<br>
<label><%=resourceBundle.getString("callDuration")%> </label> <input
	type="text" name="duration" readonly="readonly"
	value="<%=selectedBillItem.getCallDuration()%>"> <br>
<br>
<label> <%=resourceBundle.getString("callCost")%></label> <input
	type="text" name="callcost" readonly="readonly"
	value=" <%=selectedBillItem.getCallCost()%>"> <br>
<br>
<label><%=resourceBundle.getString("typeOfCall")%> </label> <input
	type="text" name="calltype" readonly="readonly"
	value="<%=selectedBillItem.getTypeOfCall()%>"> <br>
<br>
<label> <%=resourceBundle.getString("dateOfCall")%> </label> <input
	type="text" name="date" readonly="readonly"
	value="<%=selectedBillItem.getDateOfCall()%>"> <br>
<br>
<label><%=resourceBundle.getString("adjustedCost")%><font
	color="red">*</font> </label> <input type="text" name="adjustamt"
	onKeyPress="return isNumberKey(event)" maxlength="8"></input> <br>
<br>
<span id="ccerror"> </span>
<center><input type="submit" name="submit"
	value="<%=resourceBundle.getString("update")%>" class="button"></input></center>
</form>
</fieldset>
</div>
</div>
</div>

</body>
</html>

