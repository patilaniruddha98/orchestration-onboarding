package com.axis.octate.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.axis.octate.constant.PermissionURLConstants;
import com.axis.octate.jwt.JwtAuthTokenFilter;
import com.axis.octate.request.EmailRequestDto;
import com.axis.octate.request.VerificationRequest;
import com.axis.octate.service.OnboardingDocumentsServiceImpl;
import com.axis.octate.service.SubmittingDocumentService;

@RestController
@RequestMapping("/api/onboarding")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VerificationController {
	

	@Autowired
	OnboardingDocumentsServiceImpl onboardingDocumentsService;
	
	@Autowired
	SubmittingDocumentService socumentService;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/view/download/{fileName}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.VIEW + "')")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName,@RequestParam String folder){
		byte[] data = socumentService.downloadDetailsFile(folder,fileName);
		ByteArrayResource resource = new ByteArrayResource(data);
		
		return ResponseEntity
				.ok()
				.contentLength(data.length)
				.header("Content-type", "application/octet-stream")
				.header("Content-disposition","attatchment;filename=\""+fileName+"\"")
				.body(resource);
	}


	@PutMapping("/edit/verifybyhr/{id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.EDIT + "')")
	public String verficationByHr(@PathVariable("id") String id, @RequestBody VerificationRequest verificationRequest) throws Exception {
		return onboardingDocumentsService.verifyByHr(id, verificationRequest);
	}
	
	
	@PutMapping("/edit/verifybylegalexecutive/{id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.EDIT + "')")
	public String verficationByLegalexecutive(@PathVariable("id") String id, @RequestBody VerificationRequest verificationRequest) throws Exception {
		return onboardingDocumentsService.verifyByLegalexecutive(id, verificationRequest);
	}
	
	
	@PutMapping("/edit/verifybylegalmanager/{id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.EDIT + "')")
	public String verficationByLegalManager(@PathVariable("id") String id, @RequestBody VerificationRequest verificationRequest) throws Exception {
		return onboardingDocumentsService.verifyByLegalManager(id, verificationRequest);
	}
	
	@PutMapping("/edit/verifybySeniorlegalmanager/{id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.EDIT + "')")
	public String verficationBySeniorLegalManager(@PathVariable("id") String id, @RequestBody VerificationRequest verificationRequest) throws Exception {
		return onboardingDocumentsService.verifyBySeniorLegalManager(id, verificationRequest);
	}
	
	
	@PostMapping("/edit/deny/email")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ONBOARDING_API_SERVICE + "','" + PermissionURLConstants.ADD + "')")
	public String sendEmail(@Valid @RequestBody EmailRequestDto emailRequestDto) {

		
		emailRequestDto.setSubject("Orchestration - Onboarding documents");
		emailRequestDto.setBody("Document verification is deny" );
	
		
		HttpHeaders headers = new HttpHeaders();
		

		headers.setBearerAuth(JwtAuthTokenFilter.jwt.toString());
		headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
		HttpEntity<EmailRequestDto> entity = new HttpEntity<EmailRequestDto>(emailRequestDto, headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8082/api/access/hr/email",
				HttpMethod.POST, entity, String.class);
		
		return responseEntity.getBody();
	}
	
	

}
