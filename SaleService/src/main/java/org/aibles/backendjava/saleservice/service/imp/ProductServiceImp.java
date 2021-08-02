package org.aibles.backendjava.saleservice.service.imp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aibles.backendjava.saleservice.model.Product;
import org.aibles.backendjava.saleservice.repository.ProductRepository;
import org.aibles.backendjava.saleservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int productId, Product productReq) {

       Product product = productRepository.findById(productId).orElse(null);
        product.setName(productReq.getName());
        product.setOrigin(productReq.getOrigin());
        product.setPrice(productReq.getPrice());
        product.setQuantity(productReq.getQuantity());
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(int productId) {
        Product product = productRepository.findById(productId).orElse(null);
        productRepository.delete(product);
        return product;
    }

    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }
}
