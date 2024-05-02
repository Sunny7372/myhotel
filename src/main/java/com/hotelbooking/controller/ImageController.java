package com.hotelbooking.controller;

import com.hotelbooking.entity.Image;
import com.hotelbooking.entity.PropertyUser;
import com.hotelbooking.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    @PostMapping("/addImage/{id}/{bucketName}")
    public ResponseEntity<Image> addImage(@PathVariable long id, @AuthenticationPrincipal PropertyUser user, @RequestParam MultipartFile file, @PathVariable String bucketName) throws IOException {
        Image image = imageService.addImage(id, user, file, bucketName);
        return new ResponseEntity<>(image, HttpStatus.CREATED);
    }

}
