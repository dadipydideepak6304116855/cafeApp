package com.project.cafereview.service;

import java.util.List;

import com.project.cafereview.entity.CafeReview;
import com.project.cafereview.repository.CafeReviewRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeReviewService {
	
	@Autowired
	CafeReviewRepo cafeReviewRepo;
	
	    public CafeReview addReview(CafeReview cafeReview) {
	        
	            // Additional validation or business logic can be added here before saving
	            return cafeReviewRepo.save(cafeReview);
	        } 
	    

	    public List<CafeReview> getReviews() {
	        return cafeReviewRepo.findAll();
	    }

	    public List<CafeReview> getReview(Integer cafeId) {
	        return cafeReviewRepo.findByCafeId(cafeId);
	    }

}

