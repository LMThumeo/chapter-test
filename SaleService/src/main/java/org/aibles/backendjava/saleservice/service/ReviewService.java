package org.aibles.backendjava.saleservice.service;

import org.aibles.backendjava.saleservice.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {

    Review createReview (Integer productId, Review review);

    List<Review> listReview (Integer productId);
}
