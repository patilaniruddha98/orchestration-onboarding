package com.axis.octate.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.axis.octate.constant.PermissionURLConstants;
import com.axis.octate.request.CompleteDetails;
import com.axis.octate.service.OnboardingDocumentsServiceImpl;
import com.axis.octate.service.SubmittingDocumentService;
import com.axis.octate.service.model.OnboardingDocuments;

@RestController
@RequestMapping("/api/onboarding")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OnboardingDocumentsController {

	@Autowired
	OnboardingDocumentsServiceImpl onboardingDocumentsService;
	
	@Autowired 
	SubmittingDocumentService submittingDocumentService; 


	@GetMapping("/view/myrequest/{userId}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.VIEW + "')")
	public List<OnboardingDocuments> getMyRequest1(@PathVariable("userId") String userId) {

		return onboardingDocumentsService.getMyRequest(userId);
	}
	
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.ADD + "')")
	@PostMapping("/add/submitdocuments/{id}")
	public String submitDocuments(@PathVariable("id") String id,
								  @PathParam("educationalDocuments") MultipartFile educationalDocuments,
								  @PathParam("addressProof") MultipartFile addressProof,
								  Date documentSubmitted,
								  @PathParam("hrId") String hrId
									) throws Exception {
		return submittingDocumentService.DocumentSubmision(id, educationalDocuments, addressProof, documentSubmitted,hrId);
	}

	
	
	

}
