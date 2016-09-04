package com.otbes.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.otbes.dao.BTHMDAO;
import com.otbes.vo.BTHMCustomerVO;
import com.otbes.vo.BTHMEmployeeVO;
import com.otbes.vo.BTHMTicketVO;

/**
 * @author 588438
 * @version 1.0
 * @Class BTHMServlet
 * @Creation 07-12-2012 @ History
 */

public class BTHMAdministratorService {
	private static Logger log = Logger.getLogger("otbeslogger");

	/**
	 * @param employeeVo
	 * @return count return the count value to the called function
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see addHelpDeskEmployee funtion in BTHMDAO class
	 */
	public int addHelpDeskEmployee(BTHMEmployeeVO employeeVo)
			throws ClassNotFoundException, SQLException {
		/*
		 * addHelpDeskEmployee adds the employee details into the database
		 */
		BTHMDAO dao = new BTHMDAO();
		int count = 0;

		try {
			count = dao.addHelpDeskEmployee(employeeVo);

		} catch (Exception e1) {
			log.error(e1);
		}
		return count;
	}

	/**
	 * @param bthmemployeeVo
	 * @since jdk1.6.0_29
	 * @return eVO returning the user-defined data type(eVO) to the called
	 *         function
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see viewEmployeeQuery function,updateEmployeeQuery function in BTHMDAO
	 *      class
	 */
	public BTHMEmployeeVO viewEmployee(BTHMEmployeeVO bthmemployeeVo)
			throws ClassNotFoundException, SQLException {
		/*
		 * viewEmployee retrieve the Employee details from the database
		 */

		BTHMDAO dao = new BTHMDAO();
		BTHMEmployeeVO eVO = dao.viewEmployeeQuery(bthmemployeeVo);
		return eVO;
	}

	/**
	 * @param bthmemployeeVo
	 * @since jdk1.6.0_29
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see updateEmployeeQuery function in BTHMDAO class
	 */
	public void updateEmployee(BTHMEmployeeVO bthmemployeeVo)
			throws ClassNotFoundException, SQLException {
		/*
		 * updateEmployee update the employee details into the database
		 */

		BTHMDAO dao = new BTHMDAO();
		dao.updateEmployeeQuery(bthmemployeeVo);
	}

	/**
	 * @param bthmemployeeVo
	 * @since jdk1.6.0_29
	 * @return e2 as boolean to called function
	 * @throws Exception
	 * @see rmvEmployee function in BTHMDAO class
	 */
	public boolean rmvEmployee(BTHMEmployeeVO bthmemployeeVo) throws Exception {
		/*
		 * rmvEmployee update Employee status as inactive
		 */

		BTHMDAO d = new BTHMDAO();

		boolean e2 = d.rmvEmployee(bthmemployeeVo);

		return e2;

	}

	/**
	 * @param bthmTicketVo
	 * @since jdk1.6.0_29
	 * @return count to the called function
	 * @throws Exception
	 * @see raiseTicket function in BTHMDAO class
	 */
	public int bthmInsert(BTHMTicketVO bthmTicketVo) throws Exception {
		/*
		 * bthmInsert insert the new ticket into the database
		 */

		int count;
		BTHMDAO bthmTicketDao = new BTHMDAO();
		count = bthmTicketDao.raiseTicket(bthmTicketVo);

		return count;
	}

	/**
	 * @param bthmTicketVo
	 * @since jdk1.6.0_29
	 * @return count to the called function
	 * @throws Exception
	 * @see updateRaisedTicketDetails function in BTHMDAO class
	 */
	public int bthmUpdate(BTHMTicketVO bthmTicketVo) throws Exception {
		/*
		 * bthmUpdate updates the raised ticket details into the data base
		 */
		int count;
		BTHMDAO bthmTicketDao = new BTHMDAO();
		count = bthmTicketDao.updateRaisedTicketDetails(bthmTicketVo);

		return count;
	}

	/**
	 * @param bthmTicketVo
	 * @since jdk1.6.0_29
	 * @return count to the called function
	 * @throws Exception
	 * @see deleteRaisedTicketDetails function in BTHMDAO class
	 */
	public int bthmDelete(BTHMTicketVO bthmTicketVo) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * bthmDelete change the ticket status as closed into the database
		 */
		int count;
		BTHMDAO bthmTicketDao = new BTHMDAO();
		count = bthmTicketDao.deleteRaisedTicketDetails(bthmTicketVo
				.getTicketId());

		return count;
	}

	/**
	 * @param bthmCustomerVo
	 * @since jdk1.6.0_29
	 * @return bthmCustomerVo returning the user-defined data
	 *         type(bthmCustomerVo) to the called function
	 * @see ticketVerify function in BTHMDAO class
	 * @exception e
	 */
	public BTHMCustomerVO bthmVerifyCustomer(BTHMCustomerVO bthmCustomerVo) {
		// TODO Auto-generated method stub
		/*
		 * bthmVerifyCustomer is used to verify ticket availability
		 */

		BTHMDAO dao = new BTHMDAO();
		int id = bthmCustomerVo.getCustomerId();

		try {
			bthmCustomerVo = dao.ticketVerify(id);
		} catch (Exception e) {
			log.error(e);
		}

		return bthmCustomerVo;
	}

	/**
	 * @param bthmTicketVo
	 * @since jdk1.6.0_29
	 * @return bthmTicketVo bthmTicketVo returning the user-defined data
	 *         type(bthmTicketVo) to the called function
	 * @see viewRaisedTicketDetails function in BTHMDAO class
	 * @exception e
	 */
	public BTHMTicketVO bthmView(BTHMTicketVO bthmTicketVo) {
		/*
		 * bthmView retrieves raised ticket details from database
		 */

		int id = bthmTicketVo.getTicketId();
		BTHMDAO dao = new BTHMDAO();
		try {
			bthmTicketVo = dao.viewRaisedTicketDetails(id);
		} catch (Exception e) {
			log.error(e);
		}
		return bthmTicketVo;

	}

	/**
	 * @param ticketvo
	 * @since jdk1.6.0_29
	 * @return bthmTicketVo bthmTicketVo returning the user-defined data
	 *         type(bthmTicketVo) to the called function
	 * @see viewTickets function in BTHMDAO class
	 * @exception e
	 */
	public BTHMTicketVO viewTickets(BTHMTicketVO ticketvo) {
		/*
		 * viewTickets retrieves assigned ticket details from the database
		 */
		int id = ticketvo.getTicketId();
		BTHMDAO dao = new BTHMDAO();
		BTHMTicketVO ticketvo1 = new BTHMTicketVO();
		try {

			ticketvo1 = dao.viewTickets(id);
		} catch (Exception e) {
			log.error(e);
		}
		return ticketvo1;
	}

	/**
	 * @param ticketVo
	 * @since jdk1.6.0_29
	 * @return result as boolean value to the called function
	 * @throws SQLException
	 * @see assignEmployee function in BTHMDAO class
	 */
	public boolean assignEmployee(BTHMTicketVO ticketVo) throws SQLException {
		/*
		 * assignEmployee assigns the employee who is not having five priority
		 * tickets to the ticket which status is open
		 */
		BTHMDAO dao = new BTHMDAO();
		boolean result = dao.assignEmployee(ticketVo);
		return result;

	}

	/**
	 * @param ticketvo
	 * @return result as a boolean value to the called function
	 * @throws SQLException
	 * @since jdk1.6.0_29 @ see updateTicket function in BTHMDAO class
	 */
	public boolean updateTicket(BTHMTicketVO ticketvo) throws SQLException {
		/*
		 * updates the assigned ticket details into the database
		 */
		String description = ticketvo.getTicketDescription();

		int employee = ticketvo.getEmployeevo().getEmployeeId();
		int ticket = ticketvo.getTicketId();
		BTHMDAO dao = new BTHMDAO();
		boolean result = dao.updateTicket(description, employee, ticket);
		return result;
	}

	/**
	 * @return ticketvo ticketvo-arraylist returning the user-defined data
	 *         type(ticketvo) to the called function
	 * @see viewOpenTickets function in BTHMDAO class
	 * @exception e
	 * @since jdk1.6.0_29
	 */
	public ArrayList<BTHMTicketVO> getTicketList() {
		/*
		 * updateTicket retrieves the tickets from the database which status is
		 * open
		 */
		BTHMDAO dao = new BTHMDAO();
		ArrayList<BTHMTicketVO> ticketvo = new ArrayList<BTHMTicketVO>();

		try {
			ticketvo = dao.viewOpenTickets();
		} catch (Exception e) {
			log.error(e);
		}
		return ticketvo;

	}

	/**
	 * @return employeeList employeeList-array list returning the user-defined
	 *         data type(employeeList) to the called function
	 * @see showEmployees function in BTHMDAO class
	 * @exception e
	 * @since jdk1.6.0_29
	 */
	public ArrayList<BTHMEmployeeVO> showEmployees() {
		/*
		 * showEmployees retrieves employee Id from the database who is not
		 * having five high priority tickets
		 */
		BTHMDAO dao = new BTHMDAO();
		ArrayList<BTHMEmployeeVO> employeeList = new ArrayList<BTHMEmployeeVO>();
		try {
			employeeList = dao.showEmployees();
		} catch (Exception e) {
			log.error(e);
		}

		return employeeList;

	}

	/**
	 * @param bthmTicketVo
	 * @return result as a boolean to the called function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see refer to deleteAssignedTicket function in BTHMDAO class
	 */
	public boolean deleteAssignedTicket(BTHMTicketVO bthmTicketVo)
			throws SQLException {
		/*
		 * deleteAssignedTicket updates the ticket status as open into the
		 * database
		 */
		BTHMDAO dao = new BTHMDAO();
		boolean result = dao.deleteAssignedTicket(bthmTicketVo);
		return result;

	}
}
