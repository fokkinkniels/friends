package com.springdemo.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 S3(){
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIAJ2TLZ2QRATLOGNMQ",
                "k6sM99vhUHTdVHoBZciDSkDAHGPvQi0sE3dmsmUq"
        );

        return AmazonS3ClientBuilder
                .standard()
                .withRegion("eu-west-2")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
