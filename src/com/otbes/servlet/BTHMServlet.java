package com.otbes.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.otbes.constants.Constants;
import com.otbes.dao.BTHMDAO;
import com.otbes.service.BTHMAdministratorService;
import com.otbes.service.BTHMChangePwdService;
import com.otbes.service.BTHMEmployeeService;
import com.otbes.service.BTHMEncode;
import com.otbes.service.BTHMTicketService;
import com.otbes.utility.BTHMUtility;
import com.otbes.vo.BTHMChangePwdVO;
import com.otbes.vo.BTHMCustomerVO;
import com.otbes.vo.BTHMEmployeeVO;
import com.otbes.vo.BTHMTicketVO;
import com.otbes.vo.BTHMUserVO;

/**
 * @author 588438
 * @version 1.0
 * @Class BTHMServlet
 * @Creation 07-12-2012 @ History
 */
public class BTHMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("otbeslogger");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BTHMServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * @param HttpServletRequest
		 *            request, HttpServletResponse response
		 * @return void, Need not to return any value
		 * @exception ServletException
		 *                , IOException
		 * @since jdk1.6.0_29
		 * @see <reference to any other function called >
		 */
		HttpSession session;
		session = request.getSession();
		try {
			String page = (String) session.getAttribute("page");
			if (page != null && page.equalsIgnoreCase("login")) {
				/*
				 * login page
				 */
				BTHMUserVO userVo = new BTHMUserVO();
				BTHMDAO dao = new BTHMDAO();
				int userId = BTHMUtility.convert(request.getParameter("uName"));
				String pwd = request.getParameter("pwd");
				String Role = request.getParameter("role");

				userVo.setuserId(userId);
				userVo.setPwd(BTHMEncode.encode(pwd));
				userVo.setRole(Role);

				int count = dao.loginValidation(userVo);
				int days = userVo.getExpiry();
				
				session.setAttribute("themeColor", userVo.getTheme());
				if (count == 1) {
					session.setAttribute("User", Role);
					session.setAttribute("userId", userId);

					if (userVo.getRole().matches("Administrator")) {						
						if (days <= 30) {							
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher(Constants.PROFILE);
							dispatcher.forward(request, response);
						} else{
							System.out.println("Days"+days);
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher(
											"/JSP/changePassword.jsp");
							dispatcher.forward(request, response);
							session.setAttribute("userid", userId);
							session.setAttribute("User", Role);
						}
					} else if (userVo.getRole().matches("Customer")) {
						if (days < 30) {
							session.setAttribute("userid", userId);
							session.setAttribute("User", Role);
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher(Constants.PROFILE);

							dispatcher.forward(request, response);
						} else {
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher(
											"/JSP/changePassword.jsp");
							dispatcher.forward(request, response);

						}
					} else if (userVo.getRole().matches("Employee")) {
						ArrayList<BTHMTicketVO> ticketlist = new ArrayList<BTHMTicketVO>();

						BTHMEmployeeVO employeeVo = new BTHMEmployeeVO();
						employeeVo.setEmployeeId(userVo.getuserId());
						BTHMEmployeeService employeeService = new BTHMEmployeeService();
						try {
							employeeVo = employeeService
									.getDetails(employeeVo);
						} catch (ClassNotFoundException e1) {
							log.info(e1);
							// RequestDispatcher dispatcher =
							// getServletContext()
							// .getRequestDispatcher("/JSP/Error.jsp");
							// dispatcher.forward(request, response);

						} catch (SQLException e1) {
							log.error(e1);
							// RequestDispatcher dispatcher =
							// getServletContext()
							// .getRequestDispatcher("/JSP/Error.jsp");
							// dispatcher.forward(request, response);

						}
						try {
							ticketlist = employeeService
									.assignedTickets(employeeVo);
						} catch (SQLException e) {
							log.error(e);
							// RequestDispatcher dispatcher =
							// getServletContext()
							// .getRequestDispatcher("/JSP/Error.jsp");
							// dispatcher.forward(request, response);

						}
						session.setAttribute("employeeDetails", employeeVo);
						session.setAttribute("ticketls", ticketlist);
						if (days < 30) {
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher(Constants.PROFILE);
							dispatcher.forward(request, response);
						} else {
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher(
											"/JSP/changePassword.jsp");
							dispatcher.forward(request, response);

						}
					}

				} else {
					request.setAttribute("Error",
							"Please Enter Valid User Name and Pasword");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/index.jsp");
					dispatcher.forward(request, response);
				}
			} else if (page != null && page.equalsIgnoreCase("insert")) {
				/*
				 * add help desk employee page
				 */
				BTHMEmployeeVO employeeVo = new BTHMEmployeeVO();
				BTHMUtility bthmUtility = new BTHMUtility();

				try {
					employeeVo.setEmployeeId(bthmUtility.getEmployeeID());
				} catch (SQLException e2) {
					log.error(e2);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);
				} catch (ClassNotFoundException e2) {
					log.error(e2);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);
				}

				employeeVo.setFirstName(request.getParameter("firstname"));
				employeeVo.setMiddleName(request.getParameter("middlename"));
				employeeVo.setLastName(request.getParameter("lastname"));
				employeeVo.setDesignation(request.getParameter("designation"));
				employeeVo.setDateOfJoining(request
						.getParameter("dateofjoining"));
				employeeVo.setPancard(request.getParameter("pancard"));
				employeeVo.setStatus("ACTIVE");

				int count = 0; // to check the execution of the method in the
				// service class
				BTHMAdministratorService administratorService = new BTHMAdministratorService();
				try {

					count = administratorService
							.addHelpDeskEmployee(employeeVo);
				} catch (ClassNotFoundException e1) {
					log.error(e1);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);
				} catch (SQLException e1) {
					log.error(e1);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);
				}
				if (count >= 1) {
					request.setAttribute("employee", employeeVo);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.ADDHELPDESKEMPLOYEESUCCESS);
					dispatcher.forward(request, response);
				}

				if (count <= 0) {
					request
							.setAttribute("message",
									"The employee details have not been inserted properly.Try again!");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.ADDHELPDESKEMPLOYEE);
					dispatcher.forward(request, response);
				}

			}

			else if (page != null && page.equalsIgnoreCase("deletedetails")) {
				/*
				 * delete details page of the help desk employee
				 */

				BTHMEmployeeVO bthmEmployeeVo = new BTHMEmployeeVO();

				bthmEmployeeVo.setEmployeeId(Integer.parseInt(request
						.getParameter("employeeId")));
				bthmEmployeeVo.setDateOfJoining(request
						.getParameter("dateofseparation"));
				bthmEmployeeVo.setReasonForSeperation(request
						.getParameter("reasonforseparartion"));

				BTHMAdministratorService administratorService = new BTHMAdministratorService();

				try {
					administratorService.rmvEmployee(bthmEmployeeVo);
					request.setAttribute("employeeid", bthmEmployeeVo
							.getEmployeeId());
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.DELETEHELPDESKEMPLOYEEDETAILSSUCCESS);
					dispatcher.forward(request, response);

				} catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}

			}

			else if (page != null && page.equalsIgnoreCase("view")) {
				/*
				 * view page of the help desk employee
				 */

				BTHMEmployeeVO bthmEmployeeVo = new BTHMEmployeeVO();
				bthmEmployeeVo.setEmployeeId(Integer.parseInt(request
						.getParameter("employeeId")));

				BTHMEmployeeVO employeeDetails = null;
				BTHMAdministratorService bthmAdministratorService = new BTHMAdministratorService();

				try {
					employeeDetails = bthmAdministratorService
							.viewEmployee(bthmEmployeeVo);
				} catch (ClassNotFoundException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				} catch (SQLException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}
				if (employeeDetails.getPancard() == null
						&& employeeDetails.getFirstName() == null) {
					request.setAttribute("message",
							Constants.INVALIDEMPLOYEEIDMSG);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.VIEWHELPDESKEMPLOYEE);
					dispatcher.forward(request, response);
				}

				else {
					BTHMUtility bthmutility = new BTHMUtility();
					try {
						employeeDetails.setDateOfJoining(bthmutility
								.dateFormatConvertor(employeeDetails
										.getDateOfJoining()));

						if (employeeDetails.getDateOfSeperation() != null) {
							employeeDetails.setDateOfSeperation(bthmutility
									.dateFormatConvertor(employeeDetails
											.getDateOfSeperation()));
						}

					} catch (ClassNotFoundException e) {
						log.error(e);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/JSP/Error.jsp");
						dispatcher.forward(request, response);

					}
					request.setAttribute("employeeVO", employeeDetails);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.VIEWHELPDESKEMPLOYEEDETAILS);
					dispatcher.forward(request, response);
				}

			}

			else if (page != null && page.equalsIgnoreCase("deleteEmployee")) {
				/*
				 * delete page of the help desk employee
				 */
				BTHMEmployeeVO bthmEmployeeVo = new BTHMEmployeeVO();
				bthmEmployeeVo.setEmployeeId(Integer.parseInt(request
						.getParameter("employeeId")));
				BTHMEmployeeVO employeedetails = new BTHMEmployeeVO();

				BTHMAdministratorService administratorService = new BTHMAdministratorService();
				try {
					employeedetails = administratorService
							.viewEmployee(bthmEmployeeVo);

				} catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}

				if ((employeedetails.getPancard() == null && employeedetails
						.getFirstName() == null)) {
					request.setAttribute("message",
							Constants.INVALIDEMPLOYEEIDMSG);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.DELETEHELPDESKEMPLOYEE);
					dispatcher.forward(request, response);
				} else if ((employeedetails.getStatus().equals("INACTIVE"))) {
					request.setAttribute("message",
							"Employee's status is already inactive !");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.DELETEHELPDESKEMPLOYEE);
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("employeeVO", employeedetails);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.DELETEHELPDESKEMPLOYEEDETAILS);
					dispatcher.forward(request, response);
				}
			}

			else if (page != null && page.equalsIgnoreCase("update")) {
				/*
				 * update page of the help desk employee
				 */

				BTHMEmployeeVO bthmEmployeeVo = new BTHMEmployeeVO();

				bthmEmployeeVo.setEmployeeId(Integer.parseInt(request
						.getParameter("employeeId")));

				BTHMEmployeeVO employeedetails = null;
				BTHMAdministratorService administratorService = new BTHMAdministratorService();
				try {
					employeedetails = administratorService
							.viewEmployee(bthmEmployeeVo);
					request.setAttribute("employeeVO", employeedetails);
				} catch (ClassNotFoundException e1) {
					log.error(e1);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);
				} catch (SQLException e1) {
					log.error(e1);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);
				}
				if (employeedetails.getPancard() == null
						&& employeedetails.getFirstName() == null) {
					request.setAttribute("message",
							Constants.INVALIDEMPLOYEEIDMSG);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.UPDATEHELPDESKEMPLOYEE);
					dispatcher.forward(request, response);
				} else if ((employeedetails.getStatus().equals("INACTIVE"))) {
					request.setAttribute("message",
							"Employee's status is already inactive !");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.UPDATEHELPDESKEMPLOYEE);
					dispatcher.forward(request, response);
				} else {
					BTHMUtility bthmutility = new BTHMUtility();
					try {
						employeedetails.setDateOfJoining(bthmutility
								.dateFormatConvertor(employeedetails
										.getDateOfJoining()));
					} catch (ClassNotFoundException e) {
						log.error(e);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/JSP/Error.jsp");
						dispatcher.forward(request, response);

					}
					request.setAttribute("employeeVO", employeedetails);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.UPDATEHELPDESKEMPLOYEEDETAILS);
					dispatcher.forward(request, response);
				}

			} else if (page != null
					&& page.equalsIgnoreCase("updateEmployeeDetails")) {

				/*
				 * updateEmployeeDetails page of the help desk employee
				 */
				BTHMEmployeeVO bthmEmployeeVo = new BTHMEmployeeVO();
				try {
					bthmEmployeeVo.setEmployeeId(Integer.parseInt(request
							.getParameter("empid")));
					bthmEmployeeVo.setFirstName(request
							.getParameter("firstname"));
					bthmEmployeeVo.setMiddleName(request
							.getParameter("middlename"));
					bthmEmployeeVo
							.setLastName(request.getParameter("lastname"));
					bthmEmployeeVo.setDesignation(request
							.getParameter("designation"));
					bthmEmployeeVo.setDateOfJoining(request
							.getParameter("dateofjoining"));
					bthmEmployeeVo.setPancard(request.getParameter("pancard"));
					bthmEmployeeVo.setStatus(request.getParameter("status"));

					BTHMAdministratorService administratorService = new BTHMAdministratorService();
					try {
						administratorService.updateEmployee(bthmEmployeeVo);

					} catch (ClassNotFoundException e) {
						log.error(e);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/JSP/Error.jsp");
						dispatcher.forward(request, response);
					} catch (SQLException e) {
						log.error(e);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/JSP/Error.jsp");
						dispatcher.forward(request, response);

					}

					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.UPDATEHELPDESKEMPLOYEEDETAILSSUCCESS);
					dispatcher.forward(request, response);
				} catch (Exception e) {
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);
				}

			} else if (page != null && page.equalsIgnoreCase("newticketpage")) {
				/*
				 * new ticket page of the help desk ticket
				 */
				BTHMTicketVO bthmTicketVo = new BTHMTicketVO();
				BTHMCustomerVO bthmCustomerVo = new BTHMCustomerVO();
				try {
					String customerid = request.getParameter("customerid");

					int idcustomer = Integer.parseInt(customerid);

					bthmCustomerVo.setCustomerId(idcustomer);
				} catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}
				BTHMAdministratorService bthmTicketService = new BTHMAdministratorService();
				bthmCustomerVo = bthmTicketService
						.bthmVerifyCustomer(bthmCustomerVo);
				try {
					bthmTicketService.bthmVerifyCustomer(bthmCustomerVo);
					if (bthmCustomerVo.getCount() >= 1) {
						request.setAttribute("BTHMTicketVO", bthmTicketVo);
						request.setAttribute("BTHMCustomerVO", bthmCustomerVo);
						RequestDispatcher dispatcher = request
								.getRequestDispatcher(Constants.RAISENEWTICKET);
						dispatcher.forward(request, response);
					} else {
						request.setAttribute("error",
								"Please Enter Valid Customer ID");
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/JSP/BTHMNewTicket.jsp");
						dispatcher.forward(request, response);
					}
				} catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}
			}

			else if (page != null && page.equalsIgnoreCase("createpage")) {
				/*
				 * create page of the help desk ticket
				 */
				BTHMTicketVO bthmTicketVo = new BTHMTicketVO();
				BTHMUtility bthmTicketUtility = new BTHMUtility();

				try {
					String customerid = request.getParameter("customerid");
					bthmTicketVo.setTicketId(bthmTicketUtility.getTicketID());
					String sissue = request.getParameter("sissue");
					String dissue = request.getParameter("dissue");
					String dot = request.getParameter("dot");
					String status = request.getParameter("status");
					String category = request.getParameter("category");
					String priority = request.getParameter("priority");
					String path = request.getParameter("path");
					String rcomment = request.getParameter("rcomment");

					int idcustomer = Integer.parseInt(customerid);

					bthmTicketVo.setCustomerId(idcustomer);
					bthmTicketVo.setTicketDescription(dissue);
					bthmTicketVo.setTicketSummary(sissue);
					bthmTicketVo.setTicketStatus(status);
					bthmTicketVo.setTicketCategory(category);
					bthmTicketVo.setTicketPriority(priority);
					bthmTicketVo.setUploadDoc(path);
					bthmTicketVo.setResolutionComments(rcomment);
					bthmTicketVo.setDateRaised(dot);
					int count = 0;
					if ((sissue != null) || (dissue != null)) {
						BTHMAdministratorService bthmTicketService = new BTHMAdministratorService();
						try {

							count = bthmTicketService.bthmInsert(bthmTicketVo);

							if (count >= 1) {
								request.setAttribute("BTHMTicketVO",
										bthmTicketVo);
								RequestDispatcher dispatcher = request
										.getRequestDispatcher("/JSP/BTHMInsertSucess.jsp");
								dispatcher.forward(request, response);
							} else {
								RequestDispatcher dispatcher = request
										.getRequestDispatcher("/JSP/BTHMNewTicket.jsp");
								dispatcher.forward(request, response);

							}

						} catch (Exception e) {
							log.error(e);
							RequestDispatcher dispatcher = request
									.getRequestDispatcher("/JSP/Error.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/JSP/BTHMNewTicket.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);
				} catch (ClassNotFoundException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);
				}

			} else if (page != null && page.equalsIgnoreCase("viewTicketpage")) {
				/*
				 * view Ticket page of the help desk ticket
				 */
				BTHMTicketVO bthmTicketVo = new BTHMTicketVO();
				BTHMCustomerVO bthmCustomerVo = new BTHMCustomerVO();

				String ticketid = request.getParameter("ticketid");
				int idticket = Integer.parseInt(ticketid);
				bthmTicketVo.setTicketId(idticket);

				BTHMAdministratorService bthmTicketService = new BTHMAdministratorService();
				try {
					bthmTicketVo = bthmTicketService.bthmView(bthmTicketVo);
					if (bthmTicketVo.getCount() >= 1) {
						request.setAttribute("BTHMTicketVO", bthmTicketVo);
						request.setAttribute("BTHMCustomerVO", bthmCustomerVo);

						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/JSP/BTHMViewRegisteredTicketDetails.jsp");
						dispatcher.forward(request, response);
					} else {
						request.setAttribute("error",
								Constants.INVALIDTICKETIDMSG);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher(
										"/JSP/BTHMViewRegisteredTicket.jsp");
						dispatcher.forward(request, response);
					}
				} catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}
			}

			else if (page != null && page.equalsIgnoreCase("viewupdatepage")) {
				/*
				 * view update page of the help desk ticket
				 */
				BTHMTicketVO bthmTicketVo = new BTHMTicketVO();
				BTHMCustomerVO bthmCustomerVo = new BTHMCustomerVO();

				String ticketid = request.getParameter("ticketid");

				int idticket = Integer.parseInt(ticketid);

				bthmTicketVo.setTicketId(idticket);

				BTHMAdministratorService bthmTicketService = new BTHMAdministratorService();
				try {
					bthmTicketVo = bthmTicketService.bthmView(bthmTicketVo);
					if (bthmTicketVo.getCount() >= 1) {
						request.setAttribute("BTHMTicketVO", bthmTicketVo);
						request.setAttribute("BTHMCustomerVO", bthmCustomerVo);

						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/JSP/BTHMUpdateRegisteredTicketDetails.jsp");
						dispatcher.forward(request, response);
					} else {
						request.setAttribute("error",
								Constants.INVALIDTICKETIDMSG);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher(
										Constants.UPDATEREGISTEREDTICKET);

						dispatcher.forward(request, response);
					}

				} catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}
			}

			else if (page != null && page.equalsIgnoreCase("updateTicketpage")) {
				/*
				 * update Ticket page of the help desk ticket
				 */
				BTHMTicketVO bthmTicketVo = new BTHMTicketVO();

				String customerid = request.getParameter("customerid");
				String ticketid = request.getParameter("ticketid");
				String sissue = request.getParameter("sissue");
				String dissue = request.getParameter("dissue");
				String dot = request.getParameter("dot");
				String status = request.getParameter("status");
				String category = request.getParameter("category");
				String priority = request.getParameter("priority");
				String path = request.getParameter("path");
				if ((path == null) || (path == "")) {
					path = request.getParameter("docpath");
				} else {
					path = request.getParameter("path");
				}
				String doc = request.getParameter("doc");
				String rcomment = request.getParameter("rcomment");

				int idcustomer = Integer.parseInt(customerid);
				int idticket = Integer.parseInt(ticketid);

				bthmTicketVo.setCustomerId(idcustomer);
				bthmTicketVo.setTicketId(idticket);
				bthmTicketVo.setTicketDescription(dissue);
				bthmTicketVo.setTicketSummary(sissue);
				bthmTicketVo.setTicketStatus(status);
				bthmTicketVo.setTicketCategory(category);
				bthmTicketVo.setTicketPriority(priority);
				bthmTicketVo.setUploadDoc(path);
				bthmTicketVo.setResolutionComments(rcomment);
				bthmTicketVo.setDateRaised(dot);
				bthmTicketVo.setTicketClosedDate(doc);

				BTHMAdministratorService bthmTicketService = new BTHMAdministratorService();
				try {
					int count = bthmTicketService.bthmUpdate(bthmTicketVo);
					if (count >= 1) {
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/JSP/BTHMUpdateSucess.jsp");
						dispatcher.forward(request, response);
					} else {
						RequestDispatcher dispatcher = request
								.getRequestDispatcher(Constants.UPDATEREGISTEREDTICKET);
						dispatcher.forward(request, response);

					}

				} catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}

			} else if (page != null && page.equalsIgnoreCase("viewdeletepage")) {
				/*
				 * view delete page of the help desk ticket
				 */
				BTHMTicketVO bthmTicketVo = new BTHMTicketVO();
				BTHMCustomerVO bthmCustomerVo = new BTHMCustomerVO();

				String ticketid = request.getParameter("ticketid");

				int idticket = Integer.parseInt(ticketid);

				bthmTicketVo.setTicketId(idticket);

				BTHMAdministratorService bthmTicketService = new BTHMAdministratorService();
				try {
					bthmTicketVo = bthmTicketService.bthmView(bthmTicketVo);
					if ((bthmTicketVo.getCount() >= 1)
							&& (!bthmTicketVo.getTicketStatus()
									.equalsIgnoreCase("CLOSED"))) {
						request.setAttribute("BTHMTicketVO", bthmTicketVo);
						request.setAttribute("BTHMCustomerVO", bthmCustomerVo);

						RequestDispatcher dispatcher = request
								.getRequestDispatcher(Constants.DELETEHELPDESKTICKETDETAILS);
						dispatcher.forward(request, response);
					} else if ((bthmTicketVo.getCount() >= 1)
							&& (bthmTicketVo.getTicketStatus()
									.equalsIgnoreCase("CLOSED"))) {
						request.setAttribute("error",
								"The Ticket Id is in Closed State...");
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher(
										Constants.DELETEHELPDESKTICKET);

						dispatcher.forward(request, response);
					} else {
						request.setAttribute("error",
								Constants.INVALIDTICKETIDMSG);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher(
										Constants.DELETEHELPDESKTICKET);

						dispatcher.forward(request, response);
					}
				} catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}
			} else if (page != null && page.equalsIgnoreCase("deletepage")) {
				/*
				 * delete page of the help desk employee
				 */

				BTHMTicketVO bthmTicketVo = new BTHMTicketVO();

				String ticketid = request.getParameter("ticketid");
				int idticket = Integer.parseInt(ticketid);

				bthmTicketVo.setTicketId(idticket);

				BTHMAdministratorService bthmTicketService = new BTHMAdministratorService();
				try {
					int count = bthmTicketService.bthmDelete(bthmTicketVo);

					if (count >= 1) {
						RequestDispatcher dispatcher = request
								.getRequestDispatcher(Constants.DELETEHELPDESKTICKETDETAILSSUCCESS);
						dispatcher.forward(request, response);
					} else {
						RequestDispatcher dispatcher = request
								.getRequestDispatcher(Constants.DELETEHELPDESKTICKET);
						dispatcher.forward(request, response);

					}

				} catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}
			} else if (page != null && page.equalsIgnoreCase("Assignemployee")) {
				/*
				 * Assign employee of the help desk ticket to employee
				 */
				BTHMEmployeeVO employeeVo = new BTHMEmployeeVO();
				int ticketid = Integer.parseInt(request
						.getParameter("ticketid"));
				int employeeid = Integer.parseInt(request
						.getParameter("employeeId"));

				BTHMTicketVO ticketVo = new BTHMTicketVO();
				ticketVo.setTicketId(ticketid);
				employeeVo.setEmployeeId(employeeid);
				ticketVo.setEmployeevo(employeeVo);

				BTHMAdministratorService administratorService = new BTHMAdministratorService();
				boolean result = false;
				try {
					result = administratorService.assignEmployee(ticketVo);
				} catch (SQLException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}
				if (result == true) {
					request.setAttribute("ticketid", ticketid);
					request.setAttribute("employeeid", employeeid);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(Constants.ASSIGNEMPLOYEE);

					dispatcher.forward(request, response);

				}
			} else if (page != null && page.equalsIgnoreCase("ViewTicketList")) {
				/*
				 * View Ticket List of the help desk ticket to employee
				 */
				ArrayList<BTHMEmployeeVO> employeeList = new ArrayList<BTHMEmployeeVO>();
				int ticketId = Integer.parseInt(request
						.getParameter("ticketId"));
				BTHMTicketVO ticketVo = new BTHMTicketVO();
				ticketVo.setTicketId(ticketId);
				BTHMAdministratorService administratorService = new BTHMAdministratorService();
				employeeList = administratorService.showEmployees();

				request.setAttribute("ticketid", ticketId);
				request.setAttribute("employeels", employeeList);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/JSP/BTHMShowEmployeeList.jsp");

				dispatcher.forward(request, response);

			} else if (page != null && page.equalsIgnoreCase("viewpage")) {
				/*
				 * view page of the help desk ticket to employee
				 */

				int tid = Integer.parseInt(request.getParameter("ticket"));
				BTHMTicketVO ticketVo = new BTHMTicketVO();
				ticketVo.setTicketId(tid);
				BTHMTicketVO ticketVo1 = new BTHMTicketVO();
				BTHMAdministratorService administratorService = new BTHMAdministratorService();
				ticketVo1 = administratorService.viewTickets(ticketVo);

				if (ticketVo1.getTicketId() == 0) {
					request.setAttribute("message", Constants.INVALIDTICKETMSG);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTHMViewTicketDetailsAdmin.jsp");

					dispatcher.forward(request, response);

				} else {
					request.setAttribute("ticketVO", ticketVo1);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTHMViewTicket.jsp");

					dispatcher.forward(request, response);

				}
			} else if (page != null && page.equalsIgnoreCase("updatepage")) {
				/*
				 * update page of the help desk ticket to employee
				 */
				int tid = Integer.parseInt(request.getParameter("ticket"));

				BTHMTicketVO ticketVo = new BTHMTicketVO();
				ticketVo.setTicketId(tid);
				BTHMTicketVO ticketVo1 = new BTHMTicketVO();
				BTHMAdministratorService administratorService = new BTHMAdministratorService();
				ticketVo1 = administratorService.viewTickets(ticketVo);

				if (ticketVo1.getTicketId() != 0) {
					request.setAttribute("BTHMTicketVo", ticketVo1);
					ArrayList<BTHMEmployeeVO> employeeList = new ArrayList<BTHMEmployeeVO>();
					employeeList = administratorService.showEmployees();
					request.setAttribute("employeels", employeeList);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTHMUpdate.jsp");

					dispatcher.forward(request, response);
				} else {

					request.setAttribute("message", Constants.INVALIDTICKETMSG);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTHMUpdateTicketDetails.jsp");

					dispatcher.forward(request, response);
				}
			}

			else if (page != null && page.equalsIgnoreCase("updatedetails")) {
				/*
				 * update details page of the help desk ticket to employee
				 */

				String description = request.getParameter("description");

				BTHMEmployeeVO bthmEmployeeVo = new BTHMEmployeeVO();
				int employee = Integer.parseInt(request
						.getParameter("employee"));
				int ticket = Integer.parseInt(request.getParameter("ticket"));
				BTHMTicketVO ticketVo = new BTHMTicketVO();
				ticketVo.setTicketDescription(description);
				bthmEmployeeVo.setEmployeeId(employee);
				ticketVo.setEmployeevo(bthmEmployeeVo);
				ticketVo.setTicketId(ticket);
				BTHMAdministratorService administratorService = new BTHMAdministratorService();
				boolean result = false;
				try {
					result = administratorService.updateTicket(ticketVo);
				} catch (SQLException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}
				if (result == true) {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTHMUpdatedResults.jsp");

					dispatcher.forward(request, response);

				} else {
					request.setAttribute("BTHMTicketVo", ticketVo);
					request.setAttribute("message", "Invalid Update");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTHMUpdate.jsp");
					dispatcher.forward(request, response);

				}
			} else if (page != null
					&& page.equalsIgnoreCase("AssignTicketPage")) {
				/*
				 * Assign ticket Page page of the help desk ticket to employee
				 */

				ArrayList<BTHMTicketVO> ticket = new ArrayList<BTHMTicketVO>();
				BTHMAdministratorService administratorService = new BTHMAdministratorService();
				ticket = administratorService.getTicketList();

				if (ticket.isEmpty()) {

					request.setAttribute("message",
							"ALL THE TICKET WAS ASSIGNED");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTHMOpenTicketList.jsp");

					dispatcher.forward(request, response);
				}

				else {
					request.setAttribute("TicketVo", ticket);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/BTHMIndexTicketList.jsp");
					;
					dispatcher.forward(request, response);

				}

			} else if (page != null
					&& page.equalsIgnoreCase("UpdateTicketDetails")) {
				/*
				 * Update Ticket Details Page page of the help desk ticket to
				 * employee
				 */
				int ticketid = BTHMUtility.convert(request
						.getParameter("ticketid"));
				String description = request.getParameter("description");
				String status = request.getParameter("status");
				String ticketSummary = request.getParameter("shortSummary");
				String ticketCategory = request.getParameter("ticketCategory");
				String ticketPriority = request.getParameter("ticketPriority");
				String resolutionComments = request
						.getParameter("resolutionComments");

				BTHMTicketVO ticketvo = new BTHMTicketVO();
				ticketvo.setTicketId(ticketid);
				ticketvo.setTicketDescription(description);
				ticketvo.setTicketStatus(status);
				ticketvo.setTicketSummary(ticketSummary);
				ticketvo.setTicketCategory(ticketCategory);
				ticketvo.setTicketPriority(ticketPriority);
				ticketvo.setResolutionComments(resolutionComments);
				BTHMTicketService ticketService = new BTHMTicketService();
				boolean result = false;
				try {
					result = ticketService.updateTicket(ticketvo);
				} catch (SQLException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/JSP/Error.jsp");
					dispatcher.forward(request, response);

				}

				if (result == true) {
					request.setAttribute("message", "TicketDetails Updated");
					request.setAttribute("ticketdetails", ticketvo);

					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher(Constants.VIEWTICKETDETAILS);
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("message", "Invalid Update");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher(Constants.VIEWTICKETDETAILS);
					dispatcher.forward(request, response);

				}
			} else if (page != null
					&& page.equalsIgnoreCase("viewAssignedTicket")) {
				/*
				 * view Assigned Ticket page of the help desk ticket to employee
				 */

				BTHMTicketService ticketService = new BTHMTicketService();
				if (request.getParameter("TicketId") != "") {
					int ticketid = 0;
					ticketid = BTHMUtility.convert(request
							.getParameter("Ticketid"));
					BTHMTicketVO ticketVo = new BTHMTicketVO();
					ticketVo.setTicketId(ticketid);

					try {
						ticketVo = ticketService.getTicketDetails(ticketVo);

					} catch (SQLException e) {
						log.error(e);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/JSP/Error.jsp");
						dispatcher.forward(request, response);

					}

					request.setAttribute("ticketdetails", ticketVo);
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher(Constants.VIEWTICKETDETAILS);
					rd.forward(request, response);
				}
			} else if (page != null && page.equalsIgnoreCase("delete")) {
				/*
				 * delete page of the help desk ticket to employee
				 */

				int ticketid = 0;

				if (request.getParameter("ticketId") != "") {

					ticketid = BTHMUtility.convert(request
							.getParameter("ticketid"));

					BTHMTicketVO ticketVo = new BTHMTicketVO();
					ticketVo.setTicketId(ticketid);
					BTHMAdministratorService administratorService = new BTHMAdministratorService();
					boolean result = false;
					try {
						result = administratorService
								.deleteAssignedTicket(ticketVo);
					} catch (SQLException e) {
						log.error(e);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/JSP/Error.jsp");
						dispatcher.forward(request, response);

					}

					if (result == true) {
						request.setAttribute("message",
								"Ticket Assignment Deleted");
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher(
										Constants.DELETEASSIGNEDTICKETS);
						dispatcher.forward(request, response);
					} else {
						request.setAttribute("message", "Invalid TicketId");
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher(
										Constants.DELETEASSIGNEDTICKETS);
						dispatcher.forward(request, response);

					}
				}

			} else if (page != null && page.equalsIgnoreCase("viewreport")) {
				ArrayList<BTHMTicketVO> al = new ArrayList<BTHMTicketVO>();
				BTHMDAO reportdao = new BTHMDAO();
				al = reportdao.report();
				request.setAttribute("report", al);
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/BTHMPiechart.jsp");
				rd.forward(request, response);
			} else if (page != null && page.equalsIgnoreCase("changepwdpage")) {
				/*
				 * Change Password page
				 */

				String form = request.getParameter("formname");
				if (form.equalsIgnoreCase("formpassword")) {
					String password = request.getParameter("newpass");
					String Password = BTHMEncode.encode(password);
					int userid = Integer.parseInt(request
							.getParameter("userid"));
					BTHMChangePwdVO cpwdvo = new BTHMChangePwdVO();
					cpwdvo.setPassword(Password);
					cpwdvo.setUserid(userid);

					BTHMChangePwdService cpwdservice = new BTHMChangePwdService();
					int count = cpwdservice.changePassword(cpwdvo);
					if (count >= 1) {
						request
								.setAttribute("Error",
										"Your Password has been changed Successfully.Please Login to continue");
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/JSP/redirect.jsp");
						dispatcher.forward(request, response);
					} else {
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/JSP/changeRequests.jsp");
						dispatcher.forward(request, response);

					}
				} else if (form.equalsIgnoreCase("formtheme")) {
					int userid = Integer.parseInt(request
							.getParameter("userid"));
					String theme = request.getParameter("theme");
					BTHMChangePwdVO cpwdvo = new BTHMChangePwdVO();
					cpwdvo.setUserid(userid);
					cpwdvo.setTheme(theme);
					BTHMChangePwdService cpwdservice = new BTHMChangePwdService();
					cpwdservice.changePassword(cpwdvo);
					session.setAttribute("themeColor", cpwdvo.getTheme());
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/JSP/changeRequests.jsp");
					dispatcher.forward(request, response);

				}

			} else {
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/JSP/Error.jsp");
				dispatcher.forward(request, response);

			}
		} catch (Exception e) {
			log.error("Servlet " + e);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/JSP/Error.jsp");
			dispatcher.forward(request, response);
		}
	}

}