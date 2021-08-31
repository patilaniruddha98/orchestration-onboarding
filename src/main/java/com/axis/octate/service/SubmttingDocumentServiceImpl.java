package com.axis.octate.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.axis.octate.repository.OnboardingDocumentsRepository;
import com.axis.octate.repository.OnboardingVerificationRepository;
import com.axis.octate.service.model.OnboardingDocuments;
import com.axis.octate.service.model.OnboardingVerification;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class SubmttingDocumentServiceImpl implements SubmittingDocumentService {

	private String bucketName ="octatestorage";

	@Autowired
	private AmazonS3 s3Client;

	@Autowired
	OnboardingDocumentsRepository onboardingDocumentRepository;

	@Autowired
	OnboardingVerificationRepository onboardingVerificationRepository;

	@Override
	public String DocumentSubmision(String id, MultipartFile educationalDocuments, MultipartFile addressProof,
			Date documentSubmitted,String hrId) throws Exception{

		File fileObj1 = convertMultipartFileToFile(educationalDocuments);
		File fileObj2 = convertMultipartFileToFile(addressProof);

		String fileName1 = educationalDocuments.getOriginalFilename();
		String fileName2 = addressProof.getOriginalFilename();

		Date date = new Date();
		Date documentSubmittedAt = date;
		Optional<OnboardingDocuments> request = onboardingDocumentRepository.findById(id);
		if (request.isPresent()) {
			
			System.out.println("**************&&&&&&&&&&&&&&&&&&&&&&");
			
			OnboardingDocuments onboardingDocs = new OnboardingDocuments(id, request.get().getUserId(),
					request.get().getHrId(), fileName1, fileName2, request.get().getRequestFrom(),
					request.get().getRequestCreated(), documentSubmittedAt);

			onboardingDocumentRepository.save(onboardingDocs);

			OnboardingVerification onboardingVerification = new OnboardingVerification(id,hrId);
		
			onboardingVerificationRepository.save(onboardingVerification);

			s3Client.putObject(new PutObjectRequest(bucketName+"/onboardingdocuments" + "/" + request.get().getUserId(), fileName1, fileObj1));
			s3Client.putObject(new PutObjectRequest(bucketName +"/onboardingdocuments"+ "/" + request.get().getUserId(), fileName2, fileObj2));

			fileObj1.delete();
			fileObj2.delete();

			return "Files uplaoded successfully";

		} else {
			return "not uploaded";
		}

		
	}


	@Override
	public byte[] downloadDetailsFile(String folder,String fileName) {

		S3Object s3Object = s3Client.getObject(bucketName+"/onboardingdocuments"+"/"+folder, fileName);

		S3ObjectInputStream inputStream = s3Object.getObjectContent();

		try {
			byte[] content = IOUtils.toByteArray(inputStream);
			return content;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private File convertMultipartFileToFile(MultipartFile file) {

		File convertedFile = new File(file.getOriginalFilename());

		try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
			fos.write(file.getBytes());

		} catch (IOException e) {
			// log.error("Error converting multipart file to file",e);
			e.printStackTrace();
		}

		return convertedFile;

	}
}
