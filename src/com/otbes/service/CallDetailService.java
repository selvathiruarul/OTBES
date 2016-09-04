package com.otbes.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.otbes.dao.CallDetaildao;
import com.otbes.vo.CallDetailFileVO;
import com.otbes.vo.CallDetailVO;

/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author Vinod,Madhu mathi,Kalaiarasan
 * @version 1.0
 * @Class name CallDetailService
 * @Creation Date 8/12/2012 @ History
 */
public class CallDetailService {
	
		
		public void upload(CallDetailFileVO file) {
			/**
			 * This function is used to call the insert() in CallDetaildao Class.
			 * 
			 * @param CallDetailFileVO
			 * @return void
			 * @exception FileNotFoundException
			 *                and IOException are thrown.
			 * @since jdk1.6.0_29
			 * @see calls insert() in CallDetaildao Class.
			 */

			String strFile = file.getRoot();
		
			String strLine = null;
			String temp = null;
			String arr[] = new String[6];
			
			int i, j;
			CallDetailVO cd;

			try {
				
				BufferedReader br = new BufferedReader(new FileReader(strFile));
				StringTokenizer st = null;
				j = 0;
				while ((strLine = br.readLine()) != null) {
					st = new StringTokenizer(strLine, ",");
					cd = new CallDetailVO();
					i = 0;
					while (st.hasMoreTokens()) {
						arr[i++] = st.nextToken();
					}
					temp = arr[1];
					temp = temp.substring(1, temp.length() - 1);
					cd.setCallID(j);
					cd.setConnectionNo(Long.parseLong(arr[0]));
					cd.setDateOfCall(temp);
					cd.setDialedNo(Long.parseLong(arr[2]));
					cd.setDuration(Integer.parseInt(arr[3]));
					temp = arr[4];
					temp = temp.substring(1, temp.length() - 1);
					cd.setTypeOfCall(temp);
					CallDetaildao dao = new CallDetaildao();
					dao.insert(cd);
					j++;
				}

			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	public ArrayList<CallDetailVO> view(CallDetailVO vo) {
		/**
		 * This function is used to call the viewCallDetails() in CallDetaildao
		 * Class.
		 * 
		 * @param CallDetailVO
		 * @return ArrayList<CallDetailVO>
		 * @exception No
		 *                Exceptions are thrown.
		 * @since jdk1.6.0_29
		 * @see calls viewCallDetails() in CallDetaildao Class.
		 */

		ArrayList<CallDetailVO> calldetailslist = new ArrayList<CallDetailVO>();
		CallDetaildao dao = new CallDetaildao();
		calldetailslist = dao.viewCallDetails(vo);
		return calldetailslist;
	}

	public ArrayList<CallDetailVO> updateView(CallDetailVO vo) {
		/**
		 * This function is used to call the viewCallDetailsById() in
		 * CallDetaildao Class.
		 * 
		 * @param CallDetailVO
		 * @return ArrayList<CallDetailVO>
		 * @exception No
		 *                Exceptions are thrown.
		 * @since jdk1.6.0_29
		 * @see calls viewCallDetailsById() in CallDetaildao Class.
		 */

		ArrayList<CallDetailVO> calldetailslist = new ArrayList<CallDetailVO>();
		CallDetaildao dao = new CallDetaildao();
		calldetailslist = dao.viewCallDetailsById(vo);
		return calldetailslist;
	}

	public void update(CallDetailVO vo) {
		/**
		 * This function is used to call the updateCallDetails() in
		 * CallDetaildao Class.
		 * 
		 * @param CallDetailVO
		 * @return void
		 * @exception No
		 *                Exceptions are thrown
		 * @since jdk1.6.0_29
		 * @see calls updateCallDetails() in CallDetaildao Class.
		 */

		CallDetaildao dao = new CallDetaildao();
		dao.updateCallDetails(vo);
	}

	public void delete(CallDetailVO vo) {
		/**
		 * This function is used to call the deleteCallDetail() in CallDetaildao
		 * Class.
		 * 
		 * @param CallDetailVO
		 * @return void
		 * @exception No
		 *                Exceptions are thrown
		 * @since jdk1.6.0_29
		 * @see calls deleteCallDetail() in CallDetaildao Class.
		 */

		CallDetaildao dao = new CallDetaildao();
		dao.deleteCallDetails(vo);
	}

	public int deletecalls(CallDetailVO vo) {
		/**
		 * This function is used to call the deleteCallsBycon() in CallDetaildao
		 * Class.
		 * 
		 * @param CallDetailVO
		 * @return int count
		 * @exception No
		 *                Exceptions are thrown
		 * @since jdk1.6.0_29
		 * @see calls deleteCallBycon() in CallDetaildao Class.
		 */

		CallDetaildao dao = new CallDetaildao();
		int count = dao.deleteCallsBycon(vo);
		return count;

	}
}
