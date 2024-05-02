package com.hotelbooking.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AWSService {
    private AmazonS3 amazons3;

    public AWSService(AmazonS3 amazons3) {
        this.amazons3 = amazons3;
    }
    public String uploadFile(MultipartFile file, String bucketName) throws IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+ "/"+ file.getOriginalFilename());
        file.transferTo(convFile);

        amazons3.putObject(new PutObjectRequest(bucketName,convFile.getName(),convFile));
        return amazons3.getUrl(bucketName, file.getOriginalFilename()).toString();
    }

    }

