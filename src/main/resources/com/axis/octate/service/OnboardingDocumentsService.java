package com.axis.octate.service;

import java.util.List;

import com.axis.octate.service.model.OnboardingDocuments;
import com.axis.octate.service.model.OnboardingVerification;

public interface OnboardingDocumentsService {
	
	public OnboardingDocuments getMyRequest(String userId);
	
	public String deleteRequest(String userId);
	
	public OnboardingVerification getVerficationByDocId(String documentId);
	
	public String verifyByHr(String documentId,String name);
	
	public String verifyByLegalexecutive(String documentId,String name);
	
	public String verifyByLegalManager(String documentId,String name);


}
