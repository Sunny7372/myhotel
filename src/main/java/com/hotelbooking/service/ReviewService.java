package com.hotelbooking.service;

import com.hotelbooking.entity.Property;
import com.hotelbooking.entity.PropertyUser;
import com.hotelbooking.entity.Review;
import com.hotelbooking.repository.ReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public String addReview(Review review, PropertyUser user) {
        Property property = review.getProperty();
        Review r=reviewRepository.findReviewByPropertyAndPropertyUser(property,user);
        if(r!=null){
           return "review already given";
        }
        review.setPropertyUser(user);
        reviewRepository.save(review);
        return "review added sucessfully";


    }
}
