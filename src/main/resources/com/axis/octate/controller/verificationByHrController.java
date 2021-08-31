package com.axis.octate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.octate.request.VerificationRequest;
import com.axis.octate.service.OnboardingDocumentsServiceImpl;
import com.axis.octate.service.model.OnboardingVerification;

@RestController
@RequestMapping("/api/onboardingfiles/hr")
public class verificationByHrController {
	

	@Autowired
	OnboardingDocumentsServiceImpl onboardingDocumentsService;
	
	
	
	
	@PostMapping("/verifybyhr/{documentId}")
	public String verficationByHr(@PathVariable("documentId") String documentId, @RequestBody VerificationRequest verificationRequest) {
		return onboardingDocumentsService.verifyByHr(documentId, verificationRequest.getName());
	}

}
