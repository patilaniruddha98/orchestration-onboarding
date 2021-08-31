package com.axis.octate.request;

import java.util.Date;

public class OnboardingDocumentRequest {

	private String id;
	
	
	private String userId;
	

	private String hrId;
	

	private String educationalDocuments;
	
	
	private String addressProof;
	
	
	private String requestFrom;
	
	
	private Date requestCreated;
	
	
	private Date documentSubmitted;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getHrId() {
		return hrId;
	}


	public void setHrId(String hrId) {
		this.hrId = hrId;
	}


	public String getEducationalDocuments() {
		return educationalDocuments;
	}


	public void setEducationalDocuments(String educationalDocuments) {
		this.educationalDocuments = educationalDocuments;
	}


	public String getAddressProof() {
		return addressProof;
	}


	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}


	public String getRequestFrom() {
		return requestFrom;
	}


	public void setRequestFrom(String requestFrom) {
		this.requestFrom = requestFrom;
	}


	public Date getRequestCreated() {
		return requestCreated;
	}


	public void setRequestCreated(Date requestCreated) {
		this.requestCreated = requestCreated;
	}


	public Date getDocumentSubmitted() {
		return documentSubmitted;
	}


	public void setDocumentSubmitted(Date documentSubmitted) {
		this.documentSubmitted = documentSubmitted;
	}


	public OnboardingDocumentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OnboardingDocumentRequest(String id, String userId, String hrId, String educationalDocuments,
			String addressProof, String requestFrom, Date requestCreated, Date documentSubmitted) {
		super();
		this.id = id;
		this.userId = userId;
		this.hrId = hrId;
		this.educationalDocuments = educationalDocuments;
		this.addressProof = addressProof;
		this.requestFrom = requestFrom;
		this.requestCreated = requestCreated;
		this.documentSubmitted = documentSubmitted;
	}
	
	
	
	
	

}
