package com.otbes.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.otbes.dao.BTHMDAO;
import com.otbes.vo.BTHMEmployeeVO;
import com.otbes.vo.BTHMTicketVO;

/**
 * @author 588438
 * @version 1.0
 * @Class BTHMServlet
 * @Creation 07-12-2012 @ History
 */

public class BTHMEmployeeService {

	/**
	 * @param bthmEmployeeVo
	 * @return ticket list ticket list returning the user-defined
	 *         data type(ticket list) to the called function
	 * @throws SQLException
	 * @see assignedTicket function in BTHMDAO class
	 * @since jdk1.6.0_29
	 */
	public ArrayList<BTHMTicketVO> assignedTickets(BTHMEmployeeVO bthmEmployeeVo)
			throws SQLException {
		/*
		 * assignedTicket retrieve assigned ticket Id from the database
		 */
		BTHMDAO empdao = new BTHMDAO();
		ArrayList<BTHMTicketVO> ticketlist = empdao.assignedTicket(bthmEmployeeVo);
		return ticketlist;
	}

	/**
	 * @param bthmEmployeeVo
	 * @return eVO eVO returning the user-defined
	 *         data type(eVO) to the called function
	 * @throws ClassNotFoundException, SQLException
	 * @@since jdk1.6.0_29
	 * @see viewEmployeeQuery function BTHMDAO class
	 */
	public BTHMEmployeeVO getDetails(BTHMEmployeeVO bthmEmployeeVo)
			throws ClassNotFoundException, SQLException {
		/*
		 * getDetails get employee details from the database
		 */

		BTHMDAO dao = new BTHMDAO();
		BTHMEmployeeVO employeeVo = dao.viewEmployeeQuery(bthmEmployeeVo);

		return employeeVo;
	}
}
