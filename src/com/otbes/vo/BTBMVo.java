package com.otbes.vo;
import java.util.ArrayList;

/**
 * @author 		 588669
 * @version 	 1.0
 * @class 		 BTBMVo
 * @date 		 27/11/2012
 */


public class BTBMVo {
	
	private int billItemId;
	private String date;
	private String reason;
	private int disputeId;
	private String dateOfResolving;
	private String discrepancyFound;
	private String resolutionComments;
	private int adjustedCallCost;
	private String status;
	private int index;
	private String reasonForCancel;
	private String dateOfCancel;
	private int userId;
	private int custId;
	private int count;
	private String sysDate;
	
	ArrayList<Integer> list = new ArrayList<Integer>() ;
	ArrayList<BTBMVo> listVO = new ArrayList<BTBMVo>() ;
	
	
/**
 * @return sysDate
 * since jdk1.6.0_29
*/
	public String getSysDate() {
		return sysDate;
	}
	
/**
* @param sysDate
* since jdk1.6.0_29
*/	
	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}
	
/**
* @return count
* since jdk1.6.0_29
*/	
	
	public int getCount() {
		return count;
	}
	
/**      
* @param count
* since jdk1.6.0_29
*/		
	public void setCount(int count) {
		this.count = count;
	}
	
/**
* @return custId
* since jdk1.6.0_29
*/		
	public int getCustId() {
		return custId;
	}
	
	
/**      
* @param custId
* since jdk1.6.0_29
*/		
	
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
/**
* @return userId
* since jdk1.6.0_29
*/		
	
	public int getUserId() {
		return userId;
	}
		
/**      
* @param userId
* since jdk1.6.0_29
*/		
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
/**
* @return list
* since jdk1.6.0_29
*/		
	
	public ArrayList<Integer> getList() {
		return list;
	}
	
/**      
* @param list
* since jdk1.6.0_29
*/		
			
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
	
/**
* @return listVO
* since jdk1.6.0_29
*/		
	public ArrayList<BTBMVo> getListVO() {
		return listVO;
	}
/**      
* @param  listVO
* since jdk1.6.0_29
*/		
	
	public void setListVO(ArrayList<BTBMVo> listVO) {
		this.listVO = listVO;
	}
	
/**
* @return reasonForCancel
* since jdk1.6.0_29
*/		
	public String getReasonForCancel() {
		return reasonForCancel;
	}
	
/**      
* @param  reasonForCancel
* since jdk1.6.0_29
*/		
		
	public void setReasonForCancel(String reasonForCancel) {
		this.reasonForCancel = reasonForCancel;
	}
	
	
/**
* @return dateOfCancel
* since jdk1.6.0_29
*/	
	public String getDateOfCancel() {
		return dateOfCancel;
	}
	
/**      
* @param  dateOfCancel
* since jdk1.6.0_29
*/		
	public void setDateOfCancel(String dateOfCancel) {
		this.dateOfCancel = dateOfCancel;
	}

/**
* @return  index
* since jdk1.6.0_29
*/	
	public int getIndex() {
		return index;
	}
	
/**      
* @param  index
* since jdk1.6.0_29
*/	
	public void setIndex(int index) {
		this.index = index;
	}
	
/**
* @return  billItemId
* since jdk1.6.0_29
*/		
	public int getBillItemId() {
		return billItemId;
	}
	
/**      
* @param  billItemId
* since jdk1.6.0_29
*/	
	public void setBillItemId(int billItemId) {
		this.billItemId = billItemId;
	}

/**
* @return  date
* since jdk1.6.0_29
*/
	public String getDate() {
		return date;
	}
/**      
* @param date
* since jdk1.6.0_29
*/		
	
	public void setDate(String date) {
		this.date = date;
	}
	
/**
* @return reason;
* since jdk1.6.0_29
*/	
	public String getReason() {
		return reason;
	}
	
/**      
* @param reason 
* since jdk1.6.0_29
*/	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
/**
* @return  disputeId;
* since jdk1.6.0_29
*/		
	public int getDisputeId() {
		return disputeId;
	}
	
/**      
* @param disputeId 
* since jdk1.6.0_29
*/	
		
	public void setDisputeId(int disputeId) {
		this.disputeId = disputeId;
	}
	
/**
* @return  dateOfResolving;
* since jdk1.6.0_29
*/
	public String getDateOfResolving() {
		return dateOfResolving;
	}
	
/**      
* @param dateOfResolving 
* since jdk1.6.0_29
*/
	public void setDateOfResolving(String dateOfResolving) {
		this.dateOfResolving = dateOfResolving;
	}
	
/**
* @return  discrepancyFound;
* since jdk1.6.0_29
*/	
	public String getDiscrepancyFound() {
		return discrepancyFound;
	}
	
/**      
* @param discrepancyFound
* since jdk1.6.0_29
*/
	public void setDiscrepancyFound(String discrepancyFound) {
		this.discrepancyFound = discrepancyFound;
	}
	
/**
* @return   resolutionComments;
* since jdk1.6.0_29
*/		
	public String getResolutionComments() {
		return resolutionComments;
	}
	
/**      
* @param resolutionComments
* since jdk1.6.0_29
*/
	public void setResolutionComments(String resolutionComments) {
		this.resolutionComments = resolutionComments;
	}
	
/**
* @return  adjustedCallCost;
* since jdk1.6.0_29
*/		
	public int getAdjustedCallCost() {
		return adjustedCallCost;
	}
	
/**      
* @param adjustedCallCost
* since jdk1.6.0_29
*/
	public void setAdjustedCallCost(int adjustedCallCost) {
		this.adjustedCallCost = adjustedCallCost;
	}
	
/**
* @return  status;
* since jdk1.6.0_29
*/	
	public String getStatus() {
		return status;
	}
	
/**      
* @param status
* since jdk1.6.0_29
*/	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
