package org.aibles.backendjava.saleservice.service;

import org.aibles.backendjava.saleservice.dto.ProductDTO;
import org.aibles.backendjava.saleservice.model.Product;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(int productId, ProductDTO productDTO);

    Product deleteProduct(int productId);

    List<ProductDTO> listProduct();
}
