package com.axis.octate.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "onboarding_documents_verification_status")
public class OnboardingVerification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name = "document_id")
	private String documentId;
	
	@Column(name = "verified_by_hr")
	private String veifyByHr;
	
	@Column(name = "verified_by_legal_executive")
	private String verifyByLegalExecutive;
	
	@Column(name = "verified_by_legal_manager")
	private String verifiedByLegalManager;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getVeifyByHr() {
		return veifyByHr;
	}

	public void setVeifyByHr(String veifyByHr) {
		this.veifyByHr = veifyByHr;
	}

	public String getVerifyByLegalExecutive() {
		return verifyByLegalExecutive;
	}

	public void setVerifyByLegalExecutive(String verifyByLegalExecutive) {
		this.verifyByLegalExecutive = verifyByLegalExecutive;
	}

	public String getVerifiedByLegalManager() {
		return verifiedByLegalManager;
	}

	public void setVerifiedByLegalManager(String verifiedByLegalManager) {
		this.verifiedByLegalManager = verifiedByLegalManager;
	}

	public OnboardingVerification(String id, String documentId, String veifyByHr, String verifyByLegalExecutive,
			String verifiedByLegalManager) {
		super();
		this.id = id;
		this.documentId = documentId;
		this.veifyByHr = veifyByHr;
		this.verifyByLegalExecutive = verifyByLegalExecutive;
		this.verifiedByLegalManager = verifiedByLegalManager;
	}

	public OnboardingVerification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OnboardingVerification(String documentId) {
		super();
		this.documentId = documentId;
	} 
	
	
	

}
