package com.naveen.aws.secretsmanager;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.naveen.aws.AWSConstants;

import java.util.Base64;

import static com.naveen.aws.AWSConstants.SECRET_NAME;

public class AWSSecretsSamples {

    public static void main(String[] args) {
        getSecret();
    }

    public static void getSecret() {

        BasicAWSCredentials credentials = new BasicAWSCredentials(
                AWSConstants.awsAccount().KEY,
                AWSConstants.awsAccount().SECRET_KEY);

        // Create a Secrets Manager client
        AWSSecretsManager awsSecretsManagerClient = AWSSecretsManagerClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(AWSConstants.awsAccount().REGION).build();

        // In this sample we only handle the specific exceptions for the 'GetSecretValue' API.
        // See https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
        // We rethrow the exception by default.

        String secret, decodedBinarySecret;
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(SECRET_NAME);
        GetSecretValueResult getSecretValueResult = null;

        try {
            getSecretValueResult = awsSecretsManagerClient.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            throw e;
        }

        // Decrypts secret using the associated KMS CMK.
        // Depending on whether the secret is a string or binary, one of these fields will be populated.
        if (getSecretValueResult.getSecretString() != null) {
            secret = getSecretValueResult.getSecretString();
            System.out.println(secret);
        } else {
            decodedBinarySecret = new String(Base64.getDecoder().decode(getSecretValueResult.getSecretBinary()).array());
        }

        // Your code goes here.
    }
}
