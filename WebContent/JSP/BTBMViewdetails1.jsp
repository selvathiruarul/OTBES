<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.otbes.vo.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>

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
	src="<%=request.getContextPath()%>/JS/viewdetails1validation.js">
</script>



<meta name="keywords" content="" />
<meta name="description" content="" />
<style>
label {
	display: inline-block;
	float: left;
	clear: left;
	width: 250px;
	text-align: left;
}

input {
	display: inline-block;
	float: center;
}

select {
	width: 145px;
}
</style>
<% SimpleDateFormat d=new SimpleDateFormat("dd-MM-yyyy");
Date date=new Date();
String td=d.format(date);%>
<%
DecimalFormat dp = new DecimalFormat("#.00");
 %>
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
	href="<%=request.getContextPath()%>/JSP/BTBMViewid.jsp"><b>Back</b></a></p>
<div id="mandatory">* Mandatory</div>

<fieldset><legend><%=resourceBundle.getString("billPayment")%></legend>
<form name="gen" action="" method="post"><input type="hidden"
	name="option" value="viewdetails"></input><input type="hidden" name="customerId" value="<%=session.getAttribute("userId") %>" ></input> <%=resourceBundle.getString("viewDetails")%>
<br>
<br>

<br>
<br>
<% 
PaymentVO1  v = (PaymentVO1)request.getAttribute("Viewdetail"); 
%> <label><%=resourceBundle.getString("billId")%></label> <input
	type=text name="billId" value=<%out.println(v.getBillId());%>
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("connectionNumber")%></label> <input
	type=text name="connectionNo"
	value=<%out.println(v.getConnectionNo());%> readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("originalAmount")%></label> <input
	type=text name="originalAmt" value=<%out.println(v.getOriginalAmt());%>
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("excess")%></label> <input type=text
	name="excess" value=<%out.println(v.getExcess());%>></input><br>
<br>
<label><%=resourceBundle.getString("arrears")%></label> <input type=text
	name="arrears" value=<%out.println(v.getArrears());%>
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("billDate")%></label> <input
	type=text value=<%out.println(td);%> readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("statusOfPay")%></label> <input
	type=text name="statusOfpay" value=<%out.println(v.getStatusOfpay());%>
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("totalAmount")%></label> <input
	type=text name="totalAmt"
	value=<%out.println(dp.format(v.getTotalAmt()));%> readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("bankName")%>*</label> <select
	name="bankName">
	<option SELECTED>Select</option>
	<option value="sbi">SBI</option>
	<option value="hsbc">HSBC</option>
	<option value="axis">AXIS BANK</option>
</select> <br>
<span id="bankerror"></span><br>
<br>
<label> <%=resourceBundle.getString("cardType")%><font color=red>*</font></label>
<select name="cardType">
	<option SELECTED>Select</option>
	<option value="ceridit">CREDIT CARD</option>
	<option value="debit">DEBIT CARD</option>
</select><br>
<span id="typeerror"></span> <br>
<br>
<label> <%=resourceBundle.getString("cardNumber")%><font
	color=red>*</font></label> <input type="text" name="cardNo" maxlength="16"
	onKeyPress="return isNumberKey(event)"> <br></br>
<span id="card1error"> </span><br>
<br>
<label><%=resourceBundle.getString("cvvNumber")%><font color=red>
*</font></label> <input type="text" name="cvvNo" maxlength="3"
	onKeyPress="return isNumberKey(event)"> <br></br>
<span id="cvv1error"> </span><br>
<br>
<label><%=resourceBundle.getString("amountYouPay")%><font
	color=red>*</font></label><input type="text" name="amountYoupay"
	maxlength="10" onKeyPress="return isNumberKey1(event)"> <br></br>
<span id="amt1error"> </span><br>
<br>
<input type="submit"
	value="<%=resourceBundle.getString("makePayment")%> "
	onclick="return validate()" class="button"></input></form>
</fieldset>
</div>
</div>
</div>
</body>
</html>



