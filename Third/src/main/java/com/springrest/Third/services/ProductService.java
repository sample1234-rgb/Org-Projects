package com.springrest.Third.services;

import com.springrest.Third.entity.Product;
import com.springrest.Third.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product p) {
        return productRepository.save(p);
    }

    public Product getById(int id) {
        return productRepository.getById(id);
    }
}
