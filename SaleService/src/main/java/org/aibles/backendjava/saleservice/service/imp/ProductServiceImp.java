package org.aibles.backendjava.saleservice.service.imp;

import org.aibles.backendjava.saleservice.dto.ProductDTO;
import org.aibles.backendjava.saleservice.model.Product;
import org.aibles.backendjava.saleservice.repository.ProductRepository;
import org.aibles.backendjava.saleservice.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        return convertToDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO updateProduct(int productId, ProductDTO productDTO) {
        Product productReq = convertToEntity(productDTO);
        Product product = productRepository.findById(productId).orElse(null);
        product.setName(productReq.getName());
        product.setOrigin(productReq.getOrigin());
        product.setPrice(productReq.getPrice());
        product.setQuantity(productReq.getQuantity());
        return convertToDTO(productRepository.save(product));
    }

    @Override
    public Product deleteProduct(int productId) {
        Product product = productRepository.findById(productId).orElse(null);
        productRepository.delete(product);
        return product;
    }

    @Override
    public List<ProductDTO> listProduct() {
        return productRepository.findAll().stream()
                .map(product -> convertToDTO(product))
                .collect(Collectors.toList());
    }

    private Product convertToEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }

    private ProductDTO convertToDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }
}
