package com.axis.octate.request;

public class VerificationRequest {
	
	private String verifyByid;
	
	private String name;
	
	private String email;
	
	private String confirmation;
	
	private String nextId;
	
	

	public String getNextId() {
		return nextId;
	}

	public void setNextId(String nextId) {
		this.nextId = nextId;
	}

	public String getVerifyByid() {
		return verifyByid;
	}

	public void setVerifyByid(String verifyByid) {
		this.verifyByid = verifyByid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}


	
	

}
