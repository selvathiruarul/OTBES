package com.otbes.service;

import java.sql.SQLException;


import com.otbes.dao.BTHMDAO;
import com.otbes.vo.BTHMTicketVO;

/**
 * @author 588438
 * @version 1.0
 * @Class BTHMServlet
 * @Creation 07-12-2012 @ History
 */


public class BTHMTicketService {
	/**
	 * @param ticketVo
	 * @return result returning the user-defined
	 *         data type(BTHMTicketVO result) to the called function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see getTicketDetails function in BTHMDAO class
	 */
	public BTHMTicketVO getTicketDetails(BTHMTicketVO ticketVo) throws SQLException {
		/*
		 * getTicketDetails get ticket details from the data base
		 */
		BTHMDAO dao = new BTHMDAO();
		BTHMTicketVO result = new BTHMTicketVO();
		
		result = dao.getTicketDetails(ticketVo.getTicketId());
		return result;

	}
	/**
	 * @param ticketVo
	 * @return result returning the user-defined
	 *         data type(BTHMTicketVO result) to the called function
	 * @throws SQLException
	 * @since jdk1.6.0_29
	 * @see updateTicketDetails function in BTHMDAO class
	 
	 */
	public boolean updateTicket(BTHMTicketVO ticketVo) throws SQLException {
		/*
		 * update Ticket details
		 */
		BTHMDAO dao = new BTHMDAO();
		boolean result = dao.updateTicketDetails(ticketVo);
		return result;

	}

}
