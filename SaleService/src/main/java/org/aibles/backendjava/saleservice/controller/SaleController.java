package org.aibles.backendjava.saleservice.controller;

import org.aibles.backendjava.saleservice.dto.ProductDTO;
import org.aibles.backendjava.saleservice.dto.ReviewDTO;
import org.aibles.backendjava.saleservice.service.ProductService;
import org.aibles.backendjava.saleservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class SaleController {

    private final ProductService productService;

    private final ReviewService reviewService;

    @Autowired
    public SaleController(ProductService productService, ReviewService reviewService){
        this.productService = productService;
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        final ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    @CachePut(value = "products", key = "#productId")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("productId") int productId,
                                                 @RequestBody ProductDTO productDTO){
        final ProductDTO updatedProduct = productService.updateProduct(productId, productDTO);
        return  new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> listProduct(){
        final List<ProductDTO> products = productService.listProduct();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @PostMapping("/{productId}/reviews")
    public  ResponseEntity<ReviewDTO> createReview(@PathVariable("productId") int productId,
                                                   @RequestBody ReviewDTO reviewDTO) {
        final ReviewDTO createdReview = reviewService.createReview(productId, reviewDTO);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}/reviews")
    public ResponseEntity<List<ReviewDTO>> getReview(@PathVariable("productId") int productId){
      final List<ReviewDTO> reviews = reviewService.listReview(productId);
      return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
