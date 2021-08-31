package com.axis.octate.service;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public interface SubmittingDocumentService {
	
	


	byte[] downloadDetailsFile(String folder, String fileName);


	String DocumentSubmision(String id, MultipartFile educationalDocuments, MultipartFile addressProof,
			Date documentSubmitted, String hrId) throws Exception;
}
