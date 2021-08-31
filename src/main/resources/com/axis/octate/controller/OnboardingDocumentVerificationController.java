package com.axis.octate.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.octate.repository.OnboardingDocumentsRepository;
import com.axis.octate.request.VerificationRequest;
import com.axis.octate.service.OnboardingDocumentsServiceImpl;
import com.axis.octate.service.model.OnboardingDocuments;
import com.axis.octate.service.model.OnboardingVerification;

@RestController
@RequestMapping("/api/onboardingfiles")
public class OnboardingDocumentVerificationController {
	
	@Autowired
	OnboardingDocumentsRepository repo;
	
	@Autowired
	OnboardingDocumentsServiceImpl onboardingDocumentsService;
	
	@GetMapping("/getbydocumentid/{documentId}")
	public OnboardingVerification get(@PathVariable("documentId") String documentId) {
		return onboardingDocumentsService.getVerficationByDocId(documentId);
	}

	@GetMapping("/allrequest")
	public List<OnboardingDocuments> allData() {
		return repo.findAll();
	}
	
	@Transactional
	@DeleteMapping("/deleterequest/{userId}")
	public String requestDeleted(@PathVariable("userId") String userId) {
		return onboardingDocumentsService.deleteRequest(userId);
	}
	
	

}
