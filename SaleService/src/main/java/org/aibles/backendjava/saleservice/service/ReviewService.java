package org.aibles.backendjava.saleservice.service;

import org.aibles.backendjava.saleservice.dto.ReviewDTO;
import org.aibles.backendjava.saleservice.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {

    ReviewDTO createReview (Integer productId, ReviewDTO reviewDTO);

    List<ReviewDTO> listReview (Integer productId);
}
