package com.otbes.dao;

import java.sql.*;
import java.util.ArrayList;

import com.otbes.vo.*;
import com.otbes.connection.DBConnection;
import com.otbes.constants.Queryconstant;

/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author Naveen kumar
 * @version 1.0
 * @Class name Connectiondao
 * @Creation Date 8/12/2012 @ History
 */

public class Connectiondao {

	public int customerId(int id) throws SQLException {
		/**
		 * To Check the customer id
		 * 
		 * @param <Integer>
		 *            <Id:Customer id is passed>
		 * @return <integer> <countiDBConnectionheck:sends the 1 if the customer id is
		 *         present in DataBase >
		 * @exception SQLException
		 *                is thrown from this function
		 * @since JDK 1.6.0_29
		 * @see Not applicable
		 */

		int countiDBConnectionheck = 0;// To check whether the customer id is present in
		// database
		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con
				.prepareStatement(Queryconstant.SELECTCUSTOMERID);
		ps.setInt(1, id);

		ResultSet r = ps.executeQuery();

		while (r.next()) {
			countiDBConnectionheck++;

		}

		return countiDBConnectionheck;

	}

	public int customerStatus(int id) throws SQLException {
		/**
		 * To check the customer status
		 * 
		 * @param <Integer>
		 *            <Id:Customer id is passed>
		 * @return <integer> <count:sends the 0 if the customer id is present in
		 *         DataBase >
		 * @exception SQLException
		 *                is thrown from this function
		 * @since JDK 1.6.0_29
		 * @see Not applicable
		 */

		int count = 0;// To check the customer id and status
		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con
				.prepareStatement(Queryconstant.SELECTCUSTOMERIDSTATUS);
		ps.setInt(1, id);

		ResultSet s = ps.executeQuery();
		while (s.next()) {
			count++;
		}
		ps.close();
		s.close();
		con.commit();
		con.close();
		return count;
	}

	public int verifyConnection(ConnectionVO conn, int id) throws SQLException {
		/**
		 * To get the no of customer id for different connection
		 * 
		 * @param <Integer>
		 *            <Id:Customer id is passed>
		 * @return <integer> <count:sends the number of connections for a
		 *         particular customer>
		 * @exception SQLException
		 *                is thrown from this function
		 * @since JDK 1.6.0_29
		 */

		int count = 0;
		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con
				.prepareStatement(Queryconstant.SELECTCONNNO);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			rs.getInt(1);

			count++;

		}
		ps.close();
		rs.close();
		con.commit();
		con.close();

		return count;

	}

	public ArrayList<ConnectionVO> getTariffName(int custId)
			throws SQLException {
		/**
		 * To get the tariff name
		 * 
		 * @param <Integer>
		 *            <Id:Customer id is passed>
		 * @return <ArrayList<ConnectionVO>> <v2:returns the arraylist object of
		 *         Connectionvo class>
		 * @exception SQLException
		 *                is thrown from this function
		 * @since JDK 1.6.0_29
		 * @see Not applicable
		 */

		String tariffName;

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con.prepareStatement(Queryconstant.SELECTTARIFF);
		ResultSet rs = ps.executeQuery();
		ArrayList<ConnectionVO> connList = new ArrayList<ConnectionVO>();
		while (rs.next()) {
			ConnectionVO conn = new ConnectionVO();
			tariffName = rs.getString(1);
			conn.setTariffType(tariffName);
			connList.add(conn);

		}
		ps.close();
		rs.close();
		con.commit();
		con.close();

		return connList;
	}

	public void insertconnectiondetails(ConnectionVO conn) throws SQLException {
		/**
		 * Issue connection to the particular customer
		 * 
		 * @param <Integer>
		 *            <Id:Customer id is passed>
		 * @return <void> <doesnt return anything>
		 * @exception SQLException
		 *                is thrown from this function
		 * @since JDK 1.6.0_29
		 * @see Not applicable
		 */

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con
				.prepareStatement(Queryconstant.INSERTCONNECTIONDET);
		ps.setInt(1, conn.getCustId());
		ps.setString(2, conn.getTypeOfBill());
		ps.setString(3, conn.getTariffType());
		ps.setString(4, conn.getStatus());
		ps.executeUpdate();

		ps.close();
		con.commit();
		con.close();
	}

	public ArrayList<ConnectionVO> getViewConnection(int custid)
			throws SQLException {
		/**
		 * To view the connection for the particular customer
		 * 
		 * @param <Integer>
		 *            <Id:Customer id is passed>
		 * @return <ArrayList<ConnectionVO>> <v2:returns the arraylist object of
		 *         Connectionvo class>
		 * @exception SQLException
		 *                is thrown from this function
		 * @since JDK 1.6.0_29
		 * @see Not applicable
		 */

		ArrayList<ConnectionVO> connectionList = new ArrayList<ConnectionVO>();
		int number;
		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con.prepareStatement(Queryconstant.SELECTCONNNO);
		ps.setInt(1, custid);
		ResultSet s = ps.executeQuery();
		while (s.next()) {
			ConnectionVO conn = new ConnectionVO();
			number = s.getInt(1);
			conn.setConnectionNo(number);
			connectionList.add(conn);
		}

		ps.close();
		s.close();
		con.commit();
		con.close();
		return connectionList;

	}

	
	public ArrayList<ConnectionVO> getViewConnectionForActiveStatus(int custid)
	throws SQLException {
/**
 * To view the connection for the particular customer
 * 
 * @param <Integer>
 *            <Id:Customer id is passed>
 * @return <ArrayList<ConnectionVO>> <v2:returns the arraylist object of
 *         Connectionvo class>
 * @exception SQLException
 *                is thrown from this function
 * @since JDK 1.6.0_29
 * @see Not applicable
 */

ArrayList<ConnectionVO> connectionList = new ArrayList<ConnectionVO>();
int number;

Connection con = DBConnection.connectionDB();

PreparedStatement ps = con.prepareStatement(Queryconstant.SELECTCONNNO1);
ps.setInt(1, custid);
ResultSet s = ps.executeQuery();
while (s.next()) {
	ConnectionVO conn = new ConnectionVO();
	number = s.getInt(1);
	conn.setConnectionNo(number);
	connectionList.add(conn);
}

ps.close();
s.close();
con.commit();
con.close();
return connectionList;

}

	
	public ConnectionVO getConnDetails(int id) throws SQLException {
		/**
		 * To get the connection no for the customer
		 * 
		 * @param <Integer>
		 *            <Id:Customer id is passed>
		 * @return <ConnectionVO> <v2:returns the object of connectionvo >
		 * @exception SQLException
		 *                is thrown from this function
		 * @since JDK 1.6.0_29
		 * @see Not applicable
		 */

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con
				.prepareStatement(Queryconstant.SELECTMAXCONN);
		ps.setInt(1, id);
		ResultSet s = ps.executeQuery();

		ConnectionVO conn = new ConnectionVO();
		while (s.next()) {

			conn.setConnectionNo(s.getInt(1));

		}

		s.close();
		ps.close();
		con.commit();
		con.close();
		return conn;

	}

	public int updateconnection(ConnectionVO conn) throws SQLException {
		/**
		 * To update the connection details for the connection
		 * 
		 * @param <ConnectionVO>
		 *            <vo: object of the connectionvo class>
		 * @return <integer> <count:returns the no of fields int the connection
		 *         Database>
		 * @exception SQLException
		 *                is thrown from this function
		 * @since JDK 1.6.0_29
		 * @see Not applicable
		 */

		int count = 0;// to check the no of connection no for the customer id
		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con
				.prepareStatement(Queryconstant.UPDATECONNECTION);
		ps.setString(1, conn.getTypeOfBill());
		ps.setString(2, conn.getTariffType());
		ps.setString(3, conn.getStatus());
		ps.setInt(4, conn.getCustId());

		count = ps.executeUpdate();
		con.commit();
		ps.close();
		con.close();
		return count;
	}

	public int deleteConnection(int number, String reason) throws SQLException {
		/**
		 * To update the status of the connection as "inactive"
		 * 
		 * @param <integer,String> <number: connection number for a customer,
		 *        Reason: reason for deleting a connection >
		 * @return <integer> <count:returns the no of fields int the connection
		 *         Database>
		 * @exception SQLException
		 *                is thrown from this function
		 * @since JDK 1.6.0_29
		 * @see Not applicable
		 */

		
		Connection con = DBConnection.connectionDB();

		int count = 0;// to count the connection details making the status as
		// inactive

		PreparedStatement ps = con
				.prepareStatement(Queryconstant.DELETECONNECTION);

		ps.setString(1, reason);
		ps.setInt(2, number);

		count = ps.executeUpdate();
		ps.close();
		con.commit();
		con.close();

		return count;

	}

	public ConnectionVO getConnectionDetails(int Connno) throws SQLException {

		/**
		 * To get the connection details
		 * 
		 * @param <Integer>
		 *            <number: connection number for a customer>
		 * @return <ConnectionVO> <v2:returns the object of connectionvo >
		 * @exception SQLException
		 *                is thrown from this function
		 * @since JDK 1.6.0_29
		 * @see Not applicable
		 */
		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con
				.prepareStatement(Queryconstant.VIEWCONNECTIONNO);

		ps.setInt(1, Connno);

		ResultSet s = ps.executeQuery();
		ConnectionVO conn = new ConnectionVO();
		while (s.next()) {

			conn.setCustId(s.getInt(1));
			conn.setConnectionNo(s.getInt(2));
			conn.setTypeOfBill(s.getString(3));
			conn.setTariffType(s.getString(4));
			conn.setStatus(s.getString(5));
		    conn.setReason(s.getString(6));
		    		    
		}

		s.close();
		ps.close();
		con.commit();
		con.close();
		return conn;
	}

	public int verifyConnection1(ConnectionVO connection, int custId) throws SQLException {
		

		int count = 0;
		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con
				.prepareStatement(Queryconstant.SELECTCONNNO1);
		ps.setInt(1,custId);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			rs.getInt(1);

			count++;

		}
		ps.close();
		rs.close();
		con.commit();
		con.close();

		return count;
	
	}
}
