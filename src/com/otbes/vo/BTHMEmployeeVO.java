
package com.otbes.vo;

import java.util.ArrayList;


/**
 * @author 588438
 * @version 1.0
 * @Class BTHMServlet
 * @Creation 07-12-2012 @ History
 */
public class BTHMEmployeeVO {
private int employeeId; 	//employee id of the help desk employee
private String firstName;	//first name of the help desk employee
private String middleName;	//middle name of the help desk employee
private String lastName;	//last name of the help desk employee
private String designation;	//designation of the help desk employee
private String dateOfJoining;	//date of joining of the help desk employee
private String pancard;			//pan card number of the help desk employee	
private String status;		//status of the help desk employee
private String dateOfSeperation;	//date of separation of the help desk employee
private String reasonForSeperation;		//reason for  separation of the help desk employee

/**
 * @return firstName
 * @since jdk1.6.0_29
 */
public String getFirstName() {
	return firstName;
}

/**
 * @param firstName
 * @since jdk1.6.0_29
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

/**
 * @return middleName
 * @since jdk1.6.0_29
 */
public String getMiddleName() {
	return middleName;
}

/**
 * @param middleName
 * @since jdk1.6.0_29
 */
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

/**
 * @return lastName
 * @since jdk1.6.0_29
 */
public String getLastName() {
	return lastName;
}

/**
 * @param lastName
 * @since jdk1.6.0_29
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}

/**
 * @return designation
 * @since jdk1.6.0_29
 */
public String getDesignation() {
	return designation;
}

/**
 * @param designation
 * @since jdk1.6.0_29
 */
public void setDesignation(String designation) {
	this.designation = designation;
}

/**
 * @return dateOfJoining
 * @since jdk1.6.0_29
 */
public String getDateOfJoining() {
	return dateOfJoining;
}

/**
 * @param dateOfJoining
 * @since jdk1.6.0_29
 */
public void setDateOfJoining(String dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
}

/**
 * @return pancard
 * @since jdk1.6.0_29
 */
public String getPancard() {
	return pancard;
}

/**
 * @param pancard
 * @since jdk1.6.0_29
 */
public void setPancard(String pancard) {
	this.pancard = pancard;
}

/**
 * @return status
 * @since jdk1.6.0_29
 */
public String getStatus() {
	return status;
}

/**
 * @param status
 * @since jdk1.6.0_29
 */
public void setStatus(String status) {
	this.status = status;
}

/**
 * @return dateOfSeperation
 * @since jdk1.6.0_29
 */
public String getDateOfSeperation() {
	return dateOfSeperation;
}

/**
 * @param dateOfSeperation
 * @since jdk1.6.0_29
 */
public void setDateOfSeperation(String dateOfSeperation) {
	this.dateOfSeperation = dateOfSeperation;
}

/**
 * @return reasonForSeperation
 * @since jdk1.6.0_29
 */
public String getReasonForSeperation() {
	return reasonForSeperation;
}

/**
 * @param reasonForSeperation
 * @since jdk1.6.0_29
 */
public void setReasonForSeperation(String reasonForSeperation) {
	this.reasonForSeperation = reasonForSeperation;
}

/**
 * return ticketList
 * @since jdk1.6.0_29
 */
private ArrayList<BTHMTicketVO> ticketList=new ArrayList<BTHMTicketVO>();	//list of the ticket id with status as open
public ArrayList<BTHMTicketVO> getTicketList() {
	return ticketList;
}

/**
 * @param ticketList
 * @since jdk1.6.0_29
 */
public void setTicketList(ArrayList<BTHMTicketVO> ticketList) {
	this.ticketList = ticketList;
}

/**
 * @return employeeId
 * @since jdk1.6.0_29
 */
public int getEmployeeId() {
	return employeeId;
}

/**
 * @param empId
 * @since jdk1.6.0_29
 */
public void setEmployeeId(int empId) {
	this.employeeId = empId;
}
}
