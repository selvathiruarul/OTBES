package com.otbes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import com.otbes.connection.DBConnection;
import com.otbes.constants.Constants;
import com.otbes.service.BTHMEncode;
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
public class BTHMDAO {
	private static Logger log = Logger.getLogger("otbeslogger");

	/**
	 * @param e
	 * @return count as a integer value to the called function
	 * @throws Exception
	 * @since jdk1.6.0_29
	 * @see getConnectio function in DBConnection
	 */
	public int addHelpDeskEmployee(BTHMEmployeeVO bthmEmployeeVo)
			throws Exception {
		/*
		 * Add Employee to help desk
		 */
		int count = 0;
		Statement statement;
		Connection connection = null;
		try {
		connection = DBConnection.connectionDB();
			statement = connection.createStatement();
			String vsql = "insert into HelpDeskEmployee values("
					+ bthmEmployeeVo.getEmployeeId() + ",'"
					+ bthmEmployeeVo.getFirstName() + "','"
					+ bthmEmployeeVo.getMiddleName() + "','"
					+ bthmEmployeeVo.getLastName() + "','"
					+ bthmEmployeeVo.getDesignation() + "',to_date('"
					+ bthmEmployeeVo.getDateOfJoining() + "', 'dd/mm/yyyy'),'"
					+ bthmEmployeeVo.getPancard() + "','"
					+ bthmEmployeeVo.getStatus() + "','','')";

			String vsql1 = "insert into users(userid, role, password, dateupdated, expiry, theme) values("
					+ bthmEmployeeVo.getEmployeeId()
					+ ",'Employee','"
					+ BTHMEncode.encode((bthmEmployeeVo.getEmployeeId() + bthmEmployeeVo
							.getFirstName().substring(0, 3))) + "',SYSDATE, 30, 'orange')";
			count = statement.executeUpdate(vsql);
			statement.executeUpdate(vsql1);
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.commit();
			connection.close();
		}
		return count;

	}

	/**
	 * @return generatedEmployeeId as a integer value to the called function
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @since jdk1.6.0_29
	 * @see getConnection function in DBConnection
	 */
	public int helpDeskEmployeeIdGenerator() throws SQLException,
			ClassNotFoundException {
		/*
		 * Generate employee id for Help desk employee
		 */
		Connection connection = null;
		connection = DBConnection.connectionDB();
		Statement statement = connection.createStatement();
		String sql = "select max(employeeid) from HelpDeskEmployee";

		int generatedEmployeeId = 0;

		ResultSet resultSet = statement.executeQuery(sql);
		try {
			if (resultSet != null) {
				while (resultSet.next()) {
					generatedEmployeeId = resultSet.getInt(1);
				}
				generatedEmployeeId = generatedEmployeeId + 1;
			} else {
				generatedEmployeeId++;
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.close();
			resultSet.close();
		}
		return generatedEmployeeId;
	}

	/**
	 * @param e
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection function in BTHMConnction
	 */
	public void updateEmployeeQuery(BTHMEmployeeVO bthmEmployeeVo2)
			throws ClassNotFoundException, SQLException {
		/*
		 * Update Employee Details
		 */
		Connection connection = null;
		connection = DBConnection.connectionDB();
		Statement statement = connection.createStatement();
		try {
			String vsql = "update HelpDeskEmployee set firstname='"
					+ bthmEmployeeVo2.getFirstName() + "',middlename='"
					+ bthmEmployeeVo2.getMiddleName() + "',lastname='"
					+ bthmEmployeeVo2.getLastName() + "',designation='"
					+ bthmEmployeeVo2.getDesignation() + "',dateofjoining="
					+ "to_date('" + bthmEmployeeVo2.getDateOfJoining()
					+ "', 'dd/mm/yyyy')" + ",pancardnumber='"
					+ bthmEmployeeVo2.getPancard() + "',status='"
					+ bthmEmployeeVo2.getStatus() + "'  where employeeid="
					+ bthmEmployeeVo2.getEmployeeId();

			statement.executeUpdate(vsql);
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.commit();
			connection.close();
		}
	}

	/**
	 * @param bthmEmployeeVo
	 * @return e as a user-defined data type BTHMEmployee to the called function
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */

	public BTHMEmployeeVO viewEmployeeQuery(BTHMEmployeeVO bthmEmployeeVo)
			throws ClassNotFoundException, SQLException {
		/*
		 * View Employee Details
		 */

		String sql = "SELECT * FROM HelpDeskEmployee where employeeid="
				+ bthmEmployeeVo.getEmployeeId() + "";
		Connection connection = null;
		connection = DBConnection.connectionDB();
		PreparedStatement stmt1 = connection.prepareStatement(sql);
		ResultSet resultSet = stmt1.executeQuery(sql);
		try {
			while (resultSet.next()) {
				bthmEmployeeVo.setEmployeeId(resultSet.getInt("employeeid"));
				bthmEmployeeVo.setFirstName(resultSet.getString("firstname"));
				bthmEmployeeVo.setMiddleName(resultSet.getString("middlename"));
				bthmEmployeeVo.setLastName(resultSet.getString("lastname"));
				bthmEmployeeVo.setDesignation(resultSet
						.getString("designation"));

				bthmEmployeeVo.setDateOfJoining((resultSet
						.getDate("dateofjoining")).toString());

				bthmEmployeeVo.setPancard(resultSet.getString(7));
				bthmEmployeeVo.setStatus(resultSet.getString(8));
				if (resultSet.getString(8).equalsIgnoreCase("INACTIVE")) {
					bthmEmployeeVo.setDateOfSeperation(resultSet.getDate(
							"dateofseparation").toString());
					bthmEmployeeVo.setReasonForSeperation(resultSet
							.getString("reasonforseparation"));
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.commit();
			connection.close();
		}
		return bthmEmployeeVo;

	}

	/**
	 * @param bthmEmployeeVo
	 * @return boolean value to the called function
	 * @throws Exception
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public boolean rmvEmployee(BTHMEmployeeVO bthmEmployeeVo) throws Exception {
		/*
		 * remove employee from help desk
		 */
		Connection connection = null;
		connection = DBConnection.connectionDB();
		Statement statement = connection.createStatement();
		PreparedStatement stmnt;

		try {
			String vsql = "update HelpDeskEmployee set status='INACTIVE', dateofseparation=to_date('"
					+ bthmEmployeeVo.getDateOfJoining()
					+ "', 'dd/mm/yyyy')"
					+ ",reasonforseparation='"
					+ bthmEmployeeVo.getReasonForSeperation()
					+ "' where EmployeeID=" + bthmEmployeeVo.getEmployeeId();
			String deleteUserQuery = Constants.DELETE_EMPLOYEE_USER
					+ bthmEmployeeVo.getEmployeeId();
			stmnt = connection
					.prepareStatement(Constants.RETRIEVE_ASSIGNED_TICKET
							+ bthmEmployeeVo.getEmployeeId());
			ResultSet ticketResultSet = stmnt.executeQuery();
			int result = statement.executeUpdate(vsql);
			if (result == 1) {
				while (ticketResultSet.next()) {
					BTHMTicketVO bthmTicketVo = new BTHMTicketVO();
					bthmTicketVo
							.setTicketId(ticketResultSet.getInt("ticketid"));
					deleteAssignedTicket(bthmTicketVo);
				}

				statement.executeUpdate(deleteUserQuery);
				return true;
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.commit();
			connection.close();
		}
		return false;
	}

	/**
	 * @param bthmTicketVo
	 * @return count as integer data type to the called function
	 * @throws Exception
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public int raiseTicket(BTHMTicketVO bthmTicketVo) throws Exception {
		/*
		 * Raise a New Ticket
		 */
		int count = 0;
		Connection connection = null;
		connection = DBConnection.connectionDB();
		PreparedStatement preparedStatement = null;
		preparedStatement = connection
				.prepareStatement("insert into helpdeskticket(customerid, ticketid, ticketsummary, ticketdescription, dateraised, ticketstatus, ticketcategory, ticketpriority, uploaddoc, TICKETCLOSEDDATE, resolutioncomments) values('"
						+ bthmTicketVo.getCustomerId()
						+ "','"
						+ bthmTicketVo.getTicketId()
						+ "','"
						+ bthmTicketVo.getTicketSummary()
						+ "','"
						+ bthmTicketVo.getTicketDescription()
						+ "',SYSDATE,'"
						+ bthmTicketVo.getTicketStatus()
						+ "','"
						+ bthmTicketVo.getTicketCategory()
						+ "','"
						+ bthmTicketVo.getTicketPriority()
						+ "','"
						+ bthmTicketVo.getUploadDoc()
						+ "','00-000-00' ,'"
						+ bthmTicketVo.getResolutionComments() + "')");
		try {
			count = preparedStatement.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		} finally {
			preparedStatement.close();
			connection.close();
		}
		return count;
	}

	/**
	 * @param id
	 * @return bthmTicketVo as a user-defined datatype of BTHMTicketVO to the
	 *         called function
	 * @throws Exception
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public BTHMTicketVO viewRaisedTicketDetails(int id) throws Exception {
		/*
		 * View Raised Ticket Details information
		 */
		BTHMTicketVO bthmTicketVo = new BTHMTicketVO();
		Connection connection = null;
		connection = DBConnection.connectionDB();
		String sql = "select * from HELPDESKTICKET where TICKETID='" + id + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		try {
			while (resultSet.next()) {

				bthmTicketVo.setCustomerId(resultSet.getInt("CUSTOMERID"));
				bthmTicketVo.setTicketId(resultSet.getInt("TICKETID"));
				bthmTicketVo.setTicketSummary(resultSet
						.getString("TICKETSUMMARY"));
				bthmTicketVo.setTicketDescription(resultSet
						.getString("TICKETDESCRIPTION"));
				bthmTicketVo.setDateRaised(resultSet.getString("DATERAISED"));
				bthmTicketVo.setTicketStatus(resultSet
						.getString("TICKETSTATUS"));
				bthmTicketVo.setTicketCategory(resultSet
						.getString("TICKETCATEGORY"));
				bthmTicketVo.setTicketPriority(resultSet
						.getString("TICKETPRIORITY"));
				bthmTicketVo.setUploadDoc(resultSet.getString("UPLOADDOC"));
				bthmTicketVo.setTicketClosedDate(resultSet
						.getString("TICKETCLOSEDDATE"));
				bthmTicketVo.setResolutionComments(resultSet
						.getString("RESOLUTIONCOMMENTS"));
				bthmTicketVo.setCount(1);

			}
		} catch (Exception e) {
			log.error(e);
		} finally {

			resultSet.close();
			preparedStatement.close();
			connection.close();
		}
		return bthmTicketVo;

	}

	/**
	 * @param id
	 * @return bthmCustomerVo as a user-defined datatype of BTHMCustomerVO to
	 *         the called function
	 * @throws Exception
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public BTHMCustomerVO ticketVerify(int id) throws Exception {
		/*
		 * To verify Ticket Availability
		 */

		BTHMCustomerVO bthmCustomerVo = new BTHMCustomerVO();
		bthmCustomerVo.setCustomerId(id);
		Connection connection = null;
		connection = DBConnection.connectionDB();
		String sql = "select customerid from customer where CUSTOMERID='"
				+ bthmCustomerVo.getCustomerId() + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		try {
			while (resultSet.next()) {
				bthmCustomerVo.setCount(1);

				bthmCustomerVo.setCustomerId(resultSet.getInt("CUSTOMERID"));

			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			resultSet.close();
			preparedStatement.close();
			connection.close();
		}
		return bthmCustomerVo;
	}

	/**
	 * @param bthmTicketVo
	 * @return count as a integer datatype to the called function
	 * @throws Exception
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public int updateRaisedTicketDetails(BTHMTicketVO bthmTicketVo)
			throws Exception {
		/*
		 * Update Raised Ticket
		 */
		Connection connection = null;
		connection = DBConnection.connectionDB();
		int count = 0;
		PreparedStatement preparedStatement = null;
		try {
			if (bthmTicketVo.getTicketStatus().equalsIgnoreCase("closed")) {
				preparedStatement = connection
						.prepareStatement("update helpdeskticket set CUSTOMERID =?, TICKETSUMMARY =?, TICKETDESCRIPTION =?, DATERAISED =?, TICKETSTATUS =?, TICKETCATEGORY =?, TICKETPRIORITY =?, UPLOADDOC = ?, TICKETCLOSEDDATE =SYSDATE, RESOLUTIONCOMMENTS =? where TICKETID =?");
			} else {
				preparedStatement = connection
						.prepareStatement("update helpdeskticket set CUSTOMERID =?, TICKETSUMMARY =?, TICKETDESCRIPTION =?, DATERAISED =?, TICKETSTATUS =?, TICKETCATEGORY =?, TICKETPRIORITY =?, UPLOADDOC = ?, TICKETCLOSEDDATE ='00-000-00', RESOLUTIONCOMMENTS =? where TICKETID =?");
			}
			preparedStatement.setInt(1, bthmTicketVo.getCustomerId());
			preparedStatement.setString(2, bthmTicketVo.getTicketSummary());
			preparedStatement.setString(3, bthmTicketVo.getTicketDescription());
			preparedStatement.setString(4, bthmTicketVo.getDateRaised());
			preparedStatement.setString(5, bthmTicketVo.getTicketStatus());
			preparedStatement.setString(6, bthmTicketVo.getTicketCategory());
			preparedStatement.setString(7, bthmTicketVo.getTicketPriority());
			preparedStatement.setString(8, bthmTicketVo.getUploadDoc());
			preparedStatement
					.setString(9, bthmTicketVo.getResolutionComments());
			preparedStatement.setInt(10, bthmTicketVo.getTicketId());
			count = preparedStatement.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		} finally {
			preparedStatement.close();
			connection.close();
		}
		return count;
	}

	/**
	 * @param ticketid
	 * @return count as a integer data type to the called function
	 * @throws Exception
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public int deleteRaisedTicketDetails(int ticketid) throws Exception {
		/*
		 * Delete Raised Ticket
		 */
		int count = 0;
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		connection = DBConnection.connectionDB();
		try {
			preparedStatement = connection
					.prepareStatement("update helpdeskticket set TICKETSTATUS='CLOSED', TICKETCLOSEDDATE =SYSDATE where TICKETID =?");
			preparedStatement.setInt(1, ticketid);
			count = preparedStatement.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		} finally {
			preparedStatement.close();
			connection.close();
		}
		return count;

	}

	/**
	 * @return generatedTicketId as a integer datatype to the called function
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public int helpDeskTicketIdGenerator() throws SQLException,
			ClassNotFoundException {
		/*
		 * Generate Ticket Id
		 */
		Connection connection = null;
		connection = DBConnection.connectionDB();
		PreparedStatement preparedStatement = null;
		preparedStatement = connection
				.prepareStatement("select max(ticketid) from helpdeskticket");

		int generatedTicketId = 0;

		ResultSet resultSet = preparedStatement.executeQuery();
		try {
			while (resultSet.next()) {
				generatedTicketId = resultSet.getInt(1);
			}
			generatedTicketId = generatedTicketId + 1;
		} catch (Exception e) {
			log.error(e);
		} finally {
			preparedStatement.close();
			connection.close();
		}

		return generatedTicketId;
	}

	/**
	 * @param id
	 * @return ticket vo as a user-defined data type of BTHMTicketVO to the
	 *         called function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public BTHMTicketVO viewTickets(int id) throws SQLException {
		/*
		 * View Raised Ticket
		 */
		BTHMTicketVO ticketvo = new BTHMTicketVO();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		Connection connection = null;
		connection = DBConnection.connectionDB();
		String sql = "select ticketid,ticketdescription from helpdeskticket where TICKETID="
				+ id + " and TICKETSTATUS='Assigned'";// Changed

		String lsql = "select employeeid from ticketassignments where TICKETID="
				+ id;
		statement = connection.prepareStatement(sql);
		statement1 = connection.prepareStatement(lsql);
		ResultSet resultSet = statement.executeQuery();
		ResultSet employeeSet = statement1.executeQuery();
		try {
			while (resultSet.next()) {
				employeeSet.next();

				ticketvo.setTicketId(resultSet.getInt("ticketid"));

				ticketvo.setTicketDescription(resultSet
						.getString("ticketdescription"));

				ticketvo.getEmployeevo().setEmployeeId(
						employeeSet.getInt("employeeid"));
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			resultSet.close();
			statement.close();
			connection.close();

		}

		return ticketvo;

	}

	/**
	 * @param ticketVo
	 * @return boolean value to the called function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public boolean assignEmployee(BTHMTicketVO ticketVo) throws SQLException {
		/*
		 * Assign Employee to ticket
		 */
		Statement statement = null;
		Connection connection = null;
		connection = DBConnection.connectionDB();
		try {
			String sql = "insert into ticketassignments values("
					+ ticketVo.getEmployeevo().getEmployeeId() + ","
					+ ticketVo.getTicketId() + ")";
			String usql = "update helpdeskticket set ticketstatus='Assigned' where ticketid="
					+ ticketVo.getTicketId();
			Statement stmt1 = connection.prepareStatement(usql);
			statement = connection.prepareStatement(sql);
			int count = statement.executeUpdate(sql);
			if (count == 1) {
				stmt1.executeUpdate(usql);
				return true;
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.close();
		}
		return false;

	}

	/**
	 * @param description
	 * @param employee
	 * @param ticket
	 * @return boolean value to the called function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public boolean updateTicket(String description, int employee, int ticket)
			throws SQLException {
		/*
		 * Update Assigned Ticket Details
		 */
		Connection connection = DBConnection.connectionDB();
		PreparedStatement updatestatement = null;
		PreparedStatement updatestatement1 = null;
		ArrayList<BTHMEmployeeVO> employeeList = new ArrayList<BTHMEmployeeVO>();
		employeeList = showEmployees();
		try {
			for (BTHMEmployeeVO list : employeeList) {
				if (employee == list.getEmployeeId()) {
					String sql = "update helpdeskticket set TICKETDESCRIPTION='"
							+ description + "'where TICKETID='" + ticket + "'";
					String lsql = "update ticketassignments set employeeid="
							+ employee + " where TICKETID=" + ticket;
					
					updatestatement = connection.prepareStatement(sql);
					int result1 = updatestatement.executeUpdate(sql);
					updatestatement1 = connection.prepareStatement(lsql);
					int result2 = updatestatement1.executeUpdate(lsql);
					if (result1 == 1 && result2 == 1) {
						return true;
					}

				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.close();
		}

		return false;

	}

	/**
	 * @return list as a user-defined datatype of BTHMTicketVO to the called
	 *         function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public ArrayList<BTHMTicketVO> viewOpenTickets() throws SQLException {
		/*
		 * View Tickets in Open Status
		 */
		Connection connection = null;
		connection = DBConnection.connectionDB();
		PreparedStatement statement;
		String vsql = "select ticketid from HELPDESKTICKET where TICKETSTATUS='Open' or TICKETSTATUS='open' or TICKETSTATUS='OPEN'";

		statement = connection.prepareStatement(vsql);
		ResultSet resultSet = statement.executeQuery();

		ArrayList<BTHMTicketVO> list = new ArrayList<BTHMTicketVO>();
		try {
			while (resultSet.next()) {
				BTHMTicketVO volist = new BTHMTicketVO();
				volist.setTicketId(resultSet.getInt("TICKETID"));

				list.add(volist);
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.close();
			resultSet.close();

		}
		return list;
	}

	/**
	 * @return employeeList as a user-defined datatype of BTHMTicketVO to the
	 *         called function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public ArrayList<BTHMEmployeeVO> showEmployees() throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * Shows Employee list to assign ticket
		 */
		Connection connection = null;
		connection = DBConnection.connectionDB();
		ArrayList<BTHMEmployeeVO> employeeList = new ArrayList<BTHMEmployeeVO>();
		PreparedStatement statement = null;
		String sql = "select employeeid from helpdeskemployee where  status='ACTIVE' and employeeid not in (select ticketassignments.employeeid from ticketassignments,helpdeskticket where helpdeskticket.ticketpriority='HIGH' and helpdeskticket.ticketid=ticketassignments.ticketid having count(helpdeskticket.ticketid)>=5 group by employeeid)";

		statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery(sql);
		try {
			while (resultSet.next()) {
				BTHMEmployeeVO employeeVo = new BTHMEmployeeVO();
				employeeVo.setEmployeeId(resultSet.getInt("employeeid"));

				employeeList.add(employeeVo);
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.close();
			resultSet.close();
		}
		return employeeList;
	}

	/**
	 * @param ticketVo
	 * @return boolean value to the called function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public boolean updateTicketDetails(BTHMTicketVO ticketVo)
			throws SQLException {
		/*
		 * Update the ticket details into the database
		 */
		Connection connection = null;
		connection = DBConnection.connectionDB();
		int result = 0;
		PreparedStatement statement;
		try {
			String usql = "update helpdeskticket set ticketdescription='"
					+ ticketVo.getTicketDescription() + "',ticketstatus='"
					+ ticketVo.getTicketStatus() + "',resolutioncomments='"
					+ ticketVo.getResolutionComments()
					+ "',ticketcloseddate=SYSDATE where ticketid="
					+ ticketVo.getTicketId();
			if (ticketVo.getTicketStatus().equalsIgnoreCase("Closed")) {
				String dsql = "delete ticketassignments where ticketid="
						+ ticketVo.getTicketId();
				Statement statement1 = connection.prepareStatement(dsql);
				statement1.executeUpdate(dsql);

			}

			statement = connection.prepareStatement(usql);
			result = statement.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.close();
		}
		if (result == 1)
			return true;
		else
			return false;

	}

	/**
	 * @param ticketid
	 * @return ticket as a user-defined data type of BTHMTicketVO to the called
	 *         function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */

	public BTHMTicketVO getTicketDetails(int ticketid) throws SQLException {
		/*
		 * get ticket details from the database
		 */
		Connection connection = null;
		connection = DBConnection.connectionDB();
		BTHMTicketVO ticketVo = new BTHMTicketVO();
		PreparedStatement statement;
		String rsql = Constants.RETRIEVE_TICKET_TABLE + ticketid;

		statement = connection.prepareStatement(rsql);
		ResultSet rs_ticket = statement.executeQuery();
		try {
			while (rs_ticket.next()) {
				ticketVo.setTicketId(rs_ticket.getInt("ticketid"));
				ticketVo.setTicketDescription(rs_ticket
						.getString("ticketdescription"));
				ticketVo.setTicketStatus(rs_ticket.getString("ticketstatus"));
				ticketVo.setTicketCategory(rs_ticket
						.getString("ticketcategory"));
				ticketVo.setTicketPriority(rs_ticket
						.getString("ticketpriority"));
				ticketVo.setTicketSummary(rs_ticket.getString("ticketsummary"));
				ticketVo.setUploadDoc(rs_ticket.getString("uploaddoc"));
				ticketVo.setResolutionComments(rs_ticket
						.getString("resolutioncomments"));
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.close();
			rs_ticket.close();
		}
		return ticketVo;

	}

	/**
	 * @param bthmEmployeeVo
	 * @return ticket list as a user-defined data type of BTHMTicketVO to the
	 *         called function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public ArrayList<BTHMTicketVO> assignedTicket(BTHMEmployeeVO bthmEmployeeVo)
			throws SQLException {
		/*
		 * get assigned tickets from the database
		 */
		Connection connection = null;
		connection = DBConnection.connectionDB();
		PreparedStatement statement;
		String vsql = Constants.RETRIEVE_ASSIGNED_TICKET
				+ bthmEmployeeVo.getEmployeeId();

		statement = connection.prepareStatement(vsql);
		ResultSet resultSet = statement.executeQuery();

		ArrayList<BTHMTicketVO> ticketlist = new ArrayList<BTHMTicketVO>();
		try {
			while (resultSet.next()) {

				BTHMTicketVO volist = new BTHMTicketVO();
				volist.setTicketId(resultSet.getInt("TICKETID"));
				ticketlist.add(volist);
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			connection.close();
			resultSet.close();
		}
		return ticketlist;
	}

	/**
	 * @param bthmEmployeeVo
	 * @return boolean value to the called function
	 * @throws SQLException
	 * @SQLException e
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */

	public int loginValidation(BTHMUserVO bthmEmployeeVo)
			throws SQLException {
		/*
		 * validate the login
		 */
		Statement statement = null;
		Connection connection = null;
		connection = DBConnection.connectionDB();
		int count = 0;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			log.error("BTHMDAO : " + e);
		}

		String lsql = "select USERID, ROLE, PASSWORD, DATEUPDATED, EXPIRY, THEME from users where userid="
				+ bthmEmployeeVo.getuserId()
				+ " and role='"
				+ bthmEmployeeVo.getRole() + "'";

		ResultSet resultSet = null;
		try {

			resultSet = statement.executeQuery(lsql);

		} catch (SQLException e) {
			log.error("BTHMDAO : " + e);
		}
		try {

			while (resultSet.next()) {
				String password1 = resultSet.getString("password");
				String password2 = bthmEmployeeVo.getPwd();
				Date dateupdated = resultSet.getDate("dateupdated");
				String theme = resultSet.getString("THEME");
				Date today = Calendar.getInstance().getTime();
				int days = Days.daysBetween(new DateTime(dateupdated),
						new DateTime(today)).getDays();
				bthmEmployeeVo.setExpiry(days);
				bthmEmployeeVo.setTheme(theme);
				try {

				} catch (Exception e) {
					log.error("BTHMDAO : " + e);
				}
				if (password1.equalsIgnoreCase(password2)) {
					count = 1;
				}

			}
			if (count == 1) {
				System.out.println(count);
				return count;
			} else {
				System.out.println(count);
				return count;
			}
		} catch (SQLException e) {
			log.error("BTHMDAO : " + e);
		} finally {
			connection.close();
		}
		System.out.println(count);
		return count;

	}


	/**
	 * @param bthmTicketVo
	 * @return boolean value to the called function throws SQLException
	 * @since jdk1.6.0_29
	 * @see getConnection in DBConnection
	 */
	public boolean deleteAssignedTicket(BTHMTicketVO bthmTicketVo)
			throws SQLException {
		/*
		 * update the ticket status
		 */
		Statement statement = null;
		Connection connection = null;
		connection = DBConnection.connectionDB();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			log.error(e);
		}

		String lsql = "delete from ticketassignments where ticketid="
				+ bthmTicketVo.getTicketId();
		String lsql1 = "update helpdeskticket set ticketstatus='open' where ticketid="
				+ bthmTicketVo.getTicketId();

		int result = 0;
		try {
			result = statement.executeUpdate(lsql);

			if (result == 1) {

				statement.executeUpdate(lsql1);
				return true;
			} else {

				return false;
			}
		} catch (SQLException e) {
			log.error(e);
		} finally {
			connection.close();
		}
		return false;

	}

	public int updatePassword(BTHMChangePwdVO cpwdvo) throws SQLException {
		int count = 0;
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		connection = DBConnection.connectionDB();
		String Password = cpwdvo.getPassword();
		String Theme = cpwdvo.getTheme();
		try {
			if (Password != null) {
				preparedStatement = connection
						.prepareStatement("update users set password=?, dateupdated=SYSDATE where userid =?");
				preparedStatement.setString(1, Password);
				preparedStatement.setInt(2, cpwdvo.getUserid());
				count = preparedStatement.executeUpdate();
			} else {
				preparedStatement = connection
						.prepareStatement("update users set theme=? where userid =?");
				preparedStatement.setString(1, Theme);
				preparedStatement.setInt(2, cpwdvo.getUserid());
				count = preparedStatement.executeUpdate();				
			}
		} catch (Exception e) {
			log.error("BTHMDAO : " + e);
		} finally {
			preparedStatement.close();
			connection.commit();
			connection.close();
		}
		return count;
	}

	public ArrayList<BTHMTicketVO> report() throws SQLException {
		ArrayList<BTHMTicketVO> al=new ArrayList<BTHMTicketVO>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		connection = DBConnection.connectionDB();
		try {
			preparedStatement = connection
					.prepareStatement("select ticketcategory, count(ticketid) from helpdeskticket group by ticketcategory");
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				BTHMTicketVO ticketvo=new BTHMTicketVO();
				ticketvo.setTicketCategory(rs.getString(1));
				ticketvo.setTicketId(rs.getInt(2));
				al.add(ticketvo);
			}		
		}
		catch (Exception e) {
			log.error(e);
		} finally {
			preparedStatement.close();
			connection.close();
		}
	
		return al;
		
	}
}
