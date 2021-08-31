package com.axis.octate.controller;

import java.sql.ResultSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.octate.constant.PermissionURLConstants;
import com.axis.octate.repository.OnboardingDocumentsRepository;
import com.axis.octate.repository.OnboardingVerificationRepository;
import com.axis.octate.request.CompleteDetails;
import com.axis.octate.request.RequestForDocuments;
import com.axis.octate.service.OnboardingDocumentsServiceImpl;
import com.axis.octate.service.model.OnboardingVerification;

@RestController
@RequestMapping("/api/onboarding")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OnboardingDocumentVerificationController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	OnboardingDocumentsRepository repo;

	@Autowired
	OnboardingVerificationRepository onboardingVerificationRepository;

	@Autowired
	OnboardingDocumentsServiceImpl onboardingDocumentsService;
	
	CompleteDetails data= new CompleteDetails();

	@GetMapping("/view/getbydocumentid/{documentId}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.VIEW + "')")
	public OnboardingVerification get(@PathVariable("documentId") String documentId) {
		return onboardingDocumentsService.getVerficationByDocId(documentId);
	}

	@GetMapping("/view/allrequest")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.VIEW + "')")
	public List<CompleteDetails> allData() {
		List<CompleteDetails> list = jdbcTemplate.query("select user.id,user.NAME as employeeName,user.EMAIL_ID as employeeEmailId,user.department ,\r\n"
				+ "onboarding_documents.hr_id,onboarding_documents.educational_documents,onboarding_documents.address_proof,onboarding_documents.request_from,onboarding_documents.request_created,onboarding_documents.document_submitted,\r\n"
				+ "onboarding_documents_verification_status.* from user \r\n"
				+ "inner join onboarding_documents  on onboarding_documents.emp_id = user.ID\r\n"
				+ "inner join  onboarding_documents_verification_status on onboarding_documents.id = onboarding_documents_verification_status.document_id \r\n"
				+ "order by onboarding_documents.document_submitted DESC"
				, (ResultSet rs, int rowNum) -> {
					CompleteDetails data =new CompleteDetails();
					data.setEmpId(rs.getString("id"));
					data.setEmployeeName(rs.getString("employeeName"));
					data.setEmployeeEmailId(rs.getString("employeeEmailId"));
					data.setDepartment(rs.getString("department"));
					data.setEducationalDocuments(rs.getString("educational_documents"));
					data.setAddress_proof(rs.getString("address_proof"));
					data.setRequestFrom(rs.getString("request_from"));
					data.setDocumentCreated(rs.getDate("request_created"));
					data.setDocumentSubmitted(rs.getDate("document_submitted"));
					data.setVerificationId(rs.getString("verification_id"));
					data.setDocumentId(rs.getString("document_id"));
					data.setHrId(rs.getString("hr_id"));
					data.setHrName(rs.getString("hr_name"));
					data.setHrEmail(rs.getString("hr_email"));
					data.setHrConfirmation(rs.getString("hr_confirmation"));
					data.setLegalExecutiveId(rs.getString("legal_executive_id"));
					data.setLegalExecutiveName(rs.getString("legal_executive_name"));
					data.setLegalExecutiveEmail(rs.getString("legal_executive_email"));
					data.setLegalExecutiveConfirmation(rs.getString("executive_confirmation"));
					data.setLegalManagerId(rs.getString("legal_manager_id"));
					data.setLegalManagerName(rs.getString("legal_manager_name"));
					data.setLegalManagerEmail(rs.getString("legal_manager_email"));
					data.setLegalmanagerConfirmation(rs.getString("legal_manager_confirmation"));
					data.setSeniorlegalManagerId(rs.getString("legal_senior_manager_id"));
					data.setSeniorlegalManagerName(rs.getString("legal_senior_manager_name"));
					data.setSeniorlegalManagerEmail(rs.getString("legal_senior_manager_email"));
					data.setSeniorlegalmanagerConfirmation(rs.getString("senior_manager_confirmation"));
				
					return data;
				}
				
				);
		
		return  list;
		
	}
	
	
	
	@GetMapping("/view/request/{id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.VIEW + "')")
	public CompleteDetails getRequestById(@PathVariable("id") String id) {
		List<CompleteDetails> list = jdbcTemplate.query("select user.id,user.NAME as employeeName,user.EMAIL_ID as employeeEmailId,user.department ,\r\n"
				+ "onboarding_documents.hr_id,onboarding_documents.educational_documents,onboarding_documents.address_proof,onboarding_documents.request_from,onboarding_documents.request_created,onboarding_documents.document_submitted,\r\n"
				+ "onboarding_documents_verification_status.* from user \r\n"
				+ "inner join onboarding_documents  on onboarding_documents.emp_id = user.ID\r\n"
				+ "inner join  onboarding_documents_verification_status on onboarding_documents.id = onboarding_documents_verification_status.document_id "
				+ "where onboarding_documents.id=?",
				new String[] {id}
				, (ResultSet rs, int rowNum) -> {
					data =new CompleteDetails();
					data.setEmpId(rs.getString("id"));
					data.setEmployeeName(rs.getString("employeeName"));
					data.setEmployeeEmailId(rs.getString("employeeEmailId"));
					data.setDepartment(rs.getString("department"));
					data.setEducationalDocuments(rs.getString("educational_documents"));
					data.setAddress_proof(rs.getString("address_proof"));
					data.setRequestFrom(rs.getString("request_from"));
					data.setDocumentCreated(rs.getDate("request_created"));
					data.setDocumentSubmitted(rs.getDate("document_submitted"));
					data.setVerificationId(rs.getString("verification_id"));
					data.setDocumentId(rs.getString("document_id"));
					data.setHrId(rs.getString("hr_id"));
					data.setHrName(rs.getString("hr_name"));
					data.setHrEmail(rs.getString("hr_email"));
					data.setHrConfirmation(rs.getString("hr_confirmation"));
					data.setLegalExecutiveId(rs.getString("legal_executive_id"));
					data.setLegalExecutiveName(rs.getString("legal_executive_name"));
					data.setLegalExecutiveEmail(rs.getString("legal_executive_email"));
					data.setLegalExecutiveConfirmation(rs.getString("executive_confirmation"));
					data.setLegalManagerId(rs.getString("legal_manager_id"));
					data.setLegalManagerName(rs.getString("legal_manager_name"));
					data.setLegalManagerEmail(rs.getString("legal_manager_email"));
					data.setLegalmanagerConfirmation(rs.getString("legal_manager_confirmation"));
					data.setSeniorlegalManagerId(rs.getString("legal_senior_manager_id"));
					data.setSeniorlegalManagerName(rs.getString("legal_senior_manager_name"));
					data.setSeniorlegalManagerEmail(rs.getString("legal_senior_manager_email"));
					data.setSeniorlegalmanagerConfirmation(rs.getString("senior_manager_confirmation"));
				
					return data;
				}
				
				);
		
		return  data;
		
	}
	
	
	
	

	@Transactional
	@DeleteMapping("/delete/deleterequest/{userId}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.DELETE + "')")
	public String requestDeleted(@PathVariable("userId") String userId) {
		return onboardingDocumentsService.deleteRequest(userId);
	}
	
	
	@PostMapping("/add/requestfordocument")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.ADD + "')")
	public String sendRequest(@RequestBody RequestForDocuments requestForDocuments) throws Exception {
		return onboardingDocumentsService.postOnboardingRequest(requestForDocuments);
	}

}
