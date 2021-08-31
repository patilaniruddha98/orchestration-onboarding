package com.axis.octate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;




@Configuration
public class StorageConfig {
	
	//@Value("${cloud.aws.credentials.access-key}")
	private String accessKey ="AKIAQLGM5YUXAIHVGVYT";
	
	//@Value("${cloud.aws.credentials.secret-key}")
	private String accessSecret="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";
	
	//@Value("${cloud.aws.region.static}")
	private String region="ap-south-1";
	
	 @Bean
	    public AmazonS3 s3Client() {
	        AWSCredentials credentials = new BasicAWSCredentials(accessKey,accessSecret);
	        return AmazonS3ClientBuilder.standard()
	                .withCredentials(new AWSStaticCredentialsProvider(credentials))
	                .withRegion(region).build();
	    }

}
