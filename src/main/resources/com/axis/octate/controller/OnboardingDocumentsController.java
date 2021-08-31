package com.axis.octate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.octate.service.OnboardingDocumentsServiceImpl;
import com.axis.octate.service.model.OnboardingDocuments;

@RestController
@RequestMapping("/api/onboardingfiles")
public class OnboardingDocumentsController {

	@Autowired
	OnboardingDocumentsServiceImpl onboardingDocumentsService;


	@GetMapping("myrequest/{userId}")
	public OnboardingDocuments getMyRequest1(@PathVariable("userId") String userId) {

		return onboardingDocumentsService.getMyRequest(userId);
	}

	
	
	

}
