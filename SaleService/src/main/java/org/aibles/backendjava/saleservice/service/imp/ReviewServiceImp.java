package org.aibles.backendjava.saleservice.service.imp;

import org.aibles.backendjava.saleservice.model.Review;
import org.aibles.backendjava.saleservice.repository.ReviewRepository;
import org.aibles.backendjava.saleservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImp(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    @Override
    public Review createReview(Integer productId, Review review) {
        review.setProductId(productId);
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> listReview(Integer productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews;
    }
}
