package org.aibles.backendjava.saleservice.controller;


import org.aibles.backendjava.saleservice.model.Product;
import org.aibles.backendjava.saleservice.model.Review;
import org.aibles.backendjava.saleservice.service.ProductService;
import org.aibles.backendjava.saleservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
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
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        final Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") int productId,
                                                 @RequestBody Product product){
        final Product updatedProduct = productService.updateProduct(productId, product);
        if (updatedProduct != null) {
            return  new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") int productId){
        final Product updatedProduct = productService.deleteProduct(productId);
        if (updatedProduct != null) {
            return  new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(){
        final List<Product> products = productService.listProduct();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @PostMapping("/{productId}/reviews")
    public  ResponseEntity<Review> createReview(@PathVariable("productId") int productId,
                                                @RequestBody Review review) {
        final Review createdReview = reviewService.createReview(productId, review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}/reviews")
    public ResponseEntity<List<Review>> getReview(@PathVariable("productId") int productId){
      final List<Review> reviews = reviewService.listReview(productId);
      return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

}
