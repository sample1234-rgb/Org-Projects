package com.springrest.Third.controller;

import com.springrest.Third.entity.Product;
import com.springrest.Third.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public Product saveProduct(Product p){
        return productService.saveProduct(p);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productService.getById(id);
    }

}
