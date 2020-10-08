package com.springdemo.awsimageupload.bucket;

import javax.print.DocFlavor;

public enum BucketName {

    PROFILE_IMAGE("nielsimage-upload-123");

    private final String bucketName;

    BucketName(String bucketName){
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
