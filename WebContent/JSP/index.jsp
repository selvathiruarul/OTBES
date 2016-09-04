<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page import="java.util.Date,com.otbes.language.*,java.util.Locale,java.util.ResourceBundle,java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>OTBES</title>
<link href="<%=request.getContextPath()%>/CSS/layout_orange.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
</head>
<body onKeyDown="return showKeyCode(event)" onLoad="disableBackButton()" >
	<div id="wrapper">
		<div id="wrapper_background">
<%@ include file="/JSP/lingual.jsp"%>
<div id="header"></div>
<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<%
	session.setAttribute("page", "login");
	session.setAttribute("themeColor","orange");
	%>

<%String user = (String) session.getAttribute("User");
if (user != null) {		
	response.sendRedirect("profile.jsp");
} %>
<div id="menu" style="padding-top:10px"><img width="100%" height="100%" src="<%=request.getContextPath()%>/IMAGES/ad.png"></img></div>
<div id="main">
<form name="login" method="post" action="BTHMServlet"
	onSubmit="return loginValidate()" >
	<p id="mandatory">* Mandatory</p>
<fieldset><legend><%=resourceBundle.getString("logIn")%></legend>
<p><label><%=resourceBundle.getString("userName")%>*</label>
<input type="text" id="uName1" maxlength="6" name="uName" onkeypress="return isNumberKey(event)" AUTOCOMPLETE="OFF"></p>
<p><label><%=resourceBundle.getString("password")%>*</label><input type="password" id="pwd1"
	name="pwd" AUTOCOMPLETE="OFF"></input></p>
<p><label><%=resourceBundle.getString("role")%></label><select name="role">
	<option value="Administrator">Administrator</option>
	<option value="Employee">Employee</option>
	<option value="Customer">Customer</option>
</select></p>
<p><input type="submit" value="<%=resourceBundle.getString("logIn")%>" class="button"></input></p>
<p><span id="inputerror"></span></p>
<p>
<%
	if (request.getAttribute("Error") != null) {
%> <span id="error"><%=request.getAttribute("Error")%></span></p>
<%
	}
%>
</fieldset>
</form>
<form action="changeLanguage.jsp"><p><label>Select Language</label><select name="language"><option value="en">English</option><option value="de">German</option><option value="fr">French</option><option value="es">Spanish</option></select><input type="submit" value="change" class="button"></input></p></form>
</div>

</div>
</div>


</body>
</html>