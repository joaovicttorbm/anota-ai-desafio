package com.jm.anota_ai_desafio.config.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class AwsSnsConfig {
    @Value("${aws.region}")
    private String region;

    @Value("${aws.secretKeyId}")
    private String accessKeyID;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.sns.topic.catalog.arn}")
    private String catalogTopicArn;

    @Bean
    public AmazonSNS amazonSNSBuild() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKeyID, secretKey);

        return AmazonSNSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)  // Use the region specified in the properties file
                .build();
    }

    @Bean
    public String catalogTopicArn() {
        return catalogTopicArn;
    }
}
