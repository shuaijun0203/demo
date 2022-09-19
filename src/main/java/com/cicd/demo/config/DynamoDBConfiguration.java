package com.cicd.demo.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfiguration {

    @Bean
    public DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper((buildAmazonDynamoDB()));
    }

    private AmazonDynamoDB buildAmazonDynamoDB() {

        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "dynamodb.ap-northeast-1.amazonaws.com",
                                "ap-northeast-1"
                        )
                )
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        "AKIA3NU3FQB2EBMN5VU5",
                                        "JCMXR1z0mYdytYY8KDZwQ6NTCipVz+A0aiYYUZ6w"
                                )
                        )
                )
                .build();
    }
}
