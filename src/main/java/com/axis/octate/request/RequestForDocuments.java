package com.axis.octate.request;

public class RequestForDocuments {
	
	private String empId;
	
	private String myId;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getMyId() {
		return myId;
	}

	public void setMyId(String myId) {
		this.myId = myId;
	}

	public RequestForDocuments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestForDocuments(String empId, String myId) {
		super();
		this.empId = empId;
		this.myId = myId;
	}
	
	

}
