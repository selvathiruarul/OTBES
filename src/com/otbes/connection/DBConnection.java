package com.otbes.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.otbes.constants.Constants;

/**
 * @author 588438
 * @version 1.0
 * @Class BTHMServlet
 * @Creation 07-12-2012 @ History
 */
public class DBConnection {
	static Connection con = null;
	private static Logger log = Logger.getLogger("otbeslogger");
	
	public static Connection connectionDB() {
		/*
		 * To get connection for the data base
		 */

		/**
		 * @param None
		 * @return con, return the connection to the called function
		 * @exception SQLException
		 * @since jdk1.6.0_29
		 * @see <reference to any other function called >
		 */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			
			log.error(e1);
		}
		try {

			con = (Connection) DriverManager.getConnection(Constants.URL,
					Constants.USERNAME, Constants.PWD);

		} catch (SQLException e) {
			log.error(e);			
		} finally {
			if (con == null) {
				connectionDB();

			}
		}
		log.info("connected");
		
		return con; // return the connection to the called function
	}

}
