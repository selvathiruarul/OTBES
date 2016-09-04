package com.otbes.service;

import java.sql.SQLException;

import com.otbes.vo.TariffVO;
import com.otbes.dao.Tariffdao;

/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author Rahini
 * @version 1.0
 * @Class name TariffService
 * @Creation Date 8/12/2012 @ History
 */

public class TariffService {

	public void print(TariffVO tariff) {

		/**
		 * This function is used to call the insertDatabase() in Tariffdao
		 * Class.
		 * 
		 * @param TariffVO
		 * @return void
		 * @exception SQLException
		 *                are thrown.
		 * @since jdk1.6.0_29
		 * @see calls insertDatabase() in Tariffdao Class.
		 */

		String tariffName = tariff.getTariffName();
		float localpulseRate = tariff.getLocalPulseRate();
		String localUnit = tariff.getLocalUnit();
		float stdpulseRate = tariff.getStdPulseRate();
		String stdUnit = tariff.getStdUnit();
		float isdpulseRate = tariff.getIsdPulseRate();
		String isdUnit = tariff.getIsdUnit();
		int monthlyrental = tariff.getMonthlyRental();

		Tariffdao dao = new Tariffdao();
		try {
			dao
					.insertDatabase(tariffName, localpulseRate, localUnit,
							stdpulseRate, stdUnit, isdpulseRate, isdUnit,
							monthlyrental);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public TariffVO get(TariffVO tariff) {
		/**
		 * This function is used to call the getDatabase() in Tariffdao Class.
		 * 
		 * @param TariffVO
		 * @return TariffVO
		 * @exception SQLException
		 *                are thrown.
		 * @since jdk1.6.0_29
		 * @see calls getDatabase() in Tariffdao Class.
		 */

		String tariffName = tariff.getTariffName();
		TariffVO tariffvo = new TariffVO();

		Tariffdao dao = new Tariffdao();
		try {
			tariffvo = dao.getDatabase(tariffName);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return tariffvo;

	}

	public void updateTariff(TariffVO updatevo) {

		/**
		 * This function is used to call the updateTariffDatabase() in Tariffdao
		 * Class.
		 * 
		 * @param TariffVO
		 * @return void
		 * @exception SQLException
		 *                are thrown.
		 * @since jdk1.6.0_29
		 * @see calls updateTariffDatabase() in Tariffdao Class.
		 */

		Tariffdao dao = new Tariffdao();
		try {
			dao.updateTariffDatabase(updatevo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void del(TariffVO delvo) {
		/**
		 * This function is used to call the delDatabase() in Tariffdao Class.
		 * 
		 * @param TariffVO
		 * @return void
		 * @exception SQLException
		 *                are thrown.
		 * @since jdk1.6.0_29
		 * @see calls delDatabase() in Tariffdao Class.
		 */

		String tariffname = delvo.getTariffName();

		Tariffdao deldao = new Tariffdao();
		try {
			deldao.delDatabase(tariffname);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public int checkplan(TariffVO delvo) throws Exception {
		/**
		 * This function is used to call the chechTariff() in Tariffdao Class.
		 * 
		 * @param TariffVO
		 * @return int count
		 * @exception Exception
		 *                are thrown.
		 * @since jdk1.6.0_29
		 * @see calls chechTariff() in Tariffdao Class.
		 */

		int count;
		String tariffName = delvo.getTariffName();

		
		Tariffdao deldao = new Tariffdao();
		count = deldao.checkTariff(tariffName);
		
		return count;

	}

}
