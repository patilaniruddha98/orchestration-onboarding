package com.axis.octate.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "onboarding_documents")
public class OnboardingDocuments {
	
	public OnboardingDocuments(String id, String userId, String hrId, String educationalDocuments, String addressProof,
			String requestFrom, Date requestCreated, Date documentSubmitted) {
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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name = "emp_id")
	private String userId;
	
	@Column(name = "hr_id")
	private String hrId;
	
	@Column(name = "educational_documents")
	private String educationalDocuments;
	
	@Column(name="address_proof")
	private String addressProof;
	
	@Column(name = "request_from")
	private String requestFrom;
	
	@Column(name = "request_created")
	private Date requestCreated;
	
	@Column(name = "document_submitted")
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

	public OnboardingDocuments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OnboardingDocuments(String userId, String hrId) {
		super();
		this.userId = userId;
		this.hrId = hrId;
	}
	
	
	
	
		

}
