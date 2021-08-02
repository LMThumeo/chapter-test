package org.aibles.backendjava.saleservice.service.imp;

import org.aibles.backendjava.saleservice.dto.ProductDTO;
import org.aibles.backendjava.saleservice.dto.ReviewDTO;
import org.aibles.backendjava.saleservice.model.Product;
import org.aibles.backendjava.saleservice.model.Review;
import org.aibles.backendjava.saleservice.repository.ReviewRepository;
import org.aibles.backendjava.saleservice.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImp implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ReviewServiceImp(ReviewRepository reviewRepository, ModelMapper modelMapper){
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public ReviewDTO createReview(Integer productId, ReviewDTO reviewDTO) {
        Review review = convertToEntity(reviewDTO);
        review.setProductId(productId);
        return convertToDTO(reviewRepository.save(review));
    }

    @Override
    public List<ReviewDTO> listReview(Integer productId) {
        return reviewRepository.findByProductId(productId).stream()
                .map(review -> convertToDTO(review))
                .collect(Collectors.toList());
    }

    private Review convertToEntity(ReviewDTO reviewDTO){
        return modelMapper.map(reviewDTO, Review.class);
    }

    private ReviewDTO convertToDTO(Review review) {
        return modelMapper.map(review, ReviewDTO.class);
    }
}
