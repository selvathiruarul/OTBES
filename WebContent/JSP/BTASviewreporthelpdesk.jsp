<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.otbes.language.*"%>
<%@page import="java.util.*"%>
<%@ page import="com.otbes.vo.*"%>
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
	src="<%=request.getContextPath()%>/JS/addcustomer.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/CALENDAR_JS/dateJS.js"> </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<script>
            
         </script>
<meta name="keywords" content="" />
<meta name="description" content="" />

</head>
<body onKeyDown="return showKeyCode(event)"
	onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
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
<% 
ArrayList<TicketSummary> datalist= (ArrayList<TicketSummary>)request.getAttribute("report");
if(!datalist.isEmpty()){
	String fromdate=(String)request.getAttribute("fromdate");
	String todate=(String)request.getAttribute("todate");
	  System.out.println(fromdate+"jsp"+todate);
    int totalnoofrec=datalist.size();
    System.out.println("tnr" +totalnoofrec);
    int noofrecperpage;
    int startindex,endindex,currentpage,endindex1;
    startindex =(Integer) request.getAttribute("startindex");
   endindex =(Integer) request.getAttribute("endindex");
   System.out.println("jsp"+endindex);
   currentpage =(Integer) request.getAttribute("currentpage");
   noofrecperpage=(Integer) request.getAttribute("noofrecperpage");
   int quotient=(totalnoofrec/noofrecperpage);
   int remainder=(totalnoofrec%noofrecperpage);
   int noofpages = 0;
   if ( remainder != 0 )
   {
       noofpages = quotient + 1;
       
   }
   else
   {
       noofpages = quotient;
    
   }

   if(endindex<totalnoofrec)
     {endindex1  =endindex;
   }
   else
   { endindex1=totalnoofrec;
   }
%>
<fieldset>
<legend>Helpdesk Report</legend>
<table border="1" width="1" cellspacing="1" cellpadding="1" >
	<thead>
		<tr>
			<th><%=resourceBundle.getString("Sno")%></th>
			
			<th><%=resourceBundle.getString("ticketId")%></th>
			<th><%=resourceBundle.getString("issueCategory")%></th>
			<th><%=resourceBundle.getString("summaryOfTheIssue")%></th>
			
			<th><%=resourceBundle.getString("dateOfOpeningTheTicket")%></th>
			

			<th><%=resourceBundle.getString("statusOfTheTicket")%></th>
			
			<th><%=resourceBundle.getString("priority")%></th>




		</tr>
	</thead>
	<tbody>
		<% 
    for(int i=startindex-1; i<endindex1;i++)
       { 
    	TicketSummary vo = (TicketSummary)datalist.get(i);
       %>
		<tr>
			<td><%=i+1%></td>

			
			<td><%=vo.getTicketId()%></td>
			<td><%=vo.getTicketCategory()%></td>
			<td><%=vo.getTicketSummary() %></td>
			
			<td><%=vo.getDateRaised() %></td>
			
			<td><%=vo.getTicketStatus() %></td>
			
			<td><%=vo.getTicketPriority()%></td>


			<%} 
   %>

		</tr>
	</tbody>
</table>

<table width="100%">
	<!-- bottom pagination-->


	<tr>
		<td>Displaying Records: <%if(totalnoofrec>3) {%> <%if(startindex != 1) {%>
		<% String strUrl = "BTASServlet?option=generatereporthelpdesktable&fromdate="+fromdate+"&todate="+todate+"&currentpage="+(currentpage-1)+"&noofrecperpage="+noofrecperpage;%>


		<a href=<%=strUrl%>>Previous</a> <%}%> <%  for (int i2 = 1; i2 <= noofpages; i2++) {
                    	  
                if (i2 == currentpage) {%> <%=i2%> <%} else {
                    String strUrl = "BTASServlet?option=generatereporthelpdesktable&fromdate="+fromdate+"&todate="+todate+"&currentpage="+i2+"&noofrecperpage="+noofrecperpage;
                    %> <a href=<%=strUrl%>> <%=i2%></a> <%}
                         }%> <%endindex1 += noofrecperpage;%> <%System.out.println("endindex1" +endindex1); %>
		<%if(endindex1 <= totalnoofrec){%> <% String strUrl= "BTASServlet?option=generatereporthelpdesktable&fromdate="+fromdate+"&todate="+todate+"&currentpage=" +(currentpage+1) +"&noofrecperpage=" + noofrecperpage ;%>

		<a href=<%=strUrl%>>Next</a> <%}%> <%}
 else{
	 for (int i2 = 1; i2 <= totalnoofrec; i2++) {
   	 
        if (i2 == currentpage) {%> <%=i2%> <%} else {
            String strUrl = "BTASServlet?option=generatereporthelpdesktable&fromdate="+fromdate+"&todate="+todate+"&currentpage=" + i2+"&noofrecperpage=" + noofrecperpage ;
            %> <a href=<%=strUrl%>> <%=i2%></a> <%}%> <% }
}%>
		</td>
	</tr>
</table>

<a href="BTHMViewTicketReport.jsp?fromdate=<%= fromdate%>&todate=<%=todate%>">PREPARE CHART</a>

</fieldset>

<%} else{ %>

No Ticket Has been Raised during this period

<%} %>
</div>
</div>
</div>
</body>
</html>