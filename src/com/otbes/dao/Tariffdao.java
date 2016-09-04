package com.otbes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.otbes.vo.*;
import com.otbes.connection.DBConnection;
import com.otbes.constants.Queryconstant;

/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author Rahini
 * @version 1.0
 * @Class name Tariffdao
 * @Creation Date 8/12/2012 @ History
 */

public class Tariffdao {
	public void insertDatabase(String tariffName, float localpulseRate,
			String localUnit, float stdpulseRate, String stdUnit,
			float isdpulseRate, String isdUnit, int monthlyrental)
			throws SQLException {
		
		/**
		 * This function is used to get tariff details.
		 * 
		 * @param No
		 *            param
		 * @return ArrayList<TariffVO>
		 * @exception No
		 *                Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = null;

		ps = con.prepareStatement(Queryconstant.ADDTARIFF);

		ps.setString(1, tariffName);
		ps.setInt(2, monthlyrental);
		ps.setFloat(3, localpulseRate);
		ps.setString(4, localUnit);
		ps.setFloat(5, stdpulseRate);
		ps.setString(6, stdUnit);
		ps.setFloat(7, isdpulseRate);
		ps.setString(8, isdUnit);

		ps.executeUpdate();

	}

	public TariffVO getDatabase(String tariffName) throws SQLException {
		TariffVO tariff = new TariffVO();
		/**
		 * This function is used to get tariff details.
		 * 
		 * @param No
		 *            param
		 * @return ArrayList<TariffVO>
		 * @exception No
		 *                Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con.prepareStatement(Queryconstant.VIEWTARIFF);
		ps.setString(1, tariffName);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			tariff.setTariffName(rs.getString(2));
			tariff.setMonthlyRental(rs.getInt(3));
			tariff.setLocalPulseRate(rs.getFloat(4));
			tariff.setLocalUnit(rs.getString(5));
			tariff.setStdPulseRate(rs.getFloat(6));
			tariff.setStdUnit(rs.getString(7));
			tariff.setIsdPulseRate(rs.getFloat(8));
			tariff.setIsdUnit(rs.getString(9));

		}

		con.commit();
		rs.close();
		ps.close();
		con.close();

		return tariff;
	}

	public void delDatabase(String tariffname) throws SQLException {
		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = null;

		ps = con.prepareStatement(Queryconstant.DELETETARIFF);

		ps.setString(1, tariffname);
		ps.executeUpdate();

		ps.close();
		con.commit();
		con.close();

	}

	public void updateTariffDatabase(TariffVO v) throws SQLException {
		/**
		 * This function is used to get tariff details.
		 * 
		 * @param No
		 *            param
		 * @return ArrayList<TariffVO>
		 * @exception No
		 *                Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = null;

		ps = con.prepareStatement(Queryconstant.UPDATETARIFF);
		String tarrifftype = v.getTariffName();
		ps.setFloat(1, v.getLocalPulseRate());

		ps.setString(2, v.getLocalUnit());

		ps.setFloat(3, v.getStdPulseRate());

		ps.setString(4, v.getStdUnit());

		ps.setFloat(5, v.getIsdPulseRate());

		ps.setString(6, v.getIsdUnit());

		ps.setFloat(7, v.getMonthlyRental());

		ps.setString(8, tarrifftype);

		ps.execute();

		ps.close();
		con.commit();
		con.close();

	}

	public int checkTariff(String tariffName) throws SQLException {

		/**
		 * This function is used to check tariff details.
		 * 
		 * @param String
		 *            Tariff Name
		 * @return ArrayList<TariffVO>
		 * @exception SQL
		 *                Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		int count = 0;

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement p = con
				.prepareStatement(Queryconstant.CHECKTARIFFCONN);
		p.setString(1, tariffName);
		ResultSet s = p.executeQuery();

		while (s.next()) {

			count++;

		}
		
		con.commit();
		con.close();
		return count;

	}

	public ArrayList<TariffVO> getTariffName() throws SQLException {

		/**
		 * This function is used to get tariff details.
		 * 
		 * @param No
		 *            param
		 * @return ArrayList<TariffVO>
		 * @exception No
		 *                Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		String tariffName;

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement ps = con.prepareStatement(Queryconstant.SELECTTARIFF);
		ResultSet rs = ps.executeQuery();
		ArrayList<TariffVO> listOfTariff = new ArrayList<TariffVO>();
		while (rs.next()) {
			TariffVO tariff = new TariffVO();
			tariffName = rs.getString(1);
			tariff.setTariffName(tariffName);
			listOfTariff.add(tariff);

		}
		ps.close();
		rs.close();
		con.commit();
		con.close();

		return listOfTariff;
	}

	public int tariffCheck(String tariffName)throws SQLException {
		
		Connection con = DBConnection.connectionDB();
		int count=0;
		PreparedStatement ps = con.prepareStatement(Queryconstant.VIEWTARIFF);
		ps.setString(1,tariffName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			count++;
		}
		return count;
	}

}
