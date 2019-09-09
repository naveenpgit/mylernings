package com.naveen.aws.kms;

import com.naveen.aws.AWSConstants;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.model.DecryptRequest;
import software.amazon.awssdk.services.kms.model.DecryptResponse;
import software.amazon.awssdk.services.kms.model.EncryptRequest;
import software.amazon.awssdk.services.kms.model.EncryptResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.naveen.aws.AWSConstants.INPUT_FILE;
import static java.nio.file.Files.newInputStream;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardOpenOption.READ;

public class EncDecUsingCMKExample {

    public static final String OUTPUT_FILE = "E:\\naveen_git\\mylernings\\aws-kms\\src\\main\\resources\\cmk\\observation_encrypt.json";


    public KmsClient kmsClient;

    public EncDecUsingCMKExample() {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(AWSConstants.awsAccount().KEY, AWSConstants.awsAccount().SECRET_KEY);
        this.kmsClient = KmsClient.builder().credentialsProvider(StaticCredentialsProvider.create(awsCreds)).region(Region.of(AWSConstants.awsAccount().REGION)).build();
    }

    public static void main(String[] args) throws IOException {
        try {
            EncDecUsingCMKExample encDecUsingCMKExample = new EncDecUsingCMKExample();
            writeToFile(encDecUsingCMKExample.encrypt(readFromFile(INPUT_FILE)), OUTPUT_FILE);
            System.out.println(encDecUsingCMKExample.deCrypt(readFromFile(OUTPUT_FILE)).asUtf8String());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SdkBytes encrypt(SdkBytes jsonString) {
        EncryptRequest encryptRequest = EncryptRequest.builder().keyId(AWSConstants.awsAccount().KMS_CMK_ARN).plaintext(jsonString).build();
        EncryptResponse encryptResponse = this.kmsClient.encrypt(encryptRequest);
        System.out.println(encryptResponse.toString());
        return encryptResponse.ciphertextBlob();
    }

    public SdkBytes deCrypt(SdkBytes encryptedJsonString) {
        DecryptRequest decryptRequest = DecryptRequest.builder().ciphertextBlob(encryptedJsonString).build();
        DecryptResponse decryptResponse = this.kmsClient.decrypt(decryptRequest);
        return decryptResponse.plaintext();
    }

    public static void writeToFile(SdkBytes bytesToWrite, String path) throws IOException {
        Files.write(Paths.get(path), bytesToWrite.asByteArray(), StandardOpenOption.APPEND);
    }

    public static SdkBytes readFromFile(String path) throws IOException {
        return SdkBytes.fromInputStream(newInputStream(get(path), READ));
    }
}
