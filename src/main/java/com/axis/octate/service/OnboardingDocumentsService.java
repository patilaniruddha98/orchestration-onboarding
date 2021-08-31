package com.axis.octate.service;

import java.util.List;

import com.axis.octate.request.CompleteDetails;
import com.axis.octate.request.RequestForDocuments;
import com.axis.octate.request.VerificationRequest;
import com.axis.octate.service.model.OnboardingDocuments;
import com.axis.octate.service.model.OnboardingVerification;

public interface OnboardingDocumentsService {
	
	public List<OnboardingDocuments> getMyRequest(String userId);
	
	public String deleteRequest(String userId);
	
	public OnboardingVerification getVerficationByDocId(String documentId);
	
	String verifyByHr(String documentId, VerificationRequest verificationRequest) throws Exception;
	
	public String postOnboardingRequest(RequestForDocuments requestForDocuments) throws Exception;

	String verifyByLegalexecutive(String id, VerificationRequest verificationRequest) throws Exception;

	String verifyByLegalManager(String id, VerificationRequest verificationRequest) throws Exception;

	String verifyBySeniorLegalManager(String id, VerificationRequest verificationRequest) throws Exception;


}
