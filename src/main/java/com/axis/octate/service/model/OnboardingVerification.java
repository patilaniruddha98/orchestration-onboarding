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
	@Column(name="verification_id")
	private String id;
	
	@Column(name="document_id")
	private String documentId;
	
	@Column(name="hr_id")
	private String hrId;
	
	@Column(name="hr_name")
	private String hrName;
	
	@Column(name="hr_email")
	private String hrEmail;
	
	@Column(name="hr_confirmation")
	private String hrConfirmation;
	
	@Column(name="legal_executive_id")
	private String legalExecutiveId;
	
	@Column(name="legal_executive_name")
	private String legalExecutiveName;
	
	@Column(name="legal_executive_email")
	private String legalExecutiveEmail;
	
	@Column(name="executive_confirmation")
	private String legalExecutiveConfirmation;
	
	@Column(name="legal_manager_id")
	private String legalManagerId;
	
	@Column(name="legal_manager_name")
	private String legalManagerName;
	
	@Column(name="legal_manager_email")
	private String legalManagerEmail;
	
	@Column(name="legal_manager_confirmation")
	private String legalManagerConfirmation;
	
	@Column(name="legal_senior_manager_id")
	private String seniorLegalManagerId;
	
	@Column(name="legal_senior_manager_name")
	private String seniorLegalManagerName;
	
	@Column(name="legal_senior_manager_email")
	private String seniorLegalManagerEmail;
	
	@Column(name="senior_manager_confirmation")
	private String seniorLegalManagerConfirmation;

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

	public String getHrId() {
		return hrId;
	}

	public void setHrId(String hrId) {
		this.hrId = hrId;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getHrEmail() {
		return hrEmail;
	}

	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}

	public String isHrConfirmation() {
		return hrConfirmation;
	}

	public void setHrConfirmation(String hrConfirmation) {
		this.hrConfirmation = hrConfirmation;
	}

	public String getLegalExecutiveId() {
		return legalExecutiveId;
	}

	public void setLegalExecutiveId(String legalExecutiveId) {
		this.legalExecutiveId = legalExecutiveId;
	}

	public String getLegalExecutiveName() {
		return legalExecutiveName;
	}

	public void setLegalExecutiveName(String legalExecutiveName) {
		this.legalExecutiveName = legalExecutiveName;
	}

	public String getLegalExecutiveEmail() {
		return legalExecutiveEmail;
	}

	public void setLegalExecutiveEmail(String legalExecutiveEmail) {
		this.legalExecutiveEmail = legalExecutiveEmail;
	}

	public String isLegalExecutiveConfirmation() {
		return legalExecutiveConfirmation;
	}

	public void setLegalExecutiveConfirmation(String legalExecutiveConfirmation) {
		this.legalExecutiveConfirmation = legalExecutiveConfirmation;
	}

	public String getLegalManagerId() {
		return legalManagerId;
	}

	public void setLegalManagerId(String legalManagerId) {
		this.legalManagerId = legalManagerId;
	}

	public String getLegalManagerName() {
		return legalManagerName;
	}

	public void setLegalManagerName(String legalManagerName) {
		this.legalManagerName = legalManagerName;
	}

	public String getLegalManagerEmail() {
		return legalManagerEmail;
	}

	public void setLegalManagerEmail(String legalManagerEmail) {
		this.legalManagerEmail = legalManagerEmail;
	}

	public String isLegalManagerConfirmation() {
		return legalManagerConfirmation;
	}

	public void setLegalManagerConfirmation(String legalManagerConfirmation) {
		this.legalManagerConfirmation = legalManagerConfirmation;
	}

	public String getSeniorLegalManagerId() {
		return seniorLegalManagerId;
	}

	public void setSeniorLegalManagerId(String seniorLegalManagerId) {
		this.seniorLegalManagerId = seniorLegalManagerId;
	}

	public String getSeniorLegalManagerName() {
		return seniorLegalManagerName;
	}

	public void setSeniorLegalManagerName(String seniorLegalManagerName) {
		this.seniorLegalManagerName = seniorLegalManagerName;
	}

	public String getSeniorLegalManagerEmail() {
		return seniorLegalManagerEmail;
	}

	public void setSeniorLegalManagerEmail(String seniorLegalManagerEmail) {
		this.seniorLegalManagerEmail = seniorLegalManagerEmail;
	}

	public String isSeniorLegalManagerConfirmation() {
		return seniorLegalManagerConfirmation;
	}

	public void setSeniorLegalManagerConfirmation(String seniorLegalManagerConfirmation) {
		this.seniorLegalManagerConfirmation = seniorLegalManagerConfirmation;
	}

	public OnboardingVerification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OnboardingVerification(String id, String documentId, String hrId, String hrName, String hrEmail,
			String hrConfirmation, String legalExecutiveId) {
		super();
		this.id = id;
		this.documentId = documentId;
		this.hrId = hrId;
		this.hrName = hrName;
		this.hrEmail = hrEmail;
		this.hrConfirmation = hrConfirmation;
		this.legalExecutiveId = legalExecutiveId;
	}

	public OnboardingVerification(String id, String documentId, String hrId, String hrName, String hrEmail,
			String hrConfirmation, String legalExecutiveId, String legalExecutiveName, String legalExecutiveEmail,
			String legalExecutiveConfirmation, String legalManagerId) {
		super();
		this.id = id;
		this.documentId = documentId;
		this.hrId = hrId;
		this.hrName = hrName;
		this.hrEmail = hrEmail;
		this.hrConfirmation = hrConfirmation;
		this.legalExecutiveId = legalExecutiveId;
		this.legalExecutiveName = legalExecutiveName;
		this.legalExecutiveEmail = legalExecutiveEmail;
		this.legalExecutiveConfirmation = legalExecutiveConfirmation;
		this.legalManagerId = legalManagerId;
	}

	

	public OnboardingVerification(String id, String documentId, String hrId, String hrName, String hrEmail,
			String hrConfirmation, String legalExecutiveId, String legalExecutiveName, String legalExecutiveEmail,
			String legalExecutiveConfirmation, String legalManagerId, String legalManagerName,
			String legalManagerEmail, String legalManagerConfirmation, String seniorLegalManagerId) {
		super();
		this.id = id;
		this.documentId = documentId;
		this.hrId = hrId;
		this.hrName = hrName;
		this.hrEmail = hrEmail;
		this.hrConfirmation = hrConfirmation;
		this.legalExecutiveId = legalExecutiveId;
		this.legalExecutiveName = legalExecutiveName;
		this.legalExecutiveEmail = legalExecutiveEmail;
		this.legalExecutiveConfirmation = legalExecutiveConfirmation;
		this.legalManagerId = legalManagerId;
		this.legalManagerName = legalManagerName;
		this.legalManagerEmail = legalManagerEmail;
		this.legalManagerConfirmation = legalManagerConfirmation;
		this.seniorLegalManagerId = seniorLegalManagerId;
	}

	public OnboardingVerification(String id, String documentId, String hrId, String hrName, String hrEmail,
			String hrConfirmation, String legalExecutiveId, String legalExecutiveName, String legalExecutiveEmail,
			String legalExecutiveConfirmation, String legalManagerId, String legalManagerName,
			String legalManagerEmail, String legalManagerConfirmation, String seniorLegalManagerId,
			String seniorLegalManagerName, String seniorLegalManagerEmail, String seniorLegalManagerConfirmation) {
		super();
		this.id = id;
		this.documentId = documentId;
		this.hrId = hrId;
		this.hrName = hrName;
		this.hrEmail = hrEmail;
		this.hrConfirmation = hrConfirmation;
		this.legalExecutiveId = legalExecutiveId;
		this.legalExecutiveName = legalExecutiveName;
		this.legalExecutiveEmail = legalExecutiveEmail;
		this.legalExecutiveConfirmation = legalExecutiveConfirmation;
		this.legalManagerId = legalManagerId;
		this.legalManagerName = legalManagerName;
		this.legalManagerEmail = legalManagerEmail;
		this.legalManagerConfirmation = legalManagerConfirmation;
		this.seniorLegalManagerId = seniorLegalManagerId;
		this.seniorLegalManagerName = seniorLegalManagerName;
		this.seniorLegalManagerEmail = seniorLegalManagerEmail;
		this.seniorLegalManagerConfirmation = seniorLegalManagerConfirmation;
	}

	public OnboardingVerification(String documentId, String hrId) {
		super();
		this.documentId = documentId;
		this.hrId = hrId;
	}
	
	
	
	
	
	
	
	
	
	


	
	
	

}	
