<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<div id="menu"><%@ include file="/JSP/lingual.jsp"%>
<%
	if (session.getAttribute("User") == null) {
%> <marquee direction="up"><img width=250px
	src="<%=request.getContextPath()%>/IMAGES/ad.png"></img></marquee> <%
 	} else {
 %>

<ul>
	<li>
	<div id="sessionuser">Logged in as <%=session.getAttribute("User")%>
	</div>
	</li>
	<%
		if (session.getAttribute("User").toString().matches(
					"Administrator")) {
	%>

	<li><a href="#"><%=resourceBundle.getString("customerDetails")%></a>
	<ul>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASAddCustomer.jsp"><%=resourceBundle.getString("addCustomerDetails")%></a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASviewcustomerdetailsbyadmin.jsp"><%=resourceBundle.getString("viewCustomerDetails")%></a></li>
		<li><a href="<%=request.getContextPath()%>/JSP/BTASupdate.jsp"><%=resourceBundle
									.getString("updateCustomerDetails")%></a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASdeletecustomer.jsp"><%=resourceBundle
									.getString("deleteCustomerDetails")%></a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASstatuschangecustomer.jsp"><%=resourceBundle.getString("statusChange")%></a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASuploadproofcustomer.jsp"><%=resourceBundle.getString("uploadProof")%></a></li>
	</ul>
	</li>
	<li><a href="#">MANAGE CONNECTIONS</a>
	<ul>
		<li><a href="<%=request.getContextPath()%>/JSP/BTASadconn.jsp">ADD
		NEW CONNECTION</a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASviewconnection.jsp">VIEW
		CONNECTION DETAILS</a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASupdateconnection.jsp">UPDATE
		CONNECTION DETAILS</a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASdeleteconnection.jsp">DELETE
		A CONNECTION </a></li>
	</ul>
	</li>


	<li><a href="#">MANAGE TARIFFS</a>
	<ul>
		<li><a href="<%=request.getContextPath()%>/JSP/BTASaddtariff.jsp">ADD
		NEW TARIFF PLAN</a></li>
		<li><a href="BTASServlet?option=viewtariff1">VIEW TARIFF
		DETAILS</a></li>
		<li><a href="BTASServlet?option=updatetariff1">UPDATE TARIFF
		DETAILS</a></li>
		<li><a href="BTASServlet?option=deleteview">DELETE A TARIFF
		PLAN</a></li>
	</ul>
	</li>
	<li><a href="#">CALL DETAILS</a>
	<ul>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASuploadCallDetailsFile.jsp">UPLOAD
		CALL DETAILS</a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASsearchCallDetails.jsp">VIEW
		CALL DETAILS</a></li>

		<li><a
			href="<%=request.getContextPath()%>/JSP/BTASdeletecalldetails.jsp">DELETE
		CALL DETAILS</a></li>
	</ul>
	</li>
	<li><a href="#">BILL DISPUTES</a>
	<ul>
		<li><a href="BTBMAdminView.jsp">ADMIN VIEW DISPUTE</a></li>

	</ul>
	</li>
	<li><a href="#">BILL GENERATION</a>
	<ul>
		<li><a href="BTBMconnectionno.jsp">GENERATE BILL</a></li>
		<li><a href="BTBMViewConnection.jsp">VIEW BILL</a></li>
		<li><a href="BTBMupdate.jsp">UPDATE BILL</a></li>
		<li><a href="BTBMdelete.jsp">DELETE BILL</a></li>
	</ul>
	</li>
	<li><a href="#"><%=resourceBundle.getString("helpDeskTicket")%></a>
	<ul>
		<li><a href="<%=request.getContextPath()%>/JSP/BTHMNewTicket.jsp"><%=resourceBundle.getString("raiseTicket")%></a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTHMViewRegisteredTicket.jsp"><%=resourceBundle.getString("viewTicket")%></a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTHMUpdateRegisteredTicket.jsp"><%=resourceBundle.getString("updateTicket")%></a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTHMDeleteRegisteredTicket.jsp"><%=resourceBundle.getString("deleteTicket")%></a></li>
	</ul>
	</li>
	<li><a href="#"><%=resourceBundle.getString("helpDeskEmployee")%></a>
	<ul>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTHMAddHelpDeskEmployee.jsp"><%=resourceBundle.getString("addAEmployee")%></a></li>
		<li><a href="<%=request.getContextPath()%>/JSP/BTHMView.jsp"><%=resourceBundle.getString("viewHelpDeskEmployee")%></a></li>
		<li><a
			href="<%=request.getContextPath()%>/JSP/BTHMUpdateEmployee.jsp"><%=resourceBundle
							.getString("updateHelpDeskEmployee")%></a></li>
		<li><a href="<%=request.getContextPath()%>/JSP/BTHMDelete.jsp"><%=resourceBundle
							.getString("deleteHelpDeskEmployee")%></a></li>
	</ul>
	</li>
	<li><a href="#"><%=resourceBundle.getString("ticketAssignments")%></a>
	<ul>
		<li><a href="BTHMOpenTicketList.jsp"><%=resourceBundle.getString("assignEmployee")%></a></li>
		<li><a href="BTHMViewTicketDetailsAdmin.jsp"><%=resourceBundle.getString("viewAssignedTickets")%></a></li>
		<li><a href="BTHMUpdateTicketDetails.jsp"><%=resourceBundle
							.getString("updateAssignedTicketDetails")%></a></li>
		<li><a href="BTHMDeleteAssignedTicket.jsp"><%=resourceBundle.getString("deleteAssignedTicket")%></a></li>
	</ul>
	</li>
	<li><a href="#"><%=resourceBundle.getString("mySettings")%></a>
	<ul>
		<li><a href="changeRequests.jsp"><%=resourceBundle.getString("changeSettings")%></a></li>
	</ul>
	</li>
	<li><a href="#"><%=resourceBundle.getString("generateReport")%></a>
	<ul>
			
		<li><a href="BTASTicketraisedcategory.jsp">helpdeskTicket</a></li>
		
		<li><a href="BTASServlet?option=generatecustomerreport&currentpage=0&noofrecperpage=10">customerReport</a></li>
		
		<li><a href="BTASCalldetailsreport.jsp">callDetailsReport</a></li>
		
		
	</ul>
	</li>

	<%
		} else if (session.getAttribute("User").toString().matches(
					"Employee")) {
	%>

	<li><a href="#">MY DETAILS</a>
	<ul>
		<li><a href="BTHMViewMyDetails.jsp">VIEW MY DETAILS</a></li>
	</ul>
	</li>
	<li><a href="#">MY ASSIGNMENTS</a>
	<ul>
		<li><a href="BTHMViewAssignedTicket.jsp">View My Tickets</a></li>
	</ul>
	</li>
	<li><a href="#"><%=resourceBundle.getString("mySettings")%></a>
	<ul>
		<li><a href="changeRequests.jsp"><%=resourceBundle.getString("changeSettings")%></a></li>
	</ul>
	</li>


	<%
		} else if (session.getAttribute("User").toString().matches(
					"Customer")) {
	%>

	<li><a href="#"><%=resourceBundle.getString("myDetails")%></a>
	<ul>
		<li><a
			href="BTASServlet?id=<%=session.getAttribute("userid")%>&option=viewbycustomer"><%=resourceBundle.getString("viewMyDetails")%></a></li>
		<li><a
			href="BTASServlet?id=<%=session.getAttribute("userid")%>&option=updatebycustomer"><%=resourceBundle.getString("updateMyDetails")%></a></li>
	</ul>
	</li>
	<li><a href="#">BILL DISPUTES</a>
			<ul><li><a href="BTBMRaise.jsp">RAISE BILL DISPUTE</a></li>
			    <li><a href="BTBMView1disp.jsp">VIEW BILL DISPUTE</a></li>
			    <li><a href="BTBMupdatec.jsp">UPDATE BILL DISPUTE</a></li>
			    <li><a href="BTBMcancel0.jsp">CANCEL BILL DISPUTE</a></li>
			</ul>
		</li>
		
		
		<li><a href="#">BILL PAYMENT</a>
			<ul><li><a href="BTBMViewid1.jsp">VIEW BILL</a></li>
			    <li><a href="BTBMViewcid.jsp">VIEW PAYMENT</a></li>
			    <li><a href="BTBMViewid.jsp">MAKE PAYMENT</a></li>
			    
			</ul>
		</li>








</ul>
<%
	}
	}
%>
</div>


