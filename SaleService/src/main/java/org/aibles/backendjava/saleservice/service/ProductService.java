package org.aibles.backendjava.saleservice.service;

import org.aibles.backendjava.saleservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(int productId, Product productReq);

    Product deleteProduct(int productId);

    List<Product> listProduct();
}
