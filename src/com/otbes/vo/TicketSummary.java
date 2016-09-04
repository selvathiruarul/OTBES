package com.otbes.vo;

public class TicketSummary {
	private int ticketId;		//ID of the raised ticket
	private int customerId;		//Id of the customer
	private String ticketSummary;	// summary of the raised ticket
	private String ticketDescription;  //description of the raised ticket
	private String dateRaised;		//date on which the ticket is raised
	private String ticketStatus;
	private String ticketCategory;	//category of the raised ticket
	private String ticketPriority;	//priority of the raised ticket
	private String uploadDoc;		//supporting documents which are uploaded
	private String ticketClosedDate;	//date on which the ticket is closed
	private String resolutionComments;	//resolution Comments for the ticket//status of the raised ticket
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getTicketSummary() {
		return ticketSummary;
	}
	public void setTicketSummary(String ticketSummary) {
		this.ticketSummary = ticketSummary;
	}
	public String getTicketDescription() {
		return ticketDescription;
	}
	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}
	public String getDateRaised() {
		return dateRaised;
	}
	public void setDateRaised(String dateRaised) {
		this.dateRaised = dateRaised;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getTicketCategory() {
		return ticketCategory;
	}
	public void setTicketCategory(String ticketCategory) {
		this.ticketCategory = ticketCategory;
	}
	public String getTicketPriority() {
		return ticketPriority;
	}
	public void setTicketPriority(String ticketPriority) {
		this.ticketPriority = ticketPriority;
	}
	public String getUploadDoc() {
		return uploadDoc;
	}
	public void setUploadDoc(String uploadDoc) {
		this.uploadDoc = uploadDoc;
	}
	public String getTicketClosedDate() {
		return ticketClosedDate;
	}
	public void setTicketClosedDate(String ticketClosedDate) {
		this.ticketClosedDate = ticketClosedDate;
	}
	public String getResolutionComments() {
		return resolutionComments;
	}
	public void setResolutionComments(String resolutionComments) {
		this.resolutionComments = resolutionComments;
	}
	
	
}
