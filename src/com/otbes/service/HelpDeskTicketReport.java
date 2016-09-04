package com.otbes.service;

import java.util.ArrayList;

public class HelpDeskTicketReport {

	 public int startindex=0;
	 public int endindex=0;
	 public  int noofrecperpage;
	 public  int totalnoofrecords=0;
	 public  int currPage=0;
	 
	
	public void pageimplement(int currentpage, int noofrecperpage) {
		// TODO Auto-generated method stub
		System.out.println("noofrecperpage in bean " +noofrecperpage);
	      currPage = currentpage;
	      System.out.println("currPage..pageimplement.."+currPage);
	       if(currPage == 0)
	       {
	           currPage=1;
	           startindex=1;
	       }
	       else
	       {
	         startindex=(noofrecperpage*(currPage-1))+1;
	       }
	       endindex=(startindex+noofrecperpage)-1;
	       System.out.println(endindex);

	}

}
