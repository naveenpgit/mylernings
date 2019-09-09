package com.naveen.aws;

public enum AWSConstants {
    ;

    public enum AWSAccount {
        NAVEEN(
                "AKIA225XR4W4WOK2IVXY",
                "bcGqqv9JDfyi91Feqv40zSNg1IlW4SQ2LMzMBp1/",
                "arn:aws:kms:us-west-2:745024906681:key/4d568193-53cf-49c7-8a22-845644ba475c",
                "us-west-2"),

        TAVANT(
                "AKIA225XR4W4WOK2IVXY",
                "bcGqqv9JDfyi91Feqv40zSNg1IlW4SQ2LMzMBp1/",
                "arn:aws:kms:us-west-2:745024906681:key/4d568193-53cf-49c7-8a22-845644ba475c",
                "us-west-2"
        );

        public String KEY;
        public String SECRET_KEY;
        public String KMS_CMK_ARN;
        public String REGION;

        AWSAccount(String KEY, String SECRET_KEY, String KMS_CMK_ARN, String REGION) {
            this.KEY = KEY;
            this.SECRET_KEY = SECRET_KEY;
            this.KMS_CMK_ARN = KMS_CMK_ARN;
            this.REGION = REGION;
        }

    }

    static boolean useMyPersonalAWSAccount = true;
    public static String SECRET_NAME = "";
    public static String INPUT_FILE = "E:\\naveen_git\\mylernings\\aws-kms\\src\\main\\resources\\observation.json";

    public static AWSAccount awsAccount() {
        return useMyPersonalAWSAccount ? AWSAccount.NAVEEN : AWSAccount.TAVANT;
    }

}
