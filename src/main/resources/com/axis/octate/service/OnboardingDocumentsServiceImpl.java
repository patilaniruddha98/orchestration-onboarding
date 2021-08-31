package com.axis.octate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.octate.repository.OnboardingDocumentsRepository;
import com.axis.octate.repository.OnboardingVerificationRepository;
import com.axis.octate.service.model.OnboardingDocuments;
import com.axis.octate.service.model.OnboardingVerification;

@Service
public class OnboardingDocumentsServiceImpl implements OnboardingDocumentsService {

	@Autowired
	OnboardingDocumentsRepository onboardingDocumentsrepo;

	@Autowired
	OnboardingVerificationRepository onboardingVerificationRepository;

	@Override
	public OnboardingDocuments getMyRequest(String userId) {

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
	public String verifyByHr(String documentId, String name) {
		OnboardingVerification data = onboardingVerificationRepository.findRequestByDocumentId(documentId);

		if (!data.getDocumentId().isEmpty()) {
			OnboardingVerification verify = new OnboardingVerification();
			verify.setId(data.getId());
			verify.setDocumentId(documentId);
			verify.setVeifyByHr(name);
			onboardingVerificationRepository.save(verify);
		}

		return "verified by hr";
	}

	@Override
	public String verifyByLegalexecutive(String documentId, String name) {

		OnboardingVerification data = onboardingVerificationRepository.findRequestByDocumentId(documentId);

		if (!data.getDocumentId().isEmpty()) {
			OnboardingVerification verify = new OnboardingVerification();
			verify.setId(data.getId());
			verify.setDocumentId(documentId);
			verify.setVeifyByHr(data.getVeifyByHr());
			verify.setVerifyByLegalExecutive(name);
			onboardingVerificationRepository.save(verify);
		}

		return "verified by legal executive";
	}

	@Override
	public String verifyByLegalManager(String documentId, String name) {
		
		OnboardingVerification data = onboardingVerificationRepository.findRequestByDocumentId(documentId);

		if (!data.getDocumentId().isEmpty()) {
			OnboardingVerification verify = new OnboardingVerification();
			verify.setId(data.getId());
			verify.setDocumentId(documentId);
			verify.setVeifyByHr(data.getVeifyByHr());
			verify.setVerifyByLegalExecutive(data.getVerifyByLegalExecutive());
			verify.setVerifiedByLegalManager(name);
			onboardingVerificationRepository.save(verify);
		}

		return null;

	}

}
