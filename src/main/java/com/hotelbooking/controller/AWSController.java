package com.hotelbooking.controller;

import com.hotelbooking.service.AWSService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/aws")
public class AWSController {
    private AWSService service;

    public AWSController(AWSService service) {
        this.service = service;
    }
    @PostMapping("/api/aws/{bucketName}")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file,@PathVariable String bucketName) throws IOException {
        String s = service.uploadFile(file, bucketName);
        return new ResponseEntity<>(s, HttpStatus.OK);


    }
}
