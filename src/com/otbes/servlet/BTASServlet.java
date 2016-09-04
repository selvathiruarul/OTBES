package com.otbes.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.otbes.constants.FileConstants;
import com.otbes.dao.CallDetaildao;
import com.otbes.dao.Connectiondao;
import com.otbes.dao.Customerdao;

import com.otbes.dao.Tariffdao;
import com.otbes.service.BTHMEncode;
import com.otbes.service.CallDetailService;
import com.otbes.service.HelpDeskTicketReport;

import com.otbes.service.TariffService;
import com.otbes.vo.CallDetailFileVO;
import com.otbes.vo.CallDetailVO;
import com.otbes.vo.ConnectionVO;
import com.otbes.vo.CustomerVO;
import com.otbes.vo.Customerreportvo;
import com.otbes.vo.LoginVO;
import com.otbes.vo.ReportVo;
import com.otbes.vo.TariffVO;
import com.otbes.vo.TicketSummary;

/**
 * Servlet implementation class BTASServlet
 */
/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author T.Gomathi Priya,Rina ,Rahini ,Naveen
 *         kumar,Vinod,Madhumathi,Kalaiarasan
 * @version 1.0
 * @Class name Connectiondao
 * @Creation Date 8/12/2012 @ History
 */
public class BTASServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("otbeslogger");
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BTASServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet1(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;
		session = request.getSession();
		String page = request.getParameter("option");

		/**
		 * This function is used to login. The values are set and passed to
		 * Customerdao. Checking if the page isindex.jsp
		 */

		if (page.equalsIgnoreCase("login")) {
			LoginVO login = new LoginVO();
			Customerdao customer = new Customerdao();

			int userId = Integer.parseInt(request.getParameter("uName"));
			String pwd = request.getParameter("pwd");
			String role = request.getParameter("role");
			login.setUserName(userId);
			login.setPassword(pwd);
			login.setRole(role);

			try {

				boolean checkUser = customer.validateLogin(login);

				if (checkUser == true) {

					if (role.equalsIgnoreCase("Administrator")) {
						session.setAttribute("userid", userId);
						session.setAttribute("User", role);
						RequestDispatcher dispatch = getServletContext()
								.getRequestDispatcher("/JSP/BTASAdminpage.jsp");
						dispatch.forward(request, response);
					}

					if (role.equalsIgnoreCase("Customer")) {
						
						session.setAttribute("userid", userId);
						session.setAttribute("User", role);
						RequestDispatcher dispatch = getServletContext()
								.getRequestDispatcher("/JSP/BTASCustomerpage.jsp");
						dispatch.forward(request, response);
					}

				} else {
					request.setAttribute("error","INVALID LOGIN DETAILS");
					
					RequestDispatcher dispatch = getServletContext()
							.getRequestDispatcher("/JSP/BTASerrorlogin.jsp");
					dispatch.forward(request, response);
				}

			} catch (SQLException e) {

				log.error(e);
			}

		}

		/**
		 * This function is used to update the call details.Here values are set
		 * and passed to the service. Checking if JSP page is
		 * updatecalldetials.jsp
		 */
		if (page.equals("updatecalldetails")) {
			int id = Integer.parseInt(request.getParameter("callid"));
			CallDetailVO call = new CallDetailVO();
			call.setCallID(id);
			call
					.setConnectionNo(Long.parseLong(request
							.getParameter("connno")));
			call.setDateOfCall("dateofcall");

			call.setDialedNo(Long.parseLong(request.getParameter("calledno")));
			call
					.setDuration(Integer.parseInt(request
							.getParameter("duration")));
			call.setTypeOfCall(request.getParameter("type"));

			CallDetailService service = new CallDetailService();
			service.update(call);
			request.setAttribute("conno", request.getParameter("connono"));
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/JSP/BTAScalldetailsSuccess.jsp");
			rd.forward(request, response);
		}
		/**
		 * This function is used to delete the call details.Here values are set
		 * and passed to the service. Checking if JSP page is
		 * deleteecalldetials.jsp
		 */

		if (page.equals("deletecalldetails")) {
			int id = Integer.parseInt(request.getParameter("id"));
			CallDetailVO call = new CallDetailVO();
			call.setCallID(id);
			CallDetailService service = new CallDetailService();
			service.delete(call);
			request.setAttribute("conno", request.getParameter("connono"));
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/JSP/BTASsuccessdeletecalldetails.jsp");
			rd.forward(request, response);
		}
		/**
		 * This function is used to View the call details.Here values are set
		 * and passed to the service. Checking if JSP page is
		 * viewcalldetials.jsp
		 */

		if (page.equals("updateviewcalldetails")) {
			int id = Integer.parseInt(request.getParameter("id"));
			CallDetailVO call = new CallDetailVO();
			call.setCallID(id);
			ArrayList<CallDetailVO> calldetail = new ArrayList<CallDetailVO>();
			CallDetailService service = new CallDetailService();
			calldetail = service.updateView(call);

			request.setAttribute("CallDetail", calldetail);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/JSP/BTASUpdateCallDetails.jsp");
			rd.forward(request, response);

		}
		/**
		 *This function is used to add new customer. The values are set and
		 * passed to dao. Checking if the page is AddCustomer.jsp
		 */
		if (page.equalsIgnoreCase("addcust")) {

			String firstName = request.getParameter("fn");
			String middleName = request.getParameter("mn");
			String lastName = request.getParameter("ln");
			String address = request.getParameter("add");
			String state = request.getParameter("slist");
			String country = request.getParameter("country");

			Integer pincode = Integer.parseInt(request.getParameter("pincode"));
			Long contact = Long.parseLong(request.getParameter("contact"));
			String email = request.getParameter("email");
			String status = request.getParameter("status");

			try {
				CustomerVO custvo = new CustomerVO();
				CustomerVO custDetailsView = new CustomerVO();
				custvo.setFirstName(firstName);
				custvo.setMiddleName(middleName);
				custvo.setLastName(lastName);
				custvo.setAddress(address);
				custvo.setState(state);
				custvo.setCountry(country);
				custvo.setPinCode(pincode);
				custvo.setPhoneNo(contact);
				custvo.setEmail(email);
				custvo.setStatus(status);
				Customerdao customer = new Customerdao();

				custDetailsView = customer.insertCustomer(custvo);
				if (custDetailsView != null) {

				
					session.setAttribute("customer", custDetailsView);
					response.sendRedirect("BTASafteradd.jsp");
					
				}

			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function is used to get the CustomerId to view the details of
		 * the customer. The values are set and passed to Customerdao. Checking
		 * if the page is viewcustomerdetailsbyAdmin.jsp
		 */

		if (page.equalsIgnoreCase("viewbyadmin")) {
			int id = Integer.parseInt(request.getParameter("cid"));

			Customerdao customer = new Customerdao();
			CustomerVO custDetails = new CustomerVO();
			try {
				custDetails = customer.viewCustomer(id);

			} catch (SQLException e) {

				log.error(e);
			}
			if (custDetails.getCustomerID() == null) {
				RequestDispatcher dispatch = getServletContext()
						.getRequestDispatcher(FileConstants.NOCUSTOMER);
				dispatch.forward(request, response);
			} else {
				request.setAttribute("customer", custDetails);

				RequestDispatcher dispatch = getServletContext()
						.getRequestDispatcher("/JSP/BTASviewcustomer.jsp");
				dispatch.forward(request, response);
			}

		}
		/**
		 * This function is used to get the CustomerId to update the details of
		 * the customer. The values are set and passed to dao. Checking if the
		 * page is update.jsp
		 */

		if (page.equalsIgnoreCase("updatebyadmin")) {
			int id = Integer.parseInt(request.getParameter("cid"));

			Customerdao customer = new Customerdao();
			CustomerVO custDetailsUpdate = new CustomerVO();
			try {
				custDetailsUpdate = customer.viewCustomer(id);
				if (custDetailsUpdate.getCustomerID() == null) {
					RequestDispatcher dispatch = getServletContext()
							.getRequestDispatcher(FileConstants.NOCUSTOMER);
					dispatch.forward(request, response);
				} else {
					request.setAttribute("customer2", custDetailsUpdate);
					String filename = "/JSP/BTASupdatecustomer.jsp";
					RequestDispatcher dispatch = getServletContext()
							.getRequestDispatcher(filename);
					dispatch.forward(request, response);
				}

			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function is used to update the details of the customer. The
		 * values are set and passed to Customerdao. Checking if the page is
		 * updatecustomer.jsp
		 */
		if (page.equalsIgnoreCase("updation")) {
			int id = Integer.parseInt(request.getParameter("cid"));
			String firstName = request.getParameter("fn");
			String middleName = request.getParameter("mn");
			String lastName = request.getParameter("ln");
			String address = request.getParameter("add");
			String state = request.getParameter("slist");
			String country = request.getParameter("country");
			Integer pincode = Integer.parseInt(request.getParameter("pincode"));
			Long contact = Long.parseLong(request.getParameter("contact"));
			String email = request.getParameter("email");
			CustomerVO custDetailsUpdatedView = new CustomerVO();
			CustomerVO custvo = new CustomerVO();
			custvo.setCustomerID(id);
			custvo.setFirstName(firstName);
			custvo.setMiddleName(middleName);
			custvo.setLastName(lastName);
			custvo.setAddress(address);
			custvo.setState(state);
			custvo.setCountry(country);
			custvo.setPinCode(pincode);
			custvo.setPhoneNo(contact);
			custvo.setEmail(email);

			try {
				Customerdao customer = new Customerdao();
				customer.updateCustomer(custvo);

				custDetailsUpdatedView = customer.viewCustomer(id);
				if (custDetailsUpdatedView != null) {
					request.setAttribute("customer", custDetailsUpdatedView);
					String f = "/JSP/BTASupdatecustomerview.jsp";
					RequestDispatcher dispatch = getServletContext()
							.getRequestDispatcher(f);
					dispatch.forward(request, response);
				}

			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 *This function is used to change the status of the customer. The
		 * values are set and passed to Customerdao. Checking if the page is
		 * statuschangecustomer.jsp
		 */
		if (page.equalsIgnoreCase("statuschangecustomer")) {
			int id = Integer.parseInt(request.getParameter("cid"));
			Customerdao cust = new Customerdao();
			CustomerVO custDetailsStatus = new CustomerVO();

			try {
				custDetailsStatus = cust.searchId(id);
				if (custDetailsStatus.getCustomerID() == null) {
					
					RequestDispatcher dispatch = getServletContext()
							.getRequestDispatcher(FileConstants.NOCUSTOMER);
					dispatch.forward(request, response);

				} else {
					request.setAttribute("custstatus", custDetailsStatus);
					String f = "/JSP/BTASstatuschange.jsp";
					RequestDispatcher dispatch = getServletContext()
							.getRequestDispatcher(f);
					dispatch.forward(request, response);

				}
			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function is used to upload proof of the customer. The values are
		 * set and passed to Customerdao. Checking if the page is
		 * uploadproofcustomer.jsp
		 */
		if (page.equalsIgnoreCase("uploadproofcustomer")) {
			int id = Integer.parseInt(request.getParameter("cid"));
			Customerdao cust = new Customerdao();

			try {
				CustomerVO custDetails = new CustomerVO();
				custDetails = cust.searchId(id);
				if (custDetails.getCustomerID() == null) {
					
					RequestDispatcher dispatch = getServletContext()
							.getRequestDispatcher(FileConstants.NOCUSTOMER);
					dispatch.forward(request, response);

				} else {
					request.setAttribute("customer", custDetails);
					String filename = "/JSP/BTASuploadproof.jsp";
					RequestDispatcher dispatch = getServletContext()
							.getRequestDispatcher(filename);
					dispatch.forward(request, response);

				}
			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function is used to get customer Id for updation to be done by
		 * customer. The values are set and passed to dao. The Id is received by
		 * using sessions.
		 */

		if (page.equalsIgnoreCase("viewbycustomer")) {

			CustomerVO cust = new CustomerVO();

			String i = request.getParameter("id");
			int id = Integer.parseInt(i);

			try {
				Customerdao customer = new Customerdao();
				cust = customer.viewCustomer(id);

			} catch (SQLException e) {
				log.error(e);
			}

			finally {
				request.setAttribute("customer4", cust);

				RequestDispatcher dispatch = getServletContext()
						.getRequestDispatcher(
								"/JSP/BTASviewcustomerdetailsbycustomer.jsp");
				dispatch.forward(request, response);

			}

		}
		/**
		 * This function is used to get customer Id for updation to be done by
		 * customer. The values are set and passed to Customerdao. The Id is
		 * received by using sessions.
		 */
		if (page.equalsIgnoreCase("updatebycustomer")) {

			CustomerVO cust = new CustomerVO();
			Customerdao cus = new Customerdao();

			int id = Integer.parseInt(request.getParameter("id"));
			try {
				cust = cus.viewCustomer(id);

			} catch (SQLException e) {

				log.error(e);
			}

			finally {
				request.setAttribute("customer5", cust);

				RequestDispatcher dispatch = getServletContext()
						.getRequestDispatcher(
								"/JSP/BTASupdatecustomerdetailsbycustomer.jsp");
				dispatch.forward(request, response);

			}
		}
		/**
		 * This function is used to upload proof of the customer. The values are
		 * set and passed to Customerdao. Checking if the page is
		 * updatecustomerdetailsbycustomer.jsp
		 */
		if (page.equalsIgnoreCase("updationbycustomer")) {
			CustomerVO customer = new CustomerVO();
			Customerdao dao = new Customerdao();
			int id = Integer.parseInt(request.getParameter("cid"));
			customer.setCustomerID(id);
			customer.setFirstName(request.getParameter("fn"));
			customer.setMiddleName(request.getParameter("mn"));
			customer.setLastName(request.getParameter("ln"));
			customer.setAddress(request.getParameter("add"));
			customer.setState(request.getParameter("state"));
			customer.setCountry(request.getParameter("country"));
			customer.setPinCode(Integer.parseInt(request
					.getParameter("pincode")));
			customer.setEmail(request.getParameter("email"));
			customer
					.setPhoneNo(Long.parseLong(request.getParameter("contact")));

			try {
				Customerdao cust = new Customerdao();
				CustomerVO custdetails = new CustomerVO();
				dao.updateCustomer(customer);
				custdetails = cust.viewCustomer(id);
				if (custdetails != null) {
					RequestDispatcher dispatch = getServletContext()
							.getRequestDispatcher(
									"/JSP/BTASupdateviewcustomerdetailssuccess.jsp");
					dispatch.forward(request, response);

				}
			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function is used to delete the details of the customer. The
		 * values are set and passed to Customerdao. Checking if the page is
		 * deletecustomer.jsp
		 */

		if (page.equalsIgnoreCase("deletebyadmin")) {

			int id = Integer.parseInt(request.getParameter("cid"));
			Customerdao customer = new Customerdao();
			CustomerVO custdetails = new CustomerVO();

			try {

				custdetails = customer.searchId(id);
				if(custdetails.getCustomerID()==null)
				{
					RequestDispatcher dispatch = getServletContext()
					.getRequestDispatcher(FileConstants.NOCUSTOMER);
					dispatch.forward(request, response);	
				}
				else if (custdetails.getStatus().equalsIgnoreCase("Inactive")) {
					String f = "/JSP/BTASalreadydeletedcustomer.jsp";
					RequestDispatcher dispatch = getServletContext()
							.getRequestDispatcher(f);
					dispatch.forward(request, response);
				}

				else {
					int noOfConnectionActive = 0;// To find the no of connection
					// which is active
					if (custdetails.getCustomerID() != null) {
						noOfConnectionActive = customer.deleteCustomer(id);
						if (noOfConnectionActive == 0) {
							customer.deleteCustomerStatus(id);

							customer.deleteLogin(id);
							String filename = "/JSP/BTASafterdelete.jsp";
							RequestDispatcher dispatch = getServletContext()
									.getRequestDispatcher(filename);
							dispatch.forward(request, response);
						} else {

							String filename = "/JSP/BTASerrorindelete.jsp";
							RequestDispatcher dispatch = getServletContext()
									.getRequestDispatcher(filename);
							dispatch.forward(request, response);
						}
					} else {
						RequestDispatcher dispatch = getServletContext()
								.getRequestDispatcher(FileConstants.NOCUSTOMER);
						dispatch.forward(request, response);
					}
				}
			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function is used upload the call details.Here file root is set
		 * and passed to the service. Checking if JSP page is
		 * uploadcalldetials.jsp
		 */
		if (page.equals("upload")) {
			String file = request.getParameter("file");

			CallDetailFileVO call = new CallDetailFileVO();
			call.setRoot(file);
			CallDetailService service = new CallDetailService();
			service.upload(call);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/JSP/BTASsuccessupload.jsp");
			rd.forward(request, response);
		}
		/**
		 * This function is used to view the call details.Here arraylist size is
		 * checked and servie function called. Checking if JSP page is
		 * viewcalldetials.jsp
		 */
		if (page.equals("viewcalldetails")) {
			CallDetailVO call = new CallDetailVO();
			call.setConnectionNo(Long.parseLong(request
					.getParameter("connectionNo")));
			ArrayList<CallDetailVO> calldetailslist = new ArrayList<CallDetailVO>();
			CallDetailService service = new CallDetailService();
			calldetailslist = service.view(call);
			if (calldetailslist.size() == 0) {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher(FileConstants.NOCALLDETAILS);
				rd.forward(request, response);
			} else {
				request.setAttribute("CallDetailsList", calldetailslist);
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/BTASviewCallDetails.jsp");
				rd.forward(request, response);
			}
		}
		/**
		 * This function is used delete the call details for a particular
		 * connection number.Here connection number is set and passed to the
		 * service. Checking if JSP page is deletecalls.jsp
		 */

		if (page.equals("deletecalls")) {

			CallDetailVO call = new CallDetailVO();
			call.setConnectionNo(Long.parseLong(request
					.getParameter("connectionNo")));
			CallDetailService service = new CallDetailService();
			int count = service.deletecalls(call);// to count the call items in
			// the connection no
			if (count == 0) {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher(FileConstants.NOCALLDETAILS);
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher(
								"/JSP/BTASsuccessdeletecalldetails.jsp");
				rd.forward(request, response);
			}

		}
		/**
		 * This Function is performed to add connection details for a particular
		 * customer. Here Customerid,status,tarifftype,typeofbill are set using
		 * Connectionvo and passed to Connectiondao and transfer the values to
		 * the addConnection.jsp
		 */

		if (page.equalsIgnoreCase("addconnection")) {
			try {

				int count = 0; // TO Check the status of the customer
				int count2 = 0; // To check the Custid for a customer

				int custId = Integer.parseInt(request.getParameter("cid"));
				ArrayList<ConnectionVO> addconn = new ArrayList<ConnectionVO>();
				ConnectionVO connvo = new ConnectionVO();
				connvo.setCustId(custId);
				Connectiondao connDetails = new Connectiondao();
				count2 = connDetails.customerId(custId);
				if (count2 == 0) {
					ServletContext context = getServletContext();
					RequestDispatcher reqDispatcher = context
							.getRequestDispatcher(FileConstants.INVALIDCUSTOMER);
					reqDispatcher.forward(request, response);

				} else {
					count = connDetails.customerStatus(custId);

					if (count == 0) {

						ServletContext context = getServletContext();
						RequestDispatcher reqDispatcher = context
								.getRequestDispatcher(FileConstants.CHECKCUSTOMERSTATUS);
						reqDispatcher.forward(request, response);
					} else {

						int count1;
						count1 = connDetails.verifyConnection(connvo, custId);
						addconn = connDetails.getTariffName(custId);
						if (count1 >= 3) {
							ServletContext context = getServletContext();
							RequestDispatcher reqDispatcher = context
									.getRequestDispatcher("/JSP/BTAScantconnect.jsp");
							reqDispatcher.forward(request, response);
						}

						else {

							request.setAttribute("connection", connvo);
							request.setAttribute("tariffname", addconn);
							ServletContext context = getServletContext();
							RequestDispatcher reqDispatcher = context
									.getRequestDispatcher("/JSP/BTASaddConnection.jsp");
							reqDispatcher.forward(request, response);
						}
					}
				}
			} catch (Exception e) {
				log.error(e);
			}
		}
		/**
		 * This function is performed to generate the connection number for a
		 * particular.value are set in the database
		 */

		if (page.equalsIgnoreCase("addconnction1")) {
			String typeOfBill = request.getParameter("mode");
			String status = request.getParameter("Status");
			int custId = Integer.parseInt(request.getParameter("id"));
			String tariffType = request.getParameter("tarifftype");
			ConnectionVO connection = new ConnectionVO();
			connection.setCustId(custId);
			connection.setStatus(status);
			connection.setTariffType(tariffType);
			connection.setTypeOfBill(typeOfBill);
			Connectiondao conndetails = new Connectiondao();
			try {
				conndetails.insertconnectiondetails(connection);
				ConnectionVO conn = new ConnectionVO();
				Connectiondao conndao = new Connectiondao();
				conn = conndao.getConnDetails(custId);
				request.setAttribute("connectionnumber", conn);
				ServletContext context = getServletContext();
				RequestDispatcher reqDispatcher = context
						.getRequestDispatcher("/JSP/BTASconnectionestablishment.jsp");
				reqDispatcher.forward(request, response);

			}

			catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function sets the customerid in connectionvo and fetches all the
		 * connection number for the particular customersends the connection
		 * numbers to viewconnection1.jsp
		 */
		
		if (page.equalsIgnoreCase("viewconnection")) {

			try {
				int count = 0;// To check the whether the connection no is
				// present
				int custId = Integer.parseInt(request.getParameter("cid"));
				ConnectionVO connection = new ConnectionVO();
				connection.setCustId(custId);

				ArrayList<ConnectionVO> connpresent = new ArrayList<ConnectionVO>();
				Connectiondao conn = new Connectiondao();
				count = conn.customerId(custId);
				if (count == 0) {
					ServletContext context = getServletContext();
					RequestDispatcher reqDispatcher = context
							.getRequestDispatcher(FileConstants.INVALIDCUSTOMER);
					reqDispatcher.forward(request, response);

				} else {

					int count1 = 0;

					count1 = conn.customerStatus(custId);

					if (count1 == 0) {

						ServletContext context = getServletContext();
						RequestDispatcher reqDispatcher = context
								.getRequestDispatcher(FileConstants.CHECKCUSTOMERSTATUS);
						reqDispatcher.forward(request, response);
					} else {

						int count2;
						count2 = conn.verifyConnection1(connection, custId);
						if (count2 == 0) {
							ServletContext context = getServletContext();
							RequestDispatcher reqDispatcher = context
									.getRequestDispatcher(FileConstants.NOCONNECTIONNUMBERGENERATED);
							reqDispatcher.forward(request, response);
						} else {

							connpresent = conn.getViewConnectionForActiveStatus(custId);
							request.setAttribute("viewconnection", connpresent);
							ServletContext context = getServletContext();
							RequestDispatcher reqDispatcher = context
									.getRequestDispatcher("/JSP/BTASviewconnection1.jsp");
							reqDispatcher.forward(request, response);
						}
					}

				}
			}

			catch (Exception e) {

				log.error(e);

			}
		}
		/**
		 * This function sets the connection number in connectionvo and
		 * connection details for this particular connection number is sent to
		 * the viewconnection2.jsp where connection details are viewed
		 */
		if (page.equalsIgnoreCase("viewconnection1")) {
			int connectionNo = Integer.parseInt(request.getParameter("number"));
			ConnectionVO conn = new ConnectionVO();
			conn.setConnectionNo(connectionNo);

			Connectiondao connection = new Connectiondao();
			try {

				ConnectionVO connget = new ConnectionVO();
				connget = connection.getConnectionDetails(connectionNo);
				request.setAttribute("viewconnection1", connget);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/JSP/BTASviewconnection2.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function sets the customerid in connectionvo and fetches all the
		 * connection number for the particular customer and sends the
		 * connection numbers to updateconnection1.jsp
		 */

		if (page.equalsIgnoreCase("updateconnection")) {

			try {
				int count = 0;// to check the connection no is present or not
				int custId = Integer.parseInt(request.getParameter("cid"));
				ConnectionVO connvo = new ConnectionVO();
				connvo.setCustId(custId);

				ArrayList<ConnectionVO> conlist = new ArrayList<ConnectionVO>();
				Connectiondao detials = new Connectiondao();
				count = detials.customerId(custId);
				if (count == 0) {
					ServletContext context = getServletContext();
					RequestDispatcher reqDispatcher = context
							.getRequestDispatcher(FileConstants.INVALIDCUSTOMER);
					reqDispatcher.forward(request, response);

				}  else {

					int count1 = 0;

					count1 = detials.customerStatus(custId);

					if (count1 == 0) {

						ServletContext context = getServletContext();
						RequestDispatcher reqDispatcher = context
								.getRequestDispatcher(FileConstants.CHECKCUSTOMERSTATUS);
						reqDispatcher.forward(request, response);
					} 
					else {

						int count2;
						count2 = detials.verifyConnection(connvo,custId);
						if (count2 == 0) {
							ServletContext context = getServletContext();
							RequestDispatcher reqDispatcher = context
									.getRequestDispatcher(FileConstants.NOCONNECTIONNUMBERGENERATED);
							reqDispatcher.forward(request, response);
						}
					
						else{
					
					 conlist = detials.getViewConnection(custId);

					request.setAttribute("updateconnection", conlist);
					ServletContext context = getServletContext();
					RequestDispatcher reqDispatcher = context
							.getRequestDispatcher("/JSP/BTASupdateconnection1.jsp");
					reqDispatcher.forward(request, response);

				}
					}
				}
			} catch (Exception e) {

				log.error(e);

			}
		}
		/**
		 * This function sets the connection number in connectionvo and
		 * connection details for this particular connection number is sent to
		 * the updateconnection2.jsp
		 */

		if (page.equalsIgnoreCase("updateconnection1")) {
			int connectionNo = Integer.parseInt(request.getParameter("number"));
			ConnectionVO connvo = new ConnectionVO();
			connvo.setConnectionNo(connectionNo);
			ConnectionVO connectionvo = new ConnectionVO();
			Connectiondao dao = new Connectiondao();
			Tariffdao tariffdao = new Tariffdao();
			ArrayList<TariffVO> listOfTariff = new ArrayList<TariffVO>();
			try {
				connectionvo = dao.getConnectionDetails(connectionNo);
				listOfTariff = tariffdao.getTariffName();
				request.setAttribute("tariffupdate", listOfTariff);
				request.setAttribute("updateconnection1", connectionvo);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/JSP/BTASupdateconnection2.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {

				log.error(e);
			}
		}
		/**
		 * This function is used to update the connection details for a
		 * particular customer id in connectionvo and stored in database and
		 * goes to updateconnection3.jsp page
		 */

		if (page.equalsIgnoreCase("updateconnection2")) {
			try {
				int count;// to check the no of connection
				int connectionNo = Integer.parseInt(request
						.getParameter("number"));
				int custId = Integer.parseInt(request.getParameter("id"));
				String typeOfBill = request.getParameter("Typeofbill");
				String tarifftype = request.getParameter("tarifftypes");
				String status = request.getParameter("status");
				ConnectionVO cust = new ConnectionVO();
				cust.setCustId(custId);
				cust.setConnectionNo(connectionNo);
				cust.setTypeOfBill(typeOfBill);
				cust.setTariffType(tarifftype);

				cust.setStatus(status);
				Connectiondao dao = new Connectiondao();

				count = dao.updateconnection(cust);

				if (count > 0) {
					ServletContext context = getServletContext();
					RequestDispatcher reqDispatcher = context
							.getRequestDispatcher("/JSP/BTASupdateconnection3.jsp");
					reqDispatcher.forward(request, response);
				}
			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function sets the customerid in connectionvo and fetches all the
		 * connection number for the particular customer sends the connection
		 * numbers to deleteconnection1.jsp
		 */

		if (page.equalsIgnoreCase("deleteconnection")) {
			try {
				int custId = Integer.parseInt(request.getParameter("cid"));
				ConnectionVO conn = new ConnectionVO();
				conn.setCustId(custId);
			
				int count = 0;
				ArrayList<ConnectionVO> connvolist = new ArrayList<ConnectionVO>();
				Connectiondao detials = new Connectiondao();
				count = detials.customerId(custId);
				if (count == 0) {

					ServletContext context = getServletContext();
					RequestDispatcher reqDispatcher = context
							.getRequestDispatcher(FileConstants.INVALIDCUSTOMER);
					reqDispatcher.forward(request, response);
				} 
				
				 else {

						int count1 = 0;

						count1 = detials.customerStatus(custId);

						if (count1 == 0) {

							ServletContext context = getServletContext();
							RequestDispatcher reqDispatcher = context
									.getRequestDispatcher(FileConstants.CHECKCUSTOMERSTATUS);
							reqDispatcher.forward(request, response);
						} 
						else {

							int count2;
							count2 = detials.verifyConnection(conn,custId); 
							if (count2 == 0) {
								ServletContext context = getServletContext();
								RequestDispatcher reqDispatcher = context
										.getRequestDispatcher(FileConstants.NOCONNECTIONNUMBERGENERATED);
								reqDispatcher.forward(request, response);
							}
						
				else {
					connvolist = detials.getViewConnection(custId);

					request.setAttribute("deleteconnection1", connvolist);
					ServletContext context = getServletContext();
					RequestDispatcher reqDispatcher = context
							.getRequestDispatcher("/JSP/BTASdeleteconnection1.jsp");
					reqDispatcher.forward(request, response);

				}
			} 
				 }
			}catch (Exception e) {

				log.error(e);

			}

		}
		/**
		 * This function changes the status of the connection number as
		 * 'Inactive instead of deleting the connection number
		 */

		if (page.equalsIgnoreCase("deleteconnection1")) {
			int count = 0;
			int connectionNo = Integer.parseInt(request.getParameter("number"));
			String reason = request.getParameter("reason");

			Connectiondao dao = new Connectiondao();
			try {

				count = dao.deleteConnection(connectionNo, reason);

				if (count > 0) {

					RequestDispatcher rs = request
							.getRequestDispatcher("/JSP/BTASdeleteconnection2.jsp");
					rs.forward(request, response);
				}
			}

			catch (Exception e) {
				log.error(e);
			}
		}
		/**
		 * This function is used to add tariff details. The values are set and
		 * passed to service. Checking if the page is addtariff.jsp
		 */
		
		
	
	
		/**
		 * This function is used to add tariff details. The values are set and
		 * passed to service. Checking if the page is addtariff.jsp
		 */
		if (page.equalsIgnoreCase("add")) {

			String tariffName = request.getParameter("tariffName");
			float localPulseRate = Float.parseFloat(request
					.getParameter("localpulseRate"));
			String localUnit = request.getParameter("localUnit");
			float stdPulseRate = Float.parseFloat(request
					.getParameter("stdpulseRate"));
			String stdUnit = request.getParameter("stdUnit");
			float isdPulseRate = Float.parseFloat(request
					.getParameter("isdpulseRate"));
			String isdUnit = request.getParameter("isdUnit");
			int monthlyRental = Integer.parseInt(request
					.getParameter("monthlyRental"));

			TariffVO addtariff = new TariffVO();
			addtariff.setTariffName(tariffName);
			addtariff.setLocalPulseRate(localPulseRate);
			addtariff.setLocalUnit(localUnit);
			addtariff.setStdPulseRate(stdPulseRate);
			addtariff.setStdUnit(stdUnit);
			addtariff.setIsdPulseRate(isdPulseRate);
			addtariff.setIsdUnit(isdUnit);
			addtariff.setMonthlyRental(monthlyRental);
			Tariffdao tariff=new Tariffdao();
			try {
				int count=tariff.tariffCheck(tariffName);
				if(count==0)
				{
					TariffService addTariffService = new TariffService();
					addTariffService.print(addtariff);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTASsucess1.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					RequestDispatcher dispatcher = request
					.getRequestDispatcher("/JSP/BTASwrongtariffname.jsp");
			dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				
				log.error(e);
			}
			
		}
		/**
		 * This function is used to view the selected tariff plan from the drop
		 * down. TariffType is set and passed to service
		 */

		if (page.equalsIgnoreCase("viewtariff1")) {

			ArrayList<TariffVO> tarifftype = new ArrayList<TariffVO>();

			Tariffdao tariff = new Tariffdao();
			try {
				tarifftype = tariff.getTariffName();

				request.setAttribute("tarifftype", tarifftype);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/JSP/BTASviewtariff.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function is used to view the details of the selected tariff
		 * details of tariff plan . TariffType is set and passed to service
		 */

		if (page.equalsIgnoreCase("view")) {

			String tariffName = request.getParameter("tariffname");
			TariffVO tariffvo = new TariffVO();
			tariffvo.setTariffName(tariffName);

			TariffService tariffService = new TariffService();
			tariffvo = tariffService.get(tariffvo);
			request.setAttribute("tariff", tariffvo);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/JSP/BTASviewtariffdetails.jsp");
			dispatcher.forward(request, response);
		}
		/**
		 * This function is used to delete the tariff plan from the drop
		 * down.TariffType is set and passed to service
		 */

		if (page.equalsIgnoreCase("deleteview")) {
			ArrayList<TariffVO> tarifftype = new ArrayList<TariffVO>();

			Tariffdao tariff = new Tariffdao();
			try {
				tarifftype = tariff.getTariffName();

				request.setAttribute("tarifftype", tarifftype);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/JSP/BTASdeletetariff.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {

				log.error(e);
			}
		}
		/**
		 * This function is used to delete the plan if the customer does not use
		 * that particular plan. TariffName is set and passed to service
		 */

		if (page.equalsIgnoreCase("delete")) {

			int count = 0;// to the tariff is present or not
			String tariffName = request.getParameter("tariffname");

			try {
				TariffVO tariffvo = new TariffVO();
				tariffvo.setTariffName(tariffName);
				TariffService deleteService = new TariffService();
				count = deleteService.checkplan(tariffvo);

				if (count == 0) {
					deleteService.del(tariffvo);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTASdeletetariff2.jsp");
					dispatcher.forward(request, response);
				} else {
					deleteService.del(tariffvo);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTASdeletetariff1.jsp");
					dispatcher.forward(request, response);
				}
			} catch (Exception e) {

				log.error(e);
			}

		}
		/**
		 * This function is used to select and update the tariff plan from the
		 * drop down. TariffType is set and passed to service
		 */

		if (page.equalsIgnoreCase("updatetariff1")) {

			ArrayList<TariffVO> tarifftype = new ArrayList<TariffVO>();

			Tariffdao tariff = new Tariffdao();
			try {
				tarifftype = tariff.getTariffName();

				request.setAttribute("tarifftype", tarifftype);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/JSP/BTASupdatetariff.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {

				log.error(e);
			}

		}
		/**
		 * This function is used to view the selected tariff plan from the drop
		 * down. TariffType is set and passed to service
		 */

		if (page.equalsIgnoreCase("updateview")) {
			String tariffName = request.getParameter("tariffname");
			TariffVO tariffvo = new TariffVO();
			tariffvo.setTariffName(tariffName);
			TariffVO tariffvoView = new TariffVO();

			TariffService s = new TariffService();
			tariffvoView = s.get(tariffvo);

			request.setAttribute("update", tariffvoView);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/JSP/BTASupdatetariffdetails.jsp");
			dispatcher.forward(request, response);
		}
		/**
		 * This function is used to update the selected tariff details and store
		 * the same in database.
		 */

		if (page.equalsIgnoreCase("updateview1")) {

			String tariffName = request.getParameter("tarifftype");
			float localPulseRate = Float.parseFloat(request
					.getParameter("localpulseRate"));
			String localUnit = request.getParameter("localUnit");
			float stdPulseRate = Float.parseFloat(request
					.getParameter("stdpulseRate"));
			String stdUnit = request.getParameter("stdUnit");
			float isdpulseRate = Float.parseFloat(request
					.getParameter("isdpulseRate"));
			String isdUnit = request.getParameter("isdUnit");
			int monthlyRental = Integer.parseInt(request
					.getParameter("monthlyRental"));
			TariffVO updatevo = new TariffVO();
			updatevo.setTariffName(tariffName);
			updatevo.setLocalPulseRate(localPulseRate);
			updatevo.setLocalUnit(localUnit);
			updatevo.setStdPulseRate(stdPulseRate);
			updatevo.setStdUnit(stdUnit);
			updatevo.setIsdPulseRate(isdpulseRate);
			updatevo.setIsdUnit(isdUnit);
			updatevo.setMonthlyRental(monthlyRental);
			TariffService updateService = new TariffService();
			updateService.updateTariff(updatevo);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/JSP/BTASupdatedsuccess.jsp");
			dispatcher.forward(request, response);

		}
		/**
		 * This function is used to change the status of the customer. The
		 * values are set and passed to Customerdao. Checking if the page is
		 * statuschange.jsp
		 */
		if (page.equalsIgnoreCase("statuschange"))

		{
			int id = Integer.parseInt(request.getParameter("cid"));

			String status = request.getParameter("statuslist");

			Customerdao cust = new Customerdao();
			try {
				String statusBeforeChange=cust.getStatus(id);
				if(status.equalsIgnoreCase(statusBeforeChange))
				{
					request.setAttribute("status", status);
					RequestDispatcher dispatcher = request
					.getRequestDispatcher("/JSP/BTAScannotupdate.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					try {
						boolean b = cust.updateStatus(id, status);

						if (b == true) {
							CustomerVO custDetailsCheck = new CustomerVO();
							Customerdao customer = new Customerdao();
							custDetailsCheck = customer.searchId(id);
							if (custDetailsCheck.getStatus().equalsIgnoreCase("Active")) {
								LoginVO login = new LoginVO();
								String password ;
								
								
								
								
								
								try {
									System.out.println(custDetailsCheck.getFirstName().substring(0, 3));
									password=BTHMEncode.encode((custDetailsCheck.getCustomerID() + custDetailsCheck.getFirstName().substring(0, 3)));
									login.setUserName(custDetailsCheck.getCustomerID());
									login.setRole("Customer");
									login.setPassword(password);
									cust.addLogin(login);
									RequestDispatcher dispatcher = request
											.getRequestDispatcher("/JSP/BTASstatussuccess.jsp");
									dispatcher.forward(request, response);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
								
								
								
								
								
								
								
								
								
								
								
								

								

							} else if (custDetailsCheck.getStatus().equalsIgnoreCase(
									"Inactive")) {
								int noofconnectionactive = 0;
								Customerdao custinactive = new Customerdao();
								noofconnectionactive = custinactive.deleteCustomer(id);
								if (noofconnectionactive == 0) {
									cust.deleteCustomerStatus(id);

									cust.deleteLogin(id);
									String f = "/JSP/BTASafterdelete.jsp";
									RequestDispatcher dispatch = getServletContext()
											.getRequestDispatcher(f);
									dispatch.forward(request, response);

								} else {
									String f = "/JSP/BTASerrorindelete.jsp";
									RequestDispatcher dispatch = getServletContext()
											.getRequestDispatcher(f);
									dispatch.forward(request, response);
								}

							} else {
								RequestDispatcher dispatcher = request
										.getRequestDispatcher("/JSP/BTASstatussuccess.jsp");
								dispatcher.forward(request, response);
							}
						}
					} catch (SQLException e) {

						log.error(e);
					}

				}
				
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}
		if(page.equalsIgnoreCase("generatecustomerreport"))
		{
			
			ArrayList<Customerreportvo> list=new ArrayList<Customerreportvo>();
			Customerreportvo vo=new Customerreportvo();
			int currentpage1 = Integer.parseInt((String) request
					.getParameter("currentpage"));
			int noofrecperpage = Integer.parseInt((String) request
					.getParameter("noofrecperpage"));
			Customerdao custreport=new Customerdao();
			HelpDeskTicketReport p = new HelpDeskTicketReport();
			
			p.pageimplement(currentpage1, noofrecperpage);
			request.setAttribute("startindex", p.startindex);
			request.setAttribute("endindex", p.endindex);
			request.setAttribute("currentpage", p.currPage);
			request.setAttribute("noofrecperpage", noofrecperpage);
			
			try {
				list=custreport.getReportDetails(vo);
			  
				
				
				request.setAttribute("report", list);
				
				RequestDispatcher rd=request.getRequestDispatcher("BTASCustomerReportDetails.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				
				log.error(e);
			}
			
		}
		
		
		if(page.equalsIgnoreCase("piechart"))
		{
			Customerdao custreport=new Customerdao();
			Customerreportvo vo=new Customerreportvo();
			ArrayList<Customerreportvo> temp =new ArrayList<Customerreportvo>(); 
			try {
				temp=custreport.getReportDetails(vo);
				request.setAttribute("list", temp);
				RequestDispatcher rd=request.getRequestDispatcher("BTASpiechart.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
			
			
				
				
		
		}
		
		
		
		
		
		if(page.equalsIgnoreCase("generatereportcalldetails"))
		{
			 int conNo=Integer.parseInt(request.getParameter("connectionNo"));
			 	   System.out.println(conNo);
		    int currentpage1=Integer.parseInt((String)request.getParameter("currentpage"));
		   int  noofrecperpage=Integer.parseInt((String)request.getParameter("noofrecperpage"));
		     
		    
		    
		    
		    HelpDeskTicketReport p= new HelpDeskTicketReport();
		    p.pageimplement(currentpage1,noofrecperpage);
		    request.setAttribute("startindex",p.startindex);
		    request.setAttribute("endindex",p.endindex);
		    request.setAttribute("currentpage",p.currPage);
		    request.setAttribute("conno",conNo);
		    

		    request.setAttribute("noofrecperpage",noofrecperpage);
			CallDetaildao c=new CallDetaildao();
			ArrayList<CallDetailVO> tsl=new ArrayList<CallDetailVO>();
			try {
				
				tsl=c.generateReport(conNo);
				request.setAttribute("report",tsl);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/BTASviewreportcalldetails.jsp");
				rd.forward(request, response);
													
				
			} catch (SQLException e) {
				
				log.error(e);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

		if (page.equalsIgnoreCase("generatereporthelpdesktable")) {
			
			
			
			
			String fromdate = request.getParameter("fromdate");
			String todate = request.getParameter("todate");
		int currentpage1 = Integer.parseInt((String) request
					.getParameter("currentpage"));
			int noofrecperpage = Integer.parseInt((String) request
					.getParameter("noofrecperpage"));

			HelpDeskTicketReport p = new HelpDeskTicketReport();
			p.pageimplement(currentpage1, noofrecperpage);
			request.setAttribute("startindex", p.startindex);
			request.setAttribute("endindex", p.endindex);
			request.setAttribute("currentpage", p.currPage);
			request.setAttribute("fromdate", fromdate);
			request.setAttribute("todate", todate);

			request.setAttribute("noofrecperpage", noofrecperpage);
			Customerdao c = new Customerdao();
			ArrayList<TicketSummary> tsl = new ArrayList<TicketSummary>();
			try {
				tsl = c.generateReporttable(fromdate, todate);
				
				
				request.setAttribute("report", tsl);
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/BTASviewreporthelpdesk.jsp");
				rd.forward(request, response);
				

			} catch (SQLException e) {

				log.error(e);
			}
		}
		
		if(page.equalsIgnoreCase("firstPage"))
		{
			System.out.println("Entered servlet");
			int custId = Integer.parseInt(request.getParameter("cid"));
			ReportVo repVo = new ReportVo();
			repVo.setCustomerId(custId);
			
			CallDetaildao repDao = new CallDetaildao();
			try {
				repVo = repDao.getConnectionNo(custId);
				System.out.println(repVo.getCustomerId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
			System.out.println("sdfhg");
			request.setAttribute("result", repVo);
			System.out.println("sdfhg");
			if(repVo.getCheck()>0)
			{
			RequestDispatcher dispatch = request.getRequestDispatcher("BTASReportGen.jsp");
			dispatch.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatch = request.getRequestDispatcher("BTASReportErr.jsp");
				dispatch.forward(request, response);
			}
			
		}
		
		if(page.equalsIgnoreCase("reportGen"))
		{
			System.out.println("entered reportgen");
			
			ReportVo repVo = new ReportVo();
			int local=Integer.parseInt(request.getParameter("local"));
			int std = Integer.parseInt(request.getParameter("std"));
			int isd= Integer.parseInt(request.getParameter("isd"));
			System.out.println(local);
			repVo.setLocalCalls(local);
			repVo.setStdCalls(std);
			repVo.setIsdCalls(isd);
				

			request.setAttribute("result", repVo);
			RequestDispatcher dispatch = request.getRequestDispatcher("BTAScallchart.jsp");
			dispatch.forward(request, response);
			
			
			
		}
		
		
		
		
		
		
		
		
		/**
		 * 
		 *This function is used to upload proof. The values are passed to
		 * Customerdao. Checking if the page is uploadproof.jsp
		 */
		if (page.equalsIgnoreCase("uploadproof"))

		{
			int id = Integer.parseInt(request.getParameter("cid"));
			String idproof = request.getParameter("idp");
			String addproof = request.getParameter("addp");
			Customerdao cust = new Customerdao();
			try {
				cust.uploadProof(idproof, addproof, id);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/JSP/BTASproofsuccess.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {

				log.error(e);
			}

		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}