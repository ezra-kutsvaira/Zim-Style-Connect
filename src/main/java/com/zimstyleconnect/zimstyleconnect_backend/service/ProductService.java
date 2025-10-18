package com.zimstyleconnect.zimstyleconnect_backend.service;
import com.zimstyleconnect.zimstyleconnect_backend.entity.Product;
import com.zimstyleconnect.zimstyleconnect_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
