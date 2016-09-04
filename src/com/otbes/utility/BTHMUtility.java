package com.otbes.utility;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.otbes.dao.BTHMDAO;


/**
 * @author 588438
 * @version 1.0
 * @Class BTHMServlet
 * @Creation 07-12-2012 @ History
 */

public class BTHMUtility {
	private static Logger log = Logger.getLogger("otbeslogger");
	/**
	 * @param name
	 * @return value as integer to the called function
	 * @Exception e
	 * @since jdk1.6.0_29
	 */

		public static int convert(String name) 
		{
			int  value=0;
	   try{
		value = Integer.parseInt(name);
				
	 }catch(Exception e){
		log.error(e);
	}
	 return value;
	    
	 
		}


	/**
	 * @return dao.helpDeskTicketIdGenerator as integer value to the called function
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @since jdk1.6.0_29
	 * @see helpDeskTicketIdGenerator funtion in BTHMDAO class
	 */
	public int getTicketID() throws SQLException, ClassNotFoundException{
		BTHMDAO dao=new BTHMDAO();
		
		return dao.helpDeskTicketIdGenerator();
	}
	
	/**
	 * @return dao.helpDeskEmployeeIdGenerator as integer value to the called function
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @since jdk1.6.0_29
	 * @see helpDeskEmployeeIdGenerator funtion in BTHMDAO class
	 */
	public int getEmployeeID() throws SQLException, ClassNotFoundException{
		BTHMDAO dao=new BTHMDAO();
		return dao.helpDeskEmployeeIdGenerator();
	}

	/**
	 * @param string(date) in the format yyyy.mm.dd
	 * @return string(date) in format dd.mm.yyyy
	 * @throws ClassNotFoundException
	 */
	public String dateFormatConvertor(String string) throws ClassNotFoundException{
		String newDateFormat=string.substring(8,10)+"."+string.substring(5,7)+"."+string.substring(0, 4);
		return newDateFormat;
	}
}
