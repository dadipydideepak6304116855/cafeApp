package com.project.cafereview.repository;

import java.util.List;

import com.project.cafereview.entity.CafeReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CafeReviewRepo extends JpaRepository<CafeReview, Integer> {
	
	List<CafeReview> findByCafeId(Integer cafeId);

}
