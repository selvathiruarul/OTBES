package com.otbes.vo;

import java.util.ArrayList;

public class ReportVo {
	private int connectionNo;
	private int customerId;
	private int check;
	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	private int totalCalls=0;
	private int stdCalls=0;
	private int isdCalls=0;
	private int localCalls=0;
	private int count;
	ArrayList<ReportVo> conNoList = new ArrayList<ReportVo>();
	ArrayList<Integer> percentList = new ArrayList<Integer>();
	
	public ArrayList<Integer> getPercentList() {
		return percentList;
	}
	public void setPercentList(ArrayList<Integer> percentList) {
		this.percentList = percentList;
	}
	public ArrayList<ReportVo> getConNoList() {
		return conNoList;
	}
	public void setConNoList(ArrayList<ReportVo> conNoList) {
		this.conNoList = conNoList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getConnectionNo() {
		return connectionNo;
	}
	public void setConnectionNo(int connectionNo) {
		this.connectionNo = connectionNo;
	}
	public int getTotalCalls() {
		return totalCalls;
	}
	public void setTotalCalls(int totalCalls) {
		this.totalCalls = totalCalls;
	}
	public int getStdCalls() {
		return stdCalls;
	}
	public void setStdCalls(int stdCalls) {
		this.stdCalls = stdCalls;
	}
	public int getIsdCalls() {
		return isdCalls;
	}
	public void setIsdCalls(int isdCalls) {
		this.isdCalls = isdCalls;
	}
	public int getLocalCalls() {
		return localCalls;
	}
	public void setLocalCalls(int localCalls) {
		this.localCalls = localCalls;
	}
	

}
