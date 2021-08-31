package com.axis.octate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.octate.service.model.OnboardingDocuments;

@Repository
public interface OnboardingDocumentsRepository extends JpaRepository<OnboardingDocuments, String> {
	
	public List<OnboardingDocuments> findRequestByUserId(String userId);
	
	public String deleteRequestByUserId(String userId);
}
