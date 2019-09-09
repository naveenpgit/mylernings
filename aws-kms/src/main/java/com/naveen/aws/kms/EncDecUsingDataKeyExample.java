package com.naveen.aws.kms;

import com.naveen.aws.AWSConstants;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.model.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.newInputStream;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardOpenOption.READ;
import static software.amazon.awssdk.core.SdkBytes.fromByteArray;

public class EncDecUsingDataKeyExample {

    public static final String DATA_KEY_ENCRYPT_FILE = "E:\\naveen_git\\mylernings\\aws-kms\\src\\main\\resources\\datakey\\data_key_encrypt.txt";
    public static final String OBSERVATION_DATAKEY_ENCRYPT = "E:\\naveen_git\\mylernings\\aws-kms\\src\\main\\resources\\datakey\\observation_datakey_encrypt.json";

    public KmsClient kmsClient;

    public EncDecUsingDataKeyExample() {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(AWSConstants.awsAccount().KEY, AWSConstants.awsAccount().SECRET_KEY);
        this.kmsClient = KmsClient.builder().credentialsProvider(StaticCredentialsProvider.create(awsCreds)).region(Region.of(AWSConstants.awsAccount().REGION)).build();
    }

    public static void main(String[] args) throws IOException {
        try {
            EncDecUsingDataKeyExample encDecUsingCMKExample = new EncDecUsingDataKeyExample();
            encDecUsingCMKExample.encryptUsingDataKey(readFromFile(AWSConstants.INPUT_FILE));
            encDecUsingCMKExample.decryptUsingDataKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void encryptUsingDataKey(SdkBytes inputTobeEncrypted) {
        try {
            GenerateDataKeyRequest generateDataKeyRequest = GenerateDataKeyRequest.builder().keyId(AWSConstants.awsAccount().KMS_CMK_ARN).keySpec(DataKeySpec.AES_128).build();
            GenerateDataKeyResponse generateDataKeyResponse = this.kmsClient.generateDataKey(generateDataKeyRequest);

            SecretKeySpec key = new SecretKeySpec(generateDataKeyResponse.plaintext().asByteArray(), "AES");
            Cipher cipher;
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedData = cipher.doFinal(inputTobeEncrypted.asByteArray());
            byte[] encryptedDataKey = key.getEncoded();

            writeToFile(fromByteArray(encryptedData), OBSERVATION_DATAKEY_ENCRYPT);
            writeToFile(fromByteArray(encryptedDataKey), DATA_KEY_ENCRYPT_FILE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void decryptUsingDataKey() {
        try {

            SdkBytes sdkBytes = readFromFile(DATA_KEY_ENCRYPT_FILE);
            DecryptRequest decryptRequest = DecryptRequest.builder().ciphertextBlob(sdkBytes).build();
            DecryptResponse decryptResponse = this.kmsClient.decrypt(decryptRequest);

            SecretKeySpec secretKeySpec = new SecretKeySpec(decryptResponse.plaintext().asByteArray(), "AES");
            sdkBytes = readFromFile(OBSERVATION_DATAKEY_ENCRYPT);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            System.out.println(SdkBytes.fromByteArray(cipher.doFinal(sdkBytes.asByteArray())).asUtf8String());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void writeToFile(SdkBytes bytesToWrite, String path) throws IOException {
        Files.write(Paths.get(path), bytesToWrite.asByteArray(), StandardOpenOption.APPEND);
    }

    public static SdkBytes readFromFile(String path) throws IOException {
        return SdkBytes.fromInputStream(newInputStream(get(path), READ));
    }
}
