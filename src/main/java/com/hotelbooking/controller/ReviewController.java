package com.hotelbooking.controller;

import com.hotelbooking.entity.Property;
import com.hotelbooking.entity.PropertyUser;
import com.hotelbooking.entity.Review;
import com.hotelbooking.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping("/addreview")
    public ResponseEntity<String> addReview(@RequestBody Review review, @AuthenticationPrincipal PropertyUser user){
        String s = reviewService.addReview(review, user);
        return new ResponseEntity<>(s, HttpStatus.OK);


    }
}
