package com.axis.octate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.octate.service.model.OnboardingDocuments;
import com.axis.octate.service.model.OnboardingVerification;

@Repository
public interface OnboardingVerificationRepository extends JpaRepository<OnboardingVerification, String> {
	public OnboardingVerification findRequestByDocumentId(String documentId);
	
	
	
}
