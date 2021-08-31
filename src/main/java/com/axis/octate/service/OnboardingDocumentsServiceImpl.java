package com.axis.octate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.axis.octate.model.User;
import com.axis.octate.repository.OnboardingDocumentsRepository;
import com.axis.octate.repository.OnboardingVerificationRepository;
import com.axis.octate.repository.UserRepository;
import com.axis.octate.request.CompleteDetails;
import com.axis.octate.request.RequestForDocuments;
import com.axis.octate.request.VerificationRequest;
import com.axis.octate.service.model.OnboardingDocuments;
import com.axis.octate.service.model.OnboardingVerification;

@Service
public class OnboardingDocumentsServiceImpl implements OnboardingDocumentsService {

	@Autowired
	OnboardingDocumentsRepository onboardingDocumentsrepo;

	@Autowired
	OnboardingVerificationRepository onboardingVerificationRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserRepository userRepository;
	
	CompleteDetails data=new CompleteDetails();

	@Override
	public List<OnboardingDocuments> getMyRequest(String userId) {

		return onboardingDocumentsrepo.findRequestByUserId(userId);
				
	}

	@Override
	public String deleteRequest(String userId) {
		// TODO Auto-generated method stub
		onboardingDocumentsrepo.deleteRequestByUserId(userId);
		return "deletion done";
	}

	@Override
	public OnboardingVerification getVerficationByDocId(String documentId) {
		// TODO Auto-generated method stub
		return onboardingVerificationRepository.findRequestByDocumentId(documentId);
	}

	@Override
	public String verifyByHr(String id, VerificationRequest verificationRequest) throws Exception {
		Optional<OnboardingVerification> data = onboardingVerificationRepository.findById(id);

		if (data.isPresent()) {
			OnboardingVerification verify 
					= new OnboardingVerification(data.get().getId(),data.get().getDocumentId(),
							data.get().getHrId(),verificationRequest.getName(),
							verificationRequest.getEmail(),verificationRequest.isConfirmation(),
							verificationRequest.getNextId()
							);
			
			onboardingVerificationRepository.save(verify);
			return "verified";
		}else {
			throw new Exception("data not found");
		}

		
	}

	@Override
	public String verifyByLegalexecutive(String id, VerificationRequest verificationRequest) throws Exception {

		Optional<OnboardingVerification> data = onboardingVerificationRepository.findById(id);

		if (data.isPresent()) {
			OnboardingVerification verify = new OnboardingVerification(data.get().getId(),data.get().getDocumentId()
										,data.get().getHrId(),data.get().getHrName(),data.get().getHrEmail(),data.get().isHrConfirmation(),data.get().getLegalExecutiveId(),
										verificationRequest.getName(),verificationRequest.getEmail(),
										verificationRequest.isConfirmation(),verificationRequest.getNextId()
										
					
					);
	
			
			onboardingVerificationRepository.save(verify);
			return "verified by legal executive";
		}
		else {
			throw new Exception("data not found");
		}

		
	}

	
	@Override
	public String verifyByLegalManager(String id, VerificationRequest verificationRequest) throws Exception {

		Optional<OnboardingVerification> data = onboardingVerificationRepository.findById(id);

		if (data.isPresent()) {
			OnboardingVerification verify = new OnboardingVerification(data.get().getId(),data.get().getDocumentId()
					,data.get().getHrId(),data.get().getHrName(),data.get().getHrEmail(),data.get().isHrConfirmation(),data.get().getLegalExecutiveId(),
					data.get().getLegalExecutiveName(),data.get().getLegalExecutiveEmail(),data.get().isLegalExecutiveConfirmation(),data.get().getLegalManagerId(),
					verificationRequest.getName(),verificationRequest.getEmail(),verificationRequest.isConfirmation(),verificationRequest.getNextId()
					
					);
		
			onboardingVerificationRepository.save(verify);
			return "verified by legal Manager";
		}
		else {
			throw new Exception("data not found");
		}

	

	}
	
	
	

	@Override
	public String verifyBySeniorLegalManager(String id, VerificationRequest verificationRequest) throws Exception {

		Optional<OnboardingVerification> data = onboardingVerificationRepository.findById(id);

		if (data.isPresent()) {
			OnboardingVerification verify = new OnboardingVerification(data.get().getId(),data.get().getDocumentId()
					,data.get().getHrId(),data.get().getHrName(),data.get().getHrEmail(),data.get().isHrConfirmation(),data.get().getLegalExecutiveId(),
					data.get().getLegalExecutiveName(),data.get().getLegalExecutiveEmail(),data.get().isLegalExecutiveConfirmation(),data.get().getLegalManagerId(),
					data.get().getLegalManagerName(),data.get().getLegalManagerEmail(),data.get().isLegalManagerConfirmation(),data.get().getSeniorLegalManagerId(),
					verificationRequest.getName(),verificationRequest.getEmail(),verificationRequest.isConfirmation()
					);
		
			onboardingVerificationRepository.save(verify);
			return "verified by senior legal Manager";
		}else {
			throw new Exception("data not found");
		}

	

	}
	
	


	@Override
	public String postOnboardingRequest(RequestForDocuments requestForDocuments) throws Exception {
		
		Optional<User> user = userRepository.findById(requestForDocuments.getEmpId());
		
		if(user.isPresent()) {
		OnboardingDocuments request = new OnboardingDocuments(requestForDocuments.getEmpId(),requestForDocuments.getMyId());
	
		onboardingDocumentsrepo.save(request);
		return "request sent";
		
		}else {
			throw new Exception("Employee not found");
		}
	
	}

	

}
